package com.myapp.tests.topics;

import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FirstDriverTest {
    // Create FirstDriverTest class
    @Test
    public void firstDriverTest(){

        //Go to amazon page
        Driver.getDriver().get("https://www.amazon.com");
        //Verify the title includes amazon
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.toLowerCase().contains("amazon"));
        Driver.closeDriver();
    }
}
