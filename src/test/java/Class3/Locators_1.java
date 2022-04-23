package Class3;

public class Locators_1 {
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
     * 1. using the id-attribute
     *      In chropath, check if id-value is unique --> //*[@id='idAttr-Value']
     *      By locatorUsingId = By.id("idAttr-Value")
     *
     *      eg:
     *      By loginEmailLocator = By.id("email");
     *
     * 2. using name-attribute
     *      In chropath, check if name-value is unique --> //*[@name='nameAttr-Value']
     *      By locatorUsingName = By.name("nameAttr-Value");
     *
     *      eg:
     *      By loginButtonLocator = By.name("login");
     *
     * 3. using the tagName
     *      In chropath, check if tag is unique --> //tagName
     *      By locatorUsingTagName = By.tagName("tagNameValue")
     *
     *      eg:
     *      By loginBtnLocator = By.tagName("button")
     *
     * 4. using the class-attribute
     *      In chropath, check if class-value is unique --> //*[@class='classAttr-Value']
     *      By locatorUsingClassName = By.className("classAttr-Value")
     *
     *      eg:
     *      By locatorUsingClassName = By.className("_8esk");
     *
     *
     */




}
