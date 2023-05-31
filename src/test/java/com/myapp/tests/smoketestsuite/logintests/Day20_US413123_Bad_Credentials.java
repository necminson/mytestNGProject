package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day20_US413123_Bad_Credentials {
    @Test
    public void US413123_Bad_Credentials(){
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");// correct email
        rentalLoginPage.userPassword.sendKeys("fakepass");// Incorrect password
        rentalLoginPage.loginButton.click();
        ReusableMethods.verifyExpectedAndActualTextMatch("Bad credentials",rentalLoginPage.errorMessage_incorrectEmailAndPass);
        Driver.closeDriver();
    }
}
