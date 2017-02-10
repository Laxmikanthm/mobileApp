package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class SubwayAppHomePage<T extends AppiumDriver> extends MobileBasePage{

    public SubwayAppHomePage(AppiumDriver driver) {
        super(driver);
    }

    abstract MobileButton getLoginButton() throws Exception;
    abstract MobileButton getRegistrationButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public LoginPage gotoLogInPage() throws Exception {
        try{
            this.getLoginButton().click();
            return LoginPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public RegistrationPage gotoRegistrationPage() throws Exception {
        getRegistrationButton().click();
        return RegistrationPage.get((AppiumDriver)driver);
    }

    public static Class getHomepageClass(){

        String mobilePlatform = "Android";

        if(mobilePlatform.equalsIgnoreCase("IOS")) {
            return HomePageIOS.class;
        }else
            return HomePageAndroid.class;
    }
}
