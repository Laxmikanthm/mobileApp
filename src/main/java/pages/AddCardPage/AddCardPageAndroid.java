package pages.AddCardPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class AddCardPageAndroid extends  AddCardPage {

    public AddCardPageAndroid(AndroidDriver driver){super(driver);}
    public AndroidButton getAddPaymentMethod() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("AddPaymet")), "AddPaymentMethod Button");
        return button;
    }

    public AndroidTextBox getCardNumber() throws Exception {
        AndroidTextBox cardNumberInputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("CardNumber")), "CardNumber field");
        return cardNumberInputBox;
    }
    public AndroidTextBox getNameOnCard() throws Exception {
        AndroidTextBox nameOnCardInputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("NameOnCard")), "NameOnCard field");
        return nameOnCardInputBox;
    }

    public AndroidTextBox getCCV() throws Exception {
        AndroidTextBox cCVInputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("CCV")), "CCV field");
        return cCVInputBox;
    }

    public AndroidTextBox getExpiresOn() throws Exception {
        AndroidTextBox expiresOnInputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("ExpiresOn")), "ExpiresOn field");
        return expiresOnInputBox;
    }

    public AndroidTextBox getBillingStreetAddress() throws Exception {
        AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("BillingStreetAddress")), "BillingStreetAddress field");
        return InputBox;
    }

    public AndroidTextBox getBillingZipCode() throws Exception {
        AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("BillingZipCode")), "BillingZipCode field");
        return InputBox;
    }

    public AndroidTextBox getPin() throws Exception {
        AndroidTextBox pinInputBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("Pin")), "Pin field");
        return pinInputBox;
    }
    public AndroidButton getNextButton() throws Exception {
        AndroidButton nextButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("Next")+"']"), "Next Button");
        return nextButton;
    }

    public AndroidButton getReviewDetails() throws Exception {
        AndroidButton reviewButton = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("ReviewDetails")), "ReviewDetails field");
        return reviewButton;
    }

    public AndroidButton getSavePaymentMethod() throws Exception {
        AndroidButton savePaymentMethodButtoon = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("SavePaymentMethod")), "SavePaymentMethod field");
        return savePaymentMethodButtoon;
    }

    public AndroidButton getGiftCardSavePayment() throws Exception {
        AndroidButton savePaymentButtoon = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("SavePaymentForGiftCard")), "SavePaymentForGiftCard field");
        return savePaymentButtoon;
    }

    public AndroidButton getBackButton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("Backbutton")), "Back button");
        return button;
    }

    public MobileLabel getCreditCardType() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Creditcard")+"']"), "Credit Card Label");
        return items;
    }

    public MobileLabel getDebitCardType() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Debitcard")+"']"), "Debit Card Label");
        return items;
    }

    public MobileLabel getGiftCardType() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("SubwayCard")+"']"), "Subway Card Label");
        return items;
    }

    public MobileLabel getPayPalType() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("PaypalCard")+"']"), "Paypal Card Label");
        return items;
    }
}
