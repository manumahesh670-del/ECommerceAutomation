package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // 1. Store our web elements here at the top
    By searchBox = By.name("q");
    By gmailLink = By.linkText("Gmail"); // <-- NEW: We added the Gmail link here!

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Action 1: Type in the search box
    public void searchForProduct(String product) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBox).submit();
    }

    // Action 2: Click the Gmail link (NEW!)
    public void clickGmailLink() {
        driver.findElement(gmailLink).click();
    }
}