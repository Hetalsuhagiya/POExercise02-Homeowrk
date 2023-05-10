package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {
    private By _registerButton = By.xpath("//a[text()='Register']");
    private By _homePageLogo = By.xpath("//img[@alt='nopCommerce demo store']");
    private By _communityPollAnswers = By.xpath("//label[@for='pollanswers-2']");
    private By _votePoll = By.xpath("//button[@id='vote-poll-1']");
    private By _pollVoteError = By.xpath("//div[contains(@class,'poll-vote-error')]");
    private By _pollVoteAnswer = By.xpath("(//li[@class='answer'])[2]");
    private By _addToCartButton = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]");
    private By _addToCompareButton3 = By.xpath("(//button[@class='button-2 add-to-compare-list-button'])[3]");
    private By _addToCompareButton4 = By.xpath("(//button[@class='button-2 add-to-compare-list-button'])[4]");
    private By _productComparison = By.partialLinkText("product comparison");
    private By _electronicsCategory1 = By.xpath("(//a[@title='Show products in category Electronics'])[1]");
    private By _referHTCOneToAfriend = By.xpath("//a[text()='HTC One M8 Android L 5.0 Lollipop']");
    private By _searchText = By.xpath("//button[contains(@class,'button-1')]");
    private By _voteText = By.id("vote-poll-1");
    private By _selectCurrency = By.name("customerCurrency");
    private By _faceBook = By.cssSelector("li.facebook");
    private By _newReleaseComment = By.xpath("(//a[text()='details'])[2]");
    private By _searchProduct = By.xpath("//input[contains(@class,'search-box-text ui-autocomplete-input')]");
    private By _clickSearchbutton = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    private By _clickAddToCartButton = By.xpath("(//button[contains(@class,'button-2 product-box-add-to-cart-button')])[1]");
    String expectedMessage1 = "Only Registered users should be able to vote ";
    String expectedMessage2 = "Good-(Total number of votes)";
    String expectedMessage3 = "Welcome to our Store!";

    public void clickOnRegisterButton() {
        clickOnElement(_registerButton);

    }

    public void clickOnHomePageLogo() {
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

    public void verifyRegisteredUserCanVoteSuccessfully() {
        //get text from element
        String votingMessage = getTextFromElement(_pollVoteAnswer);
        System.out.println("Community Poll Vote: " + votingMessage);
        Assert.assertEquals(votingMessage, expectedMessage2, "voting poll is not showing complete data");
    }

    public void clickOnAppleMacBook() {
        //click on Add to cart button on Appple Macbook Pro 13-inch
        clickOnElement(_addToCartButton);
    }

    public void clickOnProductsToAddToCompareList() {
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

    public void clickOnElectronics() {
//click on Electronics
        clickOnElement(_electronicsCategory1);
    }

    public void clickOnProductToReferToAFriend() {
        //click on a HTC One M8 Android L to refer to a friend
        clickOnElement(_referHTCOneToAfriend);
    }

    public void printOutProductTitle() {
        //print product list
        List<WebElement> productList = driver.findElements(By.cssSelector("div.product-grid h2"));
        for (WebElement e : productList) {
            System.out.println(e.getText());
        }

    }

    public void verifySearchAlertMessage() {
        clickOnElement(_searchText);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter some search keyword");
        alert.accept();
    }

    public void verifyVoteAlertMessage() {
        //click on vote button on homepage without choosing any poll
        clickOnElement(_voteText);
        //handle error & verify error message
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please select an answer");
        //click on ok on alert message
        alert.accept();
    }

    public void selectAndVerifyCurrency() {
        //click on currency selector dropdown
        //clickOnElement(_selectCurrency);
        //select Dollar from the currency selector drop down
        selectOptionByVisibleText(_selectCurrency, "US Dollar");
        //store all products with the dollar currency
        List<WebElement> currency = driver.findElements(By.cssSelector("span.price"));
        //fetch all products with the same currency using the loop
        System.out.println("Products when currency chosen as US Dollar: ");
        for (WebElement e : currency) {
            System.out.println(e.getText());
            //select Euro from the currency selector dropdown
            selectOptionByVisibleText(_selectCurrency, "Euro");
            //store all products with the dollar currency
            List<WebElement> currency1 = driver.findElements(By.cssSelector("span.price"));
            //fetch all products with the same currency using the loop
            System.out.println("Products when currency chosen as Euro: ");
            for (WebElement e1 : currency1) {
                System.out.println(e1.getText());
            }

        }
    }

    public void clickOnFacebook() {
        //click on facebook logo on homepage
        clickOnElement(_faceBook);
        //apply wait for child window to be opened
        waitForNumberOfWindows(2, 10);
        //handle child window
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
        }

    }

    public void clickOnNewReleaseComments() {
        //click on new release button on homepage
        clickOnElement(_newReleaseComment);

    }

    public void searchProduct(String searchText) {
        searchText(_searchProduct, "Apple");
        //clickOnElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
        clickOnElement(_clickSearchbutton);
        //iterate through all searched product
        List<WebElement> collection_product_links =
                driver.findElements(By.cssSelector("div.product-grid h2"));
        //Verify if Search result is displayed corresponding to the string which was searched
        for (int i = 0; i < collection_product_links.size(); i++) {
            String temp = collection_product_links.get(i).getText();
            if ((temp.toLowerCase().contains(searchText.toLowerCase()))) {
                Assert.assertTrue(true, searchText + " is displayed on Product Title: " + temp);
            } else {
                Assert.assertTrue(false, searchText + " is not displayed on Product Title: " + temp);
            }
        }

    }

    public void AddProductToCart() {
        //Add Build your own computer to cart
        clickOnElement(_clickAddToCartButton);
    }

}


