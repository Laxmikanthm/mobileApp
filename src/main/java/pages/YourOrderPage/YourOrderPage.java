package pages.YourOrderPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageIOS;
import pages.ManageRewardsPage.ManageRewardsPage;
import pages.OrderConfirmationPage.OrderConfirmationPage;

public abstract class YourOrderPage<T extends AppiumDriver> extends MobileBasePage {
    public YourOrderPage(AppiumDriver driver) {
        super(driver);
    }
    public static YourOrderPage get(AppiumDriver driver) throws Exception {
        String platform = SubwayAppBaseTest.platformName;
        switch (platform) {
            case "iOS":
                return new YourOrderPageIOS((IOSDriver) driver);
            case "Android":
                return new YourOrderPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    abstract MobileButton getPlaceOrder() throws Exception;



    public OrderConfirmationPage assertLoyaltyDisplay() throws Exception{
        //user MyLoyalty object for assertion
        //Get expected data from API, Get actual data from mobile ui
        getPlaceOrder().click();
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public OrderConfirmationPage assertOrderSummaryInYourOrderPage() throws Exception{
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public OrderConfirmationPage assertTotalAmountInYourOrderPage() throws Exception{
        getPlaceOrder().click();
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public ManageRewardsPage goToManageRewardPage() throws Exception{

        return ManageRewardsPage.get((AppiumDriver)driver);
    }
}
