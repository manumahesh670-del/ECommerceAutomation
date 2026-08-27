package com.ecommerce.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    
    protected WebDriver driver;
    
    // 1. Create variables for the Report
    protected static com.aventstack.extentreports.ExtentReports extent;
    protected com.aventstack.extentreports.ExtentTest test;

    @BeforeSuite
    public void setUpSuite() {
        // Start the report before any tests run
        extent = com.ecommerce.utils.ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp(java.lang.reflect.Method method) {
        // Create a new test entry in the HTML report with the name of the method
        test = extent.createTest(method.getName());

        String browser = com.ecommerce.utils.ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-features=PasswordLeakDetection");
            
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // 2. Log Success or Failure to the HTML Report
        if (ITestResult.SUCCESS == result.getStatus()) {
            test.pass("Test Passed Successfully!");
        } else if (ITestResult.FAILURE == result.getStatus()) {
            test.fail("Test Failed: " + result.getThrowable().getMessage());
            
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                
                File screenshotDir = new File("Screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdir(); 
                }
                
                String screenshotPath = "Screenshots/" + result.getName() + ".png";
                File dest = new File(screenshotPath);
                FileHandler.copy(src, dest);
                
                // 3. Attach the screenshot directly into the HTML report!
                test.addScreenCaptureFromPath("../" + screenshotPath);
                
                System.out.println("TEST FAILED - Screenshot captured at: " + dest.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
        
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterSuite
    public void tearDownSuite() {
        // 4. Generate the final HTML report file
        extent.flush();
    }
}