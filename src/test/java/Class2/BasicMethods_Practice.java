package Class2;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicMethods_Practice {

    // TC-1: Verify the facebook page title starts with "facebook" on facebook home page
    /*
        Steps:
        1. Launch a new browser window
        2. Open facebook.com
        3. Verify page title starts with "facebook"
     */
    @Test
    public void verifyTitle() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String pageTitle = MyDriver.getDriver().getTitle();
        boolean isStartsWith_facebook = pageTitle.startsWith("facebook");
        Assert.assertTrue(isStartsWith_facebook , "Facebook title does NOT start with 'facebook'");

        MyDriver.quitWindows();

    }

    // TC-2: Verify the url stays same after refreshing the facebook home page
    /*
        1. Launch a new browser window
        2. Open facebook.com
        3. Observe the url-value
        4. Refresh the webpage
        5. Verify url value is same as of Step-3

     */
    @Test
    public void verifyUrlAfterRefresh() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String urlAfterLaunch = MyDriver.getDriver().getCurrentUrl();

        MyDriver.getDriver().navigate().refresh();
        Misc.pause(5);

        String urlAfterRefresh = MyDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(urlAfterLaunch, urlAfterRefresh, "Facebook url is NOT same after refresh");

        MyDriver.quitWindows();
    }

    // TC-3: Verify current url is ending with "/" on facebook home page
    @Test
    public void verifyUrlEnding() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        String urlAfterLaunch = MyDriver.getDriver().getCurrentUrl();

        boolean urlEndsWith_Slash = urlAfterLaunch.endsWith("/");
        Assert.assertTrue(urlEndsWith_Slash, "Facebook url does NOT end with '/'");

        MyDriver.quitWindows();
    }


}
