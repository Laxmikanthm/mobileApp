package pages.SidesPage;

import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class SidesPageAndroid extends SidesPage{
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    public SidesPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
