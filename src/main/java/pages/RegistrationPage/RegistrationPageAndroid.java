package pages.RegistrationPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/9/17.
 */
public class RegistrationPageAndroid extends RegistrationPage {
    public RegistrationPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    public AndroidTextBox getFirstName() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("FirstName")+"']"), "FirstName text field");

        return userNameTextbox;
    }
    public AndroidTextBox getLastName() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("LastName")+"']"), "LastName text field");

        return userNameTextbox;
    }
    public AndroidTextBox getPhone() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("Phone")+"']"), "Phone number field");

        return userNameTextbox;
    }
    public AndroidButton getNextButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("NextButton")+"']"), "Next button");

        return button;
    }
    public AndroidTextBox getEmail() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("Email")+"']"), "Email text field");

        return userNameTextbox;
    }

    public AndroidPasswordTextBox getPassword() throws Exception {

        AndroidPasswordTextBox passwordTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+ BaseTest.bundle.getString("NewPassword")+"']"), "password text field");

        return passwordTextBox;
    }
    public AndroidPasswordTextBox getConfirmPasswrod() throws Exception {

        AndroidPasswordTextBox passwordTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("ConfirmPassword")+"']"), "Confirm password text field");

        return passwordTextBox;
    }
    public AndroidButton getSignUpButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("GetStarted")+"']"), "Get Started button");

        return button;
    }
    public AndroidButton getCheckboxOffers() throws Exception{
        AndroidButton button =new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("OffersCheckbox")), "Offers checkbx");

        return button;
    }
    }

