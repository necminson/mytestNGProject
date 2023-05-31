package com.myapp.tests.smoketestsuite.logintests;
import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;
public class Day20_PositiveLogin {
    @Test
    public void US100201_Admin_Login(){
//        As admin, I should be able to log in the application
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
//        Admin email: jack@gmail.com
//        Admin password: 12345
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");
        rentalLoginPage.userPassword.sendKeys("12345");
        rentalLoginPage.loginButton.click();
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
        Driver.closeDriver();
    }
}
