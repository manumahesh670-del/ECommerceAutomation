package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge"); // <--- Make sure this is here

    // Actions
    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }
    
    // New Method to get the cart number
    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText(); // <--- And make sure this is here!
    }
}