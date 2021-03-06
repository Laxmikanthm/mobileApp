package myLoyaltyTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.CartData;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.ManageRewardsPage.ManageRewardsPage;
import pages.UserProfilePage.UserProfilePage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.YourOrderPage.YourOrderPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;

/**
 * Created by E001599 on 29-05-2017.
 */
public class Certificates extends SubwayAppBaseTest {


    MobileUser mobileUser;
    RemoteOrderCustomer user;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;
    UserProfilePage userProfilePage;
    YourOrderPage yourOrderPage;
    ManageRewardsPage manageRewardsPage;
    MyWayRewards myWayRewards;



    //DFA-9188
    @Test
    public void redeemCertificate_9188() throws Exception {
        mobileUser = setCountryName();
        user = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        user = remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        user = myWayRewards.validateTokensandCerts(homePage, user);
        homePage.certsCount();
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        CartData.createNewCart(user, store.getLocationCode());
        ordersPage.placeRandomOrderwithRedeemCertificate("All Sandwiches", mobileUser, store.getAddress1());
        homePage.assertTokensCertificates(user);
        Assert.assertEquals(user.getLoyaltyLookup().getCertificates().getCertificateCount(), homePage.certCount);
        Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//validating tokens
        userProfilePage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }

    @Test
    public void verifyCertificate() throws Exception {

        mobileUser = setCountryName();
        user = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        myWayRewards.validateTokensandCerts(homePage, user);
        //assert zero token and no certificate in home page
        user = MobileApi.placeOrderWithNoOfToken(user, 300);
        //assert n# token and n# certificate in home page
        //assert tokens in carosule banner page*/


    }

    //DFA-5049
    @Test
    public void redeemMultipleCertificate_5049() throws Exception {

        mobileUser.setEmailAddress("test4_may15_2017@mailinator.com");//user who is having multiple certificates
        mobileUser.setPassword("Subway2017");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        user = remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(400, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        homePage.validateCertificate(user);
        homePage.validateTokens(user);
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        CartData.createNewCart(user, store.getLocationCode());
        ordersPage.placeRandomOrderwithRedeemMultipleCertificate("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards, homePage.certValue);//validating myLoyaltyTest.Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//validating tokens
        userProfilePage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history
    }

    ///DFA-9167`
    @Test
    public void redeemExpiredCertificate_9167() throws Exception {
        mobileUser = setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        homePage.validateCertificate(user);
        Assert.assertEquals(user.getLoyaltyLookup().getCertificates().getCertificateCount(), homePage.certsCount());
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithExpiredCertificate("All Sandwiches", mobileUser, store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards, homePage.certValue);//validating myLoyaltyTest.Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens), homePage.tokenValue().toString());//validating tokens
        userProfilePage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }
//##################################################################################################################
    //DFA-9188
    @Test
    public void testRedeemOneCertificate() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser();
        homePage = landingPage.logIn(user);
        homePage.assertTokensCertificates(user);
        user = MobileApi.placeOrderWithNoOfToken(user, 300);
        ordersPage = homePage.selectStore(store);
        homePage.assertTokensCertificates(user);
        ordersPage = homePage.clickOnApplyAndStartOrder();
        homePage = ordersPage.placeRandomOrderMyLoyalty(0);
        userProfilePage = homePage.assertTokensCertificates(user);
        userProfilePage = purchaseHistoryPage.assertOrderInPurchaseHostoryPage(mobileUser);

    }

    @Test
    public void testTokensCertificatesDisplayAssertion() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser();
        homePage = landingPage.logIn(user);
        homePage.assertTokensCertificates(user);
        user = MobileApi.placeOrderWithNoOfToken(user, 300);
        myWayRewards = homePage.getTokensSparkle();
        homePage.assertTokensCertificates(user);
        myWayRewards = homePage.goToMyWayRewardsPage();
        homePage = myWayRewards.assertTokensAndCertificates(user);
        ordersPage = homePage.selectStore(store);
        yourOrderPage = ordersPage.selectRandomItem();
        yourOrderPage.assertLoyaltyDisplay(1);
        manageRewardsPage = yourOrderPage.goToManageRewardPage();
        manageRewardsPage.assertRewardsList(1);
    }
    @Test
    public void testRedeemMultipleCertificates() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser();
        homePage = landingPage.logIn(user);
        homePage.assertTokensCertificates(user);
        user = MobileApi.placeOrderWithNoOfToken(user, 500);
        homePage.assertTokensCertificates(user);
        ordersPage = homePage.selectStore(store);
        homePage = ordersPage.placeRandomOrderMyLoyalty(1);
        userProfilePage = homePage.assertTokensCertificates(user);
        purchaseHistoryPage = userProfilePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);

    }
    @Test
    public void testRedeemOneCertificatesFromMultiPle() throws Exception {

        // set to get at least 2 certificates
        // click apply from home page
        // add an item to card
        // remove 1 certificate from adding to order
        //assert the total in your order page
        //place order
        //assert 1 certificate still available in home page

    }

    @Test
    public void testItemPriceLessThanRedeemCertificatesAmount() throws Exception {

        // set to get at least 3 certificates
        // click apply from home page
        // add an item to cart less than certificate amount(any sides)
        //assert the total in your order page
        //place order
        //assert is certificate still available in home page

    }
    @Test
    public void testItemPriceLessThanRedeemCertificateAmount() throws Exception {

        // set to get 1 certificates
        // click apply from home page
        // add an item to cart less than certificate amount(any sides, or drinks)
        //assert the total in your order page
        //place order
        //assert is certificate still available in home page

    }
    @Test
    public void testApplyRedeemCertificateAtEndOfOrder() throws Exception {

        // set to get 2 certificates
        // don't click apply from home page
        // add an item to cart
        //assert certificate is not applied, no option to apply certificate, and the total in your order page
        //go back, apply the certificate
        //place order
        //assert is certificate still available in home page

    }
}
