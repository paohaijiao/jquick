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

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.series.JHeatmap;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
    // Default configuration
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color AXIS_COLOR = Color.BLACK;
    private static final Color CELL_BORDER_COLOR = Color.LIGHT_GRAY;
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 20);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 12);
    private static final Font VALUE_FONT = new Font("Arial", Font.PLAIN, 10);

    /**
     * Generate heatmap SVG from ECharts Option
     *
     * @param option ECharts configuration option
     * @param width SVG width
     * @param height SVG height
     * @return SVG string
     */
    public static String generateHeatmapSvg(JOption option, int width, int height) {
        try {
            // 1. Extract data from Option
            HeatmapDataExtractor extractor = new HeatmapDataExtractor(option);

            // 2. Create SVG document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            // 3. Create SVG root element
            Element svgRoot = document.createElementNS("http://www.w3.org/2000/svg", "svg");
            svgRoot.setAttributeNS(null, "width", String.valueOf(width));
            svgRoot.setAttributeNS(null, "height", String.valueOf(height));
            document.appendChild(svgRoot);

            // 4. Create SVGGraphics2D
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

            // 5. Draw heatmap
            drawHeatmap(svgGenerator, extractor, width, height);

            // 6. Fill SVG content
            svgGenerator.getRoot(svgRoot);

            // 7. Write to string
            try (Writer out = new StringWriter()) {
                svgGenerator.stream(svgRoot, out);
                return out.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void drawHeatmap(SVGGraphics2D g2d, HeatmapDataExtractor extractor,
                                    int width, int height) {
        // Draw background
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRect(0, 0, width, height);

        // Draw title
        if (extractor.getTitle() != null && !extractor.getTitle().isEmpty()) {
            g2d.setFont(TITLE_FONT);
            g2d.setColor(AXIS_COLOR);
            int titleWidth = g2d.getFontMetrics().stringWidth(extractor.getTitle());
            g2d.drawString(extractor.getTitle(), (width - titleWidth) / 2, 30);
        }

        // Calculate dimensions
        int margin = 50;
        int heatmapWidth = width - 2 * margin - 50; // Leave space for legend
        int heatmapHeight = height - 2 * margin;
        int cellWidth = heatmapWidth / extractor.getXLabels().size();
        int cellHeight = heatmapHeight / extractor.getYLabels().size();

        // Draw x-axis labels
        g2d.setFont(LABEL_FONT);
        for (int i = 0; i < extractor.getXLabels().size(); i++) {
            String label = extractor.getXLabels().get(i);
            int labelWidth = g2d.getFontMetrics().stringWidth(label);
            g2d.drawString(label,
                    margin + i * cellWidth + (cellWidth - labelWidth) / 2,
                    margin + heatmapHeight + 20);
        }

        // Draw y-axis labels
        for (int i = 0; i < extractor.getYLabels().size(); i++) {
            String label = extractor.getYLabels().get(i);
            int labelWidth = g2d.getFontMetrics().stringWidth(label);
            g2d.drawString(label,
                    margin - labelWidth - 5,
                    margin + i * cellHeight + cellHeight / 2 + 5);
        }

        // Draw heatmap cells
        for (int i = 0; i < extractor.getXLabels().size(); i++) {
            for (int j = 0; j < extractor.getYLabels().size(); j++) {
                double value = extractor.getValue(i, j);
                Color color = calculateCellColor(value, extractor.getMinValue(), extractor.getMaxValue());

                // Draw cell
                g2d.setColor(color);
                g2d.fillRect(
                        margin + i * cellWidth,
                        margin + j * cellHeight,
                        cellWidth, cellHeight);

                // Draw border
                g2d.setColor(CELL_BORDER_COLOR);
                g2d.drawRect(
                        margin + i * cellWidth,
                        margin + j * cellHeight,
                        cellWidth, cellHeight);

                // Draw value
                if (cellWidth > 30 && cellHeight > 20) { // Only draw if cell is large enough
                    g2d.setColor(AXIS_COLOR);
                    g2d.setFont(VALUE_FONT);
                    String valueStr = String.format("%.1f", value);
                    int valueWidth = g2d.getFontMetrics().stringWidth(valueStr);
                    g2d.drawString(valueStr,
                            margin + i * cellWidth + (cellWidth - valueWidth) / 2,
                            margin + j * cellHeight + cellHeight / 2 + 5);
                }
            }
        }

        // Draw legend
        drawLegend(g2d,
                margin + heatmapWidth + 20,
                margin,
                30,
                heatmapHeight,
                extractor.getMinValue(),
                extractor.getMaxValue());
    }

    private static Color calculateCellColor(double value, double minValue, double maxValue) {
        // Simple color gradient from blue (low) to red (high)
        float ratio = (float)((value - minValue) / (maxValue - minValue));
        ratio = Math.max(0, Math.min(1, ratio)); // Clamp between 0 and 1

        int red = (int)(255 * ratio);
        int green = 0;
        int blue = (int)(255 * (1 - ratio));

        return new Color(red, green, blue, 128); // Semi-transparent
    }

    private static void drawLegend(SVGGraphics2D g2d, int x, int y, int width, int height,
                                   double minValue, double maxValue) {
        // Draw gradient legend
        for (int i = 0; i < height; i++) {
            float ratio = 1 - (float)i / height;
            int red = (int)(255 * ratio);
            int green = 0;
            int blue = (int)(255 * (1 - ratio));
            g2d.setColor(new Color(red, green, blue));
            g2d.drawLine(x, y + i, x + width, y + i);
        }

        // Draw legend border
        g2d.setColor(AXIS_COLOR);
        g2d.drawRect(x, y, width, height);

        // Draw legend labels
        g2d.setFont(VALUE_FONT);
        g2d.drawString(String.format("%.1f", maxValue), x + width + 5, y + 10);
        g2d.drawString(String.format("%.1f", (maxValue + minValue) / 2), x + width + 5, y + height/2 + 5);
        g2d.drawString(String.format("%.1f", minValue), x + width + 5, y + height - 5);
    }

    /**
     * Helper class to extract data from ECharts Option
     */
    private static class HeatmapDataExtractor {
        private final List<String> xLabels;
        private final List<String> yLabels;
        private final double[][] data;
        private final double minValue;
        private final double maxValue;
        private final String title;

        public HeatmapDataExtractor(JOption option) {
            // Extract x-axis labels
            this.xLabels = option.getxAxis() != null && !option.getxAxis().isEmpty() ?
                    (List<String>) option.getxAxis().get(0).getData() :new ArrayList<>();

            // Extract y-axis labels
            this.yLabels = option.getyAxis() != null && !option.getyAxis().isEmpty() ?
                    (List<String>) option.getyAxis().get(0).getData() :new ArrayList<>();

            // Initialize data matrix
            this.data = new double[xLabels.size()][yLabels.size()];
            double tempMin = Double.MAX_VALUE;
            double tempMax = Double.MIN_VALUE;

            // Extract heatmap data
            if (option.getSeries() != null) {
                for (Object series : option.getSeries()) {
                    if (series instanceof JHeatmap) {
                        JHeatmap heatmap = (JHeatmap) series;
                        List<?> heatmapData = heatmap.getData();

                        for (Object item : heatmapData) {
                            if (item instanceof Object[]) {
                                Object[] entry = (Object[]) item;
                                if (entry.length >= 3) {
                                    int xIndex = ((Number) entry[0]).intValue();
                                    int yIndex = ((Number) entry[1]).intValue();
                                    double value = ((Number) entry[2]).doubleValue();

                                    if (xIndex >= 0 && xIndex < xLabels.size() &&
                                            yIndex >= 0 && yIndex < yLabels.size()) {
                                        data[xIndex][yIndex] = value;
                                        tempMin = Math.min(tempMin, value);
                                        tempMax = Math.max(tempMax, value);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            this.minValue = tempMin;
            this.maxValue = tempMax;
            this.title = option.getTitle() != null && null!=option.getTitle()?
                    option.getTitle().getText() :
                    "";
        }

        public List<String> getXLabels() {
            return xLabels;
        }

        public List<String> getYLabels() {
            return yLabels;
        }

        public double getValue(int x, int y) {
            return data[x][y];
        }

        public double getMinValue() {
            return minValue;
        }

        public double getMaxValue() {
            return maxValue;
        }

        public String getTitle() {
            return title;
        }
    }
}
