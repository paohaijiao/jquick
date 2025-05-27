package org.paohaijiao.jstark.client;

import org.paohaijiao.jstark.adaptor.JThornRuleAdaptor;
import org.paohaijiao.jstark.resource.JThornRuleReader;
import org.paohaijiao.jstark.resource.impl.JThornRuleDataBaseReader;
import org.paohaijiao.jstark.resource.impl.JThornRuleFileReader;

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
