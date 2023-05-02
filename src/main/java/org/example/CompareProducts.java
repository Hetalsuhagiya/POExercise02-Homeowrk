package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CompareProducts extends Utils {
    private  By _clearList = By.xpath("//a[contains(@class,'clear-list')]");
    private By _noData = By.xpath("//div[contains(@class,'no-data')]");
    String expectedMessage = "There are no items to compare";
    public void compareTwoProducts() {
        //click on clear list
        clickOnElement(_clearList);
        //get text from element
        String message = getTextFromElement(_noData);
        System.out.println(message);
        Assert.assertEquals(message, expectedMessage, "Comparision message is not correct");
    }
}