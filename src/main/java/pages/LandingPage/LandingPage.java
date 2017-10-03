package pages.LandingPage;

import Base.SubwayAppBaseTest;
import azureApi.serviceUtils.AzureClient;
import azureApi.serviceUtils.AzureIdentityApi;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import enums.Country;
import enums.PaymentMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import pojos.user.WebUser;
import util.MobileApi;
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

        String platform = SubwayAppBaseTest.platformName;

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
        //this.getLoginButton().click();
        driver.findElementById("signIn").click();
        Logz.step("##### going to login page ##### ");
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

            try {
                getSkipButton().click();
            } catch (Exception e) {
                Logz.error("Skip button not ready");
            }


        }
        return HomePage.get((AppiumDriver) driver);
    }

    public MobileUser registerUser() throws Exception {

        return RegisterUser.registerAUserWithoutCardLink(new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber"))));//JdbcUtil.getOnlineStore()));////
    }

    public RemoteOrderCustomer registerUser(String email) throws Exception {
        RemoteOrderCustomer user = new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber")));
        user.setEmailAddress(email);
        String[] nameSplit = email.split("(?=\\p{Upper})");
        user.setFirstName(nameSplit[0]);
        user.setLastName(nameSplit[1].replaceAll("@qasubway.com", ""));
        String objectId = AzureIdentityApi.getUserFromAzure(AzureClient.getAzureAccessToken(), email);
        if (objectId == null) {
            return RegisterUser.registerAUserWithoutCardLink(user);
        } else {
            user.getReltioAuthorizationToken();
            return user;
        }
    }

    public RemoteOrderCustomer getUser() throws Exception {
        RemoteOrderCustomer mobileUser = new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber")));//JdbcUtil.getOnlineStore()));////
        mobileUser.setEmailAddress(mobileUser.getFirstName() + mobileUser.getLastName() + "@qasubway.com");
        return mobileUser;
    }
//logIn

    public HomePage logInAddCreditCard(RemoteOrderCustomer mobileUser) throws Exception {
        LoginPage loginPage = gotoLogInPage();
        loginPage.login(mobileUser);
      //  MobileApi.addCreditCard(mobileUser);
        return HomePage.get((AppiumDriver) driver);
    }

    public OrdersPage logInSelectStore(RemoteOrderCustomer mobileUser, String zipCode) throws Exception {
        try {
            LoginPage loginPage = gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            //HomePage homePage = logInAddCreditCard(mobileUser);
            homePage.selectStore(zipCode).goToOrderPage();
        } catch (Exception ex) {
            throw new Exception("Unable to assert user email in menu page\n" + ex.getMessage());
        }
        return OrdersPage.get((AndroidDriver) driver);
    }
}

