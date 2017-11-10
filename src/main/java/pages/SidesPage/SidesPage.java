package pages.SidesPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonElements.CommonElements;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.user.MobileUser;
import utils.Logz;

import java.util.List;

public abstract class SidesPage<T extends AppiumDriver> extends MobileBasePage {
    public SidesPage(AppiumDriver driver) {
        super( driver );
    }

    public static SidesPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new SidesPageIOS( (IOSDriver) driver );
            case "Android":
                return new SidesPageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }

    abstract MobileButton getSelectFlavor() throws Exception;

    abstract List<WebElement> getItemFlavorList() throws Exception;

    abstract WebElement getSides() throws Exception;
    abstract WebElement getItemFlavor() throws Exception;

    abstract MobileButton getItemSelectFlavor() throws Exception;

    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    By categoryLocatorIOS = By.id( "product_group_header" );
    By categoryLocatorAndroid = By.id( "product_group_header" );
    By sidesOrDrinksIOS = By.id( "product_title" );
    By sidesOrDrinksAndroid = By.id( "product_title" );

    public HomePage selectSidesOrder(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception {
//ToDo
        String SidesName = customizedItem.getCustomizedProductDetail().getProductClassName();
        if (SidesName.equalsIgnoreCase( "Apple Slices" )) {
            Logz.step( SidesName + "is selected" );

        } else {
            for (int i = 0; i < 4; i++) {
                if (!getSides().getText().contains( SidesName )) {
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                }
            }

            getSelectFlavor().click();
            commonElements.scroll(getItemFlavor(), "up");

           for(WebElement webElement : getItemFlavorList()) {
               if(webElement.getText().contains( customizedItem.getCustomizedProductDetail().getProductName() )){
                   webElement.click();
                   break;
                  /* customizedItem.getCustomizedProductDetail().getProductName()
                   customizedItem.getCustomizedProductDetail().getCalories()
                   customizedItem.getCustomizedProductDetail().getPrice()*/
               }

           }

        }
        return HomePage.get( (AppiumDriver) driver );
    }


}
