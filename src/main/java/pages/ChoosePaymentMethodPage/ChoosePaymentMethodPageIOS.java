package pages.ChoosePaymentMethodPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class ChoosePaymentMethodPageIOS extends ChoosePaymentMethodPage{

    public ChoosePaymentMethodPageIOS(IOSDriver driver){super(driver);}

    public MobileButton getCreditCard() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }
}
