package pages.ManageRewardsPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ManageRewardsPageAndroid  extends ManageRewardsPage{
    public ManageRewardsPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }
    public MobileLabel getmyrewardspageamt() throws Exception {
        AndroidLabel rewardcertificateamount = new AndroidLabel((AndroidDriver) driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.TextView[1]"), "Rewards amount");
        return rewardcertificateamount;
    }

    public MobileButton getApplyButton() throws Exception {
        AndroidButton ApplyButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/apply"), "Apply Button");
        return ApplyButton;
    }


    public MobileButton getRemoveButton() throws Exception {
        AndroidButton removeButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/remove"),"RemoveButton)");
        return removeButton;
    }
    public MobileButton getDoneButton  () throws Exception {
        AndroidButton doneButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/done"),"Done Button");
        return doneButton;
    }
    public MobileLabel getcertificatemessage() throws Exception {
        AndroidLabel certsamount = new AndroidLabel((AndroidDriver) driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]"), "Certificate amount");
        return certsamount;
    }
    public MobileButton getManageButton  () throws Exception {
        AndroidButton doneButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/done"),"Manage Button");
        return doneButton;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
