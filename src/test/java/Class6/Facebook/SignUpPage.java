package Class6.Facebook;

import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    // Variables (Locators)
    By monthDdLocator = By.id("month");
    By yearDdLocator = By.id("year");
    By dayDdLocator = By.id("day");


    // Methods (to interact with webElements present on this webpage)
    public void selectBirthMonth(String monthName) {
        WebElement monthDd = MyDriver.getDriver().findElement(monthDdLocator);
        Select monthSelect = new Select(monthDd);
        monthSelect.selectByVisibleText(monthName);
    }

    public void selectBirthDay(String day) {
        WebElement dayDd = MyDriver.getDriver().findElement(dayDdLocator);
        Select daySelect = new Select(dayDd);
        daySelect.selectByVisibleText(day);
    }

    public void selectBirthYear(String year) {
        WebElement yearDd = MyDriver.getDriver().findElement(yearDdLocator);
        Select yearSelect = new Select(yearDd);
        yearSelect.selectByVisibleText(year);
    }

    public void selectBirthDate(String birthDate) {
        String[] birthDateData = birthDate.split(" ");
        selectBirthMonth(birthDateData[0]);
        selectBirthDay(birthDateData[1]);
        selectBirthYear(birthDateData[2]);
    }






}
