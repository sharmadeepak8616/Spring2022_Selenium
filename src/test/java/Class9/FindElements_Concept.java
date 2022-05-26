package Class9;

import Helper.DateLib;
import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements_Concept {

    /**
     * findElements()
     *      To find multiple webElements using a locator
     *      return type: List<WebElement>
     */
    // Verify there are 40 links on the facebook landing page
    /*
        Steps:
            1. Launch facebook.com
            2. Find all links-webElements
            3. Verify number of links-Elements found is equal to 40
     */
    @Test
    public void findElementsConcept() {
        // #1
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        // #2
        List<WebElement> allLinks = MyDriver.getDriver().findElements(By.tagName("a"));     // allLinks = [link1, link2, link3, link4, ...]

        // #3
        Assert.assertEquals(allLinks.size(), 40, "Number of links of facebook landing page is not as expected");
    }


    // Verify past dates in the current month calendar are disabled
    /*
        Steps:
            1. Launch hotels.com
            2. Click on Check-in box
            3. Verify past-dates are disabled
     */
    @Test
    public void calendarAutomation() {
        // #1
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");

        // #2
        MyDriver.getDriver().findElement(By.id("d1-btn")).click();

        Misc.pause(2);

        // #3
        List<WebElement> disabledDates = MyDriver.getDriver().findElements(By.xpath("//table[@class='uitk-date-picker-weeks']//button[@disabled]"));

        /*
            get the current date using Date -> 11
            verify number of disabled dates are 11-1
         */

        int dateValue = DateLib.getCurrentDateAsInt();
        Assert.assertEquals(dateValue, disabledDates.size(), "Numbers of disabled dates are not as expected");


        // Assert.assertEquals(DateLib.getCurrentDateAsInt()-1, disabledDates.size(), "Numbers of disabled dates are not as expected");
    }

    // Select June 12, 2022 as check-in date
    @Test
    public void selectDateOnCalendar() {
        // #1
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");

        // #2
        MyDriver.getDriver().findElement(By.id("d1-btn")).click();

        Misc.pause(2);

        /**
         * 1. Analyze if the date-values are present as text-value or some attribute's value in dom
         * 2. Create a locator to get all webElements in the interested month
         * 3. Use the locator to find all-dates webElements using findElements-method
         * 4. loop
         *      pick a date-WebElement from the List<WebElement>
         *      apply getAttribute or getText on date-WebElement [depends on Step#1]
         *      if (above-value is equal to the date-user-wants-to-click)
         *         click the date-WebElement
         *         stop/break the loop
         */

        List<WebElement> allDates = MyDriver.getDriver().findElements(By.xpath("//h2[text()='June 2022']/following-sibling::table//button[@data-day]"));
        // allDates = [we1, we-2, we-3, ..... , we-30]

        /*
            we-1
            getAttribute(data-day) -> 1
            if (getAttribute(data-day) isEqual to dateUserWantsToClick)
                click we-1
                break;

            we-2
            getAttribute(data-day) -> 2
            if (getAttribute(data-day) isEqual to dateUserWantsToClick)
                click we-2
                break;
            ...
            ...
            ...
            we-12
            getAttribute(data-day) -> 12
            if (getAttribute(data-day) isEqual to dateUserWantsToClick)
                click we-12
                break;



         */

        for (WebElement dateElement : allDates) {
            String dateValue = dateElement.getAttribute("data-day");
            if (dateValue.equals("12")) {
                dateElement.click();
                break;
            }
        }
    }

    /**
     * 1. Analyze if the auto-suggestions are present as text-value or some attribute's value in dom
     * 2. Create a locator to get all auto-suggestion webElements
     * 3. Use the locator to find all auto-suggestion webElements using findElements-method
     * 4. loop
     *      pick a auto-suggestion-WebElement from the List<WebElement>
     *      apply getAttribute or getText on auto-suggestion-WebElement [depends on Step#1]
     *      if (above-value is equal to the autoSuggestion-user-wants-to-click)
     *         click the auto-suggestion-WebElement
     *         stop/break the loop
     */
    @Test
    public void autoSuggestion() {
        // #1
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");

        MyDriver.getDriver().findElement(By.xpath("//button[@aria-label='Going to']")).click();
        MyDriver.getDriver().findElement(By.id("location-field-destination")).sendKeys("new");

        Misc.pause(2);

        List<WebElement> allSuggestions = MyDriver.getDriver().findElements(By.xpath("//div[@class='uitk-typeahead-results']//div[contains(@class,'truncat') and not(contains(@class,'uitk'))]"));

        for (WebElement suggestion : allSuggestions) {
            if(suggestion.getText().equalsIgnoreCase("NEWPORT")) {
                suggestion.click();
                break;
            }
        }
    }






















}
