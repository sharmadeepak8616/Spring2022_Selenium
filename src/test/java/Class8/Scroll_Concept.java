package Class8;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Scroll_Concept {

    /**
     * In selenium there is no method which can be used to scroll in a webpage
     * To scroll in a webpage, we use Javascript
     *
     *
     * "abcd-1234" (javascript to scroll a webpage)
     * run/execute the above javascript using java-code
     *
     *
     * 1. scroll by pixel
     * 2. scroll upto a webElement
     * 3. scroll upto bottom of the page
     *
     */
    // Verify user can click on Time Machine button (darksky.net)
    @Test
    public void scrollByPixel() {
        /**
         * 1. scroll by pixel
         *  scrollBy(0,y)
         *
         *  y as a +ve              -> scroll downwards
         *  eg: scrollBy(0,200)     -> scroll 200-pixels downwards
         *
         *  y as a -ve              -> scroll upwards
         *  eg: scrollBy(0,-100)    -> scroll 100-pixels upwards
         */

        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

        Misc.pause(2);

        JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("scrollBy(0,800)");

        Misc.pause(5);

        MyDriver.getDriver().findElement(By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']")).click();

    }

    public void scrollUptoWebElement() {
        /**
         * 2. scroll upto a webElement
         *
         * "element.scrollIntoView(true)"
         *
         */
        WebElement myElement = MyDriver.getDriver().findElement(By.xpath(""));

        JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("argument[0].scrollIntoView(true);", myElement);
    }

    public void scrollToBottom() {
        /**
         * 3. scroll upto bottom of the page
         *
         * "window.scrollTo(0, document.body.scrollHeight)"
         */

        JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }


    @Test
    public void scrollByPixel2() {
        /*
            Launch webpage
            try to find the Time Machine button, break if found
            if Exception occurs, scroll

         */

        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

        for (int i=0 ; i <= 15 ; i++) {
            try {
                MyDriver.getDriver().findElement(By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']")).click();
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                //scroll by 100
                JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,100)");
            }
        }

    }
}
