package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
    //    ALL PAGE CLASSES MUST HAVE A CONSTRUCTOR TO USE PAGE FACTORY
    public OrangeHRMLoginPage(){
    //        Page Factory is used to initiate the objects
    //        if we don't use this, we get null pointer exception
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //    public WebElement username = driver.findElement(By.name("username"));//TRADITIONAL
    //    POM
    // @FindBy  : Used to locate the web elements.
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

}
