package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;

public class ClickTest extends BaseTest {

    @Test
    public void verifyGmailLinkClick() {
        
        // 1. Go to the Google homepage
        driver.get("https://www.google.com");
        
        // 2. NEW SKILL: Find the link that has the text "Gmail" and click it!
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        
        // 3. Verify that the click worked by checking the new page title
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Gmail"), "Error: Did not navigate to Gmail!");
    }
}