package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        
        // Perform action
        checkoutPage.clickFinish();
        
        // Validate the result using TestNG Assert
        String expectedTitle = "Checkout Complete";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Checkout failed or title mismatch!");
    }
}