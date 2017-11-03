package pages.ProductDetailsPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class ProductDetailsPageIOS extends ProductDetailsPage {
    public ProductDetailsPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getProductName() throws Exception {
        return null;
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
    MobileButton getProductPrice() throws Exception {
        return null;
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
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
