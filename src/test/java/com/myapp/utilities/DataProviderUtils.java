package com.myapp.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider
    public Object[][] customerCredentials(){
    // This is a data source
    Object[][] customerInfo={
            {"customer1","12345"},
            {"customer2","54321"},
            {"customer3","67890"}
    };
        return customerInfo;
    }
}
