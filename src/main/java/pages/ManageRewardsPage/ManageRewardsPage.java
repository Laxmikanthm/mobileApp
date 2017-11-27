package pages.ManageRewardsPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.OrdersPage.OrdersPage;
import pages.YourOrderPage.YourOrderPage;
import org.testng.Assert;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;
import util.Utils;
import utils.Logz;

import java.util.List;


public abstract class ManageRewardsPage<T extends AppiumDriver> extends MobileBasePage {
    public ManageRewardsPage(AppiumDriver driver) {
        super(driver);
    }

    public static ManageRewardsPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new ManageRewardsPageIOS((IOSDriver) driver);
            case "Android":
                return new ManageRewardsPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    abstract MobileLabel getRewardsCount() throws Exception;
    abstract MobileLabel getcertificatemessage() throws Exception;
    abstract MobileButton getRemoveButton() throws Exception;
    abstract MobileButton getDoneButton() throws Exception;
    public int Rewards = 0;
    abstract List<WebElement> getRewardsList() throws Exception;


    YourOrderPage yourOrderPage;

    OrdersPage ordersPage;
    RemoteOrderCustomer user;


    public YourOrderPage assertRewardsList(int certRedeemCount) throws Exception {
        getActualExpectedRewardsDetails(certRedeemCount);
        clickOnDone();
        /*int rewadrsAmtapi = ordersPage.rewardsValue();
        int certficateamount = Integer.parseInt(getcertificatemessage().getText());
        Assert.assertEquals(rewadrsAmtapi, certficateamount);*/
        //user MyLoyalty object for assertion
        //Get expected data from API, Get actual data from mobile ui
        return YourOrderPage.get((AppiumDriver) driver);
    }

    private pojos.MyLoyalty getActualExpectedRewardsDetails(int certRedeemCount) throws Exception {
        pojos.MyLoyalty actualAndExpectedRewards = new pojos.MyLoyalty();
        Logz.step("Started asserting certificates in Manage Rewards page");
        List<WebElement> rewardsCount = getRewardsList();
        int RewardsCount = rewardsCount.size()*2;
        if(certRedeemCount > 0) {
            for (int i = 0; i < rewardsCount.size()-certRedeemCount; i++) {
                rewardsCount.get(i).click();
            }
        }
        if (RewardsCount > 0) {
            int RewardsCertcount = Utils.rewardsValue(ordersPage.getRewardsTxt());
            Assert.assertEquals(user.getLoyaltyLookup().getCertificates().getCertificateCount(), RewardsCertcount);
            Logz.step("Certificates/Rewards asserted in Manage Rewards page");
        } else {
            Logz.step("Certificates not available in Manage Rewards page");
        }

        return actualAndExpectedRewards;
    }

    public YourOrderPage clickOnDone() throws Exception{
        Logz.step("Click on Done button in Manage Rewards page");
        getDoneButton().click();
        Logz.step("Click on Done button in Manage Rewards page");
        return YourOrderPage.get((AppiumDriver)driver);
    }

    public YourOrderPage clickOnRemove() throws Exception{
        Logz.step("Click on Remove button in Manage Rewards page");
        getRemoveButton().click();
        Logz.step("Click on Remove button in Manage Rewards page");
        return YourOrderPage.get((AppiumDriver)driver);
    }
}
