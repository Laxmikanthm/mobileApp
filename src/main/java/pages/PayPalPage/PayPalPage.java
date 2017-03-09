package pages.PayPalPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import pojos.user.MobileUser;

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

    public void addPaypalDetails(MobileUser mobileUser)throws Exception {
        try {
                  ((AppiumDriver) driver).context("WEB_VIEW");
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
