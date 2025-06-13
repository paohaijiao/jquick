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
package com.paohaijiao.echart.generate;
import com.paohaijiao.data.JOption;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.series.JBar;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
/**
 * @ClassName PureBatikEChartsRenderer
 * @Description: Description
 * @Author: gou
 * @CreateDate: 2025/6/12 22:50
 * @UpdateUser: UpdateUser
 * @UpdateDate: 2025/6/12 22:50
 * @UpdateRemark:
 * @Version: 1.0
 */
public class JBarChartsRenderer {

    public static void renderEChartToSVG(JOption option, String outputPath) throws IOException {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        int width = 800;
        int height = 600;
        svgGenerator.setPaint(Color.WHITE);
        svgGenerator.fillRect(0, 0, width, height);
        renderEChartToGraphics2D(option, svgGenerator, width, height);
        try (Writer out = new FileWriter(outputPath)) {
            svgGenerator.stream(out, true);
        }
    }

    private static void renderEChartToGraphics2D(JOption option, SVGGraphics2D g2d, int width, int height) {
        // 设置字体
        Font titleFont = new Font("Microsoft YaHei", Font.BOLD, 18);
        Font labelFont = new Font("Microsoft YaHei", Font.PLAIN, 12);
        g2d.setFont(titleFont);
        g2d.setPaint(Color.BLACK);
        String title = option.title().text();
        String subTitle = option.title().subtext();
        g2d.drawString(title, width/2 - g2d.getFontMetrics().stringWidth(title)/2, 40);
        g2d.setFont(labelFont);
        g2d.drawString(subTitle, width/2 - g2d.getFontMetrics().stringWidth(subTitle)/2, 60);
        int padding = 60;
        int chartWidth = width - 2*padding;
        int chartHeight = height - 2*padding;
        int chartX = padding;
        int chartY = height - padding;
        g2d.setPaint(Color.BLACK);
        g2d.drawLine(chartX, chartY, chartX + chartWidth, chartY); // X轴
        g2d.drawLine(chartX, chartY, chartX, chartY - chartHeight); // Y轴

        JBar barSeries = (JBar) option.series().get(0);
        List<Object> data = barSeries.data();
        JCategoryAxis xAxis = (JCategoryAxis) option.xAxis().get(0);

        int barCount = data.size();
        int barWidth = chartWidth / (barCount + 2);
        int maxValue = getMaxValue(data);

        g2d.setFont(labelFont);
        for (int i = 0; i < barCount; i++) {
            String label = xAxis.data().get(i).toString();
            int x = chartX + (i+1)*barWidth + barWidth/2 - g2d.getFontMetrics().stringWidth(label)/2;
            g2d.drawString(label, x, chartY + 20);
        }

        int yStep = maxValue / 5;
        for (int i = 0; i <= 5; i++) {
            int value = i * yStep;
            String label = String.valueOf(value);
            int y = chartY - (int)((double)value/maxValue * chartHeight);
            g2d.drawString(label, chartX - 30, y + 5);
            g2d.drawLine(chartX - 5, y, chartX, y);
        }

        g2d.setPaint(new Color(65, 105, 225));
        for (int i = 0; i < barCount; i++) {
            int value = ((Number)data.get(i)).intValue();
            int barHeight = (int)((double)value/maxValue * chartHeight);
            int x = chartX + (i+1)*barWidth;
            int y = chartY - barHeight;
            g2d.fillRect(x, y, barWidth - 5, barHeight);
            g2d.setPaint(Color.BLACK);
            String valueLabel = String.valueOf(value);
            g2d.drawString(valueLabel, x + barWidth/2 - g2d.getFontMetrics().stringWidth(valueLabel)/2, y - 5);
            g2d.setPaint(new Color(65, 105, 225));
        }
    }

    private static int getMaxValue(List<Object> data) {
        int max = 0;
        for (Object item : data) {
            int value = ((Number)item).intValue();
            if (value > max) {
                max = value;
            }
        }
        return max == 0 ? 1 : max;
    }

    public static void main(String[] args) throws IOException {

    }
}
