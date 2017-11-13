package pages.YourOrderPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.HomePage.HomePage;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageIOS;
import pages.ManageRewardsPage.ManageRewardsPage;
import pages.OrderConfirmationPage.OrderConfirmationPage;
import pages.OrdersPage.OrdersPage;
import pojos.CustomizedItem.CustomizedItem;
import util.MobileApi;
import util.Utils;
import utils.Logz;

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
  abstract WebElement getPickupTimeHeader() throws Exception;
    abstract MobileTextBox getItemTitle() throws Exception;
    abstract MobileTextBox getItemPrice() throws Exception;
    abstract MobileTextBox getTotalText() throws Exception;


    CommonElements commonElements = new CommonElements((AppiumDriver) driver);
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    abstract MobileButton getPlaceOrder() throws Exception;
    abstract MobileLabel getcertificatemessage() throws Exception;


    public OrderConfirmationPage assertLoyaltyDisplay() throws Exception{

        try {

           /* int rewardsamtpresence= driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).size();
            if(rewardsamtpresence>0) {
                int rewadrsAmtapi = ordersPage.rewardsValue();
                int rewardsAmtui = Integer.parseInt(getcertificatemessage().getText());
                Logz.step(getcertificatemessage().getText());
                Assert.assertEquals(rewadrsAmtapi, rewardsAmtui);
                Logz.step("Loyalty display asserted");
            }
            else{Logz.step("rewards not available");}
            //user MyLoyalty object for assertion
            //Get expected data from API, Get actual data from mobile ui
            getPlaceOrder().click();*/
            return OrderConfirmationPage.get((AppiumDriver) driver);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }

    }
    public OrderConfirmationPage assertOrderSummaryInYourOrderPage() throws Exception{
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public YourOrderPage assertOrderDetailsInYourOrderPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Your Order Page");
        commonElements.scroll( getPickupTimeHeader(), "up" );
        Assert.assertEquals( getItemTitle().getText(), customizedItem.getCustomizedProductDetail().getProductName() );
        Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
       // Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("Started asserting order details In Your Order Page");
        return YourOrderPage.get((AppiumDriver)driver);
    }
    public OrderConfirmationPage goToOrderConfirmationPage() throws Exception{
        Logz.step("Navigating to Order Confirmation Page......");
        getPlaceOrder().click();
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public ManageRewardsPage goToManageRewardPage() throws Exception{

        return ManageRewardsPage.get((AppiumDriver)driver);
    }
}
