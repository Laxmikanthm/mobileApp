package pages.FindYourSubWayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class FindYourSubWayPageIOS extends  FindYourSubWayPage {


    public FindYourSubWayPageIOS(IOSDriver driver){
        super(driver);
    }
    public IOSButton getUserProfile() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public IOSButton getFindYourSubWay() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");


        return button;
    }
}