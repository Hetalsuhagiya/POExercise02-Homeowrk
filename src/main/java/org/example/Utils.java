package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;


public class Utils extends BasePage{
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }


    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static long datestamp() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
        return simpledateformat.hashCode();
    }
    public static void selectOptionByVisibleText(By by,String text){
        Select select = new Select(driver.findElement(by));
       select.selectByVisibleText(text);
    }
    public static void selectOptionByValue(By by,String text){
        Select select = new Select(driver.findElement(by));
       select.selectByValue(text);
    }
    public static void selectOptionByIndex(By by, int index){
        Select select = new Select((driver.findElement(by)));
        select.selectByIndex(index);
    }
    public static void searchText(By by,String text){
      driver.findElement(by).sendKeys(text);
    }
    public static void waitForClickable(By by,int timeInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForInvisibilityOfElement(By by, int timeInSec) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public static void waitForNumberOfWindows(int number, int timeInSec){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.numberOfWindowsToBe(number));
    }
    public static boolean isElementDisplayed(By by){
        return driver.findElement(by).isDisplayed();
    }
    public static void acceptAlert(String text){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),text);
        alert.accept();
    }

    public static void dismissAlert(String text){
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),text);
        alert.dismiss();
    }
}

