package pages.YourOrderPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class YourOrderPageAndroid  extends YourOrderPage{
    public YourOrderPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getPlaceOrder() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+ BaseTest.bundle.getString("PlaceOrder")+"']"), "Place Order button");
    }
}
