package com.paohaijiao.javelin.adaptor;

import com.paohaijiao.javelin.resource.JThornRuleReader;

public class JThornRuleAdaptor {
    private JThornRuleReader dataReader;

    public JThornRuleAdaptor(JThornRuleReader dataReader) {
        this.dataReader = dataReader;
    }

    public void setDataReader(JThornRuleReader dataReader) {
        this.dataReader = dataReader;
    }

    public String getRuleContent() {
        return dataReader.getRule();
    }
}
