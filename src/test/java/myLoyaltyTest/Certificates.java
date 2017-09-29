package myLoyaltyTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.CartData;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by E001599 on 29-05-2017.
 */
public class Certificates extends SubwayAppBaseTest {

    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;
   Store store = JdbcUtil.getLoyaltyStoreDetails();
    //Store store;

//DFA-9188
    @Test
    public void redeemCertificate_9188() throws Exception {
        mobileUser= new MobileUser(false, Country.UnitedStates, store.getLocationCode());
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

        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
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
    //DFA-5049
    @Test
    public void redeemMultipleCertificate_5049() throws Exception {

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
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating myLoyaltyTest.Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
       // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history
    }

    ///DFA-9167`
    @Test
    public void redeemExpiredCertificate_9167() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
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
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating myLoyaltyTest.Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        //menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }
}
