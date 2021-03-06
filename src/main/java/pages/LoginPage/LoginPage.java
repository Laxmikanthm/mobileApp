package pages.LoginPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.exceptions.ControlNotReadyException;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
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
    abstract MobileTextBox getPassword() throws Exception;
    abstract MobileButton getLogin() throws Exception;
    abstract MobileButton getSignUp() throws Exception;
    abstract MobileButton getCloseBtn() throws Exception;
    abstract MobileButton getShowIcon() throws Exception;
    abstract MobileButton getAllowBtn() throws Exception;
    abstract MobileButton getForgotPassword() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {


    }
    abstract MobileButton getProfile() throws Exception;
    public static LoginPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new LoginPageIOS((IOSDriver) driver);
            case "Android":
                return new LoginPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    private void setUserName(String emailAddress) throws Exception{
        MobileTextBox userName = getUserName();
        userName.isReady();
        userName.getControl().click();
        if(driver instanceof IOSDriver) {
            getCloseBtn().click();
            userName.setText(emailAddress);
            driver.getKeyboard().pressKey(Keys.ENTER);
        }else {
            userName.setText(emailAddress);
        }
        //userName.getControl().clear();
    }

    private void setPassword(String pwd) throws Exception{
        if(driver instanceof IOSDriver) {
            getShowIcon().click();
        }
        MobileTextBox password = getPassword();
        password.isReady();
        password.getControl().click();
        password.getControl().clear();
        password.setText(pwd);
    }
    private void login() throws Exception{
        MobileButton login = getLogin();
        login.isReady();
        login.click();
    }
    public HomePage dlogin(MobileUser mobileUser) throws Exception {
        try {
            try {
                Thread.sleep(15000);
                driver.findElementByXPath("//android.widget.EditText[@resource-id='custom-signInName']");
            } catch (org.openqa.selenium.NoSuchElementException ex) {
                driver.findElementById("com.android.chrome:id/terms_accept").click();
                driver.findElementById("com.android.chrome:id/negative_button").click();
            }
            getUserName().isReady();
            getUserName().getControl().click();
            getUserName().setText(mobileUser.getEmailAddress());
            getPassword().setText(mobileUser.getPassword());
            HideKeyboard();
            getLogin().click();
        } catch (Exception ex) {
            Logz.step("Unable to Login");
            throw new Exception("unable to Login");
        }
        return HomePage.get((AppiumDriver) driver);

    }
    public HomePage login(RemoteOrderCustomer mobileUser) throws Exception {
        Logz.step("##### " + mobileUser.getEmailAddress() + " is logging in ##### ");
        try {
            if (driver instanceof AndroidDriver) {
                androidPopUpCheck();
            }
            setUserName(mobileUser.getEmailAddress());
            setPassword(mobileUser.getPassword());
            HideKeyboard();
            login();
            try {
                Thread.sleep(15000);
                getProfile().getControl().isDisplayed();
                Logz.step("User is in home page");
            } catch (Exception exs) {
                try {
                    if (driver instanceof IOSDriver) {
                        getAllowBtn().click();
                    } else {
                        getSignUp().click();
                        Logz.step("User is in home page");
                    }
                } catch (org.openqa.selenium.NoSuchElementException ex) {
                    Logz.step("Pop up is not present");
                }
            }

        } catch (Exception ex) {
            throw new Exception("Unable to Login\n" + ex.getMessage());
        }

        return HomePage.get((AppiumDriver) driver);

    }

    private void androidPopUpCheck() throws Exception{
        try {
            Thread.sleep( 30000 );
            driver.findElementByXPath( "//android.widget.EditText[@resource-id='custom-signInName']" );
            Logz.step( "Found user name" );
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            Logz.step("didnt Find user name");
            driver.findElementById("com.android.chrome:id/terms_accept").click();
            driver.findElementById("com.android.chrome:id/negative_button").click();
            Logz.step("Clicked on terms");
        }
    }

    public void HideKeyboard()
    {
        if(driver instanceof AndroidDriver) {
            AppiumDriver d = (AppiumDriver) driver;
            d.hideKeyboard();
        }
    }

    public ForgotYourPasswordPage goToForgotPasswordPage() throws Exception
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
