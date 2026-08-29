package com.ecommerce.pages; // Make sure this matches your actual package name!

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    // This is the exact locator for Google's Search Bar
    @FindBy(name = "q") 
    WebElement searchBox;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method types a word into Google and hits Enter
    public void searchForProduct(String searchTerm) {
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
    }
}