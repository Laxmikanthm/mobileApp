package pages.DrinksPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import pages.CommonElements.CommonElements;
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
import utils.Logz;

import java.util.List;

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
    abstract MobileButton getSelectFlavor() throws Exception;

    abstract List<WebElement> getItemFlavorList() throws Exception;

    abstract WebElement getDrinks() throws Exception;
    abstract WebElement getItemFlavor() throws Exception;
    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    public DrinksPage selectDrinksOrder(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception{
        //ToDo
        String drinksName = customizedItem.getCustomizedProductDetail().getProductClassName();
        String drinksFlavorName = customizedItem.getCustomizedProductDetail().getProductName();

        if (drinksName.contains( "Bottled Beverage" )) {
            if (!getDrinks().getText().contains( drinksName )) {
                commonElements.swipe( (AppiumDriver) driver, "Left" );
            }
            getSelectFlavor().click();
            commonElements.scroll(getItemFlavor(), "up"); //Bottled Beverage

            for(WebElement webElement : getItemFlavorList()) {
                if(webElement.getText().contains( customizedItem.getCustomizedProductDetail().getProductName() )){
                    webElement.click();
                    break;
                  /* customizedItem.getCustomizedProductDetail().getProductName()
                   customizedItem.getCustomizedProductDetail().getCalories()
                   customizedItem.getCustomizedProductDetail().getPrice()*/
                }

            }
            Logz.step( drinksName + "is selected" );

        } else {
            for (int i = 0; i < 4; i++) { // get the count
                if (!getDrinks().getText().contains( drinksFlavorName )) {
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                }
            }



        }
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
