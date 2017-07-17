package pages.RegistrationPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

        IOSTextBox firstNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+ BaseTest.bundle.getString("FirstNameiOS") + "']"), "FirstName text field");

        return firstNameTextbox;
    }

    public IOSTextBox getLastName() throws Exception {

        IOSTextBox lastNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("LastNameiOS") + "']"), "LastName text field");

        return lastNameTextbox;
    }

    public IOSTextBox getPhone() throws Exception {

        IOSTextBox phoneTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("PhoneiOS") + "']"), "Phone number field");

        return phoneTextbox;
    }

    public IOSButton getNextButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAButton[@label='" + BaseTest.bundle.getString("NextButton") + "']"), "Next button");

        return button;
    }

    public IOSTextBox getEmail() throws Exception {

        IOSTextBox userNameTextbox = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("EmailiOS") + "']"), "Email text field");

        return userNameTextbox;
    }

    public IOSPasswordTextBox getPassword() throws Exception {

        IOSPasswordTextBox passwordTextBox = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("NewPasswordiOS") + "']"), "password text field");

        return passwordTextBox;
    }

    public IOSPasswordTextBox getConfirmPasswrod() throws Exception {

        IOSPasswordTextBox passwordTextBox = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("ConfirmPasswordiOS") + "']"), "Confirm password text field");

        return passwordTextBox;
    }

    public IOSButton getSignUpButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAButton[@label='" + BaseTest.bundle.getString("GetStarted") + "']"), "Get Started button");

        return button;
    }
    public IOSButton getCheckboxOffers() throws Exception{
        IOSButton button =new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("OffersCheckbox")), "Offers checkbx");

        return button;
    }

}
