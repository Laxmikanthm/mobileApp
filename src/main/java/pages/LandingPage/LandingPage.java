package pages.LandingPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.LoginPage.LoginPage;
import pages.RegistrationPage.RegistrationPage;

/**
 * Created by test-user on 3/1/17.
 */
public abstract class LandingPage<T extends AppiumDriver> extends MobileBasePage {

    public LandingPage(T driver) throws Exception {
        super(driver);
       // Thread.sleep(15000);
        //skip();
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    /*public static LandingPage get(AppiumDriver driver) throws Exception {

      String platform = driver.getCapabilities().getCapability("mobilePlatform").toString();

       switch (platform) {
            case "iOS":
                return new LandingPageIOS((IOSDriver) driver);
           case "Android":
                return new LandingPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform)
                        }
    }*/
    
    abstract MobileButton getLoginButton() throws Exception;
    abstract MobileButton getRegistrationButton() throws Exception;
    abstract MobileButton getSkipButton() throws Exception;

    public LoginPage gotoLogInPage() throws Exception {
        try {
            skip();
            this.getLoginButton().click();
            return LoginPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public RegistrationPage gotoRegistrationPage() throws Exception {
        getRegistrationButton().click();
        return RegistrationPage.get((AppiumDriver) driver);
    }

    public void skip() throws Exception

    {
        getSkipButton().click();
    }
    public static Class getLandingPageClass(){

        String mobilePlatform = System.getProperty("mobilePlatform");

        if(mobilePlatform.equalsIgnoreCase("IOS")) {
            return LandingPageIOS.class;
        }else
            return LandingPageAndroid.class;
    }
}
