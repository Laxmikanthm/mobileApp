package pages.YourOrderPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class YourOrderPageAndroid  extends YourOrderPage{
    public YourOrderPageAndroid(AppiumDriver driver) {
        super(driver);
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
