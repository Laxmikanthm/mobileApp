package pages.SidesPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.DrinksPage.DrinksPage;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.user.MobileUser;
import util.Utils;
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

abstract MobileTextBox getItemCountText() throws Exception;
    abstract WebElement getSides() throws Exception;
    abstract WebElement getItemFlavor() throws Exception;
    abstract MobileTextBox getSidesDescriptionText() throws Exception;
    abstract MobileButton getItemSelectFlavor() throws Exception;
    abstract List<WebElement> getAddToBag() throws Exception;
    abstract List<WebElement> getSidesPriceCaloriesList() throws Exception;
    abstract  MobileTextBox getFlavorSidesTitleText() throws Exception;
    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );


    public HomePage selectSidesOrder(CustomizedItem customizedItem) throws Exception {
//ToDo
        int count = 0;
        String SidesName = customizedItem.getCustomizedProductDetail().getProductClassName();
        if (SidesName.equalsIgnoreCase( "Apple Slices" )) {
            Logz.step( SidesName + " is selected" );

        } else {
            for (int i = 0; i < getItemCount(); i++) {
                if (!getSides().getText().contains( SidesName )) {
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                }
                count = i - 1;
            }
            Logz.step( SidesName + " is selected" );
            getSelectFlavor().click();
            commonElements.scroll(getItemFlavor(), "up");

           for(WebElement webElement : getItemFlavorList()) {
               if(webElement.getText().contains( customizedItem.getCustomizedProductDetail().getProductName() )){
                   webElement.click();
                   Logz.step( customizedItem.getCustomizedProductDetail().getProductName() + " is selected" );
                   break;
               }

           }

        }
        assertSidesDetails(customizedItem);
        getAddToBag().get( count).click();

        return HomePage.get( (AppiumDriver) driver );
    }


    public void assertSidesDetails(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting Sides product title" );
        Assert.assertEquals( getSides().getText(), customizedItem.getCustomizedProductDetail().getProductClassName(), "Sides Product title assertion is failed" );
        if(!customizedItem.getCustomizedProductDetail().getProductClassName().contains( "Apple Slices" )) {
            Assert.assertEquals( getFlavorSidesTitleText().getText(), customizedItem.getCustomizedProductDetail().getProductName(), "Sides Product title assertion is failed" );
        }
        assertSidesDescriptions(customizedItem);
        assertSidesPriceCalories(customizedItem);
        Logz.step( "Asserted Sides product title" );
    }
    public void assertSidesDescriptions(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting Sides product title" );
        Assert.assertEquals( getSidesDescriptionText().getText().trim(), customizedItem.getCustomizedProductDetail().getDescription().trim(), "Sides flavors title assertion is failed" );
        Logz.step( "Asserted Sides product title" );
    }
    public void assertSidesPriceCalories(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting Sides product title" );
        for(WebElement element: getSidesPriceCaloriesList()){
            if( element.getText().contains( "$" )){
                Assert.assertEquals( element.getText(), Utils.getExpectedPrice(customizedItem) , "Sides flavors title assertion is failed" );
            }else if(element.getText().contains( "Cals" )){
                Assert.assertEquals( element.getText().trim(), Utils.getExpectedCalories(customizedItem), "Sides flavors title assertion is failed" );
            }
        }
        Logz.step( "Asserted Sides product title" );
    }
    public int getItemCount() throws Exception{
        String[] strings = getItemCountText().getText().split( "OF " );
        return Integer.parseInt( strings[1] );
    }

}
