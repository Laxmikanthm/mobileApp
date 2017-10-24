package pages.CustomizePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class CustomizePageAndroid extends CustomizePage{
    public CustomizePageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getAddTopping() throws Exception {
        return null;
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
    MobileButton getPickerName() throws Exception {
        return null;
    }

    @Override
    MobileButton getModifierName() throws Exception {
        return null;
    }

    @Override
    MobileButton getCalories() throws Exception {
        return null;
    }

    @Override
    MobileButton getPrice() throws Exception {
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
