package com.paohaijiao.echart.anno;

import com.paohaijiao.data.data.JKData;
import com.paohaijiao.data.data.JPieData;

public enum JChartType {
    PIE("PIE", JPieData.class),
    K("K", JKData.class);
    private String type;

    private Class clazz;

    JChartType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
