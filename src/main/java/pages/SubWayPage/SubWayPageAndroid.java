package pages.SubWayPage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class SubWayPageAndroid extends SubWayPage {

    MobileButton logOutButton;
    public SubWayPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getContactInfo() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("ContactInfo")+"']"), "ContactInfo button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("ContactInfo")+"']"), "contact information");
        return button;
    }

    public AndroidButton getUserInfo() throws Exception {

        //AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("UserInfo")+"']"), "UserInformation text");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/user_name"), "UserProfile button");
        return button;
    }
    public AndroidButton getLogOut() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public AndroidButton getLogOutButtonInPopUp() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return button;
    }



}

