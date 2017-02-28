package pages.FindYourSubWayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by e002243 on 16-02-2017.
 */
public class FindYourSubWayPageAndroid extends FindYourSubWayPage {

    public FindYourSubWayPageAndroid(AndroidDriver driver){
        super(driver);
        setBys();
    }

    public AndroidButton getUserProfile() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("UserProfile")+"']"), "UserProfile button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/profile"), "UserProfile button");

        return button;
    }

    private void setBys() {

        bys = new HashMap<String, By>();
        bys.put("SearchBtnBy", By.id("com.subway.mobile.subwayapp03:id/search_mylocation_layout"));
    }

    public AndroidButton getFindYourSubWay() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");


        return button;
    }
}

