package pages.RegistrationPage;

import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/9/17.
 */
public class RegistrationPageIOS extends RegistrationPage {
    public RegistrationPageIOS(AppiumDriver driver) {
        super(driver);
    }
    public IOSTextBox getFirstName() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("FirstName")+"']"), "FirstName text field");

        return userNameTextbox;
    }
    public IOSTextBox getLastName() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("LastName")+"']"), "LastName text field");

        return userNameTextbox;
    }
    public IOSTextBox getPhone() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Phone")+"']"), "Phone number field");

        return userNameTextbox;
    }
    public IOSButton getNextButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+BaseTest.bundle.getString("NextButton")+"']"), "Next button");

        return button;
    }
    public IOSTextBox getEmail() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Email")+"']"), "Email text field");

        return userNameTextbox;
    }

    public IOSPasswordTextBox getPassword() throws Exception {

        IOSPasswordTextBox passwordTextBox = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("NewPassword")+"']"), "password text field");

        return passwordTextBox;
    }
    public IOSPasswordTextBox getConfirmPasswrod() throws Exception {

        IOSPasswordTextBox passwordTextBox = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("ConfirmPassword")+"']"), "Confirm password text field");

        return passwordTextBox;
    }
    public IOSButton getSignUpButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+BaseTest.bundle.getString("GetStarted")+"']"), "Get Started button");

        return button;
    }
}
