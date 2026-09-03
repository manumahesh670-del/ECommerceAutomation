package com.ecommerce.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            // Points to the config file we just created
            FileInputStream file = new FileInputStream("config/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            System.out.println("Error reading config file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}