package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    // Web Element Locator using Page Object Model (@FindBy)
    @FindBy(id = "finish")
    WebElement finishButton;

    // Constructor to initialize elements
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action method
    public void clickFinish() {
        finishButton.click();
    }
}