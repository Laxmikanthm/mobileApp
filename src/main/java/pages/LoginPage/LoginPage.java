package pages.LoginPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.pojos.AppUser;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.SubwayAppHomePage;
import pages.SubWayPage.SubWayPage;
import pojos.MobileUser;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class LoginPage<T extends AppiumDriver> extends MobileBasePage {
    public LoginPage(AppiumDriver driver){
        super(driver);
    }
    AppUser appUser =null;

    abstract MobileTextBox getUserName() throws Exception;
    abstract PasswordTextBox getPassword() throws Exception;
    abstract MobileButton getLogin() throws Exception;

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


    public void login() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
        //mobileUser.createMobileUser(false, Country.UnitedStates);
        mobileUser.setEmailAddress("tarun.sujit@gmail.com");
        mobileUser.setPassword("Sub@1234");
        getUserName().isReady();
        getUserName().setText(mobileUser.getEmailAddress());
        getPassword().setText(mobileUser.getPassword());
        getLogin().click();

    }
    /*public LoginPage login() throws Exception {
        appUser=AppUser.createAppUser(false, Country.UnitedStates);
        //mobileUser.createMobileUser(false, Country.UnitedStates);
        appUser.setEmailAddress(appUser.getEmailAddress());
        appUser.setPassword(appUser.getPassword());
        getUserName().isReady();
        getUserName().setText(appUser.getEmailAddress());
        getPassword().setText(appUser.getPassword());
        getLogin().click();
        return LoginPage.get((AppiumDriver) driver);

    }*/
}
