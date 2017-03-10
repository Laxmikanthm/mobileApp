package pages.FindYourSubWayPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class FindYourSubWayPage<T extends AppiumDriver> extends MobileBasePage {


    public FindYourSubWayPage(AppiumDriver driver) {
        super(driver);
    }


    abstract MobileButton getSearchButton() throws Exception;
    abstract MobileButton getSelectRestButton() throws Exception;
    abstract MobileButton getFindSubwayButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static FindYourSubWayPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new FindYourSubWayPageIOS((IOSDriver) driver);
            case "Android":
                return new FindYourSubWayPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }


}
