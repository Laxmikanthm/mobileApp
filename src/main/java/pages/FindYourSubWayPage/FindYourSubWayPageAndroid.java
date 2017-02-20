package pages.FindYourSubWayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class FindYourSubWayPageAndroid extends  FindYourSubWayPage {

    public FindYourSubWayPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidButton getUserProfile() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("UserProfile")+"']"), "UserProfile button");

        return button;
    }
}

