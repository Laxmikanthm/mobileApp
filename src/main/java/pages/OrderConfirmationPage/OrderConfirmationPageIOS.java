package pages.OrderConfirmationPage;

import base.gui.controls.mobile.generic.MobileButton;
import io.appium.java_client.AppiumDriver;

public class OrderConfirmationPageIOS  extends OrderConfirmationPage{
    public OrderConfirmationPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getGotIt() throws Exception {
        return null;
    }
}
