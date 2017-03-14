package pages.AddCardPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class AddCardPageAndroid extends  AddCardPage {

    public AddCardPageAndroid(AndroidDriver driver){super(driver);}

    public AndroidTextBox getCardNumber() throws Exception {

       // AndroidTextBox cardNumberInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("CardNumber")+"']"), "CardNumber field");
        AndroidTextBox cardNumberInputBox = new AndroidTextBox((AndroidDriver) driver, By.id("card_number"), "Card Number field");

        return cardNumberInputBox;
    }
    public AndroidTextBox getNameOnCard() throws Exception {

        //AndroidTextBox nameOnCardInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("NameOnCard")+"']"), "NameOnCard field");
        AndroidTextBox nameOnCardInputBox = new AndroidTextBox((AndroidDriver) driver, By.id("full_name"), "Full Name field");

        return nameOnCardInputBox;
    }

    public AndroidTextBox getCCV() throws Exception {

        //AndroidTextBox cCVInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("CCV")+"']"), "CCV field");
        AndroidTextBox cCVInputBox = new AndroidTextBox((AndroidDriver) driver, By.id("ccv"), "CCV field");

        return cCVInputBox;
    }

    public AndroidTextBox getExpiresOn() throws Exception {

        //AndroidTextBox expiresOnInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("ExpiresOn") + "']"), "ExpiresOn field");
        AndroidTextBox expiresOnInputBox = new AndroidTextBox((AndroidDriver) driver, By.id("expiration"), "ExpiresOn field");

        return expiresOnInputBox;
    }

    public AndroidTextBox getBillingStreetAddress() throws Exception {

        //AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("BillingStreetAddress")+"']"), "BillingStreetAddress field");
        AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.id("address"), "BillingStreetAddress field");

        return InputBox;
    }

    public AndroidTextBox getBillingZipCode() throws Exception {

        //AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("BillingZipCode")+"']"), "BillingZipCode field");
        AndroidTextBox InputBox = new AndroidTextBox((AndroidDriver) driver, By.id("zip"), "BillingZipCode field");

        return InputBox;
    }

    public AndroidTextBox getPin() throws Exception {

        //AndroidTextBox pinInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Pin")+"']"), "Pin field");
        AndroidTextBox pinInputBox = new AndroidTextBox((AndroidDriver) driver, By.id("pin"), "Pin field");

        return pinInputBox;
    }
    public AndroidButton getNextButton() throws Exception {

        //AndroidButton nextButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("NextButton") + "']"), "Next Button");
        AndroidButton nextButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("Next")+"']"), "Next Button");

        return nextButton;
    }

    public AndroidButton getReviewDetails() throws Exception {

        //AndroidButton reviewButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("ReviewDetails") + "']"), "ReviewDetails Button");
        AndroidButton reviewButton = new AndroidButton((AndroidDriver) driver, By.id("review_details"), "ReviewDetails Button");

        return reviewButton;
    }

    public AndroidButton getSavePaymentMethod() throws Exception {

       // AndroidButton savePaymentMethodButtoon = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SavePaymentMethod") + "']"), "SavePaymentMethod button");
        AndroidButton savePaymentMethodButtoon = new AndroidButton((AndroidDriver) driver, By.id("summary_save_payment"), "ReviewDetails Button");

        return savePaymentMethodButtoon;
    }

    public AndroidButton getGiftCardSavePayment() throws Exception {

        // AndroidButton savePaymentMethodButtoon = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SavePaymentMethod") + "']"), "SavePaymentMethod button");
        AndroidButton savePaymentButtoon = new AndroidButton((AndroidDriver) driver, By.id("save_button"), "ReviewDetails Button");

        return savePaymentButtoon;
    }
}
