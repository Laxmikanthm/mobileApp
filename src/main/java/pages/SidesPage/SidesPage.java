package pages.SidesPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.user.MobileUser;

public abstract class SidesPage<T extends AppiumDriver> extends MobileBasePage {
    public SidesPage(AppiumDriver driver) {
        super(driver);
    }

    public static SidesPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new SidesPageIOS((IOSDriver) driver);
            case "Android":
                return new SidesPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public HomePage placeSidesOrder(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception{
//ToDo
        return HomePage.get((AppiumDriver)driver);
    }
    public void placeRandomOrderSides(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            /*remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            scrollAndClick( storeNamesLocator, storeName, "Up" );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            String subCategoryName = order.getCart().getProductDetail().getName();
            if (subCategoryName.equalsIgnoreCase( "Apple Slices" )) {
                getAddToBag().isReady();
            } else {
                swipe( sidesOrDrinks, subCategoryName, "Left" );
                getSelectFlavor().isReady();
                getSelectFlavor().click();
                getItemSelectFlavor().isReady();
                getItemSelectFlavor().click();
                getAddToBag().isReady();
            }
            */
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

}
