package org.example;

import org.openqa.selenium.By;

public class EmailAFriendDetail extends Utils {
    private By _friendEmail = By.xpath("//input[@id='FriendEmail']");
    private By _yourEmail = By.xpath("//input[@id='YourEmailAddress']");
    private By _sendEmail = By.xpath("//button[@class='button-1 send-email-a-friend-button']");


    public void clickOnEmailAFriendDetail(){
        //type Friend's email
        typeText(_friendEmail, "friend123@gmail.com");
        //type Your email address
        typeText(_yourEmail, "test123@gmail.com");
        //click send email
        clickOnElement(_sendEmail);
    }
    public void enterEmailDetail(){
        //type friend's e-mail
        typeText(_friendEmail, "abc1234@gmail.com");
        //click send e-mail
        clickOnElement(_sendEmail);
}
}