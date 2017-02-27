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

        //AndroidPasswordTextBox phoneNumberTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("PhoneNumber")+"']"), "PhoneNumber text field");

        AndroidPasswordTextBox phoneNumberTextBox = new AndroidPasswordTextBox((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/phone"), "UserProfile button");
        return phoneNumberTextBox;
    }

    public AndroidButton getSave() throws Exception {

       // AndroidButton savebutton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("Save")+"']"), "Save button");

        AndroidButton savebutton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='SAVE']" ), "Save button");

        return savebutton;
    }
}

