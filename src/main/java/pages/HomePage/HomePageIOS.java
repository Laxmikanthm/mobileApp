package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageIOS extends HomePage {

    public HomePageIOS(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public MobileButton getMenu() throws Exception {
        IOSButton menuPageButton = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("MenuBtnBy")), "Menu button");
        return menuPageButton;
    }

    public MobileButton getOrderButton() throws Exception {
        IOSButton orderButton = new IOSButton ((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("OrderButton") + "']"), "Order Button");
        return orderButton;
    }

    public MobileButton getFindButton() throws Exception {
        IOSButton findButton = new IOSButton ((IOSDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        return findButton;
    }

    public MobileButton getFindYourSubWay() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");
        return button;
    }
    public MobileButton getFindYourAnotherSubWay() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");
        return button;
    }
    public MobileButton getAllowLocation() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("AllowLocation")+"']"), "AllowLocation button");
        return button;
    }

    public MobileButton getStoreView() throws Exception {
        IOSButton storeViewButton = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toggle_view"), "StoreView button");
        return storeViewButton;
    }
}
