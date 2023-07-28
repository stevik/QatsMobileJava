package com.essai.testautomation.calculator.core.utils;

import com.essai.testautomation.calculator.constants.Target;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesReader {
    Properties props = new Properties();

    public PropertiesReader() {
        load();
    }

    public Target getTarget() {
        return Target.valueOf(props.getProperty("target"));
    }

    public String getProperty(String propertyName) {
        return props.getProperty(propertyName);
    }

    public void load() {
        String propertyFileName = "env.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream stream = loader.getResourceAsStream(propertyFileName)) {
            props.load(stream);
        } catch (IOException e) {
            log.error("Error during loading of properties from file: " + propertyFileName, e);
        }
    }
}
