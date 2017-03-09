package pages.PaymentMethodsPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ContactInformationPage.ContactInformationPageAndroid;
import pages.ContactInformationPage.ContactInformationPageIOS;

/**
 * Created by e002243 on 01-03-2017.
 */
public class PaymentMethodsPageAndroid extends  PaymentMethodsPage{

    public PaymentMethodsPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }


    public AndroidButton getAddPaymentMethod() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("AddPaymentMethod") + "']"), "");

        return button;
    }
}
