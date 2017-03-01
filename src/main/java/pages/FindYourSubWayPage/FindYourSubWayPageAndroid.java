package pages.FindYourSubWayPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class FindYourSubWayPageAndroid extends FindYourSubWayPage {

    public FindYourSubWayPageAndroid(AndroidDriver driver){
        super(driver);
    }

    public MobileButton getSearchButton() throws Exception {
            AndroidButton searchButton = new AndroidButton((AndroidDriver) driver, By.xpath("SearchBtnBy"), "Search button");
        return searchButton;
    }

    public MobileButton getSelectRestButton() throws Exception {
        AndroidButton selectRestButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SelectRestButton") + "']"), "Select Restaurant button");
        return selectRestButton;
    }
}

