package pages.ProductDetailsPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pojos.CustomizedItem.CustomizedItem;
import utils.Logz;

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
    public ProductDetailsPage assertProductDetails(CustomizedItem customizedItem) throws Exception{
        Logz.step("##### Started asserting Product Details #####");
        try {
            //ToDO
            //assert product name
            //assert product calories
            //assert product price
            //assert product default ingredients
        }catch (Exception ex) {
            throw new Exception("Unable to assert Product Details\n"+ ex.getMessage());
        }
        Logz.step("##### Ended asserting Product Details #####");

        return ProductDetailsPage.get((AppiumDriver)driver);
    }
}
