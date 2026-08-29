package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage; // Notice we import the HomePage now!

public class ClickTest extends BaseTest {

    @Test
    public void verifyGmailLinkClick() {
        
        // 1. Go to the Google homepage
        driver.get("https://www.google.com");
        
        // 2. Tell the HomePage object to do the clicking!
        HomePage homePage = new HomePage(driver);
        homePage.clickGmailLink();
        
        // 3. Verify that the click worked
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Gmail"), "Error: Did not navigate to Gmail!");
    }
}