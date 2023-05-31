package com.myapp.pages;
import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RentalHomePage {
    public RentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(name = "car")
    public WebElement selectCar;

}