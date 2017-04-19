package pages.HelpPage;

import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;

/**
 * Created by e002243 on 18-04-2017.
 */
public abstract  class HelpPage<T extends AppiumDriver> extends MobileBasePage {

    public HelpPage(AppiumDriver driver) throws Exception {
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
