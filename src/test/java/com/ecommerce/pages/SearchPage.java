package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    // 1. Constructor to link the driver from the test class
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // 2. Define Locators (Where elements live)
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    // 3. Define Actions (What you do on the page)
    public void enterSearchTerm(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickSearch() {
        // Optional safety click, or submit
        driver.findElement(searchBox).submit();
    }
}