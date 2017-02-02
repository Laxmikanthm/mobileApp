package pages.MenuPage;

import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by test-user on 2/2/17.
 */
public class MenuPageIOS extends MenuPage {
    public MenuPageIOS(IOSDriver driver){
        super(driver);
    }

    public IOSButton getLoginButton() throws Exception {

        IOSButton menuButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
}
