package com.myapp.tests.smoketestsuite.logintests;
import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import com.myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day20_NegativeLogin {
    @Test
    public void US100208_Negative_Login(){
//        As customer, I should not be able to log in the application
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
//        Customer email: fake@bluerentalcars.com
        rentalLoginPage.userEmail.sendKeys("fake@bluerentalcars.com");
//        Customer password: fakepass
        rentalLoginPage.userPassword.sendKeys("fakepass");
        rentalLoginPage.loginButton.click();
//        ******Without waiting, test case fails because the element pops up on a web alert page that cause sysnronization issue
//        ******There are 2 waits we can use
//        1. WaitUtils.waitFor(3);//HARD WAIT. NOT RECOMMENDED
//        2. WaitUtils.waitForVisibility(rentalLoginPage.errorMessage_incorrectEmailAndPass,3);//Explicit Wait RECOMMENDED
//        *******THEN BELOW ASSERTION PASSES
//        String errorText = rentalLoginPage.errorMessage_incorrectEmailAndPass.getText();
//        Assert.assertEquals(errorText,"User with email fake@bluerentalcars.com not found");
//        *******BUT WE CAN USE REUSABLE METHOD TO DO TEXT ASSERTION QUICKER
        ReusableMethods
                .verifyExpectedAndActualTextMatch("User with email fake@bluerentalcars.com not found",rentalLoginPage.errorMessage_incorrectEmailAndPass);
        Driver.closeDriver();
    }
}