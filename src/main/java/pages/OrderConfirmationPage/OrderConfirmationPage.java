package pages.OrderConfirmationPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteItems;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.HomePage.HomePage;
import pages.NamePage.NamePage;
import pages.NamePage.NamePageAndroid;
import pages.NamePage.NamePageIOS;
import pojos.CustomizedItem.CustomizedItem;
import pojos.FavouriteDetails;
import pojos.user.MobileUser;
import util.MobileApi;
import util.Utils;
import utils.Logz;

import java.util.List;

public abstract class OrderConfirmationPage<T extends AppiumDriver> extends MobileBasePage {
    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }
    public static OrderConfirmationPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new OrderConfirmationPageIOS((IOSDriver) driver) {
                };
            case "Android":
                return new OrderConfirmationPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    abstract WebElement getPickupTimeHeader() throws Exception;
    abstract MobileTextBox getItemTitle(String itemTitle) throws Exception;
    abstract MobileTextBox getItemPrice(String price) throws Exception;
    abstract MobileTextBox getFlavorItemTitle() throws Exception;
    abstract MobileTextBox getItemTitlefortax() throws Exception;
    abstract MobileTextBox getItemPricetax() throws Exception;
    abstract MobileTextBox getTotalText(String price) throws Exception;
    abstract MobileTextBox getPickupTimeHeaderText() throws Exception;


    CommonElements commonElements = new CommonElements((AppiumDriver)driver);
    abstract MobileButton getGotIt() throws Exception;


    public HomePage assertOrderDetailsInOrderConfirmationPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Order Confirmation Page");
        Thread.sleep( 20000 );
       // getPickupTimeHeaderText().isReady();
        getGotIt().isReady();
        if(driver instanceof AndroidDriver) {
            commonElements.scroll(getPickupTimeHeader(), "down");
        }else {
            commonElements.scrollIOS(getPickupTimeHeader(), "up");
        }
        if (customizedItem.getMenuName().contains( "Sides" ) || customizedItem.getMenuName().contains( "Drinks" )){
            Assert.assertEquals( getItemTitle(customizedItem.getCustomizedProductDetail().getProductName()).getText(), customizedItem.getCustomizedProductDetail().getProductName() );
        }else{
            Assert.assertEquals( getItemTitle(customizedItem.getProductDetail().getName()).getText(), customizedItem.getCustomizedProductDetail().getProductName() );
            Assert.assertEquals( getItemTitle(customizedItem.getProductDetail().getName()).getText(), customizedItem.getProductDetail().getName() );
        }
        Assert.assertEquals( getItemPrice(Utils.getExpectedPrice(customizedItem)).getText(), Utils.getExpectedPrice(customizedItem) );
        // Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("Started asserting order details In Order Confirmation Page");
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }


    public HomePage assertOrderDetailsInOrderConfirmationPageforTax(String Productname,double Productprice) throws Exception{
        Logz.step("Started asserting order details In Order Confirmation Page");
        Thread.sleep( 20000 );
        // getPickupTimeHeaderText().isReady();
        getGotIt().isReady();
        commonElements.scroll( getPickupTimeHeader(), "down" );
        if (Productname.contains( "Sides" ) || Productname.contains( "Drinks" )){
            Assert.assertEquals( getItemPricetax().getText(), Productname );
        }else{

            String Prodsplitname[]=Productname.split(" ",2);
            String Itemtitle=getItemTitlefortax().getText();
            String ItemTitle[]=Itemtitle.split(" ",2);
            Assert.assertEquals( ItemTitle[1], Prodsplitname[1]);
            Assert.assertEquals(getItemTitlefortax().getText(),Double.toString(Productprice));
        }
        //To be discussed with Marium on how to retrieve Item Price from Customized Item
        // Class as Hot / Cold Item is retrieved using different method
        //Assert.assertEquals( getItemPrice().getText(), Utils.getExpectedPrice(customizedItem) );
        // Assert.assertEquals( getTotalText().getText(),  "PLACE ORDER | "+Utils.getExpectedPrice( customizedItem ));
        Logz.step("completed asserting order details In Order Confirmation Page");
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertSidesDrinksOrderDetailsInOrderConfirmationPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting order details In Order Confirmation Page");
        Thread.sleep( 20000 );
        // getPickupTimeHeaderText().isReady();
        getGotIt().isReady();
        if(driver instanceof AndroidDriver) {
            commonElements.scroll(getPickupTimeHeader(), "down");
        }
        if (customizedItem.getMenuName().contains( "Drinks" )) {
            if (customizedItem.getCustomizedProductDetail().getProductClassName().contains( "Bottled Beverage" )) {
                Assert.assertEquals( getItemTitle(customizedItem.getCustomizedProductDetail().getProductClassName()).getText(), customizedItem.getCustomizedProductDetail().getProductClassName() );
                Assert.assertEquals( getFlavorItemTitle().getText().substring(2).trim(), customizedItem.getCustomizedProductDetail().getProductName() );

            } else {
                Assert.assertEquals( getItemTitle(customizedItem.getCustomizedProductDetail().getProductName()).getText(), customizedItem.getCustomizedProductDetail().getProductName() );
            }
        }else{
            if (customizedItem.getCustomizedProductDetail().getProductClassName().contains( "Apple Slices" )) {
                Assert.assertEquals( getItemTitle(customizedItem.getCustomizedProductDetail().getProductClassName()).getText(), customizedItem.getCustomizedProductDetail().getProductClassName() );

            } else {
                Assert.assertEquals( getItemTitle(customizedItem.getCustomizedProductDetail().getProductClassName()).getText(), customizedItem.getCustomizedProductDetail().getProductClassName() );
                Assert.assertEquals( getFlavorItemTitle().getText().substring(2).trim(), customizedItem.getCustomizedProductDetail().getProductName() );
            }

        }
        Assert.assertEquals( getItemPrice(Utils.getExpectedPrice(customizedItem)).getText(), Utils.getExpectedPrice(customizedItem) );
        //Assert.assertEquals( getTotalText(Utils.getExpectedPrice( customizedItem )).getText(),  Utils.getExpectedPrice( customizedItem ));//$5.51
        Logz.step("Started asserting order details In Order Confirmation Page");
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertFavouriteOrderDetailsInOrderConfirmationPage(MobileUser mobileUser) throws Exception{
        Logz.step("Started asserting total amount In Your Order Page");
        FavouriteDetails actualFavourites=getActualFavourites(mobileUser);
        FavouriteDetails expectedFavourites=new FavouriteDetails();
        FavoriteItems expectedApiFavourites= MobileApi.getFavoriteItems(mobileUser);
        String result = "";
        String FavouriteName="";
        Double Price=0.0;
        for(int i=0;i<expectedApiFavourites.getResults().length;i++)
        {

            FavouriteName= expectedApiFavourites.getResults()[i].getFavoriteName();
               Price= expectedApiFavourites.getResults()[i].getPrice();
               List<FavoriteOptions> favoriteOptionsList=expectedApiFavourites.getResults()[i].getOptions().subList(0,expectedApiFavourites.getResults()[i].getOptions().size()-1);
               for(int k=0;k<favoriteOptionsList.size();k++)
               {

                   if(k==0) {
                       result=favoriteOptionsList.get(k).getName();
                   }
                   else
                   {
                       result+=","+favoriteOptionsList.get(k).getName();
                   }
               }

        }
        expectedFavourites.setIngrediants(result);
        expectedFavourites.setFavouriteName(FavouriteName);
        expectedFavourites.setPrice(Price.toString());
        /*String aTotalAmount =  commonElements.getElement(totalAmount, totalAmount, (AppiumDriver)driver).getText();
        String eTotalAmount = "";*/
        Assert.assertEquals(actualFavourites, expectedFavourites);
        Logz.step("Started asserting total amount In Your Order Page");
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public FavouriteDetails getActualFavourites(MobileUser mobileUser)throws Exception
    {
        FavouriteDetails actualfavouriteDetails=new FavouriteDetails();
        commonElements.getElement(By.id(""),By.id("item_title"),(AppiumDriver) driver);
        actualfavouriteDetails.setFavouriteName(commonElements.getElement(By.id(""),By.id("item_title"),(AppiumDriver) driver).getText());
        actualfavouriteDetails.setIngrediants(commonElements.getElement(By.id(""),By.id("item_options"),(AppiumDriver) driver).getText());
        actualfavouriteDetails.setPrice(commonElements.getElement(By.id(""),By.id("item_price"),(AppiumDriver) driver).getText());

        return actualfavouriteDetails;
    }
    public HomePage assertLoyaltyDisplay() throws Exception{
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertOrderSummaryInOrderConfirmationPage() throws Exception{
        return HomePage.get((AppiumDriver)driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
