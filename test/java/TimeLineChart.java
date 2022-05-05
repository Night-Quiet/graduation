import java.awt.*;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class TimeLineChart {
    private ChartPanel frame1;
    /**
     * 设置图标样式
     */
    public TimeLineChart() {
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("备注", "日期", "数值", xydataset, true, true, true);
        frame1 = new ChartPanel(jfreechart, true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        //设置样式
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM"));
        dateaxis.setLabelFont(new Font("黑体", Font.BOLD, 14));     //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); //垂直标题
        ValueAxis rangeAxis = xyplot.getRangeAxis();                            //获取柱状
        rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));//设置标题字体


    }

    /**
     * 创建折线对象
     *
     * @return
     */
    private static XYDataset createDataset() {
        TimeSeries timeseries1 = new TimeSeries("第一条折线");//第一条折线
        timeseries1.add(new Month(2, 2001), 181.80);
        timeseries1.add(new Month(3, 2001), 167.30);
        timeseries1.add(new Month(4, 2001), 153.80);
        TimeSeries timeseries2 = new TimeSeries("第二条折线");//第二条折线
        timeseries2.add(new Month(2, 2001), 129.5);
        timeseries2.add(new Month(3, 2001), 123.2);
        timeseries2.add(new Month(4, 2002), 117.2);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries1);
        timeseriescollection.addSeries(timeseries2);
        return timeseriescollection;
    }

    public ChartPanel getChartPanel() {
        return frame1;
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Java统计图");
        frame.setLayout(new GridLayout(2, 2, 10, 10));
        frame.add(new TimeLineChart().getChartPanel());    //添加折线图
        frame.setBounds(50, 50, 800, 600);//设置范围
        frame.setVisible(true);
    }

}