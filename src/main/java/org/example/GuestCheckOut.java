package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class GuestCheckOut extends Utils{
    private By _processor = By.cssSelector("select#product_attribute_1");
    private By _RAM = By.cssSelector("select#product_attribute_2");
    private By _HDD = By.cssSelector("input#product_attribute_3_6");
    private By _OS = By.cssSelector("input#product_attribute_4_9");
    private By _software2 = By.cssSelector("input#product_attribute_5_11");
    private By _software3 = By.cssSelector("input#product_attribute_5_12");
    private By _addToCart = By.cssSelector("button#add-to-cart-button-1");
    private By _shoppingCart = By.cssSelector("span.cart-label");
    private By _termsOfService = By.cssSelector("input#termsofservice");
    private By _checkOut = By.cssSelector("button#checkout");
    private By _checkOutAsGuest = By.cssSelector("button.button-1.checkout-as-guest-button");
   private By _confirmProduct = By.xpath("//td[@class='product']");

    public void checkOutAsGuest(){
        //select processor
        selectOptionByIndex(_processor,1);
        //select RAM
        selectOptionByIndex(_RAM,3);
        //select HDD
       clickOnElement(_HDD);
       //select OS
        clickOnElement(_OS);
        //select Softwares
        clickOnElement(_software2);
        clickOnElement(_software3);
        //click on Add to cart Button
        clickOnElement(_addToCart);
        //click on Shopping Cart
        clickOnElement(_shoppingCart);
        //accept terms of service
        clickOnElement(_termsOfService);
        //click on checkout
        clickOnElement(_checkOut);
        //click on check out as Guest
        clickOnElement(_checkOutAsGuest);

    }
}
