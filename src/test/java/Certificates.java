import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.CartData;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import kobieApi.pojos.Loyalty;
import kobieApi.pojos.SaleTerminal;
import kobieApi.pojos.Summaries;
import kobieApi.serviceUtils.Kobie;
import kobieApi.serviceUtils.KobieClient;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

import java.util.List;

/**
 * Created by E001599 on 29-05-2017.
 */
public class Certificates extends SubwayAppBaseTest {

    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;
    Store store = JdbcUtil.getStoreDetails();
    //Store store;
    String country = SubwayAppBaseTest.countryName;

//DFA-9188_ DFA-10892
    @Test
    public void redeemCertificate() throws Exception {
        if(country.equalsIgnoreCase("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }else{
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrderCustomer=remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        remoteOrderCustomer=myWayRewards.validateTokensandCerts(homePage,remoteOrderCustomer);
        homePage.certsCount();
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        CartData.createNewCart(remoteOrderCustomer,store.getLocationCode());
        ordersPage.placeRandomOrderwithRedeemCertificate("All Sandwiches",mobileUser, store.getAddress1());
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certCount);
        //Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        //menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }
    @Test
    public void verifyCertificate() throws Exception {

        if(country.equalsIgnoreCase("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }else{
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.validateTokensandCerts(homePage,remoteOrderCustomer);


    }
    //DFA-9167_DFA-5049
    @Test
    public void redeemMultipleCertificate() throws Exception {
        if(country.equalsIgnoreCase("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }else{
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        mobileUser.setEmailAddress("test4_may15_2017@mailinator.com");//user who is having multiple certificates
        mobileUser.setPassword("Subway2017");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrderCustomer=remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        homePage.validateCertificate(remoteOrderCustomer);
        homePage.validateTokens(remoteOrderCustomer);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithRedeemMultipleCertificate("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
       // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history
    }

    ///DFA-9167`
    @Test
    public void redeemExpiredCertificate() throws Exception{
        if(country.equalsIgnoreCase("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }else{
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        homePage.validateCertificate(remoteOrderCustomer);
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certsCount());
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithExpiredCertificate("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        //menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }

    @Test
    public void storeSearchForCanada() throws Exception {
        if(country.equalsIgnoreCase("US")) {
            mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        }else{
            mobileUser = new MobileUser(false, Country.Canada, store.getLocationCode());
        }
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrderCustomer=remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        remoteOrderCustomer=myWayRewards.validateTokensandCerts(homePage,remoteOrderCustomer);
        homePage.certsCount();
        OrdersPage ordersPage=homePage.findYourStore(store);
        ordersPage.placeRandomOrderwithRedeemCertificate("All Sandwiches",mobileUser, store.getAddress1());
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certCount);

    }
}
