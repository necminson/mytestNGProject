package com.myapp.tests.topics;

import com.github.javafaker.Faker;
import com.myapp.pages.XYZBankCustomerPage;
import com.myapp.pages.XYZBankManagerPage;
import com.myapp.pages.XYZBankHomePage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static com.myapp.utilities.ReusableMethods.goToURL;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {
    /*
    Given
        Go to https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
    When
        Click on "Bank Manager Login" button
    And
        Click on "Add Customer" button
    And
        Fill inputs and click on "Add Customer" submit button
    And
        Accept alert
    And
        Add 4 more customers
    And
        Click on "Open Account" button
    And
        Select customer from dropdown
    And
        Select currency (dollar)
    And
        Click on process
    And
        Accept alert
    And
        Open 4 more accounts
    And
        Click on "Home" button
    And
        Click on "Customer Login" button
    And
        Select name from dropdown
    And
        Click on "Login"
    And
        Click on "Deposit" button
    And
        Type 100 into "Amount to be Deposited" input
    And
        Click on "Deposit"(Submit) button
    Then
        Assert that "Deposit Successful" is displayed
    When
        Click on "Withdrawal" button
    And
        Type 100 into "Amount to be Withdrawn" input
    And
        Click on "Withdraw"(Submit) button
    Then
        Assert that "Transaction  Successful" is displayed
    When
        Click on "Logout" button
    And
        Click on "Home" button
    And
        Click on "Bank Manager Login" button
    And
        Click on "Customers" button
    And
        Click on each "Delete" button
    And
        Count table row numbers
    Then
        Assert that number of customers is 0
     */

    @Test
    public void xyzBankTest() {

//        Go to https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        goToURL("xyz_Bank_url");

//        Click on "Bank Manager Login" button
        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

//        Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();

        for (int i = 0; i < 5; i++) {//        Add 4 more customers
            xyzBankManagerPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (UnhandledAlertException ignored) {
            }
        }


//        Click on "Open Account" button
        xyzBankManagerPage.openAccountButton.click();

//        Select customer from dropdown
        Select userDropDown = new Select(xyzBankManagerPage.userDropDown);
        Select currencyDropDown = new Select(xyzBankManagerPage.currencyDropDown);

        for (int i = 6; i < 11; i++) {//        Open 4 more accounts

            userDropDown.selectByIndex(i);

//        Select currency (dollar)
            currencyDropDown.selectByVisibleText("Dollar");

//        Click on process
            xyzBankManagerPage.processSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (UnhandledAlertException ignored) {
            }
        }

//        Click on "Home" button
        xyzBankHomePage.homeButton.click();


//        Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();

//        Select name from dropdown
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();

        Select yourNameDropDown = new Select(xyzBankCustomerPage.yourNameDropDown);
        yourNameDropDown.selectByIndex(6);

//        Click on "Login"
        xyzBankCustomerPage.loginButton.click();

//        Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

//        Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountToBeDeposited.sendKeys("100");

//        Click on "Deposit"(Submit) button
        xyzBankCustomerPage.depositSubmitButton.click();

//        Assert that "Deposit Successful" is displayed
        assertTrue(xyzBankCustomerPage.depositSuccessfulMessage.isDisplayed());

//        Click on "Withdrawal" button
        xyzBankCustomerPage.withDrawlButton.click();

//        Type 100 into "Amount to be Withdrawn" input
        xyzBankCustomerPage.withdrawSubmitButton.click();
        xyzBankCustomerPage.amountToBeWithDrawn.sendKeys("100");

//        Click on "Withdraw"(Submit) button
        xyzBankCustomerPage.withdrawSubmitButton.click();

//        Assert that "Transaction  Successful" is displayed
        assertTrue(xyzBankCustomerPage.transactionSuccessfulMessage.isDisplayed());

//        Click on "Logout" button
        xyzBankHomePage.logoutButton.click();

//        Click on "Home" button
        xyzBankHomePage.homeButton.click();

//        Click on "Bank Manager Login" button
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

//        Click on each "Delete" button you created
        for (int i = 6; i < 11; i++) {
            xyzBankManagerPage.deleteButtonList.get(5).click();
        }

//        Count table row numbers
        int numberOfRows = xyzBankManagerPage.deleteButtonList.size();

//        Assert that number of customers is 5
        assertEquals(5, numberOfRows);
        Driver.closeDriver();

    }
}