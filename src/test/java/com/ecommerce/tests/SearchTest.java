package com.ecommerce.tests; // Make sure this matches your package name!

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utils.ConfigReader;

public class SearchTest extends BaseTest { 

    @DataProvider(name = "searchWords")
    public Object[][] getData() {
        return new Object[][] {
            {"laptop"},
            {"iphone"},
            {"running shoes"}
        };
    }

    @Test(dataProvider = "searchWords")
    public void verifyGoogleSearch(String searchItem) {
        
        // 1. Go to Google
    	driver.get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        
        // 2. Type the word and hit Enter
        homePage.searchForProduct(searchItem);
        
        // 3. NEW: Explicit Wait! Wait up to 10 seconds for the title to contain our word
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(searchItem));
        
        // 4. Verify the search actually worked
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchItem), "Error: Results failed for " + searchItem);
    }
}