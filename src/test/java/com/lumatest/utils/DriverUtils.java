package com.lumatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;
    private static final FirefoxOptions firefoxOptions;
    private static final ChromiumOptions<ChromeOptions> chromiumOptions;
    private static final EdgeOptions edgeOptions;

    static {
        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore-certificate-errors");

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");

        chromiumOptions = chromeOptions;

        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
    }

    private static WebDriver createChromeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }

        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand(
                "Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));

        return chromeDriver;
    }

    private static WebDriver createFireFoxDRiver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }

        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createChromiumDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
        ChromeDriver chromeDriver = new ChromeDriver((ChromeOptions) chromiumOptions);
        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand(
                "Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9"))
        );

        return chromeDriver;
    }

    private static WebDriver createEdgeRiver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }

//        EdgeOptions options = new EdgeOptions();
//        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        List<String> args = Arrays.asList("use-fake-ui-for-media-stream", "use-fake-device-for-media-stream");
//        Map<String, Object> map = new HashMap<>();
//        map.put("args", args);
//        options.setCapability("ms:edgeOptions", map);

        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.executeCdpCommand("Network.enable", Map.of());
        edgeDriver.executeCdpCommand(
                "Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9"))
        );

        return new EdgeDriver(edgeOptions);
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
        switch (browser) {
            case "chrome" -> {
                return createChromeDriver(driver);
            }
            case "firefox" -> {
                return createFireFoxDRiver(driver);
            }
            case "chromium" -> {
                return createChromiumDriver(driver);
            }
            case "edge" -> {
                return createEdgeRiver(driver);
            }
            default -> {

                return null;
            }
        }
    }
}

