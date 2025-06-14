
package com.paohaijiao.echart.radar;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.JRadar;
import com.paohaijiao.data.series.JRadarSeries;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JRadarChartsRenderer {
    public static void renderRadarChart(JOption option, String outputPath) throws IOException {
        Document document = GenericDOMImplementation.getDOMImplementation()
                .createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        svgGenerator.setSVGCanvasSize(new Dimension(600, 400));
        svgGenerator.setPaint(Color.WHITE);
        svgGenerator.fillRect(0, 0, 600, 400);
        JRadar radar = option.getRadar();
        List<JRadar.Indicator> indicators = radar.getIndicator();
        JRadarSeries series = (JRadarSeries) option.getSeries().get(0);
        int centerX = 300, centerY = 200;
        int radius = 150;
        svgGenerator.setPaint(new Color(220, 220, 220));
        for (int level = 1; level <= 5; level++) {
            int currentRadius = radius * level / 5;
            drawRadarPolygon(svgGenerator, centerX, centerY, currentRadius, indicators.size());
        }
        svgGenerator.setStroke(new BasicStroke(1));
        svgGenerator.setPaint(Color.GRAY);
        for (int i = 0; i < indicators.size(); i++) {
            double angle = 2 * Math.PI * i / indicators.size();
            int x = centerX + (int) (radius * Math.sin(angle));
            int y = centerY - (int) (radius * Math.cos(angle));
            svgGenerator.drawLine(centerX, centerY, x, y);
        }

        svgGenerator.setStroke(new BasicStroke(2));
        svgGenerator.setPaint(Color.BLUE);
        List<java.lang.Number> dataPoints =  series.getData();
        drawRadarData(svgGenerator, centerX, centerY, radius, indicators, dataPoints);
        try (FileWriter writer = new FileWriter(outputPath)) {
            svgGenerator.stream(writer, true);
        }
    }
    private static void drawRadarPolygon(SVGGraphics2D svg, int centerX, int centerY, int radius, int sides) {
        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];

        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            xPoints[i] = centerX + (int) (radius * Math.sin(angle));
            yPoints[i] = centerY - (int) (radius * Math.cos(angle));
        }
        svg.drawPolygon(xPoints, yPoints, sides);
    }

    private static void drawRadarData(SVGGraphics2D svg, int centerX, int centerY, int maxRadius,
                                      List<JRadar.Indicator> indicators, List<java.lang.Number> dataPoints) {
        int[] xPoints = new int[indicators.size()];
        int[] yPoints = new int[indicators.size()];

        for (int i = 0; i < indicators.size(); i++) {
            double angle = 2 * Math.PI * i / indicators.size();
            double value = ((Number) dataPoints.get(i)).doubleValue();
            double maxValue = (double)indicators.get(i).getMax();
            int radius = (int) (maxRadius * (value / maxValue));

            xPoints[i] = centerX + (int) (radius * Math.sin(angle));
            yPoints[i] = centerY - (int) (radius * Math.cos(angle));
        }
        svg.drawPolygon(xPoints, yPoints, indicators.size());
    }

}
