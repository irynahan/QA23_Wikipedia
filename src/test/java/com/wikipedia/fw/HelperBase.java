package com.wikipedia.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            if (!text.equals(driver.findElement(locator).getText())) {
                tap(locator);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void waitForElementAndTap(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForElementAndType(By locator, int timeOut, String text) {
        if (text != null) {
            waitForElementAndTap(locator, timeOut);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();

        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.8);

        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action.longPress(PointOption.point(rightPoint, middleY))
                .moveTo(PointOption.point(leftPoint, middleY))
                .release().perform();
    }

}
