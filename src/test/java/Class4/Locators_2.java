package Class4;

public class Locators_2 {
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
     * Address:
     * 5. linkText (Refer Link discussion below)
     *      In chropath, check if the linkText is unique --> //a[text()='linkText']
     *      By locatorUsingLinkText = By.linkText("link text value")
     *
     *      eg:
     *      By createNewAccountLocator = By.linkText("Create new account");
     *
     * 6. partialLinkText (Refer Link discussion below)
     *      In chropath, check if the linkText is unique --> //a[contains(text() , 'link t')]
     *      By locatorUsingPartialLinkText = By.partialLinkText("k text va")
     *
     *      eg:
     *      By createNewAccountLocator = By.partialLinkText("e new a");
     *
     * 7. Xpath
     *      In chropath, create x-path to find the webElement
     *      By locatorUsingXpath = By.xpath("//xpath that you have created to find the webElement");
     *
     */

    /**
     * Link:
     *      1. Always with 'a' tag
     *      2. Text associated with a link (or a-tag) is called Link-Text
     *      3. The value of href-attribute defines where user will land if click the link.
     */
    /**
     * XPATH
     *
     * Types:
     *      1. Absolute Xpath
     *          a) starts with single slash (/)
     *          b) tells the rout to reach to a particular webElement from the root-tag (html-tag)
     *          c) not reliable, any change in the webPage can break the absolute xpath
     *
     *      2. Relative Xpath
     *          a) starts with double slash (//)
     *          b) reliable bcz we use tagName, attribute-value, text-Value in any combination
     *
     *          -> simple xpath (direct xpath)
     *          -> advanced xpath (indirect xpath)
     *
     */

    /**
     * Simple xpath (direct xpath)
     *
     * 1. Using any attribute's value:
     *      //tag[@attrName='attr-value']
     *      --> find the tag in dom, which has attrName(attribute) with value equals to attr-value
     * eg:
     *      //input[@data-testid='royal_email']
     *
     * 2. Using text-value:
     *      //tag[text()='webElement text value']
     *      --> find the tag in dom, which has text-value with value equals to "webElement text value"
     * eg:
     *      //button[text()='Log In']
     *
     * 3. Using any attribute's partial value
     *      //tag[contains(@attrName,'attr-va')]
     *      --> find the tag in dom, which has attrName(attribute)'s value contains "attr-va"
     * eg:
     *      //button[contains(@data-testid,'royal_l')]
     *
     * 4. Using partial text value:
     *      //tag[contains(text(),'Text va')]
     *      --> find the tag in dom, where text-value contains "Text va"
     * eg:
     *      //a[contains(text() , 'got p')]
     *
     *
     *
     *
     *
     *
     *
     *
     */


    /**
     * //*[contains(@data-testid,'login_bu')]
     * --> find any tag in dom, where attribute(data-testid) contains "login_bu"
     *
     *
     */


}
