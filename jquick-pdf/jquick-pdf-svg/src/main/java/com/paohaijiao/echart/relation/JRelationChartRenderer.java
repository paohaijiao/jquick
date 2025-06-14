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
package com.paohaijiao.echart.relation;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.util.*;
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
public class JRelationChartRenderer {
    public static void generateHeatmapSVG( List<Map<String, Object>> nodes,List<Map<String, Object>> links) throws TransformerException {
        Map<String, Point> nodePositions = new HashMap<>(); // 存储节点名和坐标
        Document document = GenericDOMImplementation.getDOMImplementation()
                .createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        Random random = new Random();
        for (Map<String, Object> node : nodes) {
            String name = (String) node.get("name");
            int size = (int) node.get("symbolSize");
            int x = random.nextInt(500); // 动态生成坐标
            int y = random.nextInt(300);
            nodePositions.put(name, new Point(x, y)); // 存储节点位置
            svgGenerator.setPaint(Color.BLUE);
            svgGenerator.fillOval(x, y, size, size);
            svgGenerator.setPaint(Color.BLACK);
            svgGenerator.drawString(name, x + size, y + size / 2);
        }
        svgGenerator.setPaint(Color.RED);
        svgGenerator.setStroke(new BasicStroke(1.5f));
        for (Map<String, Object> link : links) {
            String source = (String) link.get("source");
            String target = (String) link.get("target");
            Point start = nodePositions.get(source);
            Point end = nodePositions.get(target);
            if (start != null && end != null) {
                int startX = start.x + ((int) nodes.stream()
                        .filter(n -> n.get("name").equals(source))
                        .findFirst().get().get("symbolSize")) / 2;
                int startY = start.y + ((int) nodes.stream()
                        .filter(n -> n.get("name").equals(source))
                        .findFirst().get().get("symbolSize")) / 2;
                int endX = end.x + ((int) nodes.stream()
                        .filter(n -> n.get("name").equals(target))
                        .findFirst().get().get("symbolSize")) / 2;
                int endY = end.y + ((int) nodes.stream()
                        .filter(n -> n.get("name").equals(target))
                        .findFirst().get().get("symbolSize")) / 2;
                svgGenerator.drawLine(startX, startY, endX, endY);
            }
        }
        Element root = svgGenerator.getRoot();
        document.getDocumentElement().appendChild(root);
        TransformerFactory.newInstance()
                .newTransformer()
                .transform(new DOMSource(document),
                        new StreamResult(new File("d://test//dynamic-graph.svg")));
        System.out.println("SVG 已生成：dynamic-graph.svg");
    }



}
