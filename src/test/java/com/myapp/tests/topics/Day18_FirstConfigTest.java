package com.myapp.tests.topics;

import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.IConfigEavesdropper;

public class Day18_FirstConfigTest {

    @Test
    public void firstConfigTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_prod_url"));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains("amazon"));
        Driver.closeDriver();
    }
}
