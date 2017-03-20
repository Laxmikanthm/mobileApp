package pages.PayPalPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 08-03-2017.
 */
public class PayPalPageAndroid extends PayPalPage {

    PayPalPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }

    public AndroidTextBox getPaypalUserName() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox ((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PayPalEmail")+"']"), "username text field" );

        return userNameTextbox;
    }

    public AndroidPasswordTextBox getPaypalPassword() throws Exception {

        AndroidPasswordTextBox passwordTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PayPalPassword")+"']"), "password text field");

        return passwordTextBox;
    }

    public AndroidButton getLogIn() throws Exception {

        //AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@content-des='"+BaseTest.bundle.getString("Login")+"']"), "Login button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public AndroidButton getAgreeAndContinue() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
}
