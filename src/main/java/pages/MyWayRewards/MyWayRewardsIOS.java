package pages.MyWayRewards;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.ios.IOSButton;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.LoginPage.LoginPage;

/**
 * Created by E001599 on 18-05-2017.
 */
public class MyWayRewardsIOS extends MyWayRewards {

    public MyWayRewardsIOS(IOSDriver driver) {
        super(driver);
    }

    public MobileButton getGotIt() throws Exception {
        IOSButton gotItButton = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/btn_gotit"), "GotIt Button");
        return gotItButton;
    }

    public MobileButton getToolbarClose() throws Exception {
        IOSButton toolbarCloseButton = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return toolbarCloseButton;
    }
}