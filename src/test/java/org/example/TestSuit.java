package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    EmailAppleMacBook emailAppleMacBook = new EmailAppleMacBook();
    EmailAFriendDetail emailAFriendDetail = new EmailAFriendDetail();
    EmailAfriendResultPage emailAfriendResultPage = new EmailAfriendResultPage();
    CompareProducts compareProducts = new CompareProducts();
    CameraAndPhotoPage cameraAndPhotoPage = new CameraAndPhotoPage();
    AddToCartProductPage addToCartProductPage = new AddToCartProductPage();
    ShoppingCartPageWithProduct shoppingCartPageWithProduct = new ShoppingCartPageWithProduct();
    Log_InPage log_inPage = new Log_InPage();
    LogInPageDetail logInPageDetail = new LogInPageDetail();
    ReferHTCOneToAFriend referHTCOneToAFriend = new ReferHTCOneToAFriend();
    FacebookPage facebookPage = new FacebookPage();
    NewReleaseComments newReleaseComments = new NewReleaseComments();
    GuestCheckOut guestCheckOut = new GuestCheckOut();
    CheckOutDetails checkOutDetails = new CheckOutDetails();
    CreditCardDetails creditCardDetails = new CreditCardDetails();


    @Test

    public void userShouldBeAbleToRegisterSuccessfully() {
        //click on register
        homePage.clickOnRegisterButton();
        //fill in registration details
        registrationFormPage.enterRegistrationDetails1();
        //verify user is registered successfully
        registrationResultPage.verifyUserRegisteredSuccessfullyOrNot();

    }

    @Test
    public void verifyNonRegisteredUserCanNotVote() {
        //click on Good button
        homePage.clickOnGood();
        //click on vote button
        homePage.clickOnVote();
        //verify message that non-registered user can not vote
        homePage.verifyNonRegisteredUserCanNotVote();
    }

    @Test
    public void verifyNonRegisteredUserCanNotEmailAfriend() {
        //click on product
        homePage.clickOnAppleMacBook();
//click on email a friend button
        emailAppleMacBook.EmailAproductToAFriend();
        //click on E-mail button
        emailAFriendDetail.clickOnEmailAFriendDetail();
        //verify message that Non-Registered can not E-mail A Friend
        emailAfriendResultPage.verifymessageOnlyRegisteredUserCanEmailAFriend();

    }

    @Test
    public void verifyUserCanCompareTwoProductsInCompareList() {
        //click on 2 products
        homePage.clickOnProductsToAddToCompareList();
        //compare 2 products
        compareProducts.compareTwoProducts();
    }

    @Test
    public void verifySameProductIsAddedToTheShoppingCart() {
        //click on Electronic
        homePage.clickOnElectronics();
        //click on camera and phone
        cameraAndPhotoPage.clickOnCameraAndPhoto();
        //click on add to cart button
        addToCartProductPage.clickOnAddToCartButton();
        //click on shopping cart button to verify product
        shoppingCartPageWithProduct.verifySameProductInShoppingCart();
    }

    @Test
    public void verifyRegisteredUserShouldBeAbleToReferAProductToAFriendSuccessfully() {
        //click on register button
        homePage.clickOnRegisterButton();
        //Enter registration details
        registrationFormPage.enterRegistrationDetail3();
        //click log in button
        log_inPage.clickOnLogInButton();
        //enter log-in details
        logInPageDetail.enterLogInDetail();
        //click on a HTC One M8 Android L to refer to a friend
        homePage.clickOnProductToReferToAFriend();
        //click on Email a friend to refer a product
        referHTCOneToAFriend.clickOnEmailAFriendToReferProductToFriend();
        //Enter E-mail Detail-Friend's email & send E-mail
        emailAFriendDetail.enterEmailDetail();
        //Product E-mail sent to friend message
        emailAfriendResultPage.verifyRegisteredUserCanReferAProductToAFriend();
    }

    @Test
    public void verifyRegisteredUserShouldBeAbleToVoteSuccessfully() {
        //click on register button
        homePage.clickOnRegisterButton();
        //Enter registration details
        registrationFormPage.enterRegistrationDetail2();
        //click on Log-in button
        log_inPage.clickOnLogInButton();
        //Enter Log-in detail-email & password, click log-in
        logInPageDetail.enterLogInDetail();
        //click on homepage logo
        homePage.clickOnHomePageLogo();
        //click on Good on community poll
        homePage.clickOnGood();
        //click on vote
        homePage.clickOnVote();
        //verify message
        homePage.verifyRegisteredUserCanVoteSuccessfully();
    }

    @Test
    public void printOutProductTitle() {
        //print all products titles
        homePage.printOutProductTitle();

    }

    @Test
    public void verifySearchAlert() {
        homePage.verifySearchAlertMessage();
    }

    @Test
    public void verifyAlertMessageWhenUserClickOnVoteWithoutSelectingAnyPollingOption() {
        //alert message when user try to vote
        homePage.verifyVoteAlertMessage();
    }

    @Test
    public void userShouldAbleToSelectAndVerifyTheCurrencyAccordingly() {
        //select from drop down currency on homepage & verify currency changed for the products
        homePage.selectAndVerifyCurrency();
    }

    @Test
    public void userShouldAbleToLogOnToFacebookPageSuccessfully() {
        //click on facebook logo on homepage
        homePage.clickOnFacebook();
        //Launching the facebookpage
        facebookPage.verifyFacebookPage();

    }

    @Test
    public void verifyUserShouldAbleToCommentOnNewReleaseSuccessfullyAndAppearsAtTheEnd() {
        //click on new release comment on homepage
        homePage.clickOnNewReleaseComments();
        //enter comment on new release page & verify message
        newReleaseComments.fillDetailsOnNewReleaseComments();
    }

    @Test
    public void verifyUserShouldAbleToSearchForGivenProductSuccessfully() {
        //click on search placeholder,enter product name & click on Search button & verify the search result
        homePage.searchProduct("Apple");

    }

    @Test
    public void verifyUserShouldAbleToCheckOutSuccessfullyAsGuest() {
        //click on product
        homePage.AddProductToCart();
        //select product specification
        guestCheckOut.checkOutAsGuest();
        //fill in check Out Details
        checkOutDetails.fillCheckOutDetails();
        //enter credit card details
        creditCardDetails.enterCreditCardDetails();


    }


}

