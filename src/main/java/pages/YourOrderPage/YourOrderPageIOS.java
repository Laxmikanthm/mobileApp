package pages.YourOrderPage;

import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

     MobileLabel getTaxPrice() throws Exception{
        return  null;
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
    public WebElement getMakeitaMeal() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return null;
    }

    public WebElement ViewfullMenu() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return null;
    }

    @Override
    MobileButton getDineIn() throws Exception {
        return null;
    }

}
