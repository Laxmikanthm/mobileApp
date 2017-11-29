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

import javax.print.DocFlavor;

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
    abstract WebElement getMakeitaMeal()throws  Exception;
    abstract WebElement ViewfullMenu()throws  Exception;
    abstract MobileTextBox getItemTitle() throws Exception;
    abstract MobileTextBox getItemPrice() throws Exception;
    abstract MobileTextBox getTotalText() throws Exception;
    abstract MobileTextBox getPickupTimeHeaderText() throws Exception;
    abstract MobileLabel getTaxPrice() throws Exception;
    abstract MobileButton getDineIn() throws Exception;


    CommonElements commonElements = new CommonElements((AppiumDriver) driver);
    By taxPriceLocator = By.id( "tax_header" );
    By getTotalText=By.id("submit_order");

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
        Thread.sleep( 20000 );
        getPickupTimeHeaderText().isReady();
        commonElements.scroll( getPickupTimeHeader(), "down" );
        Assert.assertEquals( getItemTitle().getText(), customizedItem.getProductDetail().getName() );
        Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
       // Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("Started asserting order details In Your Order Page");
        return YourOrderPage.get((AppiumDriver)driver);
    }

    public YourOrderPage assertOrderDetailsInYourOrderPagefortax (String Productname,boolean isDineIn,boolean isMakeitameal,double Productprice) throws Exception{
        Logz.step("Started asserting order details In Your Order Page");
        Thread.sleep( 20000 );
        getPickupTimeHeaderText().isReady();
        commonElements.scroll( getPickupTimeHeader(), "down" );
       if(isDineIn){
           getDineIn().click();
       }
       String Prodname[]=Productname.split(" ",2);
       String Productnameui[]=getItemTitle().getText().split(" ",2);
       Logz.step(Productnameui[1]);
        Logz.step(Prodname[1] );
        Assert.assertEquals( Productnameui[1],Prodname[1] );
        Logz.step("api value is p.price " +Double.toString(Productprice));
        Logz.step("UI value of p.priceis "+getItemPrice().getText());
        //Assert.assertEquals(getItemPrice().getText(),Double.toString(Productprice));
        //need to discuss with marium
        //Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice() );
        commonElements.scroll( getMakeitaMeal(), "down" );
         if(isMakeitameal){
           getMakeitaMeal().click();
          }
        commonElements.scroll( ViewfullMenu(), "down" );
        //commonElements.scrollToElement( null,getTotalText, 0.9,0.5);
        AssertTaxdetails();
        // Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("ended asserting order details In Your Order Page");
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
        getPlaceOrder().isReady();
        getPlaceOrder().click();
        return OrderConfirmationPage.get((AppiumDriver)driver);
    }
    public ManageRewardsPage goToManageRewardPage() throws Exception{

        return ManageRewardsPage.get((AppiumDriver)driver);
    }

    public  void AssertTaxdetails() throws  Exception
    {
        getTaxPrice().getControl().isDisplayed();
        if(!getTaxPrice().getText().isEmpty()){
            Logz.step("assert tax sucessful");}

    }
}
