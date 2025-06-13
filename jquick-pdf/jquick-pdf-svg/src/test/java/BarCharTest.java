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
import com.paohaijiao.data.json.JGsonOption;
import com.paohaijiao.data.series.JBar;
import com.paohaijiao.data.series.JSeries;
import com.paohaijiao.data.style.JItemStyle;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static com.paohaijiao.echart.test.PureBatikEChartsRenderer.renderEChartToSVG;

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
public class BarCharTest {
    @Test
    public void testBarChar1() throws IOException {
        JOption option = new JOption();
        option.title().text("销售数据").subtext("2023年度");
        option.tooltip().trigger(JTrigger.axis);
        JCategoryAxis xAxis = new JCategoryAxis();
        xAxis.data("衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子");
        option.xAxis(xAxis);
        option.yAxis(new JValueAxis());
        JBar bar = new JBar();
        bar.name("销量").data(5, 20, 36, 10, 10, 20);
        option.series(bar);
        renderEChartToSVG(option, "D://test//echart-output.svg");
        System.out.println("SVG文件已生成: echart-output.svg");
    }
    @Test
    public void testBarChar2() throws IOException {
        JGsonOption option = new JGsonOption();
        JCategoryAxis xAxis = new JCategoryAxis();
        xAxis.setType(JAxisType.category);
        xAxis.setData(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        option.setxAxis(Arrays.asList(xAxis));
        JValueAxis yAxis = new JValueAxis();
        yAxis.setType(JAxisType.value);
        option.setyAxis(Arrays.asList(yAxis));
        JBar bar = new JBar();
        bar.setType(JSeriesType.bar);
        List<Object> data = new ArrayList<>();
        data.add(120);
        //Map<String, Object> specialData = new HashMap<>();
    //    specialData.put("value", 200);
        JItemStyle itemStyle = new JItemStyle();
        itemStyle.setColor("#a90000");
    //    specialData.put("itemStyle", itemStyle);

      //  data.add(specialData);
        data.addAll(Arrays.asList(150, 80, 70, 110, 130));

        bar.setData(data);
        option.setSeries(Arrays.asList(bar));


        bar.setData(data);
        List<JSeries> seriesList = new ArrayList<>();
        seriesList.add(bar);
        option.setSeries(seriesList);
        JTitle title=new JTitle();
        title.setText("title");
        title.setSubtext("subtext");
        option.setTitle(title);
        renderEChartToSVG(option, "D://test//echart-output.svg");
        System.out.println("SVG文件已生成: echart-output.svg");
    }
}
