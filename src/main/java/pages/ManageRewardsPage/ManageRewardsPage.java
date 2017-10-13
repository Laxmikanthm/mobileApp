package pages.ManageRewardsPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.LoginPage.LoginPage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pages.YourOrderPage.YourOrderPage;

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
    public YourOrderPage assertRewardsList() throws Exception{
//user MyLoyalty object for assertion
        //Get expected data from API, Get actual data from mobile ui
        return YourOrderPage.get((AppiumDriver)driver);
    }
}