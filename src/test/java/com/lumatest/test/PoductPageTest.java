package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PoductPageTest extends BaseTest {
    @Test
    public void testProductDrivenBackPack() {
        Allure.step("Open Base Url");
        getDriver().get(TestData.BASE_URL);

        ProductPage poductPage = new HomePage(getDriver())
                .clickGearTopMenu()
                .clickBagsSideMenu()
                .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

        final String productName = poductPage.getProductNameText();
        final String breadcrumbsMenuText = poductPage.getBreadcrumbsMenuText();

        Allure.step(
                "Verify actual '" + productName + "' equals to '" + TestData.DRIVEN_BACKPACK_PRODUCT_NAME + "'"
        );
        Assert.assertEquals(productName, TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

        Allure.step(
                "Verify actual '" + breadcrumbsMenuText + "' equals to '" + TestData.DRIVEN_BACKPACK_PRODUCT_PAGE_BREADCRUMBS_MENU + "'"
        );
        Assert.assertEquals(breadcrumbsMenuText, TestData.DRIVEN_BACKPACK_PRODUCT_PAGE_BREADCRUMBS_MENU);
    }
}
