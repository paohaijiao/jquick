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
package com.paohaijiao.echart.boxPlot;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.io.StringWriter;
import java.io.Writer;

/**
 * packageName com.paohaijiao.echart.generate
 *
 * @author Martin
 * @version 1.0.0
 * @className JBoxPlotChartRenderer
 * @date 2025/6/13
 * @description
 */
public class JBoxPlotChartRenderer {
    public static String generateBoxplotSvg(double[][] data, String[] categories,
                                            int width, int height) {
        try {
            DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
            String svgNS = "http://www.w3.org/2000/svg";
            Document document = domImpl.createDocument(svgNS, "svg", null);
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
            svgGenerator.setSVGCanvasSize(new java.awt.Dimension(width, height));
            svgGenerator.setColor(java.awt.Color.WHITE);
            svgGenerator.fillRect(0, 0, width, height);

            int margin = 50;
            int plotWidth = width - 2 * margin;
            int plotHeight = height - 2 * margin;
            svgGenerator.setColor(java.awt.Color.BLACK);
            svgGenerator.drawLine(margin, height - margin, width - margin, height - margin);
            svgGenerator.drawLine(margin, margin, margin, height - margin);

            double minValue = Double.MAX_VALUE;
            double maxValue = Double.MIN_VALUE;
            for (double[] box : data) {
                minValue = Math.min(minValue, box[0]);
                maxValue = Math.max(maxValue, box[4]);
            }
            double valueRange = maxValue - minValue;
            int boxWidth = 30;
            int categoryCount = categories.length;
            int spacing = plotWidth / (categoryCount + 1);

            for (int i = 0; i < categoryCount; i++) {
                double[] box = data[i];
                int x = margin + (i + 1) * spacing - boxWidth / 2;
                int yMin = (int)(height - margin - (box[0] - minValue) / valueRange * plotHeight);
                int yQ1 = (int)(height - margin - (box[1] - minValue) / valueRange * plotHeight);
                int yMedian = (int)(height - margin - (box[2] - minValue) / valueRange * plotHeight);
                int yQ3 = (int)(height - margin - (box[3] - minValue) / valueRange * plotHeight);
                int yMax = (int)(height - margin - (box[4] - minValue) / valueRange * plotHeight);

                svgGenerator.drawLine(x + boxWidth/2, yMin, x + boxWidth/2, yMax);
                svgGenerator.drawLine(x, yMin, x + boxWidth, yMin);
                svgGenerator.drawLine(x, yMax, x + boxWidth, yMax);

                svgGenerator.setColor(new java.awt.Color(100, 149, 237)); // 蓝色
                svgGenerator.fillRect(x, yQ3, boxWidth, yQ1 - yQ3);
                svgGenerator.setColor(java.awt.Color.BLACK);
                svgGenerator.drawRect(x, yQ3, boxWidth, yQ1 - yQ3);

                svgGenerator.drawLine(x, yMedian, x + boxWidth, yMedian);

                svgGenerator.drawString(categories[i], x, height - margin + 20);
            }
            for (double v = minValue; v <= maxValue; v += (valueRange / 5)) {
                int y = (int)(height - margin - (v - minValue) / valueRange * plotHeight);
                svgGenerator.drawString(String.format("%.1f", v), margin - 40, y);
                svgGenerator.drawLine(margin - 5, y, margin, y);
            }
            svgGenerator.drawString("盒须图", width / 2 - 30, margin - 20);

            Writer out = new StringWriter();
            svgGenerator.stream(out, true);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
