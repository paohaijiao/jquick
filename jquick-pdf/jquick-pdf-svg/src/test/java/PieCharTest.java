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

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.JTitle;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.axis.JValueAxis;
import com.paohaijiao.data.code.JAxisType;
import com.paohaijiao.data.code.JSeriesType;
import com.paohaijiao.data.code.JTrigger;
import com.paohaijiao.data.data.JData;
import com.paohaijiao.data.json.JGsonOption;
import com.paohaijiao.data.series.JBar;
import com.paohaijiao.data.series.JPie;
import com.paohaijiao.data.series.JSeries;
import com.paohaijiao.data.style.JItemStyle;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.paohaijiao.echart.generate.JBarChartsRenderer.renderEChartToSVG;
import static com.paohaijiao.echart.generate.JPieChartsRenderer.renderPieChartToSVG;

/**
 * @ClassName BarCharTest
 * @Description: Description
 * @Author: gou
 * @CreateDate: 2025/6/13 6:52
 * @UpdateUser: UpdateUser
 * @UpdateDate: 2025/6/13 6:52
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PieCharTest {
    @Test
    public void testBarChar1() throws IOException {
        JOption option = new JOption();
        option.title().text("销售占比").subtext("2023年度");
        option.tooltip().trigger(JTrigger.item);
        JPie pie = new JPie("销售占比");
        pie.data(
                new JData().name("衬衫").value(35),
                new JData().name("羊毛衫").value(20),
                new JData().name("雪纺衫").value(15),
                new JData().name("裤子").value(18),
                new JData().name("高跟鞋").value(8),
                new JData().name("袜子").value(4)
        );
        option.series(pie);
        renderPieChartToSVG(option, "d://test//accurate-pie-chart.svg");
        System.out.println("精确版饼图SVG文件已生成: accurate-pie-chart.svg");
    }

}
