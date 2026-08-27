package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.InventoryPage;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        // Fetch URL from config
        driver.get(com.ecommerce.utils.ConfigReader.getProperty("url"));

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickLogin();
        
        // Add item to cart
        inventoryPage.addBackpackToCart();
        
        // Validation: Check that the cart icon shows "1"
        String cartCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(cartCount, "1", "Item was not added to the cart successfully!");
        
        System.out.println("Test Passed: Backpack successfully added, cart count is " + cartCount);
    }
}