package pages.OrderConfirmationPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPageIOS  extends OrderConfirmationPage{
    public OrderConfirmationPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getGotIt() throws Exception {
        return null;
    }
    @Override
    WebElement getPickupTimeHeader() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getItemTitle() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getItemPrice() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getTotalText() throws Exception {
        return null;
    }
}
