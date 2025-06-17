import com.paohaijiao.data.JOption;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.series.JBoxplot;
import com.paohaijiao.echart.boxPlot.JBoxPlotChartRenderer;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BoxPlotTest {
    @Test
    public void testBarChar1() throws IOException, ParserConfigurationException {
        JOption option = new JOption();
        option.title().text("销售数据分布");
        option.xAxis(new JCategoryAxis().data("一季度", "二季度", "三季度", "四季度"));
        option.series(new JBoxplot().data(
                new Object[]{10, 15, 20, 25, 30},
                new Object[]{12, 18, 22, 28, 35},
                new Object[]{8, 14, 19, 26, 32},
                new Object[]{11, 16, 21, 27, 33}
        ));

        String svg = JBoxPlotChartRenderer.generateBoxplotSvg(option, 800, 500);
        try {
            java.nio.file.Files.write(
                    java.nio.file.Paths.get("d://test//boxplot_custom.svg"),
                    svg.getBytes()
            );
            System.out.println("SVG文件已保存: boxplot_custom.svg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
