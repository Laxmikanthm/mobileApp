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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("LogOut")), "LogOut button");
        return button;
    }

    public AndroidButton getLogOutButtonInPopUp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("LogoutBtn")), "LogoutBtn in PopUp");
        return button;
    }

    public AndroidButton getPaymentMethods() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("PaymentMethods")), "Payment methods button");
        return button;
    }

    public AndroidButton getGoHome() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.className("android.widget.ImageButton"), "Back button");
        return button;
    }

    public AndroidButton getEmailPreferences() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("EmailPref")), "Email Preferences button");
        return button;
    }

    public AndroidButton getMobileOrderHistory() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("LogoutBtn")), "Email Preferences button");
        return button;
    }

    public AndroidButton getHelp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.RelativeLayout[@resource-id='"+BaseTest.bundle.getString("Help")+"']"), "Help button");
        return button;
    }

    public AndroidButton getAbout() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.RelativeLayout[@resource-id='"+BaseTest.bundle.getString("About")+"']"), "About button");
        return button;
    }
    public AndroidButton getEmail() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("UpdateEmailPrefernce")), "UpdateEmailPrefernce button");
        return button;
    }
    public AndroidButton getPrivacyPolicy() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("PrivacyPolicy")+"']"), "PrivacyPolicy");
        return button;
    }
    public AndroidButton getPrivacyPolicyShare() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("PrivacyPolicyShare")+"']"), "PrivacyPolicyShare");
        return button;
    }
    public AndroidButton getTermsandConditions() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TermandConditions")+"']"), "TermandConditions");
        return button;
    }

    public MobileLabel getPrivacyStatement() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.xpath("//android.view.View[@content-desc='"+BaseTest.bundle.getString("PrivacyStatement")+"']"), "PrivacyStatement");
        return label;
    }
}

