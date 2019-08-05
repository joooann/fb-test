package com.planit.jo.framework.webutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Hashtable;
import java.util.Map;

public class WebDriverFactory {

    /**
     * Creates an instance of Selenium WebDriver.
     *
     * @param browserName type of WebDriver to create
     */
    public static WebDriver getNewInstance(String browserName) {

        WebDriver driver = null;

        if ("chrome".equals(browserName.toLowerCase())) {
            WebDriverManager.chromedriver().setup();

            Map<String, Object> preferences = new Hashtable<String, Object>();
            preferences.put("profile.default_content_setting_values.notifications", 2);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", preferences);

            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();

        } else {
            throw new IllegalArgumentException("Unsupported browser");
        }

        return driver;
    }
}
