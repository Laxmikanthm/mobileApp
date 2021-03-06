package pages.UserProfilePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class UserProfilePageAndroid extends UserProfilePage {

    MobileButton logOutButton;
    public UserProfilePageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getContactInfo() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("ContactInfo")+"']"), "contact information");
        return button;
    }


   /* public MobileLabel getOrderNumber() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("UserInfo")+"']"), "User Information");
        return label;
    }
*/
    public MobileLabel getUserInfo() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("UserInfo")+"']"), "User Information");
        return label;
    }
    public AndroidButton getLogOut() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("logout"), "LogOut button");
        return button;
    }

    public AndroidButton getLogOutButtonInPopUp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("button1"), "LogoutBtn in PopUp");
        return button;
    }


    public AndroidButton getPaymentMethods() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("PaymentMethods")+"']"), "Payment methods button");
        return button;
    }


    public AndroidButton getGoHome() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("x_icon"), "Back button");        return button;
    }

    public AndroidButton getEmailPreferences() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("communication_prefs"), "Email Preferences button");
        return button;
    }

    public AndroidButton getMobileOrderHistory() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("order_history"), "MobileOrderHistory button");
        return button;
    }

    public AndroidButton getHelp() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.RelativeLayout[@resource-id='"+BaseTest.bundle.getString("Help")+"']"), "Help button");
        return button;
    }

    public AndroidButton getAbout() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("about"), "About button");
        return button;
    }
    public AndroidButton getEmail() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("emailSwitch"), "UpdateEmailPrefernce button");
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
    public By getGeneralTab() throws Exception {
        By general= By.xpath("//android.view.View [@content-desc='"+BaseTest.bundle.getString("general")+"']");
        return general;
    }
    public By getAccountTab() throws Exception {
        By general= By.xpath("//android.view.View [@content-desc='"+BaseTest.bundle.getString("myAccount")+"']");
        return general;
    }
    public By getMenuTab() throws Exception {
        By general= By.xpath("//android.view.View [@content-desc='"+BaseTest.bundle.getString("menu")+"']");
        return general;
    }
    public By getPaymentTab() throws Exception {
        By general= By.xpath("//android.view.View [@content-desc='"+BaseTest.bundle.getString("payment")+"']");
        return general;
    }

    @Override
    MobileButton getEmailAddress() throws Exception {
        return new AndroidButton((AndroidDriver) driver,By.id("user_email"), "Email address");
    }

    @Override
    MobileButton getFullName() throws Exception {
        return new AndroidButton((AndroidDriver) driver,By.id("user_name"), "getFirstName");
    }


    @Override
    MobileButton getInitials() throws Exception {
        return new AndroidButton((AndroidDriver) driver,By.id("user_initials"), "getInitials");
    }

    @Override
    AndroidButton getPurchaseHistory() throws Exception {
        return  new AndroidButton((AndroidDriver) driver, By.id("order_history"), "MobileOrderHistory button");
    }


}

