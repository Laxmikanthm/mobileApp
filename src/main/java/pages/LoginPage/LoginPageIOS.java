package pages.LoginPage;

import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by test-user on 2/2/17.
 */
public class LoginPageIOS extends LoginPage {

    public LoginPageIOS(IOSDriver driver){
        super(driver);
    }

    public IOSTextBox getUserName() throws Exception {

        IOSTextBox menuButton = new IOSTextBox((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
    public IOSPasswordTextBox getPassword() throws Exception {

        IOSPasswordTextBox menuButton = new IOSPasswordTextBox((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
    public IOSButton getLogin() throws Exception {

        IOSButton menuButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
}
