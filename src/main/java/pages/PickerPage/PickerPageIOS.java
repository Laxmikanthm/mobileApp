package pages.PickerPage;

import base.gui.controls.mobile.generic.MobileButton;
import io.appium.java_client.AppiumDriver;

public class PickerPageIOS extends PickerPage {
    public PickerPageIOS(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileButton getModifyButton() throws Exception {
        return null;
    }
}
