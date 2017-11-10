package pages.LoginPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
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
        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("UserName")+"']"), "username text field");
        return userNameTextbox;
    }

    public AndroidPasswordTextBox getPassword() throws Exception {
        AndroidPasswordTextBox passwordTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+BaseTest.bundle.getString("Password")+"']"), "password text field");
        return passwordTextBox;
    }
    public AndroidButton getLogin() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("btn-signin"), "Login button");
        return button;
    }
   /* public AndroidButton getLogin() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("Login")+"']"), "Login button");
        return button;
    }*/
   public MobileButton getProfile() throws Exception {
       AndroidButton menuPageButton = new AndroidButton((AndroidDriver) driver, By.id("profile"), "UserProfile icon is not ready");
       return menuPageButton;
   }
    public AndroidButton getForgotPassword() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.view.View[@content-desc='"+BaseTest.bundle.getString("Forgotpassword")+"']"), "ForgotPassword button");
        return button;
    }
}
