package pages.SubWayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class SubWayPageAndroid extends SubWayPage {

    public SubWayPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getContactInfo() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("ContactInfo")+"']"), "ContactInfo button");

        return button;
    }

    public AndroidButton getUserInfo() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("UserInfo")+"']"), "UserInformation text");

        return button;
    }




}

