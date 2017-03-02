package pages.LandingPage;

import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by test-user on 3/1/17.
 */
public class LandingPageIOS extends LandingPage {
    public LandingPageIOS(IOSDriver driver) throws Exception{
        super(driver);
    }

    public IOSButton getLoginButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return button;
    }

    public IOSButton getRegistrationButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("RegisterButton")), "Register button");

        return button;
    }

    public IOSButton getSkipButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("SkipButton")), "Skip button");

        return button;
    }
}
