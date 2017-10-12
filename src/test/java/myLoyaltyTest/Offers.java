package myLoyaltyTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.CountryOffer;
import enums.PaymentMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.enums.OfferPLU;
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
    RemoteOrderCustomer remoteOrderCustomer;
    Store store = JdbcUtil.getLoyaltyStoreDetails();

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


}
