package pages.ProductDetailsPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pages.CustomizePage.CustomizePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
import util.MobileApi;
import util.Utils;
import utils.Logz;

import java.util.*;

public abstract class ProductDetailsPage<T extends AppiumDriver> extends MobileBasePage {
    public ProductDetailsPage(AppiumDriver driver) {
        super(driver);
    }
    public static ProductDetailsPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new ProductDetailsPageIOS((IOSDriver) driver);

            case "Android":
                return new ProductDetailsPageAndroid((AndroidDriver) driver);

            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    abstract MobileButton getProductName(String productName) throws Exception;
    abstract MobileButton getProductIngredientsText() throws Exception;
    abstract MobileButton getProductIngredientsList() throws Exception;
    abstract MobileButton getProductDisclaimer() throws Exception;
    abstract MobileButton getProductPrice(String price) throws Exception;
    abstract MobileButton getProductCalories() throws Exception;
    abstract MobileButton getSingleProductPrice() throws Exception;
    abstract MobileButton getSingleProductCalories() throws Exception;
    abstract MobileButton getCustomize() throws Exception;
    abstract MobileButton getPriceOneOption(String price) throws Exception;
    public CustomizePage goToCustomizePage() throws Exception {
        getCustomize().click();
        return CustomizePage.get((AndroidDriver) driver);
    }
    public ProductDetailsPage assertProductNameInProductDetailsPage(CustomizedItem customizedItem) throws Exception{

        try {
            Logz.step("##### Started asserting product name in Product Details page #####");

         if(customizedItem.getMenuName().contains( "Chopped Salads" ) ||  customizedItem.getMenuName().contains( "Kids" ) || customizedItem.getMenuName().contains( "Personal Pizza" )) {

             String productName = Utils.getProductName( customizedItem.getMenuName(), customizedItem.getProductDetail().getName() );
             Assert.assertEquals( productName.toUpperCase(), getProductName( productName ).getText().toUpperCase());
             Assert.assertEquals( getPriceOneOption(Utils.getExpectedPrice(customizedItem)).getText(), Utils.getExpectedPrice(customizedItem));
         }else {
             Assert.assertTrue(customizedItem.getCustomizedProductDetail().getProductName().toUpperCase().contains(getProductName(customizedItem.getCustomizedProductDetail().getProductName()).getText().toUpperCase()));
             Assert.assertEquals( getProductPrice(Utils.getExpectedPrice(customizedItem)).getText(), Utils.getExpectedPrice(customizedItem));
         }
           Logz.step("##### Ended asserting product name in Product Details page #####");

        }catch (Exception ex) {
            throw new Exception("Unable to assert product name in Product Details page\n"+ ex.getMessage());
        }


        return ProductDetailsPage.get((AppiumDriver)driver);
    }
    public boolean assertIngredients(String aIngredients, String eIngredients){
        List<String> aIngredientsList = Arrays.asList(aIngredients.split("\\s*,\\s*"));
        List<String> eIngredientsList = Arrays.asList(eIngredients.split("\\s*,\\s*"));
        Collections.sort(aIngredientsList);
        Collections.sort(eIngredientsList);
        return aIngredientsList.equals(eIngredientsList);
    }
    public ProductDetailsPage assertProductDetails(MobileUser mobileUser, CustomizedItem customizedItem) throws Exception{
        Logz.step("##### Started asserting Product Details #####");
        try {
            if(customizedItem.getMenuName().contains( "Chopped Salads" ) ||  customizedItem.getMenuName().contains( "Kids" ) || customizedItem.getMenuName().contains( "Personal Pizza" )) {

                String productName = Utils.getProductName( customizedItem.getMenuName(), customizedItem.getProductDetail().getName() );
                Assert.assertEquals( productName.toUpperCase(), getProductName( productName ).getText().toUpperCase());
            }else {
                Assert.assertTrue(customizedItem.getCustomizedProductDetail().getProductName().toUpperCase().contains(getProductName(customizedItem.getCustomizedProductDetail().getProductName()).getText().toUpperCase()));
            }
           // String productName = Utils.getProductName( customizedItem.getMenuName(), customizedItem.getCustomizedProductDetail().getProductName() );
          //  Assert.assertEquals(getProductName(customizedItem.getCustomizedProductDetail().getProductName()).getText(), productName);
            Assert.assertEquals(getProductIngredientsText().getText(), BaseTest.getStringfromBundleFile("Ingredients"));
            Assert.assertTrue( assertIngredients(getProductIngredientsList().getText(), MobileApi.getExpectedDefaultIngredients(customizedItem.getProductDetail())) );
            Assert.assertEquals(getProductDisclaimer().getText(), customizedItem.getProductDetail().getPromoDisclaimer());
            if (MobileApi.getBreadOptionCount(customizedItem, mobileUser) > 1) {
              //  Assert.assertEquals(getProductPrice(Utils.getExpectedPrice( customizedItem )).getText(), Utils.getExpectedPrice( customizedItem ));
                Assert.assertEquals(getProductCalories().getText(), Utils.getExpectedCalories( customizedItem ));
            }else{
             //   Assert.assertEquals(getSingleProductPrice().getText(), Utils.getExpectedPrice( customizedItem ));
                Assert.assertEquals(getSingleProductCalories().getText(), Utils.getExpectedCalories( customizedItem ));
            }

        }catch (Exception ex) {
            throw new Exception("Unable to assert Product Details\n"+ ex.getMessage());
        }
        Logz.step("##### Ended asserting Product Details #####");

        return ProductDetailsPage.get((AppiumDriver)driver);
    }
}
