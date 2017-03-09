package pages.PayPalPage;

import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by e002243 on 08-03-2017.
 */
public class PayPalPageIOS extends  PayPalPage{

    public PayPalPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public IOSTextBox getPaypalUserName() throws Exception {

        IOSTextBox menuButton = new IOSTextBox((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }

    public IOSPasswordTextBox getPaypalPassword() throws Exception {

        IOSPasswordTextBox menuButton = new IOSPasswordTextBox((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }

    public IOSButton getLogIn() throws Exception {

        IOSButton menuButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }
    public IOSButton getAgreeAndContinue() throws Exception {

        IOSButton menuButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("LoginButton")), "Login button");

        return menuButton;
    }


}
