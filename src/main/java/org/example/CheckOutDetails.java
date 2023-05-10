package org.example;

import org.openqa.selenium.By;

public class CheckOutDetails extends Utils {
    private By _firstName = By.cssSelector("input#BillingNewAddress_FirstName");
    private By _lastName = By.cssSelector("input#BillingNewAddress_LastName");
    private By _Email = By.cssSelector("input#BillingNewAddress_Email");
    private By _country = By.cssSelector("select#BillingNewAddress_CountryId");
    private By _city = By.cssSelector("input#BillingNewAddress_City");
    private By _address = By.cssSelector("input#BillingNewAddress_Address1");
    private By _postCode = By.cssSelector("input#BillingNewAddress_ZipPostalCode");
    private By _phoneNumber = By.cssSelector("input#BillingNewAddress_PhoneNumber");
    private By _continue = By.xpath("//button[contains(@onclick,'Billing.save()')]");
    private By _shippingMethod = By.cssSelector("input#shippingoption_1");
    private By _continueButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
private By _creditCard = By.cssSelector("input#paymentmethod_1");
private By _creditCardContinueButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    public void fillCheckOutDetails() {
        //enter First Name
        typeText(_firstName,"Harry");
        //enter Last Name
        typeText(_lastName,"Smith");
        //enter E-mail
        typeText(_Email,"hsmith@gmail.com");
        //select Country from drop down
        selectOptionByValue(_country,"233");
        //enter city
        typeText(_city,"London");
        //enter address
        typeText(_address,"11,New Road");
        //enter post code
        typeText(_postCode,"E8 5ZE");
        //enter phone number
        typeText(_phoneNumber,"12345669581");
        //click on continue button to go to shipping method
        clickOnElement(_continue);
        //click on Next day Air shipping method
        clickOnElement(_shippingMethod);
        //click on continue button to go to payment method
        clickOnElement(_continueButton);
        //click on credit card payment method
        clickOnElement(_creditCard);
        //click on to continue button to go to next step
        clickOnElement(_creditCardContinueButton);
    }

}
