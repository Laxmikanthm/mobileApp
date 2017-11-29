package pages.YourOrderPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YourOrderPageAndroid  extends YourOrderPage{
    public YourOrderPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    WebElement getPickupTimeHeader() throws Exception {
        return new AndroidWebElement((AndroidDriver)driver, "getPickupTimeHeader").getWebElement(   By.id( "pickup_time_header" ));
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
        return new AndroidTextBox((AndroidDriver) driver, By.id("submit_order"), "getTotalText");
    }

    public MobileLabel getTaxPrice() throws Exception{
        AndroidLabel button = new AndroidLabel((AndroidDriver) driver, By.id("tax_amount"), "Tax Price ");
        return button;
    }
    WebElement getMakeitaMeal() throws Exception {
        return new AndroidWebElement((AndroidDriver)driver, "getPickupTimeHeader").getWebElement(   By.id( "com.subway.mobile.subwayapp03:id/make_it_a_meal_header" ));
    }

    WebElement ViewfullMenu() throws Exception {
        return new AndroidWebElement((AndroidDriver)driver, "getPickupTimeHeader").getWebElement(   By.id( "com.subway.mobile.subwayapp03:id/view_full_menu_text" ));
    }

    public MobileButton getDineIn() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("dine_in_button"), "DineIn Button");
        return button;
    }

    @Override
    MobileTextBox getPickupTimeHeaderText() throws Exception {
        return new AndroidTextBox((AndroidDriver) driver, By.id("pickup_time_header"), "getTotalText");
    }

    @Override
    MobileButton getPlaceOrder() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+ BaseTest.bundle.getString("PlaceOrder")+"']"), "Place Order button");
    }



    public MobileLabel getcertificatemessage() throws Exception {
        AndroidLabel certsamount = new AndroidLabel((AndroidDriver) driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]"), "Certificate amount");
        return certsamount;
    }


}
