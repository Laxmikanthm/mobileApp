package pages.SidesPage;

import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;

public class SidesPageIOS extends SidesPage{
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    public SidesPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
