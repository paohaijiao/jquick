package org.paohaijiao.jstark.adaptor;

import org.paohaijiao.jstark.resource.JThornRuleReader;

public class JThornRuleAdaptor {
    private JThornRuleReader dataReader;

    public JThornRuleAdaptor(JThornRuleReader dataReader) {
        this.dataReader = dataReader;
    }

    public void setDataReader(JThornRuleReader dataReader) {
        this.dataReader = dataReader;
    }

    public String executeRead() {
        return dataReader.readData();
    }
}
