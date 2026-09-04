package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void verifyGoogleSearch() {
        driver.get("https://www.google.com");
        
        // Initialize the Page Object
        SearchPage searchPage = new SearchPage(driver);

        // Use the page methods cleanly
        searchPage.enterSearchTerm("Selenium Automation");
        searchPage.clickSearch();

        // Validate the title
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Selenium"), "Error: Page title does not match!");
    }
}