package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAfriendResultPage extends Utils {
    private By _errorMessage = By.xpath("//div[@class='message-error validation-summary-errors']/ul/li");
    private By _result = By.xpath("//div[@class='result']");
    String expectedMessage1 = "Only Registered customers can use Email a Friend feature to refer a product";
    String expectedMessage2 = "Your E-mail has been sent";
    public void verifymessageOnlyRegisteredUserCanEmailAFriend(){
//get text from element
        String message = getTextFromElement(_errorMessage);
        System.out.println("Message: " + message);
        Assert.assertEquals(message, expectedMessage1, "Email to a friend is not showing correct message");
    }
    public void verifyRegisteredUserCanReferAProductToAFriend(){
        //print message(Your email has been sent)
        String message = getTextFromElement(_result);
        System.out.println("Sent Message: " + message);
        Assert.assertEquals(message, expectedMessage2, "Message sent to friend is not correct");
    }

    }

