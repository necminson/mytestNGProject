package com.myapp.tests.dataprovider;
import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day22_DataProvider2 {
    /*
    we use DataProvider cause ;
    ***DataProvider allows you to create more comprehensive test scenarios
    by repeating the same test with different data sets.
    ***This enables testing various inputs and scenarios.
    When there are changes in test scenarios,
    updating the data set can be sufficient.
    **It is easy to update the data set and rerun the tests without
    modifying the test code, ensuring data maintainability.
    */
//    We need 2 methods : ****@DataProvider ***@Test method
//    DATA SOURCE
    @DataProvider
    public Object[][] productListProvider(){
        Object productList[][]={
                {"tesla"},
                {"rivian"},
                {"nio"},
                {"lucid"},
                {"bmw"},
                {"volvo"}
        };
        return productList;
    }
    //    ADDING ONE MORE DATA SOURCE
    @DataProvider(name = "smokeTestProvider")//***name      : used to override the method name
    public Object[][] adminInfoProvider(){
        Object [][]adminInfo = {
                {"admin1", "12345","CEO","LA","60"},
                {"admin2", "41241","CFO","NYC","50"},
                {"admin3", "12356","CMO","LONDON","40"}
        };
        return adminInfo;
    }
    //    TEST CLASS
    @Test(dataProvider = "productListProvider")//NO NEED TO USE  dataProviderClass = Day22_DataProvider2.class WHEN IN THE SAME CLASS
    public void productTest(String data){
//        {"tesla"},{"rivian"},{"nio"},{"lucid"},{"bmw"},{"volvo"}
//        Data provider atomatically loops through the list. In this example Data provider will loops 6 times
        System.out.println(data);
//        DO GOOGLE SEARCH WITH THE DATA THAT COMES FROM THE DATA SOURCE
        Driver.getDriver().get("https://www.google.com");
//        TO HANDLE COOKIES IF YOU HAVE COOKIE USE THIS
        /*
         try {
            Driver.getDriver().findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        }catch (Exception e){
        }
         */

//        Type the data in the google search box and clicking ENTER. getting the data from productListProvider
        Driver.getDriver().findElement(By.name("q")).sendKeys(data+ Keys.ENTER);
//        Asserting if title contains the data that is sent
        Assert.assertTrue(Driver.getDriver().getTitle().contains(data));
//        close the driver
        Driver.closeDriver();
    }
    @Test(dataProvider = "smokeTestProvider")
    public void adminLoginTest(String userName,String pass,String title,String city, String age){
//        Data provider has 5 parameter therefore I must use 5 parameter in the test method
//        However I don't have to use all of them inside the method body
        System.out.println(userName+" | "+pass+" | ");
    }
}