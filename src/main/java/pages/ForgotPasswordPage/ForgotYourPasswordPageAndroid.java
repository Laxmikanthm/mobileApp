package pages.ForgotPasswordPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;

/**
 * Created by E003705 on 28-02-2017.
 */
public class ForgotYourPasswordPageAndroid extends ForgotYourPasswordPage {
    public ForgotYourPasswordPageAndroid(AndroidDriver driver){
        super(driver);
    }


    public AndroidTextBox getEmailAddress() throws Exception {
        AndroidTextBox emailTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+ BaseTest.bundle.getString("Email")+"']"), "Email text field");
        return emailTextbox;
    }

    public AndroidButton getNextButton() throws Exception {
        AndroidButton nextButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("NextButton")+"']"), "Next button");
        return nextButton;
    }

    public AndroidButton getResetButton() throws Exception {
        AndroidButton resetButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("ResetPassword")+"']"), "Reset Password button");
        return resetButton;
    }

    public AndroidPasswordTextBox getPassword() throws Exception{
        AndroidPasswordTextBox passwordField = new AndroidPasswordTextBox((AndroidDriver)driver, By.xpath("//android.widget.EditText[@resource-id='"+ BaseTest.bundle.getString("NewPassword")+"']"), "Password text field");
        return passwordField;
    }

    public AndroidPasswordTextBox getConfirmPassword() throws Exception{
        AndroidPasswordTextBox conPasswordField = new AndroidPasswordTextBox((AndroidDriver)driver, By.xpath("//android.widget.EditText[@resource-id='"+ BaseTest.bundle.getString("ConfirmPassword")+"']"), "Confirm Password text field");
        return conPasswordField;
    }

    public AndroidButton getLoginAgainPopUp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LoginAgainOkButton") + "']"), "Login Again Pop Up");
        return button;
    }
    public AndroidButton getSetPassword() throws Exception {
        AndroidButton setButton = new AndroidButton((AndroidDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("SetPassword")), "Set Password button");
        return setButton;
    }
}
