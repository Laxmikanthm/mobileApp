package pages.SubwayPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.MenuPage.MenuPage;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class SubwayPage<T extends AppiumDriver> extends MobileBasePage {

    public SubwayPage(AppiumDriver driver)
    {
        super(driver);
    }

    abstract MobileButton getAddPaymentMethod() throws Exception;

    public static SubwayPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new SubwayPageIOS((IOSDriver) driver);
            case "Android":
                return new SubwayPageAndroid((AndroidDriver) driver);
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

    public ChoosePaymentMethodPage addPaymentMethod() throws Exception
    {
        try{
            getAddPaymentMethod().click();

            return ChoosePaymentMethodPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public AddCardPage getAddCardPageInstance() throws Exception
    {
        try{

            return AddCardPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

}
