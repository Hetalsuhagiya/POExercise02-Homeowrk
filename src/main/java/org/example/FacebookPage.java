package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FacebookPage extends Utils {
    private By _closeFacebookLoginButton = By.xpath("//div[@aria-label='Close']");
    private By _allowCookies = By.xpath("(//div[contains(@aria-label,'Allow all cookies')])[2]");
    private By _fbEmail = By.xpath("//input[@placeholder='Email or phone']");
    private By _fbPassword = By.xpath("//input[@placeholder='Password']");
    private By _fbLoginButton = By.xpath("//div[@aria-label='Accessible login button']");
    private By _welcomeMessage = By.xpath("//h2[text()='Welcome to our store']");
    String expectedMessage = "Welcome to our Store";
    public void verifyFacebookPage() {
        //verify url of facebook
        String currentURL = driver.getCurrentUrl();
        System.out.println("Facebook url=" + currentURL);
        Assert.assertEquals(currentURL, "https://www.facebook.com/nopCommerce");
        //allow cookies
        clickOnElement(_allowCookies);
        //explicit wait
        waitForClickable(_closeFacebookLoginButton, 20);
        //close facebook login prompt message
        clickOnElement(_closeFacebookLoginButton);
        //verify Email,Password & Log-in button is present
        //verifying Email element is present
        boolean isEmailDisplayed = isElementDisplayed(_fbEmail);
        if(isEmailDisplayed){
            System.out.println("Email element is displayed");
        }else{
            System.out.println("Email element is not displayed");
        }
        //verifying Password element is present
        boolean isPasswordDisplayed = isElementDisplayed(_fbPassword);
        if(isPasswordDisplayed){
            System.out.println("Password element is displayed");
        }else{
            System.out.println("Password element is not displayed");
        }
        //verifying Log in element is displayed
        boolean isLogInDisplayed = isElementDisplayed(_fbLoginButton);
        if(isLogInDisplayed){
            System.out.println("Log in element is displayed");
        }else{
            System.out.println("Log in element is not displayed");
        }
        //close child(facebook) window
        driver.close();
        //switch to main window
        for(String mainWindow: driver.getWindowHandles()){
            driver.switchTo().window(mainWindow);
       String actualMessage= getTextFromElement(_welcomeMessage);
       Assert.assertEquals(actualMessage,expectedMessage,"Message is incorrect");
        }
    }
}