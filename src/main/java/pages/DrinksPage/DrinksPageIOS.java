package pages.DrinksPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DrinksPageIOS extends DrinksPage {
    public DrinksPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getSelectFlavor() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getFlavorDrinksTitleText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getFlavorPriceText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getFlavorCaloriesText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getDrinksDescriptionText() throws Exception {
        return null;
    }

    @Override
    WebElement getDrinksText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getDrinksPriceText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getDrinksCaloriesText() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getDrinksPriceCaloriesList() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getItemFlavorList() throws Exception {
        return null;
    }



    @Override
    WebElement getItemFlavor() throws Exception {
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
