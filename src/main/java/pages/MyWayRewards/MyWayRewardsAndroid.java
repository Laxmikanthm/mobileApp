package pages.MyWayRewards;
import base.gui.controls.browser.Generic;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by E001599 on 18-05-2017.
 */
public class MyWayRewardsAndroid extends MyWayRewards {

    public MyWayRewardsAndroid(AndroidDriver driver) {
        super(driver);
    }

    public MobileButton getGotIt() throws Exception {
        AndroidButton gotItButton = new AndroidButton((AndroidDriver) driver, By.id("btn_gotit"), "GotIt Button");
        return gotItButton;
    }

    public MobileButton getToolbarClose() throws Exception {
        AndroidButton toolbarCloseButton = new AndroidButton((AndroidDriver) driver, By.id("toolbar_close"), "ToolBar Close Button");
        return toolbarCloseButton;
    }

    public MobileLabel gettokensmyreward() throws Exception {
        AndroidLabel tokenscount = new AndroidLabel((AndroidDriver) driver, By.id("rewards_token_count_text"), "Token count");
        return tokenscount;
    }

    public MobileLabel getCertsmyreward() throws Exception {
        AndroidLabel Certscount = new AndroidLabel((AndroidDriver) driver, By.id("rewards_count"), "Certs Count");
        return Certscount;
    }

    List<WebElement> getRewardsList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "Rewards List").getWebElements(By.id("rewards_item_layout"));
    }

    List<WebElement> getRewardsDetails(WebElement rewards) throws Exception {
        return rewards.findElements(By.xpath("//android.widget.TextView"));
    }

}
