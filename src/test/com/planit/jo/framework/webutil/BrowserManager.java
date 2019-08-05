package com.planit.jo.framework.webutil;

import com.planit.jo.framework.util.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private static final Logger log = LoggerFactory.getLogger(BrowserManager.class);

    private WebDriver driver;

    private String browserName;
    private String applicationURL;
    private long timeout;

    public BrowserManager() {
        ConfigLoader configLoader = ConfigLoader.getInstance();

        browserName = configLoader.getProperty("browser.name");
        applicationURL = configLoader.getProperty("application.url");
        timeout = Long.valueOf(configLoader.getProperty("test.timeout"));
    }

    public WebDriver getNewBrowser() {
        driver = WebDriverFactory.getNewInstance(browserName);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        return driver;
    }

    public void gotoApplication() {
        log.info("Launching " + applicationURL);
        driver.get(applicationURL);
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void cleanUp() {
        log.info("Cleaning up WebDriver");
        driver.close();
        driver.quit();
    }
}
