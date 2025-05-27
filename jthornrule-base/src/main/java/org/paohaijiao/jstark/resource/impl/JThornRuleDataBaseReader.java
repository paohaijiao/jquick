package org.paohaijiao.jstark.resource.impl;

import org.paohaijiao.jstark.resource.JThornRuleReader;

import java.sql.*;

public class JThornRuleDataBaseReader implements JThornRuleReader {
    private String jdbcUrl;

    private String driverClass;

    private String username;

    private String password;

    private String query;

    public JThornRuleDataBaseReader(String jdbcUrl, String driverClass,
                                    String username, String password, String query) {
        this.jdbcUrl = jdbcUrl;
        this.driverClass = driverClass;
        this.username = username;
        this.password = password;
        this.query = query;
    }

    @Override
    public String getRule() {
        // 实现数据库读取逻辑
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    result.append(rs.getString(i)).append(",");
                }
                result.append("\n");
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read from database", e);
        } finally {
            // 关闭资源
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignore */ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* ignore */ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /* ignore */ }
        }

        return result.toString();
    }
}
