package com.essai.testautomation.calculator.common;

import com.essai.testautomation.calculator.constants.Target;
import com.essai.testautomation.calculator.core.driver.DriverManager;
import com.essai.testautomation.calculator.core.utils.PropertiesReader;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {
    protected static AppiumDriver driver;
    protected static PropertiesReader reader = new PropertiesReader();

    @BeforeAll
    public static void setUp() {

        Target target = reader.getTarget();
        driver = new DriverManager().getInstance(target);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}