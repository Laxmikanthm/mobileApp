package pages.YourOrderPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YourOrderPageIOS  extends YourOrderPage{
    public YourOrderPageIOS(AppiumDriver driver) {
        super(driver);
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

    @Override
    MobileTextBox getPickupTimeHeaderText() throws Exception {
        return null;
    }

    @Override
    MobileButton getPlaceOrder() throws Exception {
        return null;
    }


    public MobileLabel getcertificatemessage() throws Exception {
        IOSButton tokenscount = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return null;
    }
    public MobileLabel randommethod() throws Exception {
        IOSButton tokenscount = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return null;
    }

    public MobileButton getManage() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("android:id/button1"), "Remove Favourites ");
        return button;
    }

    public MobileLabel getRewardsAmt() throws Exception{
        IOSLabel label = new IOSLabel((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/subtotal"), "Remove Favourites ");
        return label;
    }

}
