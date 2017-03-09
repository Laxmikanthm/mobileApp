package pages.ChoosePaymentMethodPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 01-03-2017.
 */
public class ChoosePaymentMethodPageAndroid extends  ChoosePaymentMethodPage {

    public ChoosePaymentMethodPageAndroid(AndroidDriver driver){ super(driver); }
    public AndroidButton getCreditCard() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("CreditCard") + "']"), "Credit Card Button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("CreditCard")+"']"), "Credit Card button");

        return button;
    }
    public AndroidButton getDebitCard() throws Exception {

        //AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("DebitCard") + "']"), "DebitCard button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='Debit Card']"), "DebitCard button");

        return button;
    }

    public AndroidButton getGiftCard() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("GiftCard") + "']"), "GiftCard button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='Gift Card']"), "GiftCard button");

        return button;
    }

    public AndroidButton getPayPal() throws Exception {

       // AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("PayPal") + "']"), "PayPal button");
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("PayPal")+"']"), "PayPal button");


        return button;
    }
}
