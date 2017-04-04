package pages.HomePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageAndroid extends HomePage {


    public HomePageAndroid(AndroidDriver driver) throws Exception {
        super(driver);
    }
    public MobileButton getMenu() throws Exception {
        AndroidButton menuPageButton = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("UserProfile")), "UserProfile field");
        return menuPageButton;
    }

    public MobileButton getOrderButton() throws Exception {
        AndroidButton orderButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("OrderButton") + "']"), "Order Button");
        return orderButton;
    }

    public MobileButton getFindButton() throws Exception {
        AndroidButton findButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        return findButton;
    }

    public MobileButton getBackButton() throws Exception {
        AndroidButton backButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        return backButton;
    }

    public MobileButton getFindYourSubWay() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");
        return button;
    }

    public MobileButton getFindSubWayNearYou() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("FindNearbySubway")+"']"), "FindASubwayNearYou button");
        return button;
    }

    public MobileButton getAllowLocation() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("AllowLocation")+"']"), "AllowLocation button");
        return button;
    }
    public MobileButton getStoreView() throws Exception {
        AndroidButton storeViewButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toggle_view"), "StoreView button");
        return storeViewButton;
    }

}
