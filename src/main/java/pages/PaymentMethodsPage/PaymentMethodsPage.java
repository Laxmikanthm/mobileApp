package pages.PaymentMethodsPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class PaymentMethodsPage<T extends AppiumDriver> extends MobileBasePage {

    public PaymentMethodsPage(AppiumDriver driver) { super(driver); }

    abstract MobileButton getAddPaymentMethod() throws Exception;
    abstract MobileLabel getCardType() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PaymentMethodsPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new PaymentMethodsPageIOS((IOSDriver) driver);

            case "Android":
                return new PaymentMethodsPageAndroid((AndroidDriver) driver);

            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void addPaymentMethod() throws  Exception
    {
        try{
            getAddPaymentMethod().click();
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }


}
