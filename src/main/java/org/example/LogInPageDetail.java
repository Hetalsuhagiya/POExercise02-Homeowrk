package org.example;

import org.openqa.selenium.By;

public class LogInPageDetail extends Utils{

    private By _Email = By.xpath("//input[contains(@class,'email')]");
    private By _Password = By.xpath("//input[@name='Password']");
    private By _loginButton = By.xpath("//button[@class='button-1 login-button']");
    public void enterLogInDetail(){
        //type e-mail address
        typeText(_Email, "test1234@gmail.com");
        //type password
        typeText(_Password, "test1234");
        //click on Log-in
        clickOnElement(_loginButton);
    }
}
