package com.ecommerce.tests; // Make sure this matches your package name!

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;

public class SearchTest extends BaseTest { 

    // 1. This is the DataProvider: It holds a list of words to test
    @DataProvider(name = "searchWords")
    public Object[][] getData() {
        return new Object[][] {
            {"laptop"},
            {"iphone"},
            {"running shoes"}
        };
    }

    // 2. This is the Test: Notice it says dataProvider = "searchWords" now!
    @Test(dataProvider = "searchWords")
    public void verifyGoogleSearch(String searchItem) throws InterruptedException {
        
        // Go to Google
        driver.get("https://www.google.com");
        HomePage homePage = new HomePage(driver);
        
        // Type the word from our list and hit Enter
        homePage.searchForProduct(searchItem);
        
        // Wait 3 seconds to watch it happen
        Thread.sleep(3000); 
        
        // Verify the search actually worked
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchItem), "Error: Results failed for " + searchItem);
    }
}