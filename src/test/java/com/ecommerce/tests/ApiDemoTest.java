package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiDemoTest {

    @Test
    public void verifyGetUserApi() {
        System.out.println("Starting API Test...");

        // 1. Send a GET request to a public dummy API
        Response response = RestAssured.get("https://reqres.in/api/users/2");

        // 2. Grab the status code from the response
        int statusCode = response.getStatusCode();
        System.out.println("API Status Code: " + statusCode);

        // 3. Verify the status code is 200 (OK)
        Assert.assertEquals(statusCode, 200, "Error: API did not return 200 OK!");
        
        // 4. Print the JSON body so we can see the data!
        System.out.println("API Response Body: " + response.getBody().asString());
    }
}