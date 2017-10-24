package pages.OrderConfirmationPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OrderConfirmationPageAndroid extends OrderConfirmationPage {
    public OrderConfirmationPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getGotIt() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.id("got_it"), "GotIt button");
    }
}
