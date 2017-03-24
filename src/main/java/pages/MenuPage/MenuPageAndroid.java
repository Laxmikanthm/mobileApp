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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("ContactInfo")+"']"), "contact information");
        return button;
    }

    public MobileLabel getUserInfo() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("UserInfo")+"']"), "User Information");
        return label;
    }
    public AndroidButton getLogOut() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+ BaseTest.bundle.getString("LogOut")+"']"), "LogOut button");
        return button;
    }

    public AndroidButton getLogOutButtonInPopUp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+ BaseTest.bundle.getString("LogoutBtn")+"']"), "LogOut button in Popup");
        return button;
    }

    public AndroidButton getPaymentMethods() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Paymentmethods")+"']"), "Payment Methods button");
        return button;
    }

    public AndroidButton getGoHome() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.className("android.widget.ImageButton"), "Back button");
        return button;
    }

    public AndroidButton getEmailPreferences() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("EmailPref")+"']"), "EmailPreferences button");
        return button;
    }

    public AndroidButton getMobileOrderHistory() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("MobileOrderHistory")+"']"), "MobileOrderHistory button");
        return button;
    }

    public AndroidButton getHelp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Help")+"']"), "Help button");
        return button;
    }

    public AndroidButton getAbout() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("About")+"']"), "About button");
        return button;
    }

}

