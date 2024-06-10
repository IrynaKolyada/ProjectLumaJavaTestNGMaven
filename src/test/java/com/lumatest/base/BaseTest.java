package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import com.lumatest.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;


public abstract class BaseTest {
    private WebDriver driver;


    @BeforeSuite
     protected void setupDriverManager() {
         WebDriverManager.chromedriver().setup();

         WebDriverManager.firefoxdriver().setup();

     }


    @Parameters("browser")
    @BeforeMethod
    protected void setupDriver(@Optional("chrome") String browser, ITestResult result) {
        Reporter.log("_____________________________________________", true);
        Reporter.log("RUN" + " - " + result.getMethod().getMethodName(), true);

        this.driver = DriverUtils.createDriver(browser, this.driver);

        if (getDriver() == null) {
            Reporter.log("ERROR UNKNOWN parameter 'browser'" + browser.toUpperCase() + ".", true);

            System.exit(1);
        }

        Reporter.log("INFO: " + browser.toUpperCase() + " driver created", true);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown(@Optional("chrome") String browser, ITestResult result) {
        Reporter.log(" - " + result.getMethod().getMethodName() + " :" + ReportUtils.getTestStatus(result), true);
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
