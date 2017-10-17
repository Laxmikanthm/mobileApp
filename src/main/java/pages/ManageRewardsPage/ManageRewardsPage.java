package pages.ManageRewardsPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pages.Enums.MyLoyalty;
import pages.LoginPage.LoginPage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pages.OrdersPage.OrdersPage;
import pages.YourOrderPage.YourOrderPage;
import pages.YourOrderPage.YourOrderPageAndroid;
import utils.Logz;


public abstract class ManageRewardsPage<T extends AppiumDriver> extends MobileBasePage {
    public ManageRewardsPage(AppiumDriver driver) {
        super(driver);
    }
    public static ManageRewardsPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new ManageRewardsPageIOS((IOSDriver) driver);
            case "Android":
                return new ManageRewardsPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }


    YourOrderPage yourOrderPage;

    OrdersPage ordersPage;


    public YourOrderPage assertRewardsList() throws Exception{
       /* int rewadrsAmtapi=ordersPage.rewardsValue();
        int certficateamount = Integer.parseInt(getcertificatemessage().getText());
        Assert.assertEquals(rewadrsAmtapi,certficateamount);*/


         //user MyLoyalty object for assertion
        //Get expected data from API, Get actual data from mobile ui
        return YourOrderPage.get((AppiumDriver)driver);
    }
}
