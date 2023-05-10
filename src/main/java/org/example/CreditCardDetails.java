package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CreditCardDetails extends Utils{
    private By _cardHolderName = By.cssSelector("input#CardholderName");
    private By _cardNumber = By.cssSelector("input#CardNumber");
    private By _expiryMonth = By.cssSelector("select#ExpireMonth");
    private By _expiryYear = By.cssSelector("select#ExpireYear");
    private By _cardCode = By.cssSelector("input#CardCode");
    private By _continueButton = By.cssSelector("button.button-1.payment-info-next-step-button");
    private By _confirm = By.cssSelector("button.button-1.confirm-order-next-step-button");
    private By _confirmationMessage = By.xpath("//div[@class='section order-completed']/div/strong");
    String expectedMessage = "Your order has been successfully processed!";
    public void enterCreditCardDetails(){
        //enter cardholder name
        typeText(_cardHolderName,"H Smith");
        //enter credit card number
        typeText(_cardNumber,"4478769534278465");
        //select expiry month from drop down
        selectOptionByValue(_expiryMonth,"10");
        //select expiry year from drop down
        selectOptionByValue(_expiryYear,"2026");
        //enter card code
        typeText(_cardCode,"860");
        //click on continue
        clickOnElement(_continueButton);
        //continue on confirm button
        clickOnElement(_confirm);
        //verify order confirmation message
       String actualMessage= getTextFromElement(_confirmationMessage);
        Assert.assertEquals(actualMessage,expectedMessage);






    }
}
