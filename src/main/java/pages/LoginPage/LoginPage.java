package pages.LoginPage;

import base.gui.controls.exceptions.ControlNotReadyException;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pojos.user.MobileUser;
import utils.Logz;

import java.util.NoSuchElementException;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class LoginPage<T extends AppiumDriver> extends MobileBasePage {
    public LoginPage(AppiumDriver driver){
        super(driver);
    }
    abstract MobileTextBox getUserName() throws Exception;
    abstract PasswordTextBox getPassword() throws Exception;
    abstract MobileButton getLogin() throws Exception;
    abstract MobileButton getForgotPassword() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {


    }

    public static LoginPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new LoginPageIOS((IOSDriver) driver);
            case "Android":
                return new LoginPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }


    public HomePage login(MobileUser mobileUser) throws Exception {
        try {
            try {
                driver.findElementByXPath("//android.widget.EditText[@resource-id='custom-signInName']");
                getUserName().setText(mobileUser.getEmailAddress());
            }
            catch (org.openqa.selenium.NoSuchElementException ex) {
                driver.findElementById("com.android.chrome:id/terms_accept").click();
                driver.findElementById("com.android.chrome:id/negative_button").click();
                getUserName().setText(mobileUser.getEmailAddress());
            }
            getPassword().isReady();
            getPassword().setText(mobileUser.getPassword());
            HideKeyboard();
            getLogin().click();
        }catch (Exception ex){
            Logz.step("Unable to Login");
            throw new Exception("unable to Login");
        }
        return HomePage.get((AppiumDriver) driver);

    }


    public void HideKeyboard()
    {
        AppiumDriver d=(AppiumDriver) driver;
        d.hideKeyboard();
    }

    public ForgotYourPasswordPage forgotPassword() throws Exception
    {
        try{
            getForgotPassword().waitForClickable();
            getForgotPassword().click();

            return ForgotYourPasswordPage.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }


    }

    public HomePage loginAfterResetPassoword(MobileUser mobileUser) throws Exception {
        try {
            getUserName().setText(mobileUser.getEmailAddress());
            getPassword().isReady();
            getPassword().setText(mobileUser.getPassword());
            HideKeyboard();
            getPassword().isReady();
            getPassword().getControl().getLocation();
            getLogin().waitForClickable();
            getLogin().click();
            return HomePage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }
}
