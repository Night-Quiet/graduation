// JavaScript Document
/**
 * @forSubmit: 更改使得表单提交按钮不需要在form内,美化前端
 * @funnyTest: 弹球小游戏,增加娱乐性
 * @ballColor: 更换弹球小游戏背景颜色
 */
function formSubmit(select) {
    var form = document.getElementById("formSubmit");

    form.action = form.action + "?select=" + select;

    form.submit();

}

function test() {
    alert("test");
}

var funnyTest=(function(){
    var classNum=0;
    return function() {
        classNum+=1;
        var funny = document.getElementById("funny"),
            x=0,
            y=0,
            dx=10,
            dy=1,
            stopTodo=1;
        document.getElementById("funny").innerHTML+="<div class='moveIn' style='width: 20px;height: 20px;position: absolute;background-color: rgba(24, 144, 255, 0.15);'></div>";
        var moveIn = document.getElementsByClassName("moveIn")[classNum-1],
            toDo = setInterval(moveDo,25);
        function moveDo(){
            x += dx;
            y += dy;
            moveIn.style.left = x + "px";
            moveIn.style.top = y + "px";
            if (x == 520/2){
                stopTodo++;
                if(stopTodo%4==2){
                    clearInterval(toDo);
                    toDo = setInterval(moveDo,25);
                    moveIn.style.backgroundColor = "red";
                } else {
                    clearInterval(toDo);
                    toDo = setInterval(moveDo,12.5);
                    moveIn.style.backgroundColor = "aqua";
                }
            }
            if (x >= funny.offsetWidth-30 || x <= 0){ dx=-dx; }
            if (y >= funny.offsetHeight-22 || y <= 0){ dy=-dy; }
        }
    }
})();

function ballColor(num){
    var moveBall="",
        cColor="";
    moveBall=document.getElementById("funny");
    switch(num){
        case 1:
            cColor="darkslateblue";
            break;
        case 2:
            cColor="rgba(16,16,20,1)";
            break;
        case 3:
            cColor="indianred";
            break;
        case 4:
            cColor="mediumslateblue";
            break;
    }
    moveBall.style.backgroundColor=cColor;
}

function changeBig(obj) {
    coverLayer(1);
    var currImg = $(obj),
        tempContainer = $('<div class=tempContainer></div>'); //图片容器
    with (tempContainer) {//width方法等同于$(this)
        appendTo("body");
        var windowWidth = $(window).width(),
            windowHeight = $(window).height(),
            orignImg = new Image(); //获取图片原始宽度、高度
        orignImg.src = currImg.attr("src");
        var currImgWidth = orignImg.width,
            currImgHeight = orignImg.height,
            currWindow_Width = currImgWidth / windowWidth, //获取图片对比宽度、高度
            currWindow_Height = currImgHeight / windowHeight;
        // 我希望的是,照片呈现在一个页面中,不超过页面
        if (currImgWidth < windowWidth) {
            if (currImgHeight < windowHeight) { // 宽高都没崩
                if (currWindow_Width > currWindow_Height) { // 宽占比大于高占比,以宽为参考进行调整
                    var currChangeWidth = windowWidth,
                        topHeight =  (windowHeight - currImgHeight / currWindow_Width) / 2; // 上下居中
                    css('top', topHeight);
                    html('<img border=0 src=' +  currImg.attr('src') + ' width=' + currChangeWidth + '>');
                } else { // 宽占比小于高占比,以高为参考进行调整
                    var currChangeHeight = windowHeight;
                    css('top', 0);
                    html('<img border=0 src=' +  currImg.attr('src') + ' height=' + currChangeHeight + '>');
                }
            } else { // 宽没崩,高崩了
                css('top', 0);
                var currChangeHeight = windowHeight;
                html('<img border=0 src=' + currImg.attr('src') + ' height=' + currChangeHeight + '>');
            }
        } else {
            if (currImgHeight < windowHeight) { // 宽崩了,高没崩
                var currChangeWidth = windowWidth,
                    topHeight =  (windowHeight - currImgHeight / currWindow_Width) / 2; // 上下居中
                css('top', topHeight);
                html('<img border=0 src=' +  currImg.attr('src') + ' width=' + currChangeWidth + '>');
            } else { // 宽高都崩了
                if (currWindow_Width > currWindow_Height) { // 宽占比大于高占比,以宽为参考进行调整
                    var currChangeWidth = windowWidth,
                        topHeight =  (windowHeight - currImgHeight / currWindow_Width) / 2; // 上下居中
                    css('top', topHeight);
                    html('<img border=0 src=' +  currImg.attr('src') + ' width=' + currChangeWidth + '>');
                } else { // 宽占比小于高占比,以高为参考进行调整
                    var currChangeHeight = windowHeight;
                    css('top', 0);
                    html('<img border=0 src=' +  currImg.attr('src') + ' height=' + currChangeHeight + '>');
                }
            }
        }
    }
    tempContainer.click(function () {
        $(this).remove();
        coverLayer(0);
    });
}

//使用禁用蒙层效果
function coverLayer(tag) {
    with ($('.home')) {
        if (tag == 1) {
            css('opacity', 0.4);
        } else {
            css('opacity', 0.7);
        }
    }
}

function replyAppear(obj, name) {
    var reply = obj.parentNode.parentNode.children[1].children[0].children[0];
    var displaySet = getComputedStyle(reply)["display"];
    var placeholder = reply.children[0].children[0];
    console.log(placeholder);
    placeholder.setAttribute("placeholder", "回复@".concat(name));
    if (displaySet === "block") {
        reply.style.display = "none";
    } else {
        reply.style.display = "block";
    }
}

function allReplyAppear(obj) {
    var reply = obj.parentNode.parentNode.children[1].children[0].children[1];
    var displaySet = getComputedStyle(reply)["display"];
    if (displaySet === "block") {
        reply.style.display = "none";
    } else {
        reply.style.display = "block";
    }
}

function activeShow(obj) {
    var fatherDiv = document.getElementsByClassName("home-left-bottom")[0];
    var changeAll = fatherDiv.children;
    for(let i=0;i<changeAll.length;i++) {
        changeAll[i].className = "function";
    }
    obj.className = "function active";
}
