package pages.PhonePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class PhonePageAndroid extends  PhonePage {

    public PhonePageAndroid(AndroidDriver driver){
        super(driver);
    }

    public AndroidPasswordTextBox getPhoneNumber() throws Exception {
        AndroidPasswordTextBox phoneNumberTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@resource-id='"+ BaseTest.bundle.getString("PhoneNumber")+"']"), "Phone Number field");
        return phoneNumberTextBox;
    }

    public AndroidButton getSave() throws Exception {
        AndroidButton savebutton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("Save") + "']"), "Save button");
        return savebutton;
    }
}

