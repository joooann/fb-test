package com.planit.jo.framework.webutil;

import com.planit.jo.framework.util.ConfigLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static ConfigLoader config = ConfigLoader.getInstance();
    private BrowserManager browserManager;

    public BaseTest() {
        browserManager = new BrowserManager();
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        browserManager.getNewBrowser();
        browserManager.gotoApplication();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if (browserManager != null) {
            browserManager.cleanUp();
        }
    }

    public BrowserManager getBrowserManager() {
        return browserManager;
    }
}
