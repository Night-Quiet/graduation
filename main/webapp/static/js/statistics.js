var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
//        var data_use = this.responseText.slice(1, -1).split(", ");
//        var data_use = JSON.parse(this.responseText);
        window.data_use = eval('(' + this.responseText +')');
        showPic(0);
    }
};
xmlhttp.open("GET", "../file/data.txt", true);
xmlhttp.send();

function showPic(select, obj) {
    var fatherDiv = document.getElementsByClassName("home-left")[0];
    var changeAll = fatherDiv.children;
    for(let i=0;i<changeAll.length;i++) {
        changeAll[i].className = "button";
    }
    obj.className = "button active";

    var chart = document.getElementById("show-1");
    var myChart = echarts.init(chart, 'dark');
    myChart.dispose();
    myChart = echarts.init(chart, 'dark');
    window.onresize = function() {
        myChart.resize();
    };
    var option;
    // 指定图表的配置项和数据
    if (select === 0) {
        option = {
            title: {
                text: '学生浏览统计'
            },
            tooltip: {},
            legend: {
                data: ['浏览问题数']
            },
            xAxis: {
                type: 'category',
                data: window.data_use.studentView[0]
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '浏览问题数',
                    type: 'bar',
                    data: window.data_use.studentView[1],
                    showBackground: true,
                    label: {
                        show: true,
                        formatter: '{name|{b}}\n{value|{c} 浏览}',
                        minMargin: 5,
                        edgeDistance: 10,
                        lineHeight: 15,
                        rich: {
                            value: {
                                fontSize: 10,
                                color: '#333'
                            }
                        }
                    },
                    backgroundStyle: {
                        color: 'rgba(180, 180, 180, 0.2)'
                    }
                }
            ]
        };
    }
    if (select === 1) {
        option = {
            title: {
                text: '学生提问统计'
            },
            tooltip: {
                trigger: 'item'
            },
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: '提问数',
                    type: 'pie',
                    radius: ["16.6%", "83.3%"],
                    center: ['50%', '50%'],
                    roseType: 'area',
                    itemStyle: {
                        borderRadius: 8,
                    },
                    label: {
                        alignTo: 'edge',
                        formatter: '{name|{b}}\n{value|{c} 提问}',
                        minMargin: 5,
                        edgeDistance: 10,
                        lineHeight: 15,
                        rich: {
                            value: {
                                fontSize: 10,
                                color: '#999'
                            }
                        }
                    },
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: '40',
                            fontWeight: 'bold'
                        }
                    },
                    data: window.data_use.studentAsk
                }
            ]
        };
    }
    if (select === 2) {
        option = {
            title: [
                {
                    text: '学生评论统计'
                }
            ],
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            polar: {
                radius: ["16.6%", "83.3%"]
            },
            radiusAxis: {
                max: 4
            },
            angleAxis: {
                type: 'category',
                data: window.data_use.studentComment[0],
                startAngle: 75
            },
            tooltip: {},
            series: {
                type: 'bar',
                data: window.data_use.studentComment[1],
                coordinateSystem: 'polar',
                label: {
                    show: true,
                    position: 'middle',
                    formatter: '{b}: {c} 评论'
                }
            },
            // backgroundColor: 'rgba(180, 180, 180, 0.2)',
            animation: false
        };
    }
    if (select === 3) {
        option = {
            title: {
                text: '学生评论回复统计'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b} : {c} 评论回复'
            },
            toolbox: {
                feature: {
                    dataView: { readOnly: false },
                    restore: {},
                    saveAsImage: {}
                }
            },
            legend: {
                data: window.data_use.studentView[0]
            },
            series: [
                {
                    name: 'Funnel',
                    type: 'funnel',
                    left: '10%',
                    top: 60,
                    bottom: 60,
                    width: '80%',
                    min: 0,
                    max: 100,
                    minSize: '0%',
                    maxSize: '100%',
                    sort: 'descending',
                    gap: 2,
                    label: {
                        show: true,
                        position: 'inside',
                        formatter: '{b}\n{c} 评论回复'
                    },
                    labelLine: {
                        length: 10,
                        lineStyle: {
                            width: 1,
                            type: 'solid'
                        }
                    },
                    itemStyle: {
                        borderColor: '#fff',
                        borderWidth: 1
                    },
                    emphasis: {
                        label: {
                            fontSize: 20
                        }
                    },
                    data: window.data_use.studentReply
                }
            ]
        };
    }
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
