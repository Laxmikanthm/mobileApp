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
import pages.MyWayRewards.MyWayRewards;
import pages.OrderConfirmationPage.OrderConfirmationPage;
import pages.OrdersPage.OrdersPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
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
    abstract MobileTextBox getPickupTimeHeaderText() throws Exception;
    abstract MobileLabel getRewardsAmt() throws Exception;
    abstract MobileButton getManage() throws Exception;
    abstract MobileTextBox getItemName() throws Exception;
    abstract MobileTextBox getItemCost() throws Exception;


    CommonElements commonElements = new CommonElements((AppiumDriver) driver);
    By ManageLocator = By.id( "manage_rewards" );
    public int Rewards = 0;
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    abstract MobileButton getPlaceOrder() throws Exception;
    abstract MobileLabel getcertificatemessage() throws Exception;

    ManageRewardsPage manageRewardsPage;
    RemoteOrderCustomer user;


    public OrderConfirmationPage assertLoyaltyDisplay(int certRedeemCount) throws Exception {
        Logz.step("Verification of Rewards in Your Order page has started");
        assertRewardsDetailsInYourOrderPage();
        goToManageRewardPage();
        manageRewardsPage.assertRewardsList(certRedeemCount);
        goToOrderConfirmationPage();
        return OrderConfirmationPage.get((AppiumDriver) driver);
    }

    public OrderConfirmationPage assertOrderSummaryInYourOrderPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Order Confirmation Page");
        commonElements.scroll( getPickupTimeHeader(), "up" );
        Assert.assertEquals( getItemTitle().getText(), customizedItem.getCustomizedProductDetail().getProductName());
        Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public YourOrderPage assertOrderDetailsInYourOrderPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Your Order Page");
        Thread.sleep( 20000 );
        getPickupTimeHeaderText().isReady();
        commonElements.scroll( getPickupTimeHeader(), "down" );
        Assert.assertEquals( getItemTitle().getText(), customizedItem.getProductDetail().getName() );
        Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
        //Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("Started asserting order details In Your Order Page");
        return YourOrderPage.get((AppiumDriver)driver);
    }

    public YourOrderPage assertEditOrderDetailsInYourOrderPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Edit Order Page");
        Thread.sleep( 20000 );
        commonElements.scroll( getPickupTimeHeader(), "down" );
        Assert.assertEquals( getItemTitle().getText(), customizedItem.getProductDetail().getName());
        Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
        Logz.step("Started asserting order details In Edit Order Page");
        return YourOrderPage.get((AppiumDriver)driver);
    }


    public YourOrderPage assertSidesDrinksOrderDetailsInYourOrderPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Your Order Page");
        Thread.sleep( 20000 );
        getPickupTimeHeaderText().isReady();
        commonElements.scroll( getPickupTimeHeader(), "down" );
        if (customizedItem.getMenuName().contains( "Drinks" )){
            if(customizedItem.getCustomizedProductDetail().getProductClassName().contains( "Bottled Beverage" )){
                Assert.assertEquals( getItemTitle().getText(), customizedItem.getCustomizedProductDetail().getProductClassName() );
            }else {
                Assert.assertEquals( getItemTitle().getText(), customizedItem.getProductDetail().getName() );
            }
        }else{
            Assert.assertEquals( getItemTitle().getText(), customizedItem.getCustomizedProductDetail().getProductClassName() );
        }
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
        Logz.step("Click on Manage locator in Your Order page");
        getManage().click();
        Logz.step("Clicked on Manage locator in Your order page");
        return ManageRewardsPage.get((AppiumDriver)driver);
    }

    private pojos.MyLoyalty assertRewardsDetailsInYourOrderPage() throws Exception {
        pojos.MyLoyalty actualAndExpectedMyRewards = new pojos.MyLoyalty();
        Logz.step( "Manage Button verification in rewards has started " );
        commonElements.scrollToElement(null, ManageLocator,0.9, 0.5);
        Thread.sleep( 5000 );
        Logz.step("Assertion of certificates in Your Order page started");
        user = MobileApi.getLoyaltyLookUp(user);
        Assert.assertEquals(user.getLoyaltyLookup().getCertificates().getCertificateCount(),Utils.rewardsValue(getRewardsAmt().getText()));
        Logz.step("Rewards/Certificates asserted");
        return actualAndExpectedMyRewards;
    }



}
