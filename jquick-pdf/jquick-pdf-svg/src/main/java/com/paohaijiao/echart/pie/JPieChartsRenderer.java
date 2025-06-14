package com.paohaijiao.echart.pie;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.data.JData;
import com.paohaijiao.data.series.JPie;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JPieChartsRenderer {
    public static void renderPieChartToSVG(JOption option, String outputPath) throws IOException {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        int width = 800;
        int height = 600;
        svgGenerator.setPaint(Color.WHITE);
        svgGenerator.fillRect(0, 0, width, height);
        renderPieChartToGraphics2D(option, svgGenerator, width, height);
        try (Writer out = new FileWriter(outputPath)) {
            svgGenerator.stream(out, true);
        }
    }

    private static void renderPieChartToGraphics2D(JOption option, SVGGraphics2D g2d, int width, int height) {
        Font titleFont = new Font("Microsoft YaHei", Font.BOLD, 18);
        Font labelFont = new Font("Microsoft YaHei", Font.PLAIN, 12);
        g2d.setFont(titleFont);
        g2d.setPaint(Color.BLACK);
        String title = option.title().text();
        String subTitle = option.title().subtext();
        g2d.drawString(title, width/2 - g2d.getFontMetrics().stringWidth(title)/2, 40);
        g2d.setFont(labelFont);
        g2d.drawString(subTitle, width/2 - g2d.getFontMetrics().stringWidth(subTitle)/2, 60);
        JPie pieSeries = (JPie) option.series().get(0);
        List<JData> data = pieSeries.data();
        int centerX = width / 2;
        int centerY = height / 2 + 30;
        int radius = Math.min(width, height) / 3;
        double total = data.stream()
                .mapToDouble(d -> Double.valueOf(d.value()+""))
                .sum();
             Color[] colors = new Color[] {
                new Color(65, 105, 225),
                new Color(220, 20, 60),
                new Color(34, 139, 34),
                new Color(255, 165, 0),
                new Color(138, 43, 226),
                new Color(255, 215, 0)
        };

        double startAngle = 0;
        for (int i = 0; i < data.size(); i++) {
            JData item = data.get(i);
            double value = Double.valueOf(item.value()+"").doubleValue();
            double extent = 360 * (value / total);
            g2d.setPaint(colors[i % colors.length]);
            g2d.fillArc(centerX - radius, centerY - radius,
                    radius * 2, radius * 2,
                    (int)startAngle, (int)extent);
            double midAngle = Math.toRadians(startAngle + extent / 2);
            int labelX = centerX + (int)(radius * 1.2 * Math.cos(midAngle));
            int labelY = centerY + (int)(radius * 1.2 * Math.sin(midAngle));

            g2d.setPaint(Color.BLACK);
            String label = String.format("%s: %.1f%%", item.name(), (value / total * 100));
            if (labelX > centerX) {
                g2d.drawString(label, labelX, labelY);
            } else {
                int textWidth = g2d.getFontMetrics().stringWidth(label);
                g2d.drawString(label, labelX - textWidth, labelY);
            }
            startAngle += extent;
        }
        int legendX = 50;
        int legendY = height - 100;
        g2d.setFont(labelFont);
        for (int i = 0; i < data.size(); i++) {
            JData item = data.get(i);
            g2d.setPaint(colors[i % colors.length]);
            g2d.fillRect(legendX, legendY + i * 25, 20, 15);
            g2d.setPaint(Color.BLACK);
            g2d.drawString(item.name() + " (" + item.value() + ")", legendX + 25, legendY + 12 + i * 25);
        }
    }

}
