package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartProductPage extends Utils{
    private By _addToCartButton = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]");
    private By _printName = By.partialLinkText("Leica T Mirrorless Digital Camera");
    private By _shoppingCart = By.xpath("//span[@class='cart-label']");
    public void clickOnAddToCartButton(){
        //click on add to cart button
        clickOnElement(_addToCartButton);
        //print name before adding to cart
        String name1 = getTextFromElement(_printName);
        System.out.println("Product name before adding to cart: " + name1);
        // add wait until element is invisible & then click on shopping cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("content")));
        clickOnElement(_shoppingCart);
    }
}
