package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
    	// Fetch the URL dynamically from config.properties
        driver.get(com.ecommerce.utils.ConfigReader.getProperty("url"));

        // 2. Create an object of the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // 3. Perform actions using the page object methods
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // 4. Verify the login was successful by checking the URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed!");
        
        System.out.println("Login Test Passed Successfully!");
    }
}