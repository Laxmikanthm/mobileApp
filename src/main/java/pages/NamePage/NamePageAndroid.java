package pages.NamePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class NamePageAndroid extends  NamePage {

    public NamePageAndroid(AppiumDriver driver) {
        super(driver);
    }


    public AndroidTextBox getFirstName() throws Exception {

        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("Firstname") + "']"), "FirstName text field");

        return userNameTextbox;
    }

    public AndroidTextBox getLastName() throws Exception {

        AndroidTextBox passwordTextBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("Lastname") + "']"), "LastName text field");

        return passwordTextBox;
    }

    public AndroidButton getSave() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='SAVE']" ), "Save button");

        return button;
    }
}

