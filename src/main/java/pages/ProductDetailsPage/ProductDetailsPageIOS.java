package pages.ProductDetailsPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductDetailsPageIOS extends ProductDetailsPage {
    public ProductDetailsPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getProductName(String productName) throws Exception {
        if("Rotisserie-Style Chicken Sandwich".contains(productName)) {
            productName = "Rotisserie-Style Chicken";
        }
        return new IOSButton((IOSDriver) driver, By.name(productName.toUpperCase()), productName + " product name");
    }

    @Override
    MobileButton getProductIngredientsText() throws Exception {
        return null;
    }

    @Override
    MobileButton getProductIngredientsList() throws Exception {
        return null;
    }

    @Override
    MobileButton getProductDisclaimer() throws Exception {
        return null;
    }

    @Override
    MobileButton getProductPrice(String price) throws Exception {
        return new IOSButton((IOSDriver) driver, By.name(price), price + " product price");
    }

    @Override
    MobileButton getProductCalories() throws Exception {
        return null;
    }

    @Override
    MobileButton getSingleProductPrice() throws Exception {
        return null;
    }

    @Override
    MobileButton getSingleProductCalories() throws Exception {
        return null;
    }

    @Override
    MobileButton getCustomize() throws Exception {
        return null;
    }

    @Override
    MobileButton getPriceOneOption(String price) throws Exception {
        return new IOSButton((IOSDriver) driver, By.name(price), price + " price");
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
