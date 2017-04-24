package pages.PayPalPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 08-03-2017.
 */
public class PayPalPageAndroid extends PayPalPage {

    PayPalPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }

    public AndroidTextBox getPaypalUserName() throws Exception {
        AndroidTextBox userNameTextbox = new AndroidTextBox ((AndroidDriver) driver, By.xpath("//android.view.View[@resource-id='"+BaseTest.bundle.getString("PayPalEmail")+"']"), "PayPal email" );
        return userNameTextbox;
    }

    public AndroidTextBox getPaypalUname() throws Exception {
        AndroidTextBox userNameTextbox = new AndroidTextBox ((AndroidDriver) driver, By.id(BaseTest.bundle.getString("PaypalUname")), "PaypalUserName field");
        return userNameTextbox;
    }

    public AndroidTextBox getPaypalPassword() throws Exception {
        AndroidTextBox passwordTextBox = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.view.View[@resource-id='"+BaseTest.bundle.getString("PayPalPassword")+"']"), "PayPal password");
        return passwordTextBox;
    }

    public AndroidTextBox getPaypalPwd() throws Exception {
        AndroidTextBox passwordTextBox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("PaypalPwd")), "PaypalPwd field");
        return passwordTextBox;
    }

    public AndroidButton getLogIn() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("PayPalLogin")+"']"), "PayPal login" );
        return button;
    }
    public AndroidButton getAgreeAndContinue() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("AgreeBtn")), "AgreeAndContinue button");
        return button;
    }

    public MobileLabel getPayWith() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("PayWithLabel")), "PayWithLabel Label");
        return items;
    }


}
