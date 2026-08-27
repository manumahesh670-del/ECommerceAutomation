package com.ecommerce.utils;

public class ExtentManager {
    private static com.aventstack.extentreports.ExtentReports extent;

    public static com.aventstack.extentreports.ExtentReports getInstance() {
        if (extent == null) {
            // This creates a "Reports" folder and an HTML file inside it
            com.aventstack.extentreports.reporter.ExtentSparkReporter spark = new com.aventstack.extentreports.reporter.ExtentSparkReporter("Reports/AutomationReport.html");
            spark.config().setReportName("E-Commerce Test Results");
            spark.config().setDocumentTitle("Automation Report");

            extent = new com.aventstack.extentreports.ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}