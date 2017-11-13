package pages.LoginPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class LoginPageIOS extends LoginPage {

    public LoginPageIOS(IOSDriver driver) {
        super(driver);
    }

    public IOSTextBox getUserName() throws Exception {

        IOSTextBox userNameTextbox  = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("UserNameiOS")+"']"), "username text field");

        return userNameTextbox;
    }

    public IOSPasswordTextBox getPassword() throws Exception {

        IOSPasswordTextBox passwordTextBox = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("PasswordiOS")+"']"), "password text field");

        return passwordTextBox;
    }

    public IOSButton getLogin() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    @Override
    MobileButton getSignUp() throws Exception {
        return null;
    }

    public IOSButton getForgotPassword() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAButton[@label='"+BaseTest.bundle.getString("ForgotPasswordiOS")), "Forgot Password button");

        return Button;
    }

    @Override
    MobileButton getProfile() throws Exception {
        return null;
    }
}
