package Class11;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alert_Concept {

    @Test
    public void alertConcept() {

        MyDriver.launchUrlOnNewWindow("https://demo.guru99.com/test/delete_customer.php/");

        MyDriver.getDriver().findElement(By.name("cusid")).sendKeys("100");

        MyDriver.getDriver().findElement(By.name("submit")).click();

        /**
         * To interact with an Alert, we need to switch on the alert
         * Method: switchTo().alert()
         */
        Alert myAlert = MyDriver.getDriver().switchTo().alert();


        Misc.pause(10);

        /**
         * To get the text of alert
         * method: getText()
         */
        String myAlertText = myAlert.getText();
        System.out.println("myAlertText -> " + myAlertText);

        /**
         * To click on the +ve action button
         * Method: accept()
         */
        myAlert.accept();

        Assert.assertEquals(myAlert.getText(), "Customer Successfully Delete!", "Customer delete msg is not as expected");

        /**
         * To click on the -ve action button
         * Method: dismiss()
         */
        // myAlert.dismiss();
        myAlert.accept();

        /**
         * To type in the inputBox of alert
         * Method: sendKeys()
         */
        // myAlert.sendKeys("1234");





    }




}
