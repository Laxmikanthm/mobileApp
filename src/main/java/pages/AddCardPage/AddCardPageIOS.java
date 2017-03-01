package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class AddCardPageIOS extends AddCardPage {

 public AddCardPageIOS(IOSDriver driver){ super(driver);}

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
    public IOSButton getSavePaymentMethod() throws Exception {

        IOSButton savePaymentMethod = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogoutBtn") + "']"), "");

        return savePaymentMethod;
    }
}
