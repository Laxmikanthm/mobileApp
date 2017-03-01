package pages.MenuPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.MobileTextView;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class MenuPageAndroid extends MenuPage {

    MobileButton logOutButton;
    public MenuPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getContactInfo() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("ContactInfo")+"']"), "ContactInfo button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("ContactInfo")+"']"), "contact information");
        return button;
    }

    public MobileLabel getUserInfo() throws Exception {

        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.id("com.subway.mobile.subwayapp03:id/user_name"), "UserProfile button");
        return label;
    }
    public AndroidButton getLogOut() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public AndroidButton getLogOutButtonInPopUp() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }

    public AndroidButton getPaymentMethods() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }




}

