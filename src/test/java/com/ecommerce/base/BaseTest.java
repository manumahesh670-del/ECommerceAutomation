package com.ecommerce.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.ecommerce.utils.ConfigReader;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Read browser type from config.properties
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        // 2. Dynamically launch the correct browser
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
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