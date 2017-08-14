package pages.LandingPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import enums.PaymentMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import utils.Logz;

/**
 * Created by test-user on 3/1/17.
 */
public abstract class LandingPage<T extends AppiumDriver> extends MobileBasePage {

    public LandingPage(T driver) throws Exception {
        super(driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static LandingPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("mobilePlatform").toString();

        switch (platform) {
            case "iOS":
                return new LandingPageIOS((IOSDriver) driver);
            case "Android":
                return new LandingPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    abstract MobileButton getLoginButton() throws Exception;

    abstract MobileButton getRegistrationButton() throws Exception;

    abstract MobileButton getSkipButton() throws Exception;

    public LoginPage gotoLogInPage() throws Exception {
        try {
            driver.findElementById("signIn");

                   } catch (Exception ex) {
            getSkipButton().click();
            Logz.error("Skip button clicked");

        }
        this.getLoginButton().click();
        return LoginPage.get((AppiumDriver) driver);
    }


    public RegistrationPage gotoRegistrationPage() throws Exception {

        getRegistrationButton().click();
        return RegistrationPage.get((AppiumDriver) driver);
    }

    public void skip() throws Exception

    {
        getSkipButton().click();
    }

    public static Class getLandingPageClass() {

        String mobilePlatform = System.getProperty("mobilePlatform");

        if (mobilePlatform.equalsIgnoreCase("IOS")) {
            return LandingPageIOS.class;
        } else
            return LandingPageAndroid.class;
    }

    public HomePage getUserLoginAndAddingCard(MobileUser mobileUser, PaymentMethod paymentType) throws Exception {
        try {
            LoginPage loginPage = gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
            addCardPage.addPayment(mobileUser, paymentType);
            addCardPage.selectBackButton();
            menuPage.goHome();

        } catch (Exception ex) {
            getSkipButton().click();
            Logz.error("Skip button clicked");
        }
        return HomePage.get((AppiumDriver) driver);
    }

}

