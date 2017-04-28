package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class AddCardPageIOS extends AddCardPage {

 public AddCardPageIOS(IOSDriver driver){ super(driver);}

    public MobileButton getAddPaymentMethod() throws Exception {

        IOSButton addPaymentMethodButton = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return addPaymentMethodButton;
    }

    public IOSTextBox getCardNumber() throws Exception {

        IOSTextBox cardNumberInputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return cardNumberInputBox;
    }
    public IOSTextBox getExpiresOn() throws Exception {

        IOSTextBox expiresOnInputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return expiresOnInputBox;
    }
    public IOSTextBox getCCV() throws Exception {

        IOSTextBox cardNumberInputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return cardNumberInputBox;
    }
    public IOSTextBox getNameOnCard() throws Exception {

        IOSTextBox cCVInputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return cCVInputBox;
    }

    public IOSTextBox getPin() throws Exception {

        IOSTextBox pinInputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return pinInputBox;
    }
    public IOSButton getNextButton() throws Exception {

        IOSButton nextButton = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return nextButton;
    }

    public IOSTextBox getBillingStreetAddress() throws Exception {

        IOSTextBox InputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return InputBox;
    }

    public IOSTextBox getBillingZipCode() throws Exception {

        IOSTextBox InputBox = new IOSTextBox((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return InputBox;
    }

    public IOSButton getReviewDetails() throws Exception {

        IOSButton reviewButton = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return reviewButton;
    }

    public IOSButton getSavePaymentMethod() throws Exception {

        IOSButton savePaymentMethod = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return savePaymentMethod;
    }

    public IOSButton getGiftCardSavePayment() throws Exception {

        IOSButton savePaymentMethod = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return savePaymentMethod;
    }

    public IOSButton getBackButton() throws Exception {

        IOSButton backButton = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return backButton;
    }

    public MobileLabel getCreditCardType() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileLabel getDebitCardType() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileLabel getGiftCardType() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileLabel getPayPalType() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

}
