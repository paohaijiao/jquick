
import com.paohaijiao.data.JOption;
import com.paohaijiao.data.JRadar;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.axis.JValueAxis;
import com.paohaijiao.data.code.JSeriesType;
import com.paohaijiao.data.code.JTrigger;
import com.paohaijiao.data.json.JGsonOption;
import com.paohaijiao.data.series.JCandlestick;
import com.paohaijiao.data.series.JLine;
import com.paohaijiao.data.series.JRadarSeries;
import com.paohaijiao.data.style.JTextStyle;
import com.paohaijiao.echart.generate.JKChartsRenderer;
import com.paohaijiao.echart.generate.JRadarChartsRenderer;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.junit.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RadarCharTest {
    @Test
    public void testBarChar1() throws IOException, ParserConfigurationException {
        JOption option = new JOption();
        option.title().text("雷达图示例")
                .subtext("使用ECharts和Batik生成")
                .left("center")
                .textStyle(new JTextStyle().color("#333"));
        option.tooltip().trigger(JTrigger.item);
        JRadar radar = new JRadar();
        radar.indicator(
                new JRadar.Indicator().name("销售").max(6500d),
                new JRadar.Indicator().name("管理").max(16000d),
                new JRadar.Indicator().name("信息技术").max(30000d),
                new JRadar.Indicator().name("客服").max(38000d),
                new JRadar.Indicator().name("研发").max(52000d),
                new JRadar.Indicator().name("市场").max(25000d)
        );
        option.radar(radar);
        JRadarSeries series = new JRadarSeries();
        Number[] a1=new Number[]{4300, 10000, 28000, 35000, 50000, 19000};
        Number[] a2=new Number[]{5000, 14000, 28000, 31000, 42000, 21000};
        series.name("预算 vs 开销")
                .type(JSeriesType.radar)
                .data(4300, 10000, 28000, 35000, 50000, 19000
                );
        option.series(series);
        JRadarChartsRenderer.renderRadarChart(option, "d://test//radar_chart.svg");
        System.out.println("雷达图SVG已生成: radar_chart.svg");
    }
}
