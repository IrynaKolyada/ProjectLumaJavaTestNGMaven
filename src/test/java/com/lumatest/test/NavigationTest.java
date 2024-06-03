package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(description = "TC-01 Open Base Url")
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC-01 Open Base Url")
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

    @Test(dataProvider = "navigationMenuData", dataProviderClass = TestData.class)
    @Description("TC-02 testTopNavigationMenu")
    @Severity(SeverityLevel.CRITICAL)
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

    @Test (dataProvider = "navigationMenuWomenSectionData", dataProviderClass = TestData.class)
    public void testNavigationMenuWomenSection(
            String baseUrl, By nameOfLocator, By href, String expectedUrl, String expectedTitle) {

        Allure.step("Open BaseUrl");
        getDriver().get(baseUrl);
        hoverOverElement(nameOfLocator);
        getDriver().findElement(href).click();

        Allure.step("Collect actualUrl, actualTitle");
        final String actualUrl = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualUrl as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Allure.step("Collect actualTitle as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test (dataProvider = "navigationMenuTopsSectionData", dataProviderClass = TestData.class)
    public void testNavigationMenuWomenTopsSection(
            String baseUrl, By nameOfLocator, By href , By hrefSubMenu, String expectedUrl, String expectedTitle) {
        Allure.step("Open BaseUrl");
        getDriver().get(baseUrl);
        hoverOverElement(nameOfLocator);
        hoverOverElement(href);
        getDriver().findElement(hrefSubMenu).click();

        Allure.step("Collect actualUrl, actualTitle");
        final String actualUrl = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualUrl as expected");
        Assert.assertEquals(actualUrl, expectedUrl);
        Allure.step("Collect actualTitle as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }


}
