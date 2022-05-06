package Class6.Facebook;


import Web.MyDriver;
import org.openqa.selenium.By;

public class LandingPage {

    // Variables (Locators)
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");
    By createNewAccountBtnLocator = By.xpath("//a[@data-testid='open-registration-form-button']");


    // Methods (to interact with webElements present on this webpage)
    public void enterLoginEmail(String loginEmail) {
        MyDriver.getDriver().findElement(loginEmailLocator).sendKeys(loginEmail);
    }

    public void enterLoginPassword(String loginPwd) {
        MyDriver.getDriver().findElement(loginPassLocator).sendKeys(loginPwd);
    }

    public void clickLoginButton() {
        MyDriver.getDriver().findElement(loginButtonLocator).click();
    }

    public void clickCreateNewAccountBtn() {
        MyDriver.getDriver().findElement(createNewAccountBtnLocator).click();
    }

    public boolean isLoginBtnEnabled() {
        return MyDriver.getDriver().findElement(loginButtonLocator).isEnabled();
    }

    public boolean isCreateNewAccountBtnEnabled() {
        return MyDriver.getDriver().findElement(createNewAccountBtnLocator).isEnabled();
    }

}
