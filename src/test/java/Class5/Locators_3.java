package Class5;

public class Locators_3 {
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
     * Simple xpath (direct xpath)
     *
     * 5. Using the starting portion of attribute's value
     *      //tag[starts-with(@attrName, 'starting portion of attrName's value')]
     *      --> find the tag in dom, which has attrName(attribute)'s value starts with "starting portion of attrName's value"
     * eg:
     *      //input[starts-with(@aria-label, 'Fir')]
     *
     * 6. Using the starting portion of text-value
     *      //tag[starts-with(text(), 'starting portion of text-value')]
     *      --> find the tag in dom, which has text-value starts with "starting portion of text-value"
     * eg:
     *      //label[starts-with(text(), 'Fe')]
     *
     * 7. Using not() method
     *      //tag[not(@attrName='attr-value')]
     *      --> find the tag in dom, which has attrName(attribute) with value NOT equals to attr-value
     *
     *      //tag[not(text()='webElement text value')]
     *      --> find the tag in dom, which has text-value with value NOT equals to "webElement text value"
     *
     * 8. and/or operator
     *      //tag[contains(text(), 'text Val') and @attrName='attr-value']
     *      --> find the tag in dom, where
     *              text contains 'text Val'
     *                  and
     *              attribute(attrName) has value equals to 'attr-value'
     *
     *       //tag[text()='text value' or starts-with(@attrName, 'Attr Va')]
     *      --> find the tag in dom, where
     *              text is equals to 'text value'
     *                  or
     *              attribute(attrName)'s value starts with 'Attr Va'
     *
     *
     *       //tag[text()='text value' or starts-with(@attrName, 'Attr Va') or contains(@attrName1, 'Attr1 Va')]
     *      --> find the tag in dom, where
     *              text is equals to 'text value'
     *                  or
     *              attribute(attrName)'s value starts with 'Attr Va'
     *                  or
     *              attribute(attrName1)'s value contains 'Attr1 Va'
     *
     *
     *      //button[text()='Sign Up' or text()='Submit']
     *      //a[text()='Create new account' or text()='Create New Account']
     *
     */


    /**
     * //*[contains(@data-testid,'login_bu')]
     * --> find any tag in dom, where attribute(data-testid) contains "login_bu"
     *
     *
     */


}
