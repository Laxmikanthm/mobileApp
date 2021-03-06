package pages.DrinksPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.YourOrderPage.YourOrderPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
import util.Utils;
import utils.Logz;

import java.util.List;

public abstract class DrinksPage<T extends AppiumDriver> extends MobileBasePage {
    public DrinksPage(AppiumDriver driver) {
        super( driver );
    }

    public static DrinksPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new DrinksPageIOS( (IOSDriver) driver );
            case "Android":
                return new DrinksPageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }

    abstract MobileButton getSelectFlavor() throws Exception;
    abstract MobileTextBox getFlavorDrinksTitleText() throws Exception;
    abstract MobileTextBox getFlavorTitleText() throws Exception;
    abstract MobileTextBox getFlavorCaloriesText() throws Exception;
    abstract List<WebElement> getItemFlavorList() throws Exception;
    abstract WebElement getItemFlavor() throws Exception;
    abstract MobileTextBox getDrinksDescriptionText() throws Exception;
    abstract WebElement getDrinksText() throws Exception;
    abstract MobileTextBox getDrinksPriceText() throws Exception;
    abstract MobileTextBox getDrinksCaloriesText() throws Exception;
    abstract List<WebElement> getDrinksPriceCaloriesList() throws Exception;
    abstract MobileTextBox getItemCountText() throws Exception;
    abstract List<WebElement> getAddToBag() throws Exception;


    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    String drinksFlavorName;
    public YourOrderPage selectDrinksOrder(CustomizedItem customizedItem) throws Exception {
        //ToDo

        String drinksName = customizedItem.getCustomizedProductDetail().getProductClassName();
        drinksFlavorName = customizedItem.getCustomizedProductDetail().getProductName();

        if (drinksName.contains( "Bottled Beverage" )) {
            if (drinksFlavorName.contains( "Dasani® Water" )) {
                for (int i = 0; i < getItemCount(); i++) { // get the count
                    if (!getDrinksText().getText().contains( drinksFlavorName )) {
                        commonElements.swipe( (AppiumDriver) driver, "Left" );
                    }
                }
            } else {

                int count = 0;
                while (count < getItemCount()) {
                    if (!getDrinksText().getText().equalsIgnoreCase( drinksName.replaceAll( "s", "" ) )) {
                        commonElements.swipe( (AppiumDriver) driver, "Left" );
                    }

                    getSelectFlavor().click();
                    commonElements.scroll( getItemFlavor(), "up" ); //Bottled Beverage

                    for (WebElement webElement : getItemFlavorList()) {
                        if (webElement.getText().contains( customizedItem.getCustomizedProductDetail().getProductName() )) {
                            assertFlavoredDrinksDetails(customizedItem);
                            webElement.click();
                            break;

                        }

                    }
                    count++;
                }

            }
            assertDrinksDetails(customizedItem);
            Logz.step( drinksName + drinksFlavorName + "is selected" );

        } else {
            for (int i = 0; i < getItemCount(); i++) { // get the count
                if (!getDrinksText().getText().contains( drinksFlavorName )) {
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                }
            }
            assertDrinksDetails(customizedItem);

        }
        goToYourOrderPage();
        return YourOrderPage.get( (AppiumDriver) driver );
    }

    public int getItemCount() throws Exception{
        String[] strings = getItemCountText().getText().split( "OF " );
        return Integer.parseInt( strings[1] );
    }
    public void assertDrinksDescriptions(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        Assert.assertEquals( getDrinksDescriptionText().getText().trim(), customizedItem.getCustomizedProductDetail().getDescription().trim(), "Drink flavors title assertion is failed" );
        Logz.step( "Asserted drinks product title" );
    }
    public void assertDrinksPriceCalories(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        for(WebElement element: getDrinksPriceCaloriesList()){
            if( element.getText().contains( "$" )){
                Assert.assertEquals( element.getText(), Utils.getExpectedPrice(customizedItem) , "Drink flavors title assertion is failed" );
            }else if(element.getText().contains( "Cals" )){
                Assert.assertEquals( element.getText().trim(), Utils.getExpectedCalories(customizedItem), "Drink flavors title assertion is failed" );
            }
        }
        Logz.step( "Asserted drinks product title" );
    }
    public void assertFlavoredDrinksDetails(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        Assert.assertEquals( getFlavorTitleText().getText().trim(),  customizedItem.getCustomizedProductDetail().getProductName(), "Drink flavors title assertion is failed" );
        Assert.assertEquals( getFlavorCaloriesText().getText().trim(), Utils.getExpectedCalories(customizedItem), "Drink flavors title assertion is failed" );
        Logz.step( "Asserted drinks product title" );
    }
    public void assertDrinksDetails(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        Assert.assertEquals( getDrinksText().getText(), customizedItem.getCustomizedProductDetail().getProductName(), "Drink Product title assertion is failed" );
        assertDrinksDescriptions(customizedItem);
        assertDrinksPriceCalories(customizedItem);
        Logz.step( "Asserted drinks product title" );
    }

    public void goToYourOrderPage( ) throws Exception{

        if (drinksFlavorName.contains( "21oz Fountain Drink" )) {
            getAddToBag().get( 0 ).click();
        }else {
            getAddToBag().get( 1 ).click();
        }
        Logz.step( "Navigating to our order page......" );

    }
    //quantity_more
    //quantity
    //quantity_less
}
