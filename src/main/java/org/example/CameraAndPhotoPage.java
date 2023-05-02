package org.example;

import org.openqa.selenium.By;

public class CameraAndPhotoPage extends Utils{
    private By _cameraAndPhoto = By.xpath("(//a[@title='Show products in category Camera & photo'])[1]");
    public void clickOnCameraAndPhoto(){
        //click on camera and photo
        clickOnElement(_cameraAndPhoto);
    }
}
