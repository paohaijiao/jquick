package com.paohaijiao.javelin.client;

import com.paohaijiao.javelin.adaptor.JThornRuleAdaptor;
import com.paohaijiao.javelin.resource.JThornRuleReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleDataBaseReader;
import com.paohaijiao.javelin.resource.impl.JThornRuleFileReader;

public class Client {
    public static void main(String[] args) {
        // 使用文件读取
        JThornRuleReader fileReader = new JThornRuleFileReader("xxx/rule.txt");
        JThornRuleAdaptor context = new JThornRuleAdaptor(fileReader);
        System.out.println(context.getRuleContent());

        // 切换到数据库读取
        JThornRuleReader dbReader = new JThornRuleDataBaseReader(
                "jdbc:mysql://localhost:3306/mydb",
                "com.mysql.jdbc.Driver",
                "xxx",
                "xxx",
                "SELECT * FROM xxx"
        );
        context.setDataReader(dbReader);
        System.out.println(context.getRuleContent());
    }
}
