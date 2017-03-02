package pages.ChoosePaymentMethodPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.SubwayPage.SubwayPage;
import pages.SubwayPage.SubwayPageAndroid;
import pages.SubwayPage.SubwayPageIOS;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class ChoosePaymentMethodPage<T extends AppiumDriver> extends MobileBasePage{

    public ChoosePaymentMethodPage(AppiumDriver driver) { super(driver); }

    abstract MobileButton getCreditCard() throws Exception;

    public static ChoosePaymentMethodPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new ChoosePaymentMethodPageIOS((IOSDriver) driver);
            case "Android":
                return new ChoosePaymentMethodPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}