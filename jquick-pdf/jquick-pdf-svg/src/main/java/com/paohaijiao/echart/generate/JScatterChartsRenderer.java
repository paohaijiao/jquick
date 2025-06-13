
package com.paohaijiao.echart.generate;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.data.JData;
import com.paohaijiao.data.series.JScatter;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JScatterChartsRenderer {

    public static void renderScatterToSvg(JOption option, String outputPath) throws IOException {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

        int width = 800;
        int height = 600;
        svgGenerator.setPaint(Color.WHITE);
        svgGenerator.fillRect(0, 0, width, height);

        renderScatter(option, svgGenerator, width, height);

        try (Writer out = new FileWriter(outputPath)) {
            svgGenerator.stream(out, true);
        }
    }

    private static void renderScatter(JOption option, SVGGraphics2D g2d, int width, int height) {
        JScatter scatter = (JScatter) option.series().get(0);
        List<JData> dataList = scatter.data();
        int symbolSize =(int) scatter.symbolSize();
        double minX = Double.MAX_VALUE, maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE, maxY = Double.MIN_VALUE;
        for (JData data : dataList) {
            List<Object> point = (List<Object>) data.value();
            double x = ((Number)point.get(0)).doubleValue();
            double y = ((Number)point.get(1)).doubleValue();
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        double xRange = maxX - minX;
        double yRange = maxY - minY;
        minX -= xRange * 0.1;
        maxX += xRange * 0.1;
        minY -= yRange * 0.1;
        maxY += yRange * 0.1;
        int margin = 60;
        int plotWidth = width - 2 * margin;
        int plotHeight = height - 2 * margin;
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawLine(margin, height - margin, width - margin, height - margin); // X轴
        g2d.drawLine(margin, margin, margin, height - margin); // Y轴
        Font labelFont = new Font("Microsoft YaHei", Font.PLAIN, 10);
        g2d.setFont(labelFont);
        for (double x = Math.ceil(minX); x <= Math.floor(maxX); x++) {
            int xPos = margin + (int)((x - minX) / (maxX - minX) * plotWidth);
            g2d.drawLine(xPos, height - margin, xPos, height - margin + 5);
            g2d.drawString(String.format("%.1f", x), xPos - 10, height - margin + 20);
        }
        for (double y = Math.ceil(minY); y <= Math.floor(maxY); y++) {
            int yPos = height - margin - (int)((y - minY) / (maxY - minY) * plotHeight);
            g2d.drawLine(margin - 5, yPos, margin, yPos);
            g2d.drawString(String.format("%.1f", y), margin - 40, yPos + 5);
        }
        g2d.setPaint(new Color(65, 105, 225));
        int halfSize = symbolSize / 2;
        for (JData data : dataList) {
            List<Object> point = ( List<Object>) data.value();
            double x = ((Number)point.get(0)).doubleValue();
            double y = ((Number)point.get(1)).doubleValue();
            int xPos = margin + (int)((x - minX) / (maxX - minX) * plotWidth);
            int yPos = height - margin - (int)((y - minY) / (maxY - minY) * plotHeight);
            g2d.fillOval(xPos - halfSize, yPos - halfSize, symbolSize, symbolSize);
        }
        Font titleFont = new Font("Microsoft YaHei", Font.BOLD, 14);
        g2d.setFont(titleFont);
        String title = option.title().text();
        g2d.drawString(title, width/2 - g2d.getFontMetrics().stringWidth(title)/2, 30);
    }

}
