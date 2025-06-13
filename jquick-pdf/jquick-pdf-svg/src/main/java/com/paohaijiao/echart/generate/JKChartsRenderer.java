
package com.paohaijiao.echart.generate;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.series.JCandlestick;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

public class JKChartsRenderer {
    public static void generateSVGFromOption(JOption option, String outputPath) {
        try {
            DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
            Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
            drawKLineChart(svgGenerator, option);
            try (Writer out = new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8")) {
                svgGenerator.stream(out, true);
                System.out.println("K线图SVG文件已生成: " + outputPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void drawKLineChart(SVGGraphics2D svgGenerator, JOption option) {
        svgGenerator.setColor(Color.WHITE);
        svgGenerator.fillRect(0, 0, 800, 500);
        svgGenerator.setFont(new Font("Arial", Font.PLAIN, 12));
        svgGenerator.setColor(Color.BLACK);
        if (option.getTitle() != null && option.getTitle().getText() != null) {
            svgGenerator.drawString(option.getTitle().getText(), 350, 30);
        }
        drawAxes(svgGenerator, option);
        drawCandlestickData(svgGenerator, option);
    }

    private static void drawAxes(SVGGraphics2D svgGenerator, JOption option) {
        svgGenerator.drawLine(80, 400, 720, 400);

        svgGenerator.drawLine(80, 400, 80, 80);
        if (option.getxAxis() != null && !option.getxAxis().isEmpty()
                && option.getxAxis().get(0) instanceof JCategoryAxis) {
            JCategoryAxis xAxis = (JCategoryAxis) option.getxAxis().get(0);
            List<String> xData = xAxis.getData();
            if (xData != null && !xData.isEmpty()) {
                int xStep = 640 / xData.size();
                for (int i = 0; i < xData.size(); i++) {
                    if (i % 2 == 0) { // 每隔一个显示标签，避免拥挤
                        svgGenerator.drawString(xData.get(i), 80 + i * xStep, 420);
                    }
                }
            }
        }
        svgGenerator.drawString("价格", 40, 60);
        for (int i = 0; i <= 10; i++) {
            int value = i * 10;
            svgGenerator.drawString(String.valueOf(value), 50, 400 - i * 30);
        }
    }

    private static void drawCandlestickData(SVGGraphics2D svgGenerator, JOption option) {
        if (option.getSeries() == null || option.getSeries().isEmpty()) {
            return;
        }
        for (Object seriesObj : option.getSeries()) {
            if (seriesObj instanceof JCandlestick) {
                JCandlestick candlestick = (JCandlestick) seriesObj;
                List<?> data = candlestick.getData();

                if (data != null && !data.isEmpty()) {
                    double[] priceRange = calculatePriceRange(data);
                    double minPrice = priceRange[0];
                    double maxPrice = priceRange[1];
                    double priceDiff = maxPrice - minPrice;
                    int xStep = 640 / data.size();
                    int candleWidth = Math.max(5, xStep / 2);
                    for (int i = 0; i < data.size(); i++) {
                        Object item = data.get(i);
                        if (item instanceof Object[]) {
                            Object[] values = (Object[]) item;
                            if (values.length >= 4) {
                                double open = ((Number) values[0]).doubleValue();
                                double close = ((Number) values[1]).doubleValue();
                                double low = ((Number) values[2]).doubleValue();
                                double high = ((Number) values[3]).doubleValue();
                                int x = 80 + i * xStep;
                                int yOpen = 400 - (int)((open - minPrice) / priceDiff * 300);
                                int yClose = 400 - (int)((close - minPrice) / priceDiff * 300);
                                int yLow = 400 - (int)((low - minPrice) / priceDiff * 300);
                                int yHigh = 400 - (int)((high - minPrice) / priceDiff * 300);
                                boolean isRising = close >= open;
                                svgGenerator.setColor(isRising ? Color.RED : Color.GREEN);
                                svgGenerator.drawLine(x, yHigh, x, yLow);
                                int candleTop = Math.min(yOpen, yClose);
                                int candleHeight = Math.abs(yOpen - yClose);
                                candleHeight = Math.max(candleHeight, 1); // 确保最小高度
                                svgGenerator.fillRect(x - candleWidth/2, candleTop, candleWidth, candleHeight);
                                svgGenerator.setColor(Color.BLACK);
                                svgGenerator.drawRect(x - candleWidth/2, candleTop, candleWidth, candleHeight);
                            }
                        }
                    }
                }
            }
        }
    }

    private static double[] calculatePriceRange(List<?> data) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (Object item : data) {
            if (item instanceof Object[]) {
                Object[] values = (Object[]) item;
                if (values.length >= 4) {
                    double low = ((Number) values[2]).doubleValue();
                    double high = ((Number) values[3]).doubleValue();

                    min = Math.min(min, low);
                    max = Math.max(max, high);
                }
            }
        }

        // 添加一些边距
        double margin = (max - min) * 0.1;
        return new double[]{min - margin, max + margin};
    }


}
