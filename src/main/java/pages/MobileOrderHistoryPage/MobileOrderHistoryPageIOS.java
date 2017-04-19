package pages.MobileOrderHistoryPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 19-04-2017.
 */
public class MobileOrderHistoryPageIOS extends MobileOrderHistoryPage {

    public MobileOrderHistoryPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public MobileButton getFavorite() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }

    public MobileButton getFavoriteSaveButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");

        return button;
    }
    public IOSTextBox getFavoriteOrderName() throws Exception {

        IOSTextBox userNameTextbox  = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("UserNameiOS")+"']"), "username text field");

        return userNameTextbox;
    }
    public MobileButton getBackButton() throws Exception {
        IOSButton backButton = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toggle_view"), "StoreView button");
        return backButton;
    }
}
