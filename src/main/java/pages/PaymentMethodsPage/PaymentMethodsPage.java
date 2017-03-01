package pages.PaymentMethodsPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class PaymentMethodsPage<T extends AppiumDriver> extends MobileBasePage {

    public PaymentMethodsPage(AppiumDriver driver) { super(driver); }

    abstract MobileButton getAddPaymentMethod() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

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
