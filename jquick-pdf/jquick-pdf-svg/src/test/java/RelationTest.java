import com.paohaijiao.data.JOption;
import com.paohaijiao.echart.relation.JRelationChartRenderer;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.*;

public class RelationTest {
    @Test
    public void testBarChar1() throws IOException, ParserConfigurationException, TransformerException {
        JOption option = new JOption();
        option.title("关系图示例");
        List<Map<String, Object>> nodes = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("name", "CEO");
                    put("category", "管理");
                    put("symbolSize", 50);
                    put("itemStyle", new HashMap<String, String>() {{
                        put("color", "#c23531");
                    }});
                }},
                new HashMap<String, Object>() {{
                    put("name", "技术部");
                    put("category", "部门");
                    put("symbolSize", 40);
                    put("itemStyle", new HashMap<String, String>() {{
                        put("color", "#2f4554");
                    }});
                }},
                new HashMap<String, Object>() {{
                    put("name", "产品部");
                    put("category", "部门");
                    put("symbolSize", 40);
                }},
                new HashMap<String, Object>() {{
                    put("name", "前端组");
                    put("category", "团队");
                    put("symbolSize", 30);
                }},
                new HashMap<String, Object>() {{
                    put("name", "后端组");
                    put("category", "团队");
                    put("symbolSize", 30);
                }},
                new HashMap<String, Object>() {{
                    put("name", "UI设计");
                    put("category", "岗位");
                    put("symbolSize", 20);
                }},
                new HashMap<String, Object>() {{
                    put("name", "Java开发");
                    put("category", "岗位");
                    put("symbolSize", 20);
                }}
        );
        List<Map<String, Object>> links = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("source", "CEO");
                    put("target", "技术部");
                    put("label", "直属管理");
                    put("lineStyle", new HashMap<String, Object>() {{
                        put("width", 3);
                        put("type", "solid");
                    }});
                }},
                new HashMap<String, Object>() {{
                    put("source", "技术部");
                    put("target", "前端组");
                    put("label", "包含");
                    put("lineStyle", new HashMap<String, Object>() {{
                        put("width", 2);
                        put("type", "dashed");
                    }});
                }},
                new HashMap<String, Object>() {{
                    put("source", "前端组");
                    put("target", "UI设计");
                    put("label", "协作");
                    put("lineStyle", new HashMap<String, Object>() {{
                        put("width", 1);
                        put("type", "dotted");
                    }});
                }},
                new HashMap<String, Object>() {{
                    put("source", "技术部");
                    put("target", "产品部");
                    put("label", "跨部门合作");
                    put("lineStyle", new HashMap<String, Object>() {{
                        put("color", "#61a0a8");
                        put("curveness", 0.3); // 曲线度
                    }});
                }}
        );
               Document document = GenericDOMImplementation.getDOMImplementation()
               .createDocument("http://www.w3.org/2000/svg", "svg", null);SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        SVGGraphics2D svgGraphics2D = new SVGGraphics2D(document);
        JRelationChartRenderer.generateHeatmapSVG(nodes,links);
    }
}
