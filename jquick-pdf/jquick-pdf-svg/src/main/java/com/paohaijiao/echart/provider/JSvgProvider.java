package com.paohaijiao.echart.provider;

import com.paohaijiao.echart.anno.JChartType;


public interface JSvgProvider <T>{

    public void drawSvg(JChartType type, T data);
}
