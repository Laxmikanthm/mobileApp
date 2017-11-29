package pages.ProductDetailsPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductDetailsPageAndroid extends ProductDetailsPage {
    public ProductDetailsPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getProductName(String productName) throws Exception {
     return new AndroidButton((AndroidDriver) driver, By.id("product_name"), "product_name");
    }

    @Override
    MobileButton getProductIngredientsText() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("product_items"), "product_items");
    }

    @Override
    MobileButton getProductIngredientsList() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("product_items"), "product_detail_ingredient");
    }

    @Override
    MobileButton getProductDisclaimer() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("disclaimer"), "disclaimer");
    }

    @Override
    MobileButton getProductPrice(String price) throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("two_option_price"), "two_option_price");
    }

    @Override
    MobileButton getProductCalories() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("two_option_calories"), "two_option_calories");
    }

    @Override
    MobileButton getSingleProductPrice() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("single_option_price"), "single_option_price");
    }

    @Override
    MobileButton getSingleProductCalories() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("single_option_calories"), "single_option_calories");
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public MobileButton getCustomize() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+ BaseTest.bundle.getString("Customize")+"']"), "Customize button");
        return button;
    }
}
