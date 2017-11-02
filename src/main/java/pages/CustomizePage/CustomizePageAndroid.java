package pages.CustomizePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CustomizePageAndroid extends CustomizePage{
    public CustomizePageAndroid(AppiumDriver driver) {
        super(driver);
    }
//By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("AddPaymet") + "']")
    @Override
    MobileButton getAddTopping() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("add_ingredient"), "Click AddTopping");
    }


    @Override
    MobileTextBox getPickerName() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getModifierName() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getCalories() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getBreadCalories() throws Exception {
        return new AndroidTextBox((AndroidDriver)driver, By.id("bread_calories_textview"), "getBreadCalories");
    }

    @Override
    MobileTextBox getPrice() throws Exception {
        return null;
    }

    @Override
    MobileButton getBread() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("data_layout"), "Click Bread");

    }

    @Override
    MobileTextBox getToastIt() throws Exception {
         return new AndroidTextBox((AndroidDriver)driver, By.id("toasted_text"), "getToastItText");
    }

    @Override
    MobileButton getToastItIcon() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("toasted_image"), "Click ToastItIcon");
    }

    @Override
    MobileButton getLooksGood() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("done_button"), "Looks Good");
    }

    @Override
    MobileTextBox getBreadTitle() throws Exception {
        return new AndroidTextBox((AndroidDriver)driver, By.id("bread_title"), "getBreadTitle");
    }

    @Override
    MobileButton getBackIcon() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getTitleText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getBreadSizeText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getBreadCalorieText() throws Exception {
        return null;
    }

    @Override
    MobileButton getHelpIcon() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getBreadFtue() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getaddFtue() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getIngredientFtueText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getDisclaimerText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getIngredientNameText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getIngredientCaloriesText() throws Exception {
        return null;
    }

    @Override
    MobileButton getAddToBagButton() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getCalorieInfoIcon() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getDisclaimer() throws Exception {
        return null;
    }

    @Override
    MobileButton getDoneButton() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id("done"), "Looks Good" );
    }

    @Override
    MobileTextBox getIngredientText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getCalorieCountText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getModifyText() throws Exception {
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
