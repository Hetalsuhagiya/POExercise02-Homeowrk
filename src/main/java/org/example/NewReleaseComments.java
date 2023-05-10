package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewReleaseComments extends Utils{
    private By _newReleaseTitle =By.xpath("//input[contains(@class,'enter-comment-title')]");
    private By _newReleaseComment = By.cssSelector("textarea.enter-comment-text");
    private By _newCommentButton = By.xpath("//button[contains(@name,'add-comment')]");
    private By _newReleaseCommentMessage = By.xpath("(//div[contains(@class,'result')])[1]");
    String expectedMessage = "News comment is successfully added.";
    String expectedMessage1= "Please inform when new stock arrive";
    public void fillDetailsOnNewReleaseComments(){
        //enter title of the comment
        typeText(_newReleaseTitle,"Nike Floral Shoes Size 8");
        //enter comment
        typeText(_newReleaseComment,"Please inform when new stock arrive");
        //click on NEW COMMENT Button
        clickOnElement(_newCommentButton);
        //verify comment is successfully added
        String newCommentMessage = getTextFromElement(_newReleaseCommentMessage);
        Assert.assertEquals(newCommentMessage,expectedMessage);
        //verify newly added comment is added at the end of the all comments on page by running for each loop
        List<WebElement> comments = driver.findElements(By.cssSelector("p.comment-text"));
        String lastComment = comments.get(comments.size()-1).getText();
        Assert.assertEquals(lastComment,expectedMessage1);
    }

}
