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
package com.paohaijiao.echart.sunburst;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * packageName com.paohaijiao.echart.generate
 *
 * @author Martin
 * @version 1.0.0
 * @className SunburstChart
 * @date 2025/6/14
 * @description
 */
public class JSunburstChart {
    private static class SunburstNode {
        String name;
        Color color;
        Color borderColor;
        List<SunburstNode> children = new ArrayList<>();
        double value = 1; // Default value
        double startAngle;
        double endAngle;
        int depth;
        int maxDepth;
    }

    public static void main(String[] args) throws Exception {
        // Create SVG document
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // Create root element with animation support
        Element svgRoot = document.createElementNS(svgNS, "svg");
        svgRoot.setAttributeNS(null, "width", "1000");
        svgRoot.setAttributeNS(null, "height", "1000");
        svgRoot.setAttributeNS(null, "viewBox", "0 0 1000 1000");
        document.appendChild(svgRoot);

        // Add style for hover effects
        Element style = document.createElementNS(svgNS, "style");
        style.setTextContent(
                ".arc:hover { filter: url(#drop-shadow); } " +
                        ".label { font-family: Arial; font-size: 12px; pointer-events: none; } " +
                        ".center-text { font-family: Arial; font-size: 24px; font-weight: bold; text-anchor: middle; }"
        );
        svgRoot.appendChild(style);

        // Add filter for hover effect
        Element filter = document.createElementNS(svgNS, "filter");
        filter.setAttributeNS(null, "id", "drop-shadow");
        filter.setAttributeNS(null, "height", "130%");
        Element feGaussian = document.createElementNS(svgNS, "feGaussianBlur");
        feGaussian.setAttributeNS(null, "in", "SourceAlpha");
        feGaussian.setAttributeNS(null, "stdDeviation", "3");
        filter.appendChild(feGaussian);
        svgRoot.appendChild(filter);

        // Create graphics context
        SVGGraphics2D g = new SVGGraphics2D(document);

        // Parse data and build tree
        SunburstNode root = buildCoffeeLexiconTree();
        calculateTreeAngles(root, 0, 2 * Math.PI);

        // Draw sunburst with multiple levels
        drawMultiLevelSunburst(document, g, svgRoot, root, 500, 500);

        // Add title
        Element title = document.createElementNS(svgNS, "text");
        title.setAttributeNS(null, "x", "500");
        title.setAttributeNS(null, "y", "40");
        title.setAttributeNS(null, "class", "center-text");
        title.setTextContent("WORLD COFFEE RESEARCH SENSORY LEXICON");
        svgRoot.appendChild(title);

        // Add subtitle
        Element subtitle = document.createElementNS(svgNS, "text");
        subtitle.setAttributeNS(null, "x", "500");
        subtitle.setAttributeNS(null, "y", "70");
        subtitle.setAttributeNS(null, "class", "center-text");
        subtitle.setAttributeNS(null, "style", "font-size: 14px;");
        subtitle.setTextContent("Source: worldcoffeeresearch.org");
        svgRoot.appendChild(subtitle);

        // Write SVG file
        try (Writer out = new OutputStreamWriter(new FileOutputStream("d://test//enhanced_coffee_sunburst.svg"), "UTF-8")) {
            g.stream(svgRoot, out, true, false);
        }
    }

    private static SunburstNode buildCoffeeLexiconTree() {
        SunburstNode root = new SunburstNode();
        root.depth = -1;

        // Level 1 Categories
        String[] categories = {"Flora", "Fruity", "Sour/Fermented", "Green/Vegetative",
                "Other", "Roasted", "Spices", "Nutty/Cocoa", "Sweet"};
        Color[] colors = {
                Color.decode("#da0d68"), Color.decode("#da1d23"), Color.decode("#ebb40f"),
                Color.decode("#187a2f"), Color.decode("#0aa3b5"), Color.decode("#c94930"),
                Color.decode("#ad213e"), Color.decode("#a87b64"), Color.decode("#e65832")
        };

        for (int i = 0; i < categories.length; i++) {
            SunburstNode category = new SunburstNode();
            category.name = categories[i];
            category.color = colors[i];
            category.borderColor = colors[i].darker();
            category.depth = 0;

            // Add subcategories (simplified)
            int subCount = 3 + (int)(Math.random() * 3);
            for (int j = 0; j < subCount; j++) {
                SunburstNode subcategory = new SunburstNode();
                subcategory.name = "Sub-" + (j+1);
                subcategory.color = interpolateColor(colors[i], Color.WHITE, 0.3f);
                subcategory.borderColor = colors[i].darker();
                subcategory.depth = 1;

                // Add leaf items
                int leafCount = 2 + (int)(Math.random() * 4);
                for (int k = 0; k < leafCount; k++) {
                    SunburstNode leaf = new SunburstNode();
                    leaf.name = "Item-" + (k+1);
                    leaf.color = interpolateColor(colors[i], Color.WHITE, 0.6f);
                    leaf.borderColor = colors[i].darker();
                    leaf.depth = 2;
                    leaf.value = 0.5 + Math.random() * 1.5;
                    subcategory.children.add(leaf);
                }

                category.children.add(subcategory);
            }

            root.children.add(category);
        }

        return root;
    }
    private static double calculateTreeAngles(SunburstNode node, double startAngle, double endAngle) {
        node.startAngle = startAngle;

        if (node.children.isEmpty()) {
            node.endAngle = endAngle;
            return node.value > 0 ? node.value : 1;
        }

        // First pass: calculate total value of children
        double total = 0;
        for (SunburstNode child : node.children) {
            total += child.value > 0 ? child.value : 1;
        }

        // Second pass: assign angles proportionally
        double currentStart = startAngle;
        for (SunburstNode child : node.children) {
            double childValue = child.value > 0 ? child.value : 1;
            double childSpan = (endAngle - startAngle) * (childValue / total);
            calculateTreeAngles(child, currentStart, currentStart + childSpan);
            currentStart += childSpan;
        }

        node.endAngle = endAngle;
        return total;
    }

    private static void drawMultiLevelSunburst(Document doc, SVGGraphics2D g, Element svgRoot, SunburstNode root, int centerX, int centerY) {
        // Adjust radii to better fit the space
        int[] levelRadii = {50, 150, 250, 350}; // Start with smaller inner radius

        // Draw arcs for each node
        drawNodeArcs(doc, svgRoot, root, centerX, centerY, levelRadii);

        // Draw labels after all arcs are drawn
        drawNodeLabels(doc, svgRoot, root, centerX, centerY, levelRadii);
    }

    private static void drawNodeArcs(Document doc, Element svgRoot, SunburstNode node, int centerX, int centerY, int[] levelRadii) {
        if (node.depth >= 0 && node.depth < levelRadii.length) {
            int outerRadius = levelRadii[node.depth];
            int innerRadius = node.depth > 0 ? levelRadii[node.depth - 1] : 0;

            // Create arc path
            Element arc = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");

            // Build the arc path data
            double startDeg = Math.toDegrees(node.startAngle);
            double extentDeg = Math.toDegrees(node.endAngle - node.startAngle);

            Point2D outerStart = getPoint(centerX, centerY, outerRadius, node.startAngle);
            Point2D outerEnd = getPoint(centerX, centerY, outerRadius, node.endAngle);
            Point2D innerStart = getPoint(centerX, centerY, innerRadius, node.startAngle);
            Point2D innerEnd = getPoint(centerX, centerY, innerRadius, node.endAngle);

            boolean largeArc = extentDeg > 180;

            String pathData = String.format("M%.1f,%.1f L%.1f,%.1f A%d,%d 0 %d,1 %.1f,%.1f L%.1f,%.1f A%d,%d 0 %d,0 %.1f,%.1f Z",
                    outerStart.getX(), outerStart.getY(),
                    innerStart.getX(), innerStart.getY(),
                    innerRadius, innerRadius, largeArc ? 1 : 0,
                    innerEnd.getX(), innerEnd.getY(),
                    outerEnd.getX(), outerEnd.getY(),
                    outerRadius, outerRadius, largeArc ? 1 : 0,
                    outerStart.getX(), outerStart.getY());

            arc.setAttributeNS(null, "d", pathData);
            arc.setAttributeNS(null, "fill", toHex(node.color));
            arc.setAttributeNS(null, "stroke", toHex(node.borderColor));
            arc.setAttributeNS(null, "stroke-width", "1");
            arc.setAttributeNS(null, "class", "arc");

            // Add animation
            Element animate = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "animate");
            animate.setAttributeNS(null, "attributeName", "opacity");
            animate.setAttributeNS(null, "values", "0;1");
            animate.setAttributeNS(null, "dur", "0.5s");
            animate.setAttributeNS(null, "begin", node.depth * 0.1 + "s");
            animate.setAttributeNS(null, "fill", "freeze");
            arc.appendChild(animate);

            svgRoot.appendChild(arc);
        }

        for (SunburstNode child : node.children) {
            drawNodeArcs(doc, svgRoot, child, centerX, centerY, levelRadii);
        }
    }
    private static void drawNodeLabels(Document doc, Element svgRoot, SunburstNode node, int centerX, int centerY, int[] levelRadii) {
        if (node.name != null && node.depth >= 0 && node.depth < levelRadii.length) {
            int outerRadius = levelRadii[node.depth];
            int innerRadius = node.depth > 0 ? levelRadii[node.depth - 1] : 0;
            int labelRadius = (outerRadius + innerRadius) / 2;

            double midAngle = (node.startAngle + node.endAngle) / 2;
            Point2D point = getPoint(centerX, centerY, labelRadius, midAngle);

            // More relaxed condition for showing labels
            if ((node.endAngle - node.startAngle) > Math.toRadians(5)) {
                Element text = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "text");
                text.setAttributeNS(null, "x", String.valueOf(point.getX()));
                text.setAttributeNS(null, "y", String.valueOf(point.getY()));
                text.setAttributeNS(null, "class", "label");
                text.setAttributeNS(null, "fill", "#ffffff"); // Better contrast

                // Rotate text for better readability
                double degrees = Math.toDegrees(midAngle);
                if (degrees > 90 && degrees < 270) {
                    degrees += 180;
                    text.setAttributeNS(null, "text-anchor", "end");
                } else {
                    text.setAttributeNS(null, "text-anchor", "start");
                }

                text.setAttributeNS(null, "transform",
                        String.format("rotate(%.1f %.1f %.1f)", degrees, point.getX(), point.getY()));

                // Add animation
                Element animate = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "animate");
                animate.setAttributeNS(null, "attributeName", "opacity");
                animate.setAttributeNS(null, "values", "0;1");
                animate.setAttributeNS(null, "dur", "0.5s");
                animate.setAttributeNS(null, "begin", node.depth * 0.1 + 0.3 + "s");
                animate.setAttributeNS(null, "fill", "freeze");
                text.appendChild(animate);

                text.setTextContent(node.name);
                svgRoot.appendChild(text);
            }
        }

        for (SunburstNode child : node.children) {
            drawNodeLabels(doc, svgRoot, child, centerX, centerY, levelRadii);
        }
    }

    // Helper methods
    private static Point2D getPoint(int centerX, int centerY, int radius, double angle) {
        return new Point2D.Double(
                centerX + radius * Math.cos(angle),
                centerY + radius * Math.sin(angle)
        );
    }

    private static String toHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    private static Color interpolateColor(Color c1, Color c2, float ratio) {
        int r = (int)(c1.getRed() * ratio + c2.getRed() * (1 - ratio));
        int g = (int)(c1.getGreen() * ratio + c2.getGreen() * (1 - ratio));
        int b = (int)(c1.getBlue() * ratio + c2.getBlue() * (1 - ratio));
        return new Color(r, g, b);
    }
}
