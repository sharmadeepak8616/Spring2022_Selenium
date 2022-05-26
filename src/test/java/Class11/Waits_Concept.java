package Class11;

import Web.MyDriver;
import com.google.common.base.Function;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits_Concept {


    /**
     * Thread.sleep(5000)       // to pause the program execution
     *
     * sleep - no functionality | pause for prolong time | in-active state
     * wait - stop wait for signal then go | pause for something to finish |
     *
     *
     * sleep for 10-seconds -> no activity for 10-seconds
     * wait for 10-seconds -> active, and keep looking for signal to move ahead
     *
     *
     * 0900 hrs sleep for 10-mins
     *  0903
     * 0910 hrs
     *
     * 0900 hrs wait for 10-mins
     *  0901 - check for friend, arrived? if not keep waiting
     *  0902 - check for friend, arrived? if not keep waiting
     *  0903 - check for friend, arrived? Yes. stop waiting and start conversation
     *
     * 0910hr is max upto which you will wait
     *
     */
    /**
     * Timeout -> max time period for which driver will wait
     * Polling period -> Time interval after which driver checks; should it stop wait or not
     */

    /**
     * Types of Wait in Selenium:
     *      1. Implicit Wait
     *      2. Explicit Wait
     *      3. Fluent Wait
     */
    /**
     * Implicit Wait:
     *
     * Implicit wait is useful when you are finding a webElement.
     *
     * -> Wait for a certain amount of time before throwing NoSuchElementException
     * and stop waiting as soon the element is found.
     *
     * -> During the wait time, implicit wait ignores NoSuchElementException;
     * if any other exception occurs, driver cannot ignore it, and throw it right away.
     *
     * Polling period : 250ms
     */
    @Test
    public void implicitWait() {

        /*
            facebook.com
            enter incorrect login username
            enter incorrect login pwd
            click login button
            Verify error msg is displayed
         */
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        MyDriver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MyDriver.getDriver().findElement(By.id("email")).sendKeys("@#$%^&*(");
        MyDriver.getDriver().findElement(By.id("pass")).sendKeys("abcd@12345");
        MyDriver.getDriver().findElement(By.tagName("button")).click();
        boolean isErrorDisplayed = MyDriver.getDriver().findElement(By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']")).isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error is not displayed");

    }

    /**
     * Explicit Wait:
     * Wait for a certain amount of time until the specified condition(s) is met
     * As soon as the mentioned condition(s) is met, driver will stop waiting.
     *
     * During wait time, Explicit wait ignores exception related to the condition(s)
     * If any other exception occurs (which is not related to specified condition(s)), driver will not ignore it and throw right away.
     *
     * Timeout: is always in Seconds
     * Polling Period: 500ms
     */
    @Test
    public void explicitWaits() {
        /*
            facebook.com
            enter incorrect login username
            enter incorrect login pwd
            click login button
            Verify error msg is displayed
         */
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        WebDriverWait eWait = new WebDriverWait(MyDriver.getDriver(), 20);
        eWait.until(ExpectedConditions.titleContains("abcd"));


        MyDriver.getDriver().findElement(By.id("email")).sendKeys("@#$%^&*(");
        MyDriver.getDriver().findElement(By.id("pass")).sendKeys("abcd@12345");
        MyDriver.getDriver().findElement(By.tagName("button")).click();

        eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']")));

        boolean isErrorDisplayed = MyDriver.getDriver().findElement(By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']")).isDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error is not displayed");

        eWait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains("facebook"),
                ExpectedConditions.alertIsPresent(),
                ExpectedConditions.elementToBeClickable(By.xpath(""))
        ));

        eWait.until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("")),
                ExpectedConditions.urlToBe("https://www.facebook.com/")
        ));
    }

    /**
     * Fluent Wait
     * Wait for a certain amount of time until the element is found or the specified condition(s) is met
     * If the wait-time is over, it throws TimeoutException
     *
     * User can:
     *      set/define the polling period
     *      ignore other exception(s) during the wait-time
     *      put a custom to print in case of TimeOutException
     *
     *
     */
    @Test
    public void fluentWait() {

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        Wait fWait = new FluentWait(MyDriver.getDriver())
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoAlertPresentException.class)
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(ElementClickInterceptedException.class)
                        .withMessage("Fluent wait timeout, waited for 30-seconds");


        // Use fluent wait for a condition to met (like an Explicit wait)
        fWait.until(ExpectedConditions.alertIsPresent());


        // Use fluent wait to find a webElement (like an Implicit wait)
        // we want method to return WebElement
        // until return Object
        // Typecast Object into WebElement
        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
                                                          public WebElement apply(WebDriver driver) {
                                                              return driver.findElement(By.id(""));
                                                          }
                                                      });
        element.click();

        /**
         * using fluent wait to find element
         *      use until() to keep find the element
         */

    }






}
