package pages.ModifierPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;

public class ModifierPageIOS  extends ModifierPage{
    public ModifierPageIOS(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileButton getLess() throws Exception {
        return null;
    }

    @Override
    MobileButton getMore() throws Exception {
        return null;
    }

    @Override
    MobileButton getRegular() throws Exception {
        return null;
    }

    @Override
    MobileButton getLooksGood() throws Exception {
        return null;
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
