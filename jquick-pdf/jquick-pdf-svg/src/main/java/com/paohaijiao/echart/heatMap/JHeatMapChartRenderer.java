/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */
package com.paohaijiao.echart.heatMap;

import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * packageName com.paohaijiao.echart.generate
 *
 * @author Martin
 * @version 1.0.0
 * @className JHeatMap
 * @date 2025/6/13
 * @description
 */
public class JHeatMapChartRenderer {
    public static void generateHeatmapSVG(double[][] data, String[] xLabels, String[] yLabels, String outputPath) {
        try {
            // 创建SVG文档
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            // 创建SVG根元素
            Element svgRoot = document.createElementNS("http://www.w3.org/2000/svg", "svg");
            svgRoot.setAttributeNS(null, "width", "800");
            svgRoot.setAttributeNS(null, "height", "600");
            document.appendChild(svgRoot);

            // 创建SVGGraphics2D对象
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

            // 绘制热力图
            drawHeatmap(svgGenerator, data, xLabels, yLabels);

            // 将图形内容填充到SVG根元素
            svgGenerator.getRoot(svgRoot);

            // 输出SVG文件
            try (Writer out = new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8")) {
                svgGenerator.stream(svgRoot, out);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void drawHeatmap(SVGGraphics2D g2d, double[][] data, String[] xLabels, String[] yLabels) {
        // 设置背景
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 800, 600);

        // 绘制标题
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("热力图", 350, 30);

        // 计算热力图区域和单元格大小
        int margin = 50;
        int width = 700;
        int height = 450;
        int cellWidth = width / xLabels.length;
        int cellHeight = height / yLabels.length;

        // 绘制x轴标签
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int i = 0; i < xLabels.length; i++) {
            g2d.drawString(xLabels[i], margin + i * cellWidth + cellWidth/2 - 10, margin + height + 20);
        }

        // 绘制y轴标签
        for (int i = 0; i < yLabels.length; i++) {
            g2d.drawString(yLabels[i], margin - 40, margin + i * cellHeight + cellHeight/2 + 5);
        }

        // 绘制热力图单元格
        for (int i = 0; i < xLabels.length; i++) {
            for (int j = 0; j < yLabels.length; j++) {
                double value = data[i][j];
                // 根据值计算颜色（简单示例，实际可能需要更复杂的颜色映射）
                int red = (int) (255 * (value / 100.0));
                int green = 0;
                int blue = (int) (255 * (1 - value / 100.0));
                Color color = new Color(red, green, blue, 128);

                g2d.setColor(color);
                g2d.fillRect(margin + i * cellWidth,
                        margin + j * cellHeight,
                        cellWidth, cellHeight);

                // 绘制边框
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawRect(margin + i * cellWidth,
                        margin + j * cellHeight,
                        cellWidth, cellHeight);

                // 显示值
                g2d.setColor(Color.BLACK);
                g2d.drawString(String.format("%.1f", value),
                        margin + i * cellWidth + cellWidth/2 - 10,
                        margin + j * cellHeight + cellHeight/2 + 5);
            }
        }

        // 绘制图例
        drawLegend(g2d, margin + width + 20, margin, 30, height);
    }

    private static void drawLegend(SVGGraphics2D g2d, int x, int y, int width, int height) {
        // 绘制渐变图例
        for (int i = 0; i < height; i++) {
            double ratio = 1 - (double)i / height;
            int red = (int) (255 * ratio);
            int green = 0;
            int blue = (int) (255 * (1 - ratio));
            g2d.setColor(new Color(red, green, blue));
            g2d.drawLine(x, y + i, x + width, y + i);
        }

        // 绘制图例边框
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);

        // 绘制图例标签
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.drawString("100", x + width + 5, y + 10);
        g2d.drawString("50", x + width + 5, y + height/2 + 5);
        g2d.drawString("0", x + width + 5, y + height - 5);
    }
}
