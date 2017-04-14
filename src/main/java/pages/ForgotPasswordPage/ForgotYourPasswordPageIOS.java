package pages.ForgotPasswordPage;



import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;


/**
 * Created by E003705 on 28-02-2017.
 */
public class ForgotYourPasswordPageIOS extends ForgotYourPasswordPage {
    public ForgotYourPasswordPageIOS(AppiumDriver driver) {
        super(driver);
    }

    public IOSTextBox getEmailAddress() throws Exception {

        IOSTextBox emailText = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("Email") + "']"), "Email text field");

        return emailText;
    }
    public IOSButton getNextButton() throws Exception {

        IOSButton nextbutton = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='" + BaseTest.bundle.getString("NextButton") + "']"), "Next button");

        return nextbutton;
    }
    public IOSButton getResetButton() throws Exception {

        IOSButton resetButton = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='" + BaseTest.bundle.getString("ResetPassword") + "']"), "Reset Password button");

        return resetButton;
    }
    public IOSPasswordTextBox getPassword() throws Exception {

        IOSPasswordTextBox passwordText = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("NewPassword") + "']"), "Password text field");

        return passwordText;
    }

    public IOSPasswordTextBox getConfirmPassword() throws Exception {

        IOSPasswordTextBox conText = new IOSPasswordTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("ConfirmPassword") + "']"), "Confirm Password text field");

        return conText;
    }
    public IOSButton getSetPassword() throws Exception {

        IOSButton setButton = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='" + BaseTest.bundle.getString("SetPassword") + "']"), "Set Password button");

        return setButton;
    }
    public IOSButton getLoginAgainPopUp() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LoginAgainOkButton") + "']"), "Login Again Pop Up");

        return button;
    }

}


