package pages.PayPalPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPageAndroid;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPageIOS;
import pojos.user.MobileUser;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by e002243 on 08-03-2017.
 */
public abstract class PayPalPage<T extends AppiumDriver> extends MobileBasePage {

    public PayPalPage(AppiumDriver driver)
    {
        super(driver);
    }

    abstract MobileTextBox getPaypalUserName() throws Exception;
    abstract MobileTextBox getPaypalPassword() throws Exception;
    abstract MobileButton getLogIn() throws Exception;
    abstract MobileButton getAgreeAndContinue() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PayPalPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new PayPalPageIOS((IOSDriver) driver);
            case "Android":
                return new PayPalPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void addPaypalDetails(MobileUser mobileUser)throws Exception {
        try {
            AppiumDriver d = (AppiumDriver)driver;

            Set contextNames = d.getContextHandles();


            Iterator itr= contextNames.iterator();
          Object obj= itr.next();
          Object obj1 = itr.next();

                d.context(obj1.toString());

                    getPaypalUserName().wait(10000);
                    getPaypalUserName().isReady();
                    getPaypalUserName().setText(mobileUser.getEmailAddress());
                    getPaypalPassword().setText(mobileUser.getPassword());
                    getLogIn().click();
                    getAgreeAndContinue().click();


                }catch(Exception ex)
                {
                    throw new Exception(ex);
                }
            }

        }
