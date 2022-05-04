package Class5;

public class Locators_4 {
    /**
     * Types of WebElements:
     *      Button                  -> click
     *      TextBox/InputField      -> type
     *      Links                   -> click
     *      Dropdown                -> click
     *      Radio Button            -> click
     *      CheckBox                -> click
     *      Image                   -> click, get text from Image
     *      Text/Copy               ->
     *      Alert
     *      Frames
     */

    /**
     *  Chropath plugin:
     *  https://chrome.google.com/webstore/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo
     */

    /**
     * Locator is a kind of route to reach/find a particular webElement.
     * Datatype of locator -> By
     *
     *
     *
     * Steps to interact with webElement:
     * 1. Find the unique address to reach to the WebElement using DOM
     * 2. Depending upon the type of address,
     *      we use specific method from By-Class to create locator
     * 3. Use locator to find the WebElement using findElement()
     * 4. once webElement is found, interact with it
     */

    /**
     * Advanced Xpath (Indirect xpath):
     *
     * 1. Using parent/grandParent tag
     *      //div[contains(@class, 'selectric-below')]//div[@class='selectric']//b
     *
     * 2. Xpath axes:
     *      1. following-sibling
     *      //tag[condition(s)]/following-sibling::tag2[condition(s)]
     * eg:
     *      //label[text()='Female']/following-sibling::input
     *      //h2[text()='June 2022']/following-sibling::table//button[@data-day='20']
     *
     *      2. preceding-sibling
     *      //tag[condition(s)]/preceding-sibling::tag2[condition(s)]
     *
     *      3. following
     *      //tag[condition(s)]/following::tag2[condition(s)]
     * eg:
     *      //a[text()='Help']/following::div[contains(@class, 'copyright')]//span[text()=' Meta © 2022']
     *
     *      4. preceding
     *      //tag[condition(s)]/preceding::tag2[condition(s)]
     * eg:
     *      //a[text()='Create new account']/preceding::button[@name='login']
     *
     *      5. ancestor
     *      //tag[condition(s)]/ancestor::tag2[condition(s)]
     *
     *      6. descendant
     *      //tag[condition(s)]/descendant::tag2[condition(s)]
     */


    /**
     * //*[contains(@data-testid,'login_bu')]
     * --> find any tag in dom, where attribute(data-testid) contains "login_bu"
     */


}
