package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import org.testng.annotations.Test;

// The 'extends' keyword connects this test to your Base Class
public class FirstTest extends BaseTest {

    @Test
    public void launchBrowser() {
        // No need to initialize ChromeDriver or use driver.quit() here!
        driver.get("https://www.google.com");
        
        System.out.println("Page title is: " + driver.getTitle());
    }
}