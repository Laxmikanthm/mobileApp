package pages.LandingPage;

import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import azureApi.serviceUtils.AzureClient;
import azureApi.serviceUtils.AzureIdentityApi;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.LocationData;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.ProductGroup;
import enums.Country;
import enums.CountryOffer;
import enums.PaymentMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.RegistrationPage.RegistrationPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.RemoteOrder;
import pojos.enums.OfferPLU;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;
import utils.Logz;

import java.util.List;

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
            getLoginButton();
        } catch (Exception ex) {
            if (driver instanceof IOSDriver) {
                driver.switchTo().alert().accept(); // Accept Notification permission
            }
            getSkipButton().click();
            Logz.error("Skip button clicked");
        }
        //this.getLoginButton().click();
        getLoginButton().click();
        Logz.step("##### Navigating to login page .......##### ");
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
            /*MenuPage menuPage = homePage.getUserDetails();
            AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
            addCardPage.addPayment(mobileUser, paymentType);
            addCardPage.selectBackButton();
            menuPage.goHome();*/
            pojos.tenders.CreditCard creditCard = new pojos.tenders.CreditCard();
            creditCard.addGuestCreditPayment(mobileUser);
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
        if (System.getProperty("country").contains("US")) {
            return RegisterUser.registerAUserWithoutCardLink(new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber"))));//JdbcUtil.getOnlineStore()));////

        } else {
            return RegisterUser.registerAUserWithoutCardLink(new MobileUser(false, Country.Canada, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber"))));//JdbcUtil.getOnlineStore()));////

        }
    }

    public MobileUser registerOfferUser(MobileUser mobileUser) throws Exception {
        RemoteOrderCustomer remoteOrderCustomer;
        if (System.getProperty("country").contains("US")) {
            //remoteOrderCustomer= RegisterUser.getUserWithOffers(1, CountryOffer.US, OfferPLU.US_FREE_BAG_OF_CHIPS.getValue());
            mobileUser.setEmailAddress("GradyWilliscroft@qasubway.com");
            mobileUser.setPassword("Subway1234");
        } else {
            remoteOrderCustomer = RegisterUser.getUserWithOffers(1, CountryOffer.US, OfferPLU.US_FREE_BAG_OF_CHIPS.getValue());
        }
        return mobileUser;
    }

    public MobileUser registerUser(String email) throws Exception {
        MobileUser user = new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber")));
        user.setEmailAddress(email);
        String[] nameSplit = email.split("(?=\\p{Upper})");
        user.setFirstName(nameSplit[0]);
        user.setLastName(nameSplit[1].replaceAll("@qasubway.com", ""));
        String objectId = AzureIdentityApi.getUserFromAzure(AzureClient.getAzureAccessToken(), email);
        if (objectId == null) {
            if (System.getProperty("country").contains("US")) {
                return RegisterUser.registerAUserWithoutCardLink(new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber"))));//JdbcUtil.getOnlineStore()));////

            } else {
                return RegisterUser.registerAUserWithoutCardLink(new MobileUser(false, Country.Canada, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber"))));//JdbcUtil.getOnlineStore()));////

            }
        } else {
            user.getReltioAuthorizationToken();
            return user;
        }
    }

    public MobileUser getUser() throws Exception {
        MobileUser mobileUser;
        if (System.getProperty("country").contains("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber")));//JdbcUtil.getOnlineStore()));////
        } else {
            mobileUser = new MobileUser(false, Country.Canada, Integer.valueOf(BaseTest.getStringfromBundleFile("StoreNumber")));//JdbcUtil.getOnlineStore()));////

        }
        mobileUser.setEmailAddress(mobileUser.getFirstName() + mobileUser.getLastName() + "@qasubway.com");
        return mobileUser;
    }
//logIn

    public HomePage logInAddCreditCard(RemoteOrderCustomer mobileUser) throws Exception {
        LoginPage loginPage = gotoLogInPage();
        loginPage.login(mobileUser);
        MobileApi.addCreditCard(mobileUser);
        return HomePage.get((AppiumDriver) driver);
    }

    public HomePage logInSelectStore(RemoteOrderCustomer mobileUser, Store store) throws Exception {
        try {
            mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
            HomePage homePage = logInAddCreditCard(mobileUser);
            homePage.selectStore(store);
        } catch (Exception ex) {
            throw new Exception("Unable to log In and Select Store \n" + ex.getMessage());
        }
        return HomePage.get((AndroidDriver) driver);
    }

    public HomePage logInSelectStore(RemoteOrderCustomer mobileUser, String store) throws Exception {
        try {
            LoginPage loginPage = gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);

            // HomePage homePage = logInAddCreditCard(mobileUser);
            homePage.selectStore(store);
        } catch (Exception ex) {
            throw new Exception("Unable to log In and Select Store \n" + ex.getMessage());
        }
        return HomePage.get((AndroidDriver) driver);
    }

    public HomePage logIn(RemoteOrderCustomer mobileUser) throws Exception {
        try {
            LoginPage loginPage = gotoLogInPage();
            loginPage.login(mobileUser);
        } catch (Exception ex) {
            throw new Exception("Unable to log In and Select Store \n" + ex.getMessage());
        }
        return HomePage.get((AndroidDriver) driver);
    }
    public MobileUser addFavouriteOrderThroughApi(OrdersPage ordersPage)throws Exception
    {
        MobileUser mobileUser = registerUser();
        MobileApi.addFavorite(mobileUser);

        return  mobileUser;
    }

    public void placeDefaultOrderThenAssert(String menuCategories, BreadSize breadSize, Store store) throws Exception {
        MobileUser mobileUser = registerUser();
        mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
        List<ProductGroup> productGroups = LocationData.getStoreMenu(mobileUser, mobileUser.getStoreID());
        logAllMenuCategoriesName(productGroups, store);
        for (ProductGroup productGroup : productGroups) {
            if (productGroup.getName().contains(menuCategories)) {
                OrdersPage ordersPage = logInSelectStore(mobileUser, store).goToOrderPage();
                ordersPage.placeDefaultOrder(mobileUser,menuCategories,breadSize, store);
            }else {
            Logz.step("##### Product menu: " + menuCategories + " is not present at this store: " + store.getStoreNumber() + " #####");
        }
        }


    }
    public void placeCustomizedOrderThenAssert(String menuCategories, BreadSize breadSize, Store store) throws Exception {
        MobileUser mobileUser = registerUser();//"OatesJodlkowski@qasubway.com"
        mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
        List<ProductGroup> productGroups = LocationData.getStoreMenu(mobileUser, mobileUser.getStoreID());
        logAllMenuCategoriesName(productGroups, store);
        for (ProductGroup productGroup : productGroups) {
            if (productGroup.getName().contains(menuCategories)) {
                OrdersPage ordersPage = logInSelectStore(mobileUser, store).goToOrderPage();
                ordersPage.placeCustomizedOrder(mobileUser,menuCategories,breadSize, store);
            }
        }


    }

    public void placeFavouriteOrderThenAssert(String menuCategories, BreadSize breadSize, Store store) throws Exception {
        MobileUser mobileUser = registerUser();
        mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
        List<ProductGroup> productGroups = LocationData.getStoreMenu(mobileUser, mobileUser.getStoreID());
        logAllMenuCategoriesName(productGroups, store);
        for (ProductGroup productGroup : productGroups) {
            if (productGroup.getName().contains(menuCategories)) {
                OrdersPage ordersPage = logInSelectStore(mobileUser, store).goToOrderPage();
                ordersPage.placeFavouriteOrder(mobileUser,menuCategories,breadSize, store);
            }else {
                Logz.step("##### Product menu: " + menuCategories + " is not present at this store: " + store.getStoreNumber() + " #####");
            }
        }


    }
    public void placeFavouriteReOrderThenAssert(MobileUser mobileUser, Store store) throws Exception {
                mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
                OrdersPage ordersPage = logInSelectStore(mobileUser, store).goToOrderPage();
                ordersPage.placeFavouriteReOrder(mobileUser);

        }
    public void placeUnFavouriteOrderThenAssert(MobileUser mobileUser, Store store) throws Exception {
        mobileUser.setStoreID(Integer.parseInt(store.getStoreNumber()));
        OrdersPage ordersPage = logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.removeFavouriteOrder(mobileUser);

    }

    private void logAllMenuCategoriesName(List<ProductGroup> productGroups, Store store) throws Exception{
        for (ProductGroup productGroup : productGroups) {
            Logz.step("##### Product menu category name: " + productGroup.getName() + "  Store: " + store.getStoreNumber() + " #####");
        }

    }
}

