///*
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// *
// * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
// */
//package com.paohaijiao.echart.provider.impl;
//
//import com.paohaijiao.data.axis.JCategoryAxis;
//import com.paohaijiao.data.axis.JValueAxis;
//import com.paohaijiao.data.code.JMagic;
//import com.paohaijiao.data.code.JTool;
//import com.paohaijiao.data.feature.JMagicType;
//import com.paohaijiao.data.json.JGsonOption;
//import com.paohaijiao.data.series.JBar;
//import com.paohaijiao.data.style.JItemStyle;
//import com.paohaijiao.data.style.itemstyle.JNormal;
//import com.paohaijiao.echart.anno.JChartType;
//import com.paohaijiao.echart.provider.JSvgProvider;
//
//import javax.lang.model.element.Element;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName JSvgImplProvider
// * @Description: Description
// * @Author: gou
// * @CreateDate: 2025/6/11 19:36
// * @UpdateUser: UpdateUser
// * @UpdateDate: 2025/6/11 19:36
// * @UpdateRemark:
// * @Version: 1.0
// */
//public class JSvgBarChartProvider extends JSvgBaseImplProvider<JGsonOption> implements JSvgProvider<JGsonOption> {
//
//    @Override
//    public String getData(JChartType type, JGsonOption option) {
//        String[] citis = { "广州", "深圳", "珠海", "汕头", "韶关", "佛山" };
//        int[] datas = { 6030, 7800, 5200, 3444, 2666, 5708 };
//        String[] colors = { "rgb(2,111,230)", "rgb(186,73,46)", "rgb(78,154,97)", "rgb(2,111,230)", "rgb(186,73,46)", "rgb(78,154,97)" };
//        String title = "地市数据";
//        boolean isHorizontal=true;
//        option.title(title); // 标题
//               option.toolbox().show(true).feature(JTool.mark,
//                       JTool.dataView,
//                       new JMagicType(JMagic.line, JMagic.bar),
//                JTool.restore,
//                JTool.saveAsImage);
//                option.tooltip().show(true).formatter("{a} <br/>{b} : {c}");//显示工具提示,设置提示格式
//                option.legend(title);
//                JBar bar = new JBar(title);
//                JCategoryAxis category = new JCategoryAxis();// 轴分类
//                category.data(citis);// 轴数据类别
//                for (int i = 0; i < citis.length; i++) {
//                 int data = datas[i];
//                    String color = colors[i];
//                         Map<String, Object> map = new HashMap<String, Object>(2);
//                         map.put("value", data);
//                         map.put("itemStyle", new JItemStyle().normal(new JNormal().color(color)));
//                         bar.data(map);
//                     }
//
//                 if (isHorizontal) {// 横轴为类别、纵轴为值
//                         option.xAxis(category);// x轴
//                         option.yAxis(new JValueAxis());// y轴
//                     } else {// 横轴为值、纵轴为类别
//                         option.xAxis(new JValueAxis());// x轴
//                         option.yAxis(category);// y轴
//                     }
//
//                 option.series(bar);
//                 return option.toString();
//
//    }
//
//    @Override
//    public Map<String, Object> buildSvgParam() {
//        // 提取配置参数
//        Map<String, Object> titleConfig = (Map<String, Object>) echartConfig.get("title");
//        String title = (String) titleConfig.get("text");
//
//        Map<String, Object> xAxisConfig = ((List<Map<String, Object>>) echartConfig.get("xAxis")).get(0);
//        List<String> categories = (List<String>) xAxisConfig.get("data");
//
//        Map<String, Object> seriesConfig = ((List<Map<String, Object>>) echartConfig.get("series")).get(0);
//        List<Map<String, Object>> data = (List<Map<String, Object>>) seriesConfig.get("data");
//
//        // 初始化SVG文档
//        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
//        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
//        Document document = impl.createDocument(svgNS, "svg", null);
//
//        // 设置SVG根元素属性
//        Element svgRoot = document.getDocumentElement();
//        svgRoot.setAttribute("width", "800");
//        svgRoot.setAttribute("height", "500");
//        svgRoot.setAttribute("viewBox", "0 0 800 500");
//
//        // 添加样式
//        Element style = document.createElementNS(svgNS, "style");
//        style.setTextContent(
//                ".title { font: bold 18px sans-serif; } " +
//                        ".axis-label { font: 12px sans-serif; } " +
//                        ".legend-label { font: 12px sans-serif; } " +
//                        ".tooltip { font: 12px sans-serif; fill: #333; }" +
//                        ".grid-line { stroke: #eee; stroke-width: 1; }"
//        );
//        svgRoot.appendChild(style);
//
//        // 添加背景
//        Element background = document.createElementNS(svgNS, "rect");
//        background.setAttribute("x", "0");
//        background.setAttribute("y", "0");
//        background.setAttribute("width", "100%");
//        background.setAttribute("height", "100%");
//        background.setAttribute("fill", "#fff");
//        svgRoot.appendChild(background);
//
//        // 添加标题
//        Element titleElement = document.createElementNS(svgNS, "text");
//        titleElement.setAttribute("x", "400");
//        titleElement.setAttribute("y", "40");
//        titleElement.setAttribute("text-anchor", "middle");
//        titleElement.setAttribute("class", "title");
//        titleElement.setTextContent(title);
//        svgRoot.appendChild(titleElement);
//
//        // 计算图表参数
//        int barWidth = 50;
//        int gap = 30;
//        int startX = 100;
//        int startY = 400;
//        int chartHeight = 300;
//
//        // 找出最大值用于缩放
//        double maxValue = data.stream()
//                .mapToDouble(d -> Double.parseDouble(d.get("value").toString()))
//                .max()
//                .orElse(1.0);
//
//        // 绘制网格线
//        for (int i = 0; i <= 5; i++) {
//            int y = startY - (int) (chartHeight * (i / 5.0));
//
//            Element gridLine = document.createElementNS(svgNS, "line");
//            gridLine.setAttribute("x1", String.valueOf(startX - 20));
//            gridLine.setAttribute("y1", String.valueOf(y));
//            gridLine.setAttribute("x2", String.valueOf(startX + categories.size() * (barWidth + gap) - gap + 20));
//            gridLine.setAttribute("y2", String.valueOf(y));
//            gridLine.setAttribute("class", "grid-line");
//            svgRoot.appendChild(gridLine);
//
//            // 添加Y轴刻度标签
//            Element scaleLabel = document.createElementNS(svgNS, "text");
//            scaleLabel.setAttribute("x", String.valueOf(startX - 25));
//            scaleLabel.setAttribute("y", String.valueOf(y + 4));
//            scaleLabel.setAttribute("text-anchor", "end");
//            scaleLabel.setAttribute("class", "axis-label");
//            scaleLabel.setTextContent(String.valueOf((int) (maxValue * (i / 5.0))));
//            svgRoot.appendChild(scaleLabel);
//        }
//
//        // 绘制X轴和Y轴
//        Element xAxis = document.createElementNS(svgNS, "line");
//        xAxis.setAttribute("x1", String.valueOf(startX - 20));
//        xAxis.setAttribute("y1", String.valueOf(startY));
//        xAxis.setAttribute("x2", String.valueOf(startX + categories.size() * (barWidth + gap) - gap + 20));
//        xAxis.setAttribute("y2", String.valueOf(startY));
//        xAxis.setAttribute("stroke", "#333");
//        xAxis.setAttribute("stroke-width", "2");
//        svgRoot.appendChild(xAxis);
//
//        Element yAxis = document.createElementNS(svgNS, "line");
//        yAxis.setAttribute("x1", String.valueOf(startX - 20));
//        yAxis.setAttribute("y1", String.valueOf(startY));
//        yAxis.setAttribute("x2", String.valueOf(startX - 20));
//        yAxis.setAttribute("y2", String.valueOf(startY - chartHeight - 10));
//        yAxis.setAttribute("stroke", "#333");
//        yAxis.setAttribute("stroke-width", "2");
//        svgRoot.appendChild(yAxis);
//
//        // 绘制柱状图
//        for (int i = 0; i < categories.size(); i++) {
//            String category = categories.get(i);
//            Map<String, Object> item = data.get(i);
//            double value = Double.parseDouble(item.get("value").toString());
//
//            // 获取自定义颜色
//            String color = "#4e79a7"; // 默认颜色
//            if (item.containsKey("itemStyle")) {
//                Map<String, Object> itemStyle = (Map<String, Object>) item.get("itemStyle");
//                if (itemStyle.containsKey("normal")) {
//                    Map<String, Object> normal = (Map<String, Object>) itemStyle.get("normal");
//                    if (normal.containsKey("color")) {
//                        color = (String) normal.get("color");
//                    }
//                }
//            }
//
//            // 计算柱子的高度
//            int barHeight = (int) (chartHeight * (value / maxValue));
//
//            // 绘制柱子
//            Element bar = document.createElementNS(svgNS, "rect");
//            bar.setAttribute("x", String.valueOf(startX + i * (barWidth + gap)));
//            bar.setAttribute("y", String.valueOf(startY - barHeight));
//            bar.setAttribute("width", String.valueOf(barWidth));
//            bar.setAttribute("height", String.valueOf(barHeight));
//            bar.setAttribute("fill", color);
//            bar.setAttribute("rx", "2"); // 圆角
//            bar.setAttribute("ry", "2"); // 圆角
//
//            // 添加鼠标悬停效果
//            bar.setAttribute("onmouseover", "showTooltip(evt, '" + category + "', " + value + ")");
//            bar.setAttribute("onmouseout", "hideTooltip()");
//
//            svgRoot.appendChild(bar);
//
//            // 添加X轴标签
//            Element label = document.createElementNS(svgNS, "text");
//            label.setAttribute("x", String.valueOf(startX + i * (barWidth + gap) + barWidth / 2));
//            label.setAttribute("y", String.valueOf(startY + 25));
//            label.setAttribute("text-anchor", "middle");
//            label.setAttribute("class", "axis-label");
//            label.setTextContent(category);
//            svgRoot.appendChild(label);
//        }
//
//        // 添加图例
//        Element legendGroup = document.createElementNS(svgNS, "g");
//        legendGroup.setAttribute("transform", "translate(600, 100)");
//
//        Element legendRect = document.createElementNS(svgNS, "rect");
//        legendRect.setAttribute("x", "0");
//        legendRect.setAttribute("y", "0");
//        legendRect.setAttribute("width", "150");
//        legendRect.setAttribute("height", "40");
//        legendRect.setAttribute("fill", "#f9f9f9");
//        legendRect.setAttribute("stroke", "#ddd");
//        legendGroup.appendChild(legendRect);
//
//        Element legendSymbol = document.createElementNS(svgNS, "rect");
//        legendSymbol.setAttribute("x", "10");
//        legendSymbol.setAttribute("y", "15");
//        legendSymbol.setAttribute("width", "15");
//        legendSymbol.setAttribute("height", "15");
//        legendSymbol.setAttribute("fill", "#4e79a7");
//        legendGroup.appendChild(legendSymbol);
//
//        Element legendLabel = document.createElementNS(svgNS, "text");
//        legendLabel.setAttribute("x", "35");
//        legendLabel.setAttribute("y", "27");
//        legendLabel.setAttribute("class", "legend-label");
//        legendLabel.setTextContent("地市数据");
//        legendGroup.appendChild(legendLabel);
//
//        svgRoot.appendChild(legendGroup);
//
//        // 添加工具提示容器
//        Element tooltip = document.createElementNS(svgNS, "g");
//        tooltip.setAttribute("id", "tooltip");
//        tooltip.setAttribute("visibility", "hidden");
//
//        Element tooltipRect = document.createElementNS(svgNS, "rect");
//        tooltipRect.setAttribute("rx", "5");
//        tooltipRect.setAttribute("ry", "5");
//        tooltipRect.setAttribute("fill", "rgba(50, 50, 50, 0.8)");
//        tooltip.appendChild(tooltipRect);
//
//        Element tooltipText = document.createElementNS(svgNS, "text");
//        tooltipText.setAttribute("class", "tooltip");
//        tooltipText.setAttribute("x", "10");
//        tooltipText.setAttribute("y", "20");
//        tooltip.appendChild(tooltipText);
//
//        svgRoot.appendChild(tooltip);
//
//        // 添加JavaScript处理工具提示
//        Element script = document.createElementNS(svgNS, "script");
//        script.setAttribute("type", "text/ecmascript");
//        script.setTextContent(
//                "function showTooltip(evt, name, value) {\n" +
//                        "  var tooltip = document.getElementById('tooltip');\n" +
//                        "  var tooltipText = tooltip.getElementsByTagName('text')[0];\n" +
//                        "  \n" +
//                        "  tooltipText.textContent = name + ': ' + value;\n" +
//                        "  \n" +
//                        "  var bbox = tooltipText.getBBox();\n" +
//                        "  var tooltipRect = tooltip.getElementsByTagName('rect')[0];\n" +
//                        "  tooltipRect.setAttribute('x', bbox.x - 5);\n" +
//                        "  tooltipRect.setAttribute('y', bbox.y - 5);\n" +
//                        "  tooltipRect.setAttribute('width', bbox.width + 10);\n" +
//                        "  tooltipRect.setAttribute('height', bbox.height + 10);\n" +
//                        "  \n" +
//                        "  tooltip.setAttribute('transform', 'translate(' + (evt.clientX - 50) + ',' + (evt.clientY - 50) + ')');\n" +
//                        "  tooltip.setAttribute('visibility', 'visible');\n" +
//                        "}\n" +
//                        "\n" +
//                        "function hideTooltip() {\n" +
//                        "  document.getElementById('tooltip').setAttribute('visibility', 'hidden');\n" +
//                        "}"
//        );
//        svgRoot.appendChild(script);
//
//        // 保存SVG到文件
//        saveSVG(document, outputFile);
//    }
//
//    public static void main(String[] args) {
//        JSvgBarChartProvider bar=new JSvgBarChartProvider();
//        System.out.println(bar.getData(null,new JGsonOption()));
//    }
//}
