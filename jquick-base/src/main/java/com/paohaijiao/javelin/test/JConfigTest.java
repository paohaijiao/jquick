package com.paohaijiao.javelin.test;

import com.paohaijiao.javelin.env.JEnvironmentAwareConfigLoader;

public class JConfigTest {
    public static void main(String[] args) {
        JEnvironmentAwareConfigLoader configLoader = new JEnvironmentAwareConfigLoader();
        System.out.println("Dev Environment:");
        printConfigs(configLoader);
        configLoader.setActiveProfile("prod");
        System.out.println("\nProd Environment:");
        printConfigs(configLoader);
    }

    private static void printConfigs(JEnvironmentAwareConfigLoader configLoader) {
        System.out.println("App Name: " + configLoader.getProperty("app.name"));
        System.out.println("DB URL: " + configLoader.getProperty("database.url"));
        System.out.println("DB Username: " + configLoader.getProperty("database.username"));
        System.out.println("DB Pool Size: " + configLoader.getProperty("database.pool-size"));
    }
}
