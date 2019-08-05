package com.planit.jo.framework.webutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Handles web object interactions
 */
public class WebDriverActions {

    /**
     * Verifies that the current page contains 'text'
     *
     * @param driver WebDriver object
     * @param text   string to locate in the page
     * @return true if text is found, false if not
     */
    public boolean pageShouldContainText(WebDriver driver, String text) {
        String locator = String.format("//*[contains(., '%s')]", text);

        if (driver.findElements(By.xpath(locator)).size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}