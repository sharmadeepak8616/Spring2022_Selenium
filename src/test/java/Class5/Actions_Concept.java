package Class5;

import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions_Concept {

    /**
     * mouseHover       ->      moveToElement()
     * right click      ->      contextClick()
     * double click     ->      doubleClick()
     * Drag and drop    ->      dragAndDrop()
     * click            ->      click()
     * type             ->      sendKeys()
     *
     */
    // TC -> Verify user can see news/notification when perform mouse hover on bell icon
    /*
        1. launch browser
        2. open yahoo.com
        3. move mouse on bell-icon
        4. Verify news/notification is displayed
     */
    @Test
    public void ActionsDemo() {

        MyDriver.launchUrlOnNewWindow("https://www.yahoo.com/");

        By bellIconLocator = By.xpath("//label[@for='ybarNotificationMenu']");
        WebElement bellIcon = MyDriver.getDriver().findElement(bellIconLocator);

        Actions action = new Actions(MyDriver.getDriver());
        action.moveToElement(bellIcon).perform();
    }

    /**
     * .build().perform() vs .perform();
     *
     * when a method (from Actions class) is doing only 1-action -> .perform() is enough
     *      [but we can use .build().perform() as well]
     *
     * when a method (from Actions class) is more than 1-action -> .build().perform()
     *
     */


}
