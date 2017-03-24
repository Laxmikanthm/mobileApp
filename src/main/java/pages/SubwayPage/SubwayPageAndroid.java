package pages.SubwayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class SubwayPageAndroid extends SubwayPage {

    public SubwayPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }

    public AndroidButton getAddPaymentMethod() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("AddPaymet") + "']"), "AddPaymentMethod Button");
        return button;
    }
}


