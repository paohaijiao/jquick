
package com.paohaijiao.echart.line;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.axis.JValueAxis;
import com.paohaijiao.data.series.JLine;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

public class JLineChartsRenderer {

    /**
     * 根据ECharts Option生成SVG文件
     * @param option ECharts配置选项
     * @param outputPath 输出文件路径
     */
    public static void generateSVGFromOption(JOption option, String outputPath) {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        drawChart(svgGenerator, option);
        try (Writer out = new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8")) {
            svgGenerator.stream(out, true);
            System.out.println("SVG文件已生成: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制图表
     * @param svgGenerator SVG生成器
     * @param option ECharts配置选项
     */
    private static void drawChart(SVGGraphics2D svgGenerator, JOption option) {
        svgGenerator.setColor(Color.WHITE);
        svgGenerator.fillRect(0, 0, 600, 400);
        svgGenerator.setFont(new Font("Arial", Font.PLAIN, 12));
        svgGenerator.setColor(Color.BLACK);
        if (option.getTitle() != null && option.getTitle().getText() != null) {
            svgGenerator.drawString(option.getTitle().getText(), 250, 30);
        }
        drawAxes(svgGenerator, option);
        drawSeries(svgGenerator, option);
    }

    /**
     * 绘制坐标轴
     * @param svgGenerator SVG生成器
     * @param option ECharts配置选项
     */
    private static void drawAxes(SVGGraphics2D svgGenerator, JOption option) {
        svgGenerator.drawLine(50, 350, 550, 350);
        svgGenerator.drawLine(50, 350, 50, 50);
        if (option.getxAxis() != null && !option.getxAxis().isEmpty()
                && option.getxAxis().get(0) instanceof JCategoryAxis) {
            JCategoryAxis xAxis = (JCategoryAxis) option.getxAxis().get(0);
            List<String> xData = xAxis.getData();
            if (xData != null) {
                int xStep = 500 / (xData.size() + 1);
                for (int i = 0; i < xData.size(); i++) {
                    svgGenerator.drawString(xData.get(i), 70 + i * xStep, 370);
                }
            }
        }

        if (option.getyAxis() != null && !option.getyAxis().isEmpty()
                && option.getyAxis().get(0) instanceof JValueAxis) {
            JValueAxis yAxis = (JValueAxis) option.getyAxis().get(0);
            for (int i = 0; i <= 5; i++) {
                int value = i * 50;
                svgGenerator.drawString(String.valueOf(value), 30, 350 - i * 60);
            }
        }
    }

    /**
     * 绘制系列数据
     * @param svgGenerator SVG生成器
     * @param option ECharts配置选项
     */
    private static void drawSeries(SVGGraphics2D svgGenerator, JOption option) {
        if (option.getSeries() == null || option.getSeries().isEmpty()) {
            return;
        }
        for (Object seriesObj : option.getSeries()) {
            if (seriesObj instanceof JLine) {
                JLine line = (JLine) seriesObj;
                List<?> data = line.getData();
                if (data != null && !data.isEmpty()) {
                    svgGenerator.setColor(getSeriesColor(line));
                    int xStep = 500 / (data.size() + 1);
                    for (int i = 0; i < data.size() - 1; i++) {
                        Number yValue = (Number) data.get(i);
                        Number nextYValue = (Number) data.get(i + 1);
                        int x1 = 70 + i * xStep;
                        int y1 = 350 - (int)(yValue.doubleValue() / 250.0 * 300);
                        int x2 = 70 + (i + 1) * xStep;
                        int y2 = 350 - (int)(nextYValue.doubleValue() / 250.0 * 300);
                        svgGenerator.drawLine(x1, y1, x2, y2);
                        svgGenerator.fillOval(x1 - 3, y1 - 3, 6, 6);
                    }
                    if (!data.isEmpty()) {
                        Number lastYValue = (Number) data.get(data.size() - 1);
                        int lastX = 70 + (data.size() - 1) * xStep;
                        int lastY = 350 - (int)(lastYValue.doubleValue() / 250.0 * 300);
                        svgGenerator.fillOval(lastX - 3, lastY - 3, 6, 6);
                    }
                }
                break;
            }
        }
    }

    /**
     * 获取系列颜色
     * @param line 折线系列
     * @return 颜色对象
     */
    private static Color getSeriesColor(JLine line) {
        // 简化处理，返回默认颜色
        return Color.BLUE;
    }
}
