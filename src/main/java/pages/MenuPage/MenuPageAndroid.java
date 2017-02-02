package pages.MenuPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by test-user on 2/2/17.
 */
public class MenuPageAndroid extends MenuPage {
    public MenuPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getLoginButton() throws Exception {

        AndroidButton menuButton = new AndroidButton((AndroidDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
}
