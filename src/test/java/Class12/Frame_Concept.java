package Class12;

import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frame_Concept {

    /**
     * Frames: is a web-page on a web-page.
     *      Frame is always going to be 'iframe' tag
     *      a web-page can have any number of frames
     */

    /**
     * To interact with a frame:
     *  1. switch on the frame
     *  2. interact with any element in the frame
     */
    /**
     * Switch to frame:
     *  1. using the id of the iframe tag
     *  2. using the frame-webElement
     *  3. using the frame-index
     */
    @Test
    public void frameConcept() {

        MyDriver.launchUrlOnNewWindow("https://www.yahoo.com/");

        // 1. using the id of the iframe tag
        MyDriver.getDriver().switchTo().frame("my-adsLREC3-iframe");

        // 2. using the frame-webElement
        By FrameLocator = By.xpath("//div[@id='darla_csc_holder']//iframe");
        WebElement myFrame = MyDriver.getDriver().findElement(FrameLocator);
        MyDriver.getDriver().switchTo().frame(myFrame);


        // 3. using the frame-index
        MyDriver.getDriver().switchTo().frame(2);

        // To switch/connect driver back to main-window from frame.
        MyDriver.getDriver().switchTo().defaultContent();





    }
}
