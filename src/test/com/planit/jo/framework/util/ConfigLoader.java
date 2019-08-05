package com.planit.jo.framework.util;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Loads environment properties from file
 */
public class ConfigLoader {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConfigLoader.class);

    private static ConfigLoader instance = null;
    private Properties properties;
    private String configFile = "config.properties";

    protected ConfigLoader() throws IOException {
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(configFile));
    }

    public static ConfigLoader getInstance() {
        if (instance == null) {
            try {
                instance = new ConfigLoader();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "");
    }
}