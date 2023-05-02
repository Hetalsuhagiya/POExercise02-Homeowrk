package org.example;

import org.openqa.selenium.By;

public class EmailAppleMacBook extends Utils{
    private By _emailAFriendButton = By.xpath("//button[@class='button-2 email-a-friend-button']");
    public void EmailAproductToAFriend(){
        //click on email a friend button
        clickOnElement(_emailAFriendButton);

    }
}
