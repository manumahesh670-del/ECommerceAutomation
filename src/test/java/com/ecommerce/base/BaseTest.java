package com.ecommerce.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecommerce.utils.ConfigReader;

public class BaseTest {
	public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Read browser type from config.properties
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        // 2. Dynamically launch the correct browser
        switch (browser) {
        case "chrome":
            ChromeOptions options = new ChromeOptions();
            // This tells Chrome to run invisibly without a UI
            options.addArguments("--headless");
            // We must force a window size so elements don't get squished and become unclickable
            options.addArguments("--window-size=1920,1080"); 
            driver = new ChromeDriver(options);
            break;
                
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        
        // 3. Read timeout from config.properties
        int timeout = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}