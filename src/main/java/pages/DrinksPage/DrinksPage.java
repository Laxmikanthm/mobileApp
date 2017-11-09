package pages.DrinksPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.user.MobileUser;
import utils.Logz;

public abstract class DrinksPage<T extends AppiumDriver> extends MobileBasePage {
    public DrinksPage(AppiumDriver driver) {
        super(driver);
    }

    public static DrinksPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new DrinksPageIOS((IOSDriver) driver);
            case "Android":
                return new DrinksPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public DrinksPage placeDrinksOrder(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception{
        //ToDo
        return DrinksPage.get((AppiumDriver)driver);
    }
    public void placeRandomOrderDrinks(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
          /*  remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            String subCategoryName = order.getCart().getProductDetail().getName();
            swipe( sidesOrDrinks, subCategoryName, "Left" );
            getAddToBag().isReady();
            getAddToBag().click();
            Thread.sleep( 20000 );
            getTokens( remoteOrder );
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();*/
        } catch (Exception ex) {
            Logz.error( ex.toString() );
        }
    }
}
