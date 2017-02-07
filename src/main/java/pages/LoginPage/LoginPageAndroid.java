package pages.LoginPage;

import base.gui.controls.mobile.android.AndroidButton;
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

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath(BaseTest.bundle.getString("LoginButton")), "Login button");

        return userNameTextbox;
    }

    public AndroidTextBox getPassword() throws Exception {

        AndroidTextBox passwordTextBox = new AndroidTextBox((AndroidDriver) driver, By.xpath(BaseTest.bundle.getString("LoginButton")), "Login button");

        return passwordTextBox;
    }

    public AndroidButton getLogin() throws Exception {

        AndroidButton menuButton = new AndroidButton((AndroidDriver) driver, By.xpath(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
}
