package myLoyaltyTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.ManageRewardsPage.ManageRewardsPage;
import pages.MenuPage.MenuPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.SearchStore.SearchStore;
import pages.UserProfilePage.UserProfilePage;
import pages.YourOrderPage.YourOrderPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by E001599 on 13-06-2017.
 */
@ContextConfiguration({ "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class Offers extends SubwayAppBaseTest {
    MobileUser mobileUser;
    RemoteOrderCustomer user;
   Store store = JdbcUtil.getStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;
    UserProfilePage userProfilePagePage;
    YourOrderPage yourOrderPage;
    ManageRewardsPage manageRewardsPage;
    MyWayRewards myWayRewards;
    LoginPage loginPage;



   //DFA-9193
    @Test
    public void redeemOffer() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
        //user=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("j0tJQ6jI7u@qasubway.com");
        mobileUser.setPassword("Subway1234");
        // user=RegisterUser.getUserWithOffers(1);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        menuPage.goHome();
       // HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore("19428");
        ordersPage.placeRandomOrderwithRedeemOffers("All Sandwiches", mobileUser, "200 W Ridge Pike");
        //need to do offers validation As we are not able place order and not displaying offers in place order page
      //  Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//tokenVerification
       // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//Order Verification
       // homePage.validateTokens(user);


    }

//DFA-9320
    @Test
    public void redeemOfferandCertificate() throws Exception {

        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.placeOrderwithRedeemOffersandCertificates("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//tokenVerification
        menuPage.assertMobileOrderHistory(ordersPage.orderValue);//Order Verification
        //need to do error log


    }
    //############################################################################################
    //DFA-9193
    @Test
    public void testRedeemOneOffer() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        //user =  RegisterUser.getUserWithOffers(1);
        user = landingPage.registerUser("StephenieLenglet@qasubway.com");
        ordersPage = landingPage.logInSelectStore(user, BaseTest.getStringfromBundleFile("StoreNumber")).goToOrderPage();
        homePage = ordersPage.placeSpecificOrderRedeemOffers(user);
        purchaseHistoryPage = homePage.assertOfferIsNotPresent().goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testOffersDisplay() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // user =   RegisterUser.getUserWithOffers(1);
        user = landingPage.registerUser("StephenieLenglet@qasubway.com");
        homePage = landingPage.logIn(user).assertOffersDisplay();
        ordersPage =  homePage.selectStore(BaseTest.getStringfromBundleFile("StoreNumber"));
        homePage.assertOffersDisplay();
        //add item to cart
        //

    }
    @Test
    public void testOffersRemoved() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // user =   RegisterUser.getUserWithOffers(1);
        user = landingPage.registerUser("StephenieLenglet@qasubway.com");
        ordersPage = landingPage.logInSelectStore(user, BaseTest.getStringfromBundleFile("StoreNumber")).goToOrderPage();
        homePage.assertOffersDisplay();
        //add item to cart
        // remove offers
        //place order
        //assert offer is not redeemed

    }
    @Test
    public void testOffersAddedAfterItemAddedToCart() throws Exception {

    }
    @Test
    public void testRedeemMultipleOffers() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        //user =  RegisterUser.getUserWithOffers(1);
        user = landingPage.registerUser("StephenieLenglet@qasubway.com");
        ordersPage = landingPage.logInSelectStore(user, BaseTest.getStringfromBundleFile("StoreNumber")).goToOrderPage();
        //
    }




}
