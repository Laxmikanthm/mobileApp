package pages.ContactInformationPage;

        import base.gui.controls.mobile.android.AndroidButton;
        import base.gui.controls.mobile.ios.IOSButton;
        import base.test.BaseTest;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.ios.IOSDriver;
        import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class ContactInformationPageIOS extends ContactInformationPage {

    public ContactInformationPageIOS(IOSDriver driver){
        super(driver);
    }


    public IOSButton getName() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public IOSButton getPassWord() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public IOSButton getPhone() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public IOSButton getBackButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }



}
