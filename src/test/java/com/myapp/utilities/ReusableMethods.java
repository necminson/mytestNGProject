package com.myapp.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.testng.AssertJUnit.*;


public class ReusableMethods {
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
    }

    public static String getTextWithTimeout(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
        return null;
    }
    /*
    Custom method to wait to type in an input
     */
    public static void sendKeysWithTimeout(WebElement element,String text,int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
    }
    //    RADIO BUTTON
    public void clickRadioByIndex(int index){
        int numOfRadio =Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).size();
        for (int i=0;i<numOfRadio;i++){
            if (!Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).get(index).isSelected()) {
                Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).get(index).click();
            }
        }
    }
    //    CHECKBOX BUTTON
    public void clickCheckboxByIndex(int index){
        int numOfRadio =Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).size();
        try{
            for (int i=0;i<numOfRadio;i++){
                if (!Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).get(index).isSelected()) {
                    Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //    DROPDOWN
//    USE THIS ONE TO SELECT FROM A DROPDOWN
    public static void selectByVisibleText(WebElement element, String text){
        Select select =new Select(element);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(text)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    public static void selectByIndex(WebElement element, int index){
        Select objSelect =new Select(element);
        objSelect.selectByIndex(index);
    }
    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        objSelect.selectByValue(value);
    }
    public static void selectDropdownByValue(WebElement element,String textOfDropdown){
        List<WebElement> options = element.findElements(By.tagName("option"));
        for (WebElement option : options){
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)){
                option.click();
                break;
            }
        }
    }
    //  DROPDOWN
    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    //    DROPDOWN: accepts dropdown element and returns all selected element texts as an arraylist
    public ArrayList<String> getDropdownSelectedOptions(WebElement element) throws Exception {
        if (element!=null){
            Select list = new Select(element);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions){
                result.add(eachSelected.getText());
            }
            return result;
        }else {
            throw new Exception("No element is returned");
        }
    }
    //    VERIFY ELEMENT IS DISPLAYED
    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            org.testng.Assert.fail("Element is not found: " + element);
        }
    }
    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            org.testng.Assert.fail("Element not found: " + by);
        }
    }
    //VERIFY ELEMENT IS NOT DISPLAYED
    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    /**
     * Verifies whether the element matching the provided WebElement is NOT displayed on page
     * fails if the element matching the WebElement is not found or not displayed
     * @paramWebElement
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public static void verifyElementClickable(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Element not found: " + element);
        }
    }
    public static void verifyElementNotClickable(WebElement element) {
        try {
            assertFalse("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    //    ALERT
    public void acceptAlert() throws InterruptedException {
        Driver.getDriver().switchTo().alert().accept();
    }
    public void dismissAlert() throws InterruptedException {
        Driver.getDriver().switchTo().alert().accept();
    }
    //    IFRAME
    public static void switchIframeByWebElement(String xpath){
        WebElement iframeElement = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.getDriver().switchTo().frame(iframeElement);
    }
    //    IFRAME
    public static void switchIframeByIndex(int index){
        Driver.getDriver().switchTo().frame(index);
    }
    //    MULTIPLE WINDOW !!!
    public static void switchToWindowByTitle(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String childWindow : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(childWindow);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : "+targetTitle);
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    //    windowNumber starts at (0)
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(list.get(windowNumber));
    }
    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        new Actions(Driver.getDriver()).contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
        //        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
        //        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
        //        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
        //        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
        //        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).dragAndDropBy(source,x,y).perform();
    }
}
