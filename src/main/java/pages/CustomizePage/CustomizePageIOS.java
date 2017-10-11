package pages.CustomizePage;

import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class CustomizePageIOS extends CustomizePage{
    public CustomizePageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
