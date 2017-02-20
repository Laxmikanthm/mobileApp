package pages.NamePage;

import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class NamePageIOS extends NamePage {

    public NamePageIOS(IOSDriver driver){
        super(driver);
    }


    public IOSTextBox getFirstName() throws Exception {

        IOSTextBox firstName = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("UserName")+"']"), "username text field");

        return firstName;
    }

    public IOSTextBox getLastName() throws Exception {

        IOSTextBox lastName = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Password")+"']"), "password text field");

        return lastName;
    }

    public IOSButton getSave() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSTextBox getPhoneNumber() throws Exception {

        IOSTextBox phoneNumberTextBox = new IOSTextBox((IOSDriver) driver, By.xpath("//*[@content-desc='"+BaseTest.bundle.getString("Login")+"']"), "Login button");

        return phoneNumberTextBox;
    }
}