package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPageWithProduct extends Utils{
    private By _verifyProductNameInShoppingCart = By.partialLinkText("Leica T Mirrorless Digital Camera");

     String expectedMessage = "Leica-T Mirrorless Digital Camera";
    public void verifySameProductInShoppingCart(){
        //verify same product in shopping cart
        String name2 = getTextFromElement(_verifyProductNameInShoppingCart);
        System.out.println("Product name after adding to cart: " + name2);
        Assert.assertEquals(name2, expectedMessage, "Product name does not appear same on shopping cart");

    }

}
