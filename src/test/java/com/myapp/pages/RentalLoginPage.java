package com.myapp.pages;
import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RentalLoginPage {
    public RentalLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "formBasicEmail")
    public WebElement userEmail;
    @FindBy(id="formBasicPassword")
    public WebElement userPassword;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement errorMessage_incorrectEmailAndPass;
}