package com.wikipedia.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(AppiumDriver driver) {
        super(driver);
    }

    public void openFavoriteLists() {
        waitForElementAndTap(By.xpath("//*[@content-desc='My lists']"),15);
        waitForElementAndTap(By.id("item_title"),15);
    }

    public void removeFromFavoriteLists() {
        moveElementToLeft(By.id("page_list_item_title"));
    }
}
