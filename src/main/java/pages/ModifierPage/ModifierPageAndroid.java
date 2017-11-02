package pages.ModifierPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ModifierPageAndroid extends ModifierPage {
    public ModifierPageAndroid(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileButton getLess() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id("option1_text"), "Less" );
    }

    @Override
    MobileButton getMore() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id("option3_text"), "More" );
    }

    @Override
    MobileButton getRegular() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id("option2_text"), "Regular" );
    }

    @Override
    MobileButton getLooksGood() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id("done"), "Looks Good" );
    }

    @Override
    MobileTextBox getIngredientSelectedText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getIngredientCalPriceText() throws Exception {
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
