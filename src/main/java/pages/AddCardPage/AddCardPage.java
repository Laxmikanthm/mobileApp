package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class AddCardPage <T extends AppiumDriver> extends MobileBasePage {

    public AddCardPage(AppiumDriver driver){ super(driver);}

    abstract MobileTextBox getCardNumber() throws Exception;
    abstract MobileTextBox getExpiresOn() throws Exception;
    abstract MobileTextBox getCCV() throws Exception;
    abstract MobileTextBox getPin() throws Exception;
    abstract MobileTextBox getNameOnCard() throws Exception;
    abstract MobileButton getNextButton() throws  Exception;
    abstract MobileButton getSavePaymentMethod() throws  Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}


