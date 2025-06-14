import com.paohaijiao.echart.boxPlot.JBoxPlotChartRenderer;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BoxPlotTest {
    @Test
    public void testBarChar1() throws IOException, ParserConfigurationException {
        // 准备数据
        double[][] data = {
                {3.0, 4.0, 5.0, 6.0, 7.0},  // 类别1
                {2.0, 4.0, 6.0, 8.0, 10.0}, // 类别2
                {1.0, 3.0, 5.0, 7.0, 9.0},  // 类别3
                {4.0, 5.0, 5.5, 6.0, 7.0}   // 类别4
        };
        String[] categories = {"类别1", "类别2", "类别3", "类别4"};
        String svgContent = JBoxPlotChartRenderer.generateBoxplotSvg(data, categories, 600, 400);
        try {
            java.nio.file.Files.write(
                    java.nio.file.Paths.get("d://test//boxplot_custom.svg"),
                    svgContent.getBytes()
            );
            System.out.println("SVG文件已保存: boxplot_custom.svg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
