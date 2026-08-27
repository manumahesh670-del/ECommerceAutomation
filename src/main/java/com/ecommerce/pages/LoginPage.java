package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    private WebDriver driver;

    // 1. Constructor: Connects the driver from the test to this page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 2. Locators: Find the elements on the page (SauceDemo locators)
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // 3. Actions: Methods to interact with the page
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

 // Notice the return type changed from 'void' to 'InventoryPage'
    public InventoryPage clickLogin() {
        driver.findElement(loginButton).click();
        
        // This is the chain! It automatically returns the next page.
        return new InventoryPage(driver);
    
    }
}