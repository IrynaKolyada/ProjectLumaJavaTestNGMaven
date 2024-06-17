package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(description = "TC-01 Open Base Url", groups = {"smoke", "regression"}, testName = "Navigation | Open Base URL")
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify that the URL and Title of the application are correct and as expected")
    @Link(TestData.BASE_URL)
    public void testOpenBaseUrl() {
        Allure.step("Setup expected results");
        final String expectedUrl = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_URL_TITLE;

        Allure.step("Open BaseUrl");
        getDriver().get(TestData.BASE_URL);
        Allure.step("Collect actualUrl, actualTitle");
        final String actualUrl = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualUrl as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Allure.step("Collect actualTitle as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dataProvider = "navigationMenuData",  dataProviderClass = TestData.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify that the top menu navigation on website functions correctly by ensuring that"
            + "clicking on menu items directs the user on correct page")
    public void testNavigationMenu(String baseUrl, By nameOfLocator, String expectedUrl, String expectedTitle) {

        Allure.step("Open BaseUrl");
        getDriver().get(baseUrl);
        getDriver().findElement(nameOfLocator).click();

        Allure.step("Collect actualUrl, actualTitle");
        final String actualUrl = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualUrl as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Allure.step("Collect actualTitle as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }


}
