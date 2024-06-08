package com.lumatest.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
    public static final String BASE_URL = "https://magento.softwaretestingboard.com";
    public static final String BASE_URL_TITLE = "Home Page";

    //NavBarMenu
    // What's New
    public static final By WHATS_NEW_MENU = By.xpath("//nav//a/span[text() = \"What's New\"]");
    public static final String WHATS_NEW_MENU_URL = BASE_URL + "/what-is-new.html";
    public static final String WHATS_NEW_MENU_TITLE = "What's New";

    // Women
    public static final By WOMEN_MENU = By.xpath("//nav//a/span[text() = 'Women']");
    public static final String WOMEN_URL = BASE_URL + "/women.html";
    public static final String WOMEN_TITLE = "Women";
    public static final By WOMEN_TOPS_MENU_HREF = By.xpath(
            "//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html']");
    public static final String WOMEN_TOPS_URL = BASE_URL + "/women/tops-women.html";
    public static final String WOMEN_TOPS_TITLE = "Tops - Women";
    public static final By WOMEN_TOPS_HEADER = By.xpath("//h1/span");
    public static final By WOMEN_BOTTOMS_MENU_HREF = By.xpath(
            "//a[@href='https://magento.softwaretestingboard.com/women/bottoms-women.html']");
    public static final String WOMEN_BOTTOMS_URL = BASE_URL + "/women/bottoms-women.html";
    public static final String WOMEN_BOTTOMS_TITLE = "Bottoms - Women";
    public static final By BOTTOMS_TOPS_HEADER = By.xpath("//h1/span");
    public static final By WOMEN_JACKETS_MENU_HREF = By.xpath(
            "//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']");//Jackets
    public static final String WOMEN_JACKETS_URL = BASE_URL + "/women/tops-women/jackets-women.html";
    public static final String WOMEN_JACKETS_TITLE = "Jackets - Tops - Women";

    // Men
    public static final By MEN_MENU = By.xpath("//nav//a/span[text() = 'Men']");
    public static final String MEN_URL = BASE_URL + "/men.html";
    public static final String MEN_TITLE = "Men";

    //Gear
    public static final By GEAR_MENU = By.xpath("//nav//a/span[text() = 'Gear']");
    public static final String GEAR_URL = BASE_URL + "/gear.html";
    public static final String GEAR_TITLE = "Gear";

    //Training
    public static final By TRAINING_MENU = By.xpath("//nav//a/span[text() = 'Training']");
    public static final String TRAINING_URL = BASE_URL + "/training.html";
    public static final String TRAINING_TITLE = "Training";

    //Sale
    public static final By SALE_MENU = By.xpath("//nav//a/span[text() = 'Sale']");
    public static final String SALE_URL = BASE_URL + "/sale.html";
    public static final String SALE_TITLE = "Sale";

    @DataProvider(name = "navigationMenuData")
    public static Object[][] navigationMenuTestDataProvider() {

        return new Object[][]{
                {BASE_URL, WHATS_NEW_MENU, WHATS_NEW_MENU_URL, WHATS_NEW_MENU_TITLE},
                {BASE_URL, WOMEN_MENU, WOMEN_URL, WOMEN_TITLE},
                {BASE_URL, MEN_MENU, MEN_URL, MEN_TITLE},
                {BASE_URL, GEAR_MENU, GEAR_URL, GEAR_TITLE},
                {BASE_URL, TRAINING_MENU, TRAINING_URL, TRAINING_TITLE},
                {BASE_URL, SALE_MENU, SALE_URL, SALE_TITLE}
        };
    }


}
