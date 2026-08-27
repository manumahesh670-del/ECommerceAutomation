package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseTest {

    // 1. Create the Data Provider
    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},     // Row 1: Valid user (Will Pass)
            {"locked_out_user", "secret_sauce"},   // Row 2: Locked out user (Will Fail)
            {"invalid_user", "wrong_password"}     // Row 3: Invalid user (Will Fail)
        };
    }

    // 2. Link the Test to the DataProvider and add parameters
    @Test(dataProvider = "loginCredentials")
    public void testLogins(String username, String password) {
        // Navigate to the site
        driver.get("https://www.saucedemo.com/");

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // 3. Verify Login
        String currentUrl = driver.getCurrentUrl();
        
        // This assertion will intentionally FAIL for the invalid users
        // so you can see how TestNG handles and reports test failures!
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed for user: " + username);
        
        System.out.println("Login Test Passed for user: " + username);
    }
}