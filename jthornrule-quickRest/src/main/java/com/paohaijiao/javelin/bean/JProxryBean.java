package com.paohaijiao.javelin.bean;

import com.paohaijiao.javelin.enums.JProxryType;
import lombok.Data;

@Data
public class JProxryBean {

    private String host;
    private Integer port;
    private JProxryType type;
}
