package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;


    @BeforeMethod
    protected void setup() {
//        WebDriverManager.chromedriver().setup();

        createChromeDriver();

    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
       if(this.driver != null) {
           getDriver().quit();
           this.driver = null;
       }
    }

    private void createChromeDriver() {
        if (this.driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "----window-size=1920,1080", "--remote-allow-origins=*");
            this.driver = new ChromeDriver(options);
        }
    }

    public WebDriver getDriver() {

        return this.driver;
    }

    public void hoverOverElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }


}
