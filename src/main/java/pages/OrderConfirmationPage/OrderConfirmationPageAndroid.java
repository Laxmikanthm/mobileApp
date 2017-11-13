package pages.OrderConfirmationPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPageAndroid extends OrderConfirmationPage {
    public OrderConfirmationPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getGotIt() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.id("got_it"), "GotIt button");
    }
    @Override
    WebElement getPickupTimeHeader() throws Exception {
        return new AndroidWebElement((AndroidDriver)driver, "getPickupTimeHeader").getWebElement(   By.id( "ready_today_at" ));
    }

    @Override
    MobileTextBox getItemTitle() throws Exception {
        return new AndroidTextBox((AndroidDriver) driver, By.id("item_title"), "getItemTitle");
    }

    @Override
    MobileTextBox getItemPrice() throws Exception {
        return new AndroidTextBox((AndroidDriver) driver, By.id("item_price"), "getItemPrice");
    }

    @Override
    MobileTextBox getTotalText() throws Exception {
        return new AndroidTextBox((AndroidDriver) driver, By.id("total"), "getTotalText");
    }
}
