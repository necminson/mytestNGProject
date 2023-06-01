package com.myapp.tests.dataprovider;

import com.myapp.utilities.DataProviderUtils;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    /*
What is Data Provider?
***It is a TestNG annotation
***It is used to provide data to the test classes
***It returns a 2D array
Why you use Data Provider?
***We use data provider to get the data from the data source(json file, excel sheet, xml file,...)
***We also use data provider to do Data Driven Testing(testing the functionality with multiple data)
How do you use data provider?
***We have a data pool/ data source that has multiple data. In that data source we use @DataProvider annotation
***And in the @Test method, I use dataProvider parameter to link data source method and test method
Data provider has 2 parameters
***name      : used to override the method name
***parallel  : used for parallel testing
 */
    @Test(dataProvider = "customerCredentials",dataProviderClass = DataProviderUtils.class)
    public void customerCredentialsTest(String username,String password){
        System.out.println("username = " + username+ " || password =  "+ password);

    }
}
