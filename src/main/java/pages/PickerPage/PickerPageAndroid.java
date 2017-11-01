package pages.PickerPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PickerPageAndroid extends PickerPage{
    public PickerPageAndroid(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileButton getModifyButton() throws Exception {
        return new AndroidButton((AndroidDriver)driver, By.id("modify_layout"), "Click Modify");
    }
}
