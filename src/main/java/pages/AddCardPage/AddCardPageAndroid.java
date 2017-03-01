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

        AndroidTextBox cardNumberInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return cardNumberInputBox;
    }
    public AndroidTextBox getNameOnCard() throws Exception {

        AndroidTextBox nameOnCardInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return nameOnCardInputBox;
    }
    public AndroidTextBox getExpiresOn() throws Exception {

        AndroidTextBox expiresOnInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return expiresOnInputBox;
    }
    public AndroidTextBox getCCV() throws Exception {

        AndroidTextBox cCVInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return cCVInputBox;
    }

    public AndroidTextBox getPin() throws Exception {

        AndroidTextBox pinInputBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return pinInputBox;
    }
    public AndroidButton getNextButton() throws Exception {

        AndroidButton nextButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return nextButton;
    }
    public AndroidButton getSavePaymentMethod() throws Exception {

        AndroidButton savePaymentMethodButtoon = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return savePaymentMethodButtoon;
    }
}
