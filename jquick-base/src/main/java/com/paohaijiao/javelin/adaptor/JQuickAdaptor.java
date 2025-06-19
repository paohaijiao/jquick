package com.paohaijiao.javelin.adaptor;

import com.paohaijiao.javelin.resource.JQuickReader;

public class JQuickAdaptor {
    private JQuickReader dataReader;

    public JQuickAdaptor(JQuickReader dataReader) {
        this.dataReader = dataReader;
    }

    public void setDataReader(JQuickReader dataReader) {
        this.dataReader = dataReader;
    }

    public String getRuleContent() {
        return dataReader.getRule();
    }
}
