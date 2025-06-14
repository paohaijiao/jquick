import com.paohaijiao.echart.heatMap.JHeatMapChartRenderer;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class HeatMapCharTest {
    @Test
    public void testBarChar1() throws IOException, ParserConfigurationException {
        // 1. 使用ECharts Java库生成热力图数据模型
        //String echartsOption = HeatmapGenerator.generateHeatmapOption();
        System.out.println("ECharts配置JSON:");
        //System.out.println(echartsOption);

        // 2. 生成模拟数据
        String[] xLabels = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        String[] yLabels = {"12a", "1a", "2a", "3a", "4a", "5a", "6a",
                "7a", "8a", "9a", "10a", "11a", "12p", "1p",
                "2p", "3p", "4p", "5p", "6p", "7p", "8p", "9p", "10p", "11p"};

        double[][] heatmapData = new double[xLabels.length][yLabels.length];
        for (int i = 0; i < xLabels.length; i++) {
            for (int j = 0; j < yLabels.length; j++) {
                heatmapData[i][j] = Math.random() * 100;
            }
        }

        // 3. 使用Batik生成SVG
        JHeatMapChartRenderer.generateHeatmapSVG(heatmapData, xLabels, yLabels, "d://test//heatmap.svg");
        System.out.println("SVG文件已生成: heatmap.svg");
    }
}
