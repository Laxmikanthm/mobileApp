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
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
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
    abstract MobileTextBox getFlavorPriceText() throws Exception;
    abstract MobileTextBox getFlavorCaloriesText() throws Exception;
    abstract List<WebElement> getItemFlavorList() throws Exception;
    abstract WebElement getItemFlavor() throws Exception;
    abstract MobileTextBox getDrinksDescriptionText() throws Exception;
    abstract WebElement getDrinksText() throws Exception;
    abstract MobileTextBox getDrinksPriceText() throws Exception;
    abstract MobileTextBox getDrinksCaloriesText() throws Exception;
    abstract List<WebElement> getDrinksPriceCaloriesList() throws Exception;



    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );

    public DrinksPage selectDrinksOrder(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception {
        //ToDo
        String drinksName = customizedItem.getCustomizedProductDetail().getProductClassName();
        String drinksFlavorName = customizedItem.getCustomizedProductDetail().getProductName();

        if (drinksName.contains( "Bottled Beverage" )) {
            if (drinksFlavorName.contains( "Dasani® Water" )) {
                for (int i = 0; i < 9; i++) { // get the count
                    if (!getDrinksText().getText().contains( drinksFlavorName )) {
                        commonElements.swipe( (AppiumDriver) driver, "Left" );
                    }
                }
            } else {

                int count = 0;
                while (count < 10) {
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
            for (int i = 0; i < 9; i++) { // get the count
                if (!getDrinksText().getText().contains( drinksFlavorName )) {
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                } else {
                    assertDrinksDetails(customizedItem);
                }
            }


        }
        return DrinksPage.get( (AppiumDriver) driver );
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
               Assert.assertEquals( element.getText(), "$" +String.format("%.2f", Double.valueOf( customizedItem.getCustomizedProductDetail().getPrice()), "Drink flavors title assertion is failed" ));
           }else if(element.getText().contains( "Cals" )){
               Assert.assertEquals( element.getText().trim(), customizedItem.getCustomizedProductDetail().getCalories().trim()+" Cals*", "Drink flavors title assertion is failed" );
           }
        }
        Logz.step( "Asserted drinks product title" );
    }
    public void assertFlavoredDrinksDetails(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        Assert.assertEquals( getFlavorDrinksTitleText().getText().trim(), "$" +String.format("%.2f", Double.valueOf( customizedItem.getCustomizedProductDetail().getPrice()), "Drink flavors title assertion is failed" ));
        Assert.assertEquals( getFlavorCaloriesText().getText().trim(), customizedItem.getCustomizedProductDetail().getCalories().trim()+" Cals*", "Drink flavors title assertion is failed" );
        Assert.assertEquals( getFlavorPriceText().getText().trim(), customizedItem.getCustomizedProductDetail().getPrice().trim(), "Drink flavors title assertion is failed" );
        Logz.step( "Asserted drinks product title" );
    }
    public void assertDrinksDetails(CustomizedItem customizedItem) throws Exception {
        Logz.step( "Asserting drinks product title" );
        Assert.assertEquals( getDrinksText().getText(), customizedItem.getCustomizedProductDetail().getProductName(), "Drink Product title assertion is failed" );
        assertDrinksDescriptions(customizedItem);
        assertDrinksPriceCalories(customizedItem);
        Logz.step( "Asserted drinks product title" );
    }

}
