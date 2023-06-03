package com.myapp.tests.dataprovider;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

import static com.myapp.utilities.ReusableMethods.goToURL;

public class Day22_DataProvider3 {
    //GETTING THE DATA
    // TEST LOGIN FUNCTIONALITY USING CUSTOMER SERVICE CREDENTIALS
    //    We need 2 methods : ****@DataProvider ***@Test method
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
@Test(dataProvider = "customerDataProvider",dataProviderClass = DataProviderUtils.class)
    public void customerLoginTest(String username, String password){
    System.out.println("username = " + username+",  password = " + password);
    goToURL("rental_home_url"); // From Utilities > ReusableMethods
    //Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
    rentalHomePage = new RentalHomePage();
    rentalLoginPage = new RentalLoginPage();
//            LOG IN
//            click on login
    WaitUtils.waitFor(1);
    rentalHomePage.loginLink.click();
    WaitUtils.waitFor(1);
//            enter username
    rentalLoginPage.userEmail.sendKeys(username);//GET DATA FROM DATA PROVIDER
    WaitUtils.waitFor(1);
//            enter password
    rentalLoginPage.userPassword.sendKeys(password);//GET DATA FROM DATA PROVIDER
    WaitUtils.waitFor(1);
//            click on login button
    rentalLoginPage.loginButton.click();
    WaitUtils.waitFor(1);
//            verify login
    ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
    WaitUtils.waitFor(1);

//            LOG OUT
//            click on id
    rentalHomePage.userID.click();
    WaitUtils.waitFor(3);
//            click on logout
    WaitUtils.waitForVisibility(rentalHomePage.logOut,5).click();

//            click on ok
    WaitUtils.waitForVisibility(rentalHomePage.OK,5).click();
    Driver.closeDriver();

}
}
