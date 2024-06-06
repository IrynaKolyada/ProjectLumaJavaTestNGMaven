package com.lumatest.base;

import com.lumatest.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    protected void setupDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setupDriver() {
        this.driver = DriverUtils.createChromeDriver(getDriver());

    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
       if(this.driver != null) {
           getDriver().quit();
           this.driver = null;
       }
    }


    public WebDriver getDriver() {

        return this.driver;
    }

    public void hoverOverElement(By locator) {
        Actions actions = new Actions(getDriver());
        WebElement element =  getWait10().until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//        getWait10().until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    protected WebDriverWait getWait10() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }


}
