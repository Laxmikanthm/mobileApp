package pages.YourOrderPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class YourOrderPageIOS  extends YourOrderPage{
    public YourOrderPageIOS(AppiumDriver driver) {
        super(driver);
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
}
