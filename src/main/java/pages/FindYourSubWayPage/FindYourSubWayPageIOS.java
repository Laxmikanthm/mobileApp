package pages.FindYourSubWayPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 16-02-2017.
 */
public class FindYourSubWayPageIOS extends  FindYourSubWayPage {


    public FindYourSubWayPageIOS(IOSDriver driver){
        super(driver);
    }
    public MobileButton getSearchButton() throws Exception {
        IOSButton searchButton = new IOSButton((IOSDriver) driver, By.xpath("SearchBtnBy"), "Search button");
        return searchButton;
    }

    public MobileButton getSelectRestButton() throws Exception {
        IOSButton selectRestButton = new IOSButton ((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SelectRestButton") + "']"), "Select Restaurant button");
        return selectRestButton;
    }
    public MobileButton getFindSubwayButton() throws Exception {
        IOSButton selectRestButton = new IOSButton ((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SelectRestButton") + "']"), "Select Restaurant button");
        return selectRestButton;
    }
}