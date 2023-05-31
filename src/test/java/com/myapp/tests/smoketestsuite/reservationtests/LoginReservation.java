package com.myapp.tests.smoketestsuite.reservationtests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static com.myapp.utilities.ReusableMethods.goToURL;
import static com.myapp.utilities.ReusableMethods.selectByValue;

public class LoginReservation {
   // Name:
    //Require user to login for reservation
    //Description:
    //User should see a message when user tries to book a car while not logged in
    //Acceptance Criteria:
    @Test
    public void loginReservation(){

    //As customer, I should be able to see error message, when I try to book a car while not logged in
        RentalHomePage rentalHomePage = new RentalHomePage();
        goToURL("rental_home_url");
        selectByValue(rentalHomePage.selectCar,"11");
    //Message: Please first login
    //Given user is on the login page
    //And tries to book a car
    //And click continue reservation
    //Then user see the warning message: Please first login
    }
}
