package com.ecommerce.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
    
    // Grabs the report setup from your ExtentManager
    private ExtentReports extent = ExtentManager.getInstance(); 
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        // Tells the dashboard a new test has started
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Logs a green checkmark
        test.log(Status.PASS, "Test Passed Successfully!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Logs a red error and the exact exception message
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        
        System.out.println("Watchdog Alert: Test Failed! Capturing screen...");
        // NOTE: Once you integrate your screenshot path here, you can attach it to the report like this:
        // test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // This is the magic command! It physically saves the HTML file.
        extent.flush(); 
    }
}