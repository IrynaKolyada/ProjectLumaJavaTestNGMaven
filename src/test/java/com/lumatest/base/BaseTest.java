package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public abstract class BaseTest {
    private WebDriver driver;
//    private final String browser = "firefox";

    @BeforeSuite
    protected void setupDriverManager() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }

    @Parameters("browser")
    @BeforeMethod
    protected void setupDriver(String browser) {
        Reporter.log("_____________________________________________", true);
        this.driver = DriverUtils.createDriver(browser, this.driver);

        if (getDriver() == null) {
            Reporter.log("ERROR UNKNOWN parameter 'browser'" + browser.toUpperCase() + ".", true);

            System.exit(1);
        }

        Reporter.log("INFO: " + browser.toUpperCase() + " driver created", true);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown(String browser) {
        if (this.driver != null) {
            getDriver().quit();
            Reporter.log("INFO: " + browser.toUpperCase() + " driver closed", true);

            this.driver = null;
        } else {

            Reporter.log("INFO: Driver is null", true);
        }
    }

    public WebDriver getDriver() {

        return this.driver;
    }

}
