package pages.PaymentMethodsPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class PaymentMethodsPageIOS extends PaymentMethodsPage {

    public PaymentMethodsPageIOS(IOSDriver driver) { super(driver); }

    public MobileButton getAddPaymentMethod() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }

    public MobileLabel getCardType() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
}
