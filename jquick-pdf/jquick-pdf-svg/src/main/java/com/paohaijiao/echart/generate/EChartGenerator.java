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
package com.paohaijiao.echart.generate;

import com.paohaijiao.data.JOption;
import com.paohaijiao.data.axis.JCategoryAxis;
import com.paohaijiao.data.axis.JValueAxis;
import com.paohaijiao.data.series.JBar;

/**
 * @ClassName EChartGenerator
 * @Description: Description
 * @Author: gou
 * @CreateDate: 2025/6/12 8:56
 * @UpdateUser: UpdateUser
 * @UpdateDate: 2025/6/12 8:56
 * @UpdateRemark:
 * @Version: 1.0
 */
public class EChartGenerator {
    public static JOption createBarChart() {
        JOption option = new JOption();
        option.title().text("示例柱状图").subtext("来自ECharts数据");

        // X轴
        JCategoryAxis xAxis = new JCategoryAxis();
        xAxis.data("周一", "周二", "周三", "周四", "周五", "周六", "周日");
        option.xAxis(xAxis);

        // Y轴
        option.yAxis(new JValueAxis());

        // 数据系列
        JBar bar = new JBar("销量");
        bar.data(120, 200, 150, 80, 70, 110, 130);
        option.series(bar);

        return option;
    }
}
