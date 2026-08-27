package com.ecommerce.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // The static block runs once when the class is loaded
    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties file!");
        }
    }

    // Method to fetch data by its key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}