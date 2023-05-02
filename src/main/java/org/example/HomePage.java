package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils {
    private By _registerButton = By.xpath("//a[text()='Register']");
    private By _homePageLogo = By.xpath("//img[@alt='nopCommerce demo store']");
private  By _communityPollAnswers = By.xpath("//label[@for='pollanswers-2']");
  private By _votePoll = By.xpath("//button[@id='vote-poll-1']");
  private By _pollVoteError = By.xpath("//div[contains(@class,'poll-vote-error')]");
  private By _pollVoteAnswer = By.xpath("(//li[@class='answer'])[2]");
  private By _addToCartButton = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]");
private By _addToCompareButton3 = By.xpath("(//button[@class='button-2 add-to-compare-list-button'])[3]");
   private By _addToCompareButton4 = By.xpath("(//button[@class='button-2 add-to-compare-list-button'])[4]");
private By _productComparison = By.partialLinkText("product comparison");
   private By _electronicsCategory1 = By.xpath("(//a[@title='Show products in category Electronics'])[1]");
   private By _referHTCOneToAfriend = By.xpath("//a[text()='HTC One M8 Android L 5.0 Lollipop']");
   String expectedMessage1 = "Only Registered users should be able to vote ";
    String expectedMessage2 = "Good-(Total number of votes)";

    public void clickOnRegisterButton() {
        clickOnElement(_registerButton);

    }
    public void clickOnHomePageLogo(){
        //click on homepage logo
        clickOnElement(_homePageLogo);
    }

    public void clickOnGood() {
        //click on Good on community poll
        clickOnElement(_communityPollAnswers);
    }

    public void clickOnVote() {
        clickOnElement(_votePoll);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("block-poll-vote-error-1")));
    }

    public void verifyNonRegisteredUserCanNotVote() {
        //get text from element
        String message = getTextFromElement(_pollVoteError);
        System.out.println("My message: " + message);
        Assert.assertEquals(message, expectedMessage1, "voting eligibility message is not correct");
    }
    public void verifyRegisteredUserCanVoteSuccessfully(){
        //get text from element
        String votingMessage = getTextFromElement(_pollVoteAnswer);
        System.out.println("Community Poll Vote: " + votingMessage);
        Assert.assertEquals(votingMessage, expectedMessage2, "voting poll is not showing complete data");
    }
public void clickOnAppleMacBook(){
    //click on Add to cart button on Appple Macbook Pro 13-inch
    clickOnElement(_addToCartButton);
}
public void clickOnProductsToAddToCompareList(){
    //click on Add to compare list on HTC One M8 Android L5.0 Lollipop
    clickOnElement(_addToCompareButton3);
    //add wait time
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='bar-notification success']")));
    //click on Add to compare list on $25 Virtual Gift Card
    clickOnElement(_addToCompareButton4);
    //click on product comparison list
    clickOnElement(_productComparison);
}

public void clickOnElectronics(){
//click on Electronics
    clickOnElement(_electronicsCategory1);
}
public void clickOnProductToReferToAFriend(){
    //click on a HTC One M8 Android L to refer to a friend
    clickOnElement(_referHTCOneToAfriend);
}


}
