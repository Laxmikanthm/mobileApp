package pages.CustomizePage;

import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class CustomizePageAndroid extends CustomizePage{
    public CustomizePageAndroid(AppiumDriver driver) {
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
