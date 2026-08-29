package com.ecommerce.tests; // Make sure this matches your test package name!

import org.testng.annotations.Test;
import com.ecommerce.pages.HomePage; // This imports the page we just built
import com.ecommerce.base.BaseTest;
import org.testng.Assert;

public class SearchTest extends BaseTest { 

	@Test
    public void verifyGoogleSearch() throws InterruptedException {
        // 1. Tell the browser to go directly to Google
        driver.get("https://www.google.com");
        
        // 2. Connect to the HomePage class
        HomePage homePage = new HomePage(driver);
        
        // 3. Type "laptop" into Google and hit Enter!
        homePage.searchForProduct("laptop");
        
        // 4. Wait 3 seconds for the results page to load
        Thread.sleep(3000); 
        
        // 5. NEW: Grab the title of the webpage
        String actualTitle = driver.getTitle();
        
        // 6. NEW: Assert (Verify) that the title contains the word "laptop"
        Assert.assertTrue(actualTitle.contains("laptop"), "Error: Search results did not load!");
    }
}