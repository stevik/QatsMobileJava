package com.essai.testautomation.calculator.core.driver;

import com.essai.testautomation.calculator.constants.Target;
import com.essai.testautomation.calculator.core.utils.CapabilitiesHelper;
import com.essai.testautomation.calculator.core.utils.PropertiesReader;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Slf4j
public class DriverManager {
    private static AppiumDriver driver;
    String APPIUM_SERVER_URL = new PropertiesReader().getProperty("appium.server.url");

    public AppiumDriver getInstance(Target target) {
        log.info("Getting instance of: " + target.name());
        return switch (target) {
            case ANDROID -> getAndroidDriver();
            case IOS -> getIOSDriver();
        };
    }

    private AppiumDriver getAndroidDriver() {
        Map<String, String> map = CapabilitiesHelper.readAndMakeCapabilities("android-caps.json");
        log.debug("Android Appium capabilities was loaded: " + map);
        return getDriver(map);
    }

    private AppiumDriver getIOSDriver() {
        Map<String, String> map = CapabilitiesHelper.readAndMakeCapabilities("ios-caps.json");
        log.debug("IOs Appium capabilities was loaded: " + map);
        return getDriver(map);
    }

    private AppiumDriver getDriver(Map<String, String> map) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(map);

        try {
            driver = new AppiumDriver(
                    new URL(APPIUM_SERVER_URL), desiredCapabilities);
        } catch (MalformedURLException e) {
            log.error("Error during initialization of Appium Driver", e);
        }

        return driver;
    }
}


