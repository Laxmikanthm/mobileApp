package pages.UserProfilePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class UserProfileAndroid extends  UserProfile{
    public UserProfileAndroid(AppiumDriver driver) {
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
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

}
