package pages.YourOrderPage;

import base.gui.controls.mobile.generic.MobileButton;
import io.appium.java_client.AppiumDriver;

public class YourOrderPageIOS  extends YourOrderPage{
    public YourOrderPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getPlaceOrder() throws Exception {
        return null;
    }
}
