package pages.ProductDetailsPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
import util.MobileApi;
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
    abstract MobileButton getProductName() throws Exception;
    abstract MobileButton getProductIngredientsText() throws Exception;
    abstract MobileButton getProductIngredientsList() throws Exception;
    abstract MobileButton getProductDisclaimer() throws Exception;
    abstract MobileButton getProductPrice() throws Exception;
    abstract MobileButton getProductCalories() throws Exception;
    abstract MobileButton getSingleProductPrice() throws Exception;
    abstract MobileButton getSingleProductCalories() throws Exception;
    public ProductDetailsPage assertProductDetails(MobileUser mobileUser) throws Exception{
        Logz.step("##### Started asserting Product Details #####");
        try {
            CustomizedItem customizedItem = new CustomizedItem();
            Assert.assertEquals(getProductName().getText(), customizedItem.getCustomizedProductDetail().getProductName());
           // Assert.assertEquals(getProductIngredientsText().getText(), BaseTest.getStringfromBundleFile("Ingredient"));
            Assert.assertTrue( assertIngredients(getProductIngredientsList().getText(), MobileApi.getExpectedDefaultIngredients(customizedItem.getProductDetail())) );
           Assert.assertEquals(getProductDisclaimer().getText(), customizedItem.getProductDetail().getPromoDisclaimer());
            if (MobileApi.getBreadOptionCount(customizedItem, mobileUser) > 1) {
                    Assert.assertEquals(getProductPrice().getText(), "$"+customizedItem.getCustomizedProductDetail().getPrice());
                    Assert.assertEquals(getProductCalories().getText(), customizedItem.getCustomizedProductDetail().getCalories()+" Cals*");
            }else{
                Assert.assertEquals(getSingleProductPrice().getText(), "$"+customizedItem.getCustomizedProductDetail().getPrice());
                Assert.assertEquals(getSingleProductCalories().getText(), customizedItem.getCustomizedProductDetail().getCalories()+" Cals*");
            }

        }catch (Exception ex) {
            throw new Exception("Unable to assert Product Details\n"+ ex.getMessage());
        }
        Logz.step("##### Ended asserting Product Details #####");

        return ProductDetailsPage.get((AppiumDriver)driver);
    }
    public boolean assertIngredients(String aIngredients, String eIngredients){
        List<String> aIngredientsList = Arrays.asList(aIngredients.split("\\s*,\\s*"));
        List<String> eIngredientsList = Arrays.asList(eIngredients.split("\\s*,\\s*"));
        Collections.sort(aIngredientsList);
        Collections.sort(eIngredientsList);
        return aIngredientsList.equals(eIngredientsList);
    }

}
