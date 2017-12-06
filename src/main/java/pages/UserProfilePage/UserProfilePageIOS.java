package pages.UserProfilePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class UserProfilePageIOS extends UserProfilePage {

    public UserProfilePageIOS(IOSDriver driver){
        super(driver);
    }

    public IOSButton getContactInfo() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileLabel getUserInfo() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileButton getLogOut() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("LogOutIOSBtn")), "");

        return button;
    }

    public MobileButton getLogOutButtonInPopUp() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("LogOutPopupBtn")), "");

        return button;
    }

    public MobileButton getPaymentMethods() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }

    public MobileButton getGoHome() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public MobileButton getEmailPreferences() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public MobileButton getMobileOrderHistory() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public MobileButton getHelp() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.getStringfromBundleFile("HelpIOS")), "");

        return button;
    }

    public MobileButton getAbout() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }
    public MobileButton getEmail() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }
    public MobileButton getPrivacyPolicy() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public MobileButton getPrivacyPolicyShare() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }
    public MobileButton getTermsandConditions() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }
    public MobileLabel getPrivacyStatement() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
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
        return null;
    }

    @Override
    MobileButton getFullName() throws Exception {
        return null;
    }

    @Override
    MobileButton getInitials() throws Exception {
        return null;
    }

    @Override
    MobileButton getPurchaseHistory() throws Exception {
        return new IOSButton((IOSDriver) driver, By.id(BaseTest.getStringfromBundleFile("PurchaseHistory")), "PurchaseHistory button");
    }

}
