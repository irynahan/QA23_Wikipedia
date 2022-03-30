package com.wikipedia.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities;

    public NavigationHelper getNavigation() {
        return navigation;
    }

    NavigationHelper navigation;
    ArticleHelper article;
    NavigationHelper navigation;

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public ArticleHelper getArticle() {
        return article;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa23mob");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/projects/Tools/AndStudio/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        navigation = new NavigationHelper(driver);
        article = new ArticleHelper(driver);
        navigation = new NavigationHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
}
