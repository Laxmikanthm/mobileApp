package pages.LoginPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class LoginPageAndroid extends LoginPage {

    public LoginPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidTextBox getUserName() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("UserName")+"']"), "username text field");

        return userNameTextbox;
    }

    public AndroidPasswordTextBox getPassword() throws Exception {

        AndroidPasswordTextBox passwordTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Password")+"']"), "password text field");

        return passwordTextBox;
    }

    public AndroidButton getLogin() throws Exception {

        //AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@content-des='"+BaseTest.bundle.getString("Login")+"']"), "Login button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("SignInButton")+"']"), "Login button");

        return button;
    }

    public AndroidButton getForgotPassword() throws Exception {

        //AndroidButton forgotPasswordButton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("ForgotPassword")+"']"), "Forgot password button");
       // AndroidButton forgotPasswordButton = new AndroidButton((AndroidDriver) driver, By.id("custom-forgotPassword"), "Forgot password button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@content-desc='Forgot password?']"), "Forgot password button");

        return button;
    }
}
