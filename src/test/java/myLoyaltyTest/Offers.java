package myLoyaltyTest;

import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
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
import pages.UserProfilePage.UserProfilePage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.SearchStore.SearchStore;
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
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;


   /* @BeforeClass
    public MobileUser init() throws Exception {
        mobileUser=setCountryName();
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser=landingPage.registerOfferUser(mobileUser);
        return mobileUser;

    }*/



//DFA-9193
    @Test
    public void redeemOffer() throws Exception {
        mobileUser=setCountryName();
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        //mobileUser=landingPage.registerOfferUser(mobileUser);
        mobileUser.setEmailAddress("GradyWilliscroft@qasubway.com");
        mobileUser.setPassword("Subway1234");
        OrdersPage ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.placeRandomOrderwithRedeemOffers("Sides", mobileUser, store.getAddress1());
        //need to do offers validation As we are not able place order and not displaying offers in place order page
      //  Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//tokenVerification
       // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//Order Verification
       // homePage.validateTokens(remoteOrderCustomer);


    }

//DFA-9320
    @Test
    public void redeemOfferandCertificate() throws Exception {

        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        userProfilePage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.placeOrderwithRedeemOffersandCertificates("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//tokenVerification
        userProfilePage.assertMobileOrderHistory(ordersPage.orderValue);//Order Verification
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
        homePage = ordersPage.placeSpecificOrderRedeemOffers(mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG);
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
