package Class3;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UseLocators_1 {
    /**
     * To find a WebElement
     * method: findElement
     * input: By (locator for WebElement which we want to interact with)
     * return type: WebElement
     *
     * if the element is found using the locator
     *      method returns WebElement
     * else
     *      NoSuchElement Exception
     */

    /**
     * To type in a webElement
     * method: sendKeys()
     * input: String (data that we want to type in the webElement)
     */

    /**
     * To click on a webElement
     * method: click()
     */

    /**
     * To clear the text in a webElement
     * method: clear()
     */

    // Using Selenium enter data in login Email and password ; and click login button
    @Test
    public void useLocators_1() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String loginEmailIdValue = "email";
        By loginEmailLocator = By.id(loginEmailIdValue);
        WebElement loginEmailBox = MyDriver.getDriver().findElement(loginEmailLocator);
        loginEmailBox.sendKeys("abcd@test.com");

        Misc.pause(5);
        // loginEmailBox.clear();
        // Misc.pause(3);
        // loginEmailBox.sendKeys("testing@abc.com");

        String loginPassNameValue = "pass";
        By loginPassLocator = By.name(loginPassNameValue);
        WebElement loginPassBox = MyDriver.getDriver().findElement(loginPassLocator);
        loginPassBox.sendKeys("abcd@1234");


        Misc.pause(5);


        String loginButtonNameValue = "login";
        By loginLoginBtnLocator = By.name(loginButtonNameValue);
        WebElement loginButton = MyDriver.getDriver().findElement(loginLoginBtnLocator);
        loginButton.click();





    }

























}
