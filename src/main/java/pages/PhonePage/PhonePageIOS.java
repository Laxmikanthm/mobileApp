package pages.PhonePage;


import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class PhonePageIOS extends  PhonePage{

    public PhonePageIOS(IOSDriver driver){
        super(driver);
    }

    public IOSTextBox getPhoneNumber() throws Exception {

        IOSTextBox phoneNumberTextBox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("Password")+"']"), "password text field");

        return phoneNumberTextBox;
    }

    public IOSButton getSave() throws Exception {

        IOSButton savebutton = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+BaseTest.bundle.getString("Login")+"']"), "Login button");

        return savebutton;
    }
}

