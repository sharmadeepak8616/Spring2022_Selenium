package Class4;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UseLocators_2 {
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

    /**
     * To get the value of one of the attribute of a webElement
     * method: getAttribute()
     * input: attrName
     * return type: String
     */

    /**
     * To get the text of a webElement
     * method: getText()
     * return type: String
     */

    /**
     * To get if a webElement is enabled or not
     * method: isEnabled()
     * return type: boolean
     */

    /**
     * To get if a webElement is displayed or not
     * method: isDisplayed()
     * return type: boolean
     */

    /**
     * To get if a webElement is selected or not
     * method: isSelected()
     * return type: boolean
     */

    // TC -> Verify user lands on correct page after click Messenger link
    /*
        Steps:
        1. Launch browser
        2. Open facebook.com
        3. Click Messenger link
        4. Verify user lands on messenger.com

        3. Click Messenger link
        find the locator of Messenger link
        find the webElement using the locator
        get the value of href-attribute
        verify href-attribute's value is "messenger.com"
        click the webElement

        4. Verify user lands on messenger.com
        get current-url using getCurrentUrlMethod
        verify currentUrl is "messenger.com"
     */
    @Test
    public void verifyMessengerLink() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String messengerText = "Messenger";
        By messengerLocator = By.linkText(messengerText);
        WebElement messengerLink = MyDriver.getDriver().findElement(messengerLocator);

        String hrefValue = messengerLink.getAttribute("href");
        Assert.assertTrue(hrefValue.contains("messenger.com"), "href on messenger link is incorrect");

        messengerLink.click();

        Misc.pause(5);

        String urlAfterLink = MyDriver.getDriver().getCurrentUrl();
        Assert.assertTrue(urlAfterLink.contains("messenger.com"), "Url is incorrect");

        MyDriver.quitWindows();
    }

    // TC -> Verify create new account button text is "Create New Account"
    /*
        Steps:
        1. Launch browser
        2. Open facebook.com
        3. Verify text/copy on create new account btn is "Create New Account"


        3. Verify text/copy on create new account btn is "Create New Account"
        find the locator for create new account btn
        find the webElement using locator
        get the text of the WebElement
        verify text is equals to "Create New Account"
     */
    @Test
    public void verifyCreateNewAccountBtnText() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        By createNewAccountLocator = By.partialLinkText("ccount");
        WebElement createNewAccBtn = MyDriver.getDriver().findElement(createNewAccountLocator);
        String createNewAccBtnText = createNewAccBtn.getText();
        Assert.assertEquals(createNewAccBtnText, "Create New Account", "Create new account btn copy is not correct");

        MyDriver.quitWindows();

    }

    // TC -> Verify the login button is enabled when user lands on facebook.com
    /*
        Steps:
        1. Launch browser
        2. Open facebook.com
        3. Verify Login button is enabled


        3. Verify Login button is enabled
        find locator for login button
        find webElement using the locator
        Verify webElement is enabled
     */
    @Test
    public void isLoginEnabled() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String loginBtnXpath = "//button[@type='submit']";
        By loginBtnLocator = By.xpath(loginBtnXpath);
        WebElement loginBtn = MyDriver.getDriver().findElement(loginBtnLocator);

        boolean isLoginBtnEnabled = loginBtn.isEnabled();
        Assert.assertTrue(isLoginBtnEnabled, "Login btn is not enabled when user lands on facebook.com");

        MyDriver.quitWindows();

    }


    // TC -> Verify error message is displayed for invalid credentials
    /*
        Steps:
        1. Launch browser
        2. Open facebook.com
        3. Enter "$%^&*(" as login email
        4. Enter "abcd@1234" as login pwd
        5. Click login button
        6. Verify error msg is displayed (The email or mobile number you entered isn’t connected to an account.)
     */
    @Test
    public void verifyErrorMsgOnInvalidLoginCredentials() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String loginEmailId = "email";
        By loginEmailLocator = By.id(loginEmailId);
        WebElement loginEmail = MyDriver.getDriver().findElement(loginEmailLocator);
        loginEmail.sendKeys("$%^&*(");

        // String loginPassXpath = "//input[contains(@data-testid , '_pass')]";
        // By loginPassLocator = By.xpath(loginPassXpath);
        // WebElement loginPass = MyDriver.getDriver().findElement(loginPassLocator);
        // loginPass.sendKeys("abcd@1234");

        MyDriver.getDriver().findElement(By.xpath("//input[contains(@data-testid , '_pass')]")).sendKeys("abcd@1234");

        By loginBtnLocator = By.xpath("//*[@data-testid='royal_login_button']");
        WebElement loginBtn = MyDriver.getDriver().findElement(loginBtnLocator);
        loginBtn.click();

        Misc.pause(5);

        String expErrorMsg = "The email or mobile number you entered isn’t connected to an account.";
        By loginErrorLocator = By.xpath("//div[contains(text() , 'connected to an')]");
        WebElement loginError = MyDriver.getDriver().findElement(loginErrorLocator);
        Assert.assertEquals(loginError.getText().trim(), expErrorMsg, "Login error is not displayed");
        // get the text of WebElement
        // Verify the text of WebElement is equals to "The email or mobile number you entered isn’t connected to an account."

        //  OR

        By loginErrorLocator2 = By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']");
        WebElement loginError2 = MyDriver.getDriver().findElement(loginErrorLocator2);
        Assert.assertTrue(loginError2.isDisplayed(), "Login error is not displayed");

    }








}


























