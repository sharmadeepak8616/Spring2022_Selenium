package Class5;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdowns {

    /**
     * Dropdowns
     *
     * dropdown are either 'select' or any other tag
     *
     * Dropdown with select-tag --> Select class
     *
     * 1. find the locator of the dropdown webElement (or select-tag)
     * 2. find the dropdown-webElement using step-1 locator
     * 3. Create an object of Select-class, and pass the dropdown-WebElement (found on Step-2) in the Constructor
     * 4. Use relevant method form Select class to select the desired value in the dropdown
     *      selectByVisibleText     |       selectByValue       |       selectByIndex
     */

    // TC -> Select date of birth values in the sign up dropdown
    //      Jan 01 1990
    /*
        Steps:
        1. Launch browser
        2. open facebook.com
        3. Click 'Create new account' button
        4. Select Jan 01 1990 in date of birth dropdown
     */
    @Test
    public void dropdowns() {

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        By createNewAccountLocator = By.xpath("//a[text()='Create new account' or text()='Create New Account']");
        MyDriver.getDriver().findElement(createNewAccountLocator).click();

        Misc.pause(5);

        By monthDdLocator = By.id("month");
        WebElement monthDdElement = MyDriver.getDriver().findElement(monthDdLocator);
        Select monthDd = new Select(monthDdElement);
        monthDd.selectByVisibleText("Jan");

        By dateDdLocator = By.name("birthday_day");
        WebElement dateDdElement = MyDriver.getDriver().findElement(dateDdLocator);
        Select dateDd = new Select(dateDdElement);
        dateDd.selectByValue("1");

        By yearDdLocator = By.xpath("//select[starts-with(@title, 'Ye')]");
        WebElement yearDdElement = MyDriver.getDriver().findElement(yearDdLocator);
        Select yearDd = new Select(yearDdElement);
        yearDd.selectByIndex(2);

    }


    @Test
    public void dropdownsNotSelectTag() {



    }



}


























