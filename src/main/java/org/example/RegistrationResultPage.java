package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    private By _resultPage = By.xpath("//div[@class='result']");
    String expectedRegistrationCompleteMessage = "Thank You for Registration";
    public void verifyUserRegisteredSuccessfullyOrNot(){
        //get text from element
        String actualMessage = getTextFromElement(_resultPage);
        System.out.println("My message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedRegistrationCompleteMessage, "Registration is not working");


    }

}
