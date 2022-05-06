package Class6;

import Class6.Facebook.LandingPage;
import Class6.Facebook.SignUpPage;
import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectModel {
    /**
     * Page Object Model (POM) Concept
     *
     * We create a java-class which represent one webpage
     * Locators will be stored as variables
     * Methods will be created to interact with webElements of the webpage
     *
     */


    // Using Selenium enter data in login Email and password ; and click login button
    /*
        Steps
        1. Open facebook.com
        2. enter login email (abcd@gmail.com)
        3. enter password (abcd@1234)
        4. Click login button
     */
    @Test
    public void usePom_1() {

        LandingPage lpage = new LandingPage();

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        lpage.enterLoginEmail("abcd@gmail.com");

        lpage.enterLoginPassword("abcd@1234");

        lpage.clickLoginButton();

    }


    // TC -> Select date of birth values in the sign up dropdown
    //      Jan 01 1990
    /*
        Steps:
        1. Launch browser
        2. open facebook.com
        3. Click 'Create new account' button (LandingPage)
        4. Select Jan 1 1990 in date of birth dropdown (SignUpPage)
     */
    @Test
    public void usePom_2() {

        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        LandingPage lPage = new LandingPage();
        lPage.clickCreateNewAccountBtn();

        Misc.pause(5);

        SignUpPage sPage = new SignUpPage();
        sPage.selectBirthDate("Jan 1 1990");

    }


    // Verify login and Create-New-Account buttons are enabled by default
    /*
        Steps:
        1. Launch browser
        2. open facebook.com
        3. Verify Login button is enabled
        4. Verify Create new account button is enabled
     */
    @Test
    public void verifyButtonsEnabled() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        LandingPage lPage = new LandingPage();
        Assert.assertTrue(lPage.isLoginBtnEnabled(), "Login button is not enabled by default");
        Assert.assertTrue(lPage.isCreateNewAccountBtnEnabled(), "Create new account button is not enabled by default");

        MyDriver.quitWindows();
    }






}
