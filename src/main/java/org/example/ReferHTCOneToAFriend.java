package org.example;

import org.openqa.selenium.By;

public class ReferHTCOneToAFriend extends Utils{
    private By _productemailafriend = By.xpath("//button[@onclick='setLocation(\"/productemailafriend/18\")']");
    public void clickOnEmailAFriendToReferProductToFriend(){
        //click on email friend
        clickOnElement(_productemailafriend);
    }

}
