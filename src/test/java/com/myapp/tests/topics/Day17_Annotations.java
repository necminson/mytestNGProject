package com.myapp.tests.topics;

import org.testng.annotations.*;

public class Day17_Annotations {
    /*
    @Test : Is used for creating test case
    @Before and @After : There are 5 @Before and 5 @After annotations
    suite > test > group > class > method
    @BeforeSuite : runs ones before for each Suit Test
    @AfterSuite : runs ones after for each Suit Test
    @BeforeTest : runs ones before for each Test ( Do not confuse with Test case "public void Test(){}")
    @AfterTest : runs ones after for each Test ( Do not confuse with Test case "public void Test(){}" )
    @BeforeClass : runs ones before for each class
    @AfterClass : runs ones after for each class
    @BeforeMethod : runs ones before for each @Test ( Just like @Before ın JUnit )
    @AfterMethod : runs ones after for each @Test ( Just like @After ın JUnit )
    -----------------------------------------------------------------------------------------------------------
    @Ignore : runs to skip test case
    @Test(enable false) : executes to make the test case ( @Test ) out of work
    ------------------------------------------------------------------------------------------------------------
    In TestNG,test cases execute in natural order
    @Test(priority = 1) : Executes @Test case in the first order
    NOTE : Default value of priority is 0 (zero)

     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println(" Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println(" Before Test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println(" Before Groups");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println(" Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println(" Before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("After Groups");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(priority = 1)
    public void test7(){
        System.out.println("Test 7");

    }
    @Test @Ignore
    public void test2(){
        System.out.println("Test 2");
        // throw new SkipException("Ignored because of an issue");

    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("Test 3");

    }
    @Test(priority = 4)
    public void test4(){
        System.out.println("Test 4");

    }
    @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");

    }
    @Test(priority = -5+6)
    public void test6(){
        System.out.println("Test 6");

    }
}
