package pages.PayPalPage;

import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 08-03-2017.
 */
public class PayPalPageIOS extends  PayPalPage{

    public PayPalPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public IOSTextBox getPaypalUserName() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox ((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PayPalEmail")+"']"), "PayPal email" );

        return userNameTextbox;
    }

    public IOSTextBox getPaypalUname() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox ((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PayPalEmail")+"']"), "PayPal email" );

        return userNameTextbox;
    }

    public IOSPasswordTextBox getPaypalPassword() throws Exception {

        IOSPasswordTextBox passwordText = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("NewPassword") + "']"), "Password text field");

        return passwordText;
    }

    public IOSPasswordTextBox getPaypalPwd() throws Exception {

        IOSPasswordTextBox passwordText = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("NewPassword") + "']"), "Password text field");

        return passwordText;
    }


    public IOSButton getLogIn() throws Exception {

        //AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@content-des='"+BaseTest.bundle.getString("Login")+"']"), "Login button");
        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("PayPalLogin")+"']"), "Login button");

        return button;
    }
    public IOSButton getAgreeAndContinue() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("AgreeBtn")+"']"), "Agree button");

        return button;
    }

    public IOSButton getBackBtn() throws Exception {

        IOSButton backButton = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return backButton;
    }

    public MobileLabel getPayWith() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
}


