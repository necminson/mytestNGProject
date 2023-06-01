package com.myapp.tests.smoketestsuite.logintests.excelautomation;
import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
public class Day21_ExcelLogin {
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
    //    to call the Excel Util constructor and methods
    ExcelUtils excelUtils;
    //    will be used to store the data
    List<Map<String, String>> dataList;
    @Test
    public void customerLoginTest(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtils= new ExcelUtils(path,sheetName);
        dataList=excelUtils.getDataList();
        System.out.println(dataList);//returns all the data as list of map of string
        for (Map<String, String> eachData : dataList){
//            go to home page
            Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
            rentalHomePage = new RentalHomePage();
            rentalLoginPage = new RentalLoginPage();
//            LOG IN
//            click on login
            WaitUtils.waitFor(1);
            rentalHomePage.loginLink.click();
            WaitUtils.waitFor(1);
//            enter username
            rentalLoginPage.userEmail.sendKeys(eachData.get("username"));//GET DATA FROM EXCEL
            WaitUtils.waitFor(1);
//            enter password
            rentalLoginPage.userPassword.sendKeys(eachData.get("password"));//GET DATA FROM EXCEL
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

        }
        Driver.closeDriver();
/*
TRY LOOPING THIS CONTENT
go to home page
click on login
enter username
enter password
click on login button
verify login
click on id
click on logout
click on ok
*/
/*
pseudo code:
***********
go to home page
---LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT----
click on id
click on logout
click on ok
----LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
---LOG IN ---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
 */
    }
}