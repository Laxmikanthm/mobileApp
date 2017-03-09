package pages.SubwayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class SubwayPageIOS extends SubwayPage {

    public SubwayPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public MobileButton getAddPaymentMethod() throws Exception {

        AndroidButton addPaymentMethodButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return addPaymentMethodButton;
    }
}
