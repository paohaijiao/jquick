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
import com.paohaijiao.data.JOption;
import com.paohaijiao.data.series.JBoxplot;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
    // 默认配置
    private static final Color BOX_FILL_COLOR = new Color(100, 149, 237);
    private static final Color AXIS_COLOR = Color.BLACK;
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 12);
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 14);

    /**
     * 根据ECharts Option生成盒须图SVG
     *
     * @param option ECharts配置选项
     * @param width SVG宽度
     * @param height SVG高度
     * @return SVG字符串
     */
    public static String generateBoxplotSvg(JOption option, int width, int height) {
        try {
            // 1. 验证并提取Option中的数据
            BoxplotDataExtractor extractor = new BoxplotDataExtractor(option);

            // 2. 创建SVG文档
            DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
            Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
            svgGenerator.setSVGCanvasSize(new Dimension(width, height));

            // 3. 绘制背景
            drawBackground(svgGenerator, width, height);

            // 4. 计算边距和绘图区域
            int margin = calculateMargin(width, height);
            int plotWidth = width - 2 * margin;
            int plotHeight = height - 2 * margin;

            // 5. 绘制坐标轴
            drawAxes(svgGenerator, margin, width, height, plotWidth, plotHeight);

            // 6. 绘制盒须图
            drawBoxplots(svgGenerator, extractor, margin, width, height, plotWidth, plotHeight);

            // 7. 绘制标题
            drawTitle(svgGenerator, extractor.getTitle(), width, margin);

            // 8. 输出SVG
            return writeSvgToString(svgGenerator);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 以下是私有辅助方法（与之前版本类似，但适配Option参数）

    private static void drawBackground(SVGGraphics2D svg, int width, int height) {
        svg.setColor(BACKGROUND_COLOR);
        svg.fillRect(0, 0, width, height);
    }

    private static int calculateMargin(int width, int height) {
        return Math.min(width, height) / 10;
    }

    private static void drawAxes(SVGGraphics2D svg, int margin,
                                 int width, int height,
                                 int plotWidth, int plotHeight) {
        svg.setColor(AXIS_COLOR);
        svg.drawLine(margin, height - margin, width - margin, height - margin);
        svg.drawLine(margin, margin, margin, height - margin);
    }

    private static void drawBoxplots(SVGGraphics2D svg, BoxplotDataExtractor extractor,
                                     int margin, int width, int height,
                                     int plotWidth, int plotHeight) {
        int boxWidth = 30;
        int categoryCount = extractor.getCategories().size();
        int spacing = plotWidth / (categoryCount + 1);

        svg.setFont(DEFAULT_FONT);

        for (int i = 0; i < categoryCount; i++) {
            double[] box = extractor.getBoxData(i);
            String category = extractor.getCategories().get(i);

            // 计算坐标
            int yMin = scaleToPlot(box[0], height, margin, plotHeight, extractor.getValueRange());
            int yQ1 = scaleToPlot(box[1], height, margin, plotHeight, extractor.getValueRange());
            int yMedian = scaleToPlot(box[2], height, margin, plotHeight, extractor.getValueRange());
            int yQ3 = scaleToPlot(box[3], height, margin, plotHeight, extractor.getValueRange());
            int yMax = scaleToPlot(box[4], height, margin, plotHeight, extractor.getValueRange());

            int x = margin + (i + 1) * spacing - boxWidth / 2;

            // 绘制须线
            svg.setColor(AXIS_COLOR);
            svg.drawLine(x + boxWidth/2, yMin, x + boxWidth/2, yMax);
            svg.drawLine(x, yMin, x + boxWidth, yMin);
            svg.drawLine(x, yMax, x + boxWidth, yMax);

            // 绘制箱体
            svg.setColor(BOX_FILL_COLOR);
            svg.fillRect(x, yQ3, boxWidth, yQ1 - yQ3);
            svg.setColor(AXIS_COLOR);
            svg.drawRect(x, yQ3, boxWidth, yQ1 - yQ3);

            // 绘制中位数
            svg.drawLine(x, yMedian, x + boxWidth, yMedian);

            // 绘制类别标签
            svg.drawString(category, x, height - margin + 20);
        }

        // 绘制Y轴刻度
        drawYAxisTicks(svg, margin, height, plotHeight, extractor.getValueRange());
    }

    private static int scaleToPlot(double value, int height, int margin,
                                   int plotHeight, ValueRange valueRange) {
        return (int)(height - margin - (value - valueRange.min) / valueRange.range * plotHeight);
    }

    private static void drawYAxisTicks(SVGGraphics2D svg, int margin,
                                       int height, int plotHeight,
                                       ValueRange valueRange) {
        int tickCount = 5;
        double tickStep = valueRange.range / (tickCount - 1);

        for (int i = 0; i < tickCount; i++) {
            double value = valueRange.min + i * tickStep;
            int y = scaleToPlot(value, height, margin, plotHeight, valueRange);

            svg.drawString(String.format("%.1f", value), margin - 40, y);
            svg.drawLine(margin - 5, y, margin, y);
        }
    }

    private static void drawTitle(SVGGraphics2D svg, String title, int width, int margin) {
        if (title != null && !title.isEmpty()) {
            svg.setFont(TITLE_FONT);
            svg.drawString(title, width / 2 - title.length() * 4, margin - 20);
        }
    }

    private static String writeSvgToString(SVGGraphics2D svgGenerator) throws Exception {
        Writer out = new StringWriter();
        svgGenerator.stream(out, true);
        return out.toString();
    }

    /**
     * 值范围辅助类
     */
    private static class ValueRange {
        final double min;
        final double max;
        final double range;

        ValueRange(double min, double max) {
            this.min = min;
            this.max = max;
            this.range = max - min;
        }
    }

    /**
     * Option数据提取器
     */
    private static class BoxplotDataExtractor {
        private final List<String> categories;
        private final List<double[]> boxData;
        private final ValueRange valueRange;
        private final String title;

        public BoxplotDataExtractor(JOption option) {
            // 提取类别
            this.categories = option.getxAxis() != null ?
                    (List<String>) option.getxAxis().get(0).getData() :new ArrayList<>()
            ;

            // 提取盒须图数据
            this.boxData = new ArrayList<>();
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            if (option.getSeries() != null) {
                for (Object series : option.getSeries()) {
                    if (series instanceof JBoxplot) {
                        JBoxplot boxplot = (JBoxplot) series;
                        for (Object data : boxplot.getData()) {
                            if (data instanceof Object[]) {
                                Object[] values = (Object[]) data;
                                double[] box = new double[]{
                                        ((Number) values[0]).doubleValue(),
                                        ((Number) values[1]).doubleValue(),
                                        ((Number) values[2]).doubleValue(),
                                        ((Number) values[3]).doubleValue(),
                                        ((Number) values[4]).doubleValue()
                                };
                                boxData.add(box);
                                min = Math.min(min, box[0]);
                                max = Math.max(max, box[4]);
                            }
                        }
                    }
                }
            }

            this.valueRange = new ValueRange(min, max);
            this.title = option.getTitle() != null ? option.getTitle().getText() : "";
        }

        public List<String> getCategories() {
            return categories;
        }

        public double[] getBoxData(int index) {
            return boxData.get(index);
        }

        public ValueRange getValueRange() {
            return valueRange;
        }

        public String getTitle() {
            return title;
        }
    }
}
