package pages.MyWayRewards;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


/**
 * Created by E001599 on 18-05-2017.
 */
public class MyWayRewardsAndroid extends MyWayRewards {

    public MyWayRewardsAndroid(AndroidDriver driver) {
        super(driver);
    }

    public MobileButton getGotIt() throws Exception {
        AndroidButton gotItButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/btn_gotit"), "GotIt Button");
        return gotItButton;
    }

    public MobileButton getToolbarClose() throws Exception {
        AndroidButton toolbarCloseButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return toolbarCloseButton;
    }
}
