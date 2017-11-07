package pages.UserProfilePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class UserProfilePageAndroid extends UserProfilePage {
    public UserProfilePageAndroid(AndroidDriver driver) {
        super(driver);
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
        return  new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("MobileOrderHistory")), "MobileOrderHistory button");
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

}
