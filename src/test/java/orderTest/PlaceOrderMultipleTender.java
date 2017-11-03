package orderTest;

import Base.Order;
import Base.SubwayAppBaseTest;
import azureApi.serviceUtils.AzureIdentityApi;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.tenders.SubwayCard;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

import java.util.List;

public class PlaceOrderMultipleTender extends SubwayAppBaseTest {
    List<SubwayCard> cards =null;
    MobileUser mobileUser;
    Order order;
    Store store=JdbcUtil.getStoreDetails();


    //DFA-9175
    @Test
    @DirtiesContext
    public void addCreditCard_8818() throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        Assert.assertTrue(addCardPage.checkCreditCardElementPresence(),"Credit Card got added successfully");
        addCardPage.selectBackButton();
        userProfilePage.logout();

    }


    //DFA-9175
    @Test
    public void addDebitCard() throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.DEBITCARD);
        Assert.assertTrue(addCardPage.checkDebitCardElementPresence(),"Debit Card got added successfully");
        addCardPage.selectBackButton();
        userProfilePage.logout();

    }
    //DFA-9177
    @Test
    public void addGiftCard() throws Exception {
        try{
            mobileUser=setCountryName();
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            cards.add(0,SubwayCard.getSubwayCardFromDB(pojos.enums.Lock.TRUE));
            mobileUser.setSubwayCards(cards);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            UserProfilePage userProfilePage = homePage.getUserDetails();
            AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
            addCardPage.addPayment(mobileUser,PaymentMethod.SUBWAYCARD);
            Assert.assertTrue(addCardPage.checkGiftCardElementPresence(),"Subway Card got added successfully");
            addCardPage.selectBackButton();
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        } catch (Exception ex){
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        }
    }
    //DFA-9175
    @Test
    @DirtiesContext
    public void addPayPal() throws Exception{
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.PAYPAL);
        Assert.assertTrue(addCardPage.checkPayPalElementPresence(),"Paypal Card/account got added successfully");
        addCardPage.selectBackButton();
        userProfilePage.logout();

    }
    //DFA-7122
    @Test
    @DirtiesContext
    public void orderWithGiftCardCredit() throws  Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        String paymentTypeCreditCard = "CreditCard";
        String paymentTypeGiftCard="GiftCard";
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder(order.getCategoryAllSandwiches(), mobileUser, order.getStoreName());
    }

    @Test
    public void testPlaceRandomOrderVisaCard() throws Exception{

    }

    @Test
    public void testPlaceRandomOrderSubwayCard() throws Exception{

    }
    @Test
    public void testPlaceRandomOrderMasterCard() throws Exception{

    }
    @Test
    public void testPlaceRandomOrderMasterPass() throws Exception{

    }
    @Test
    public void testPlaceRandomOrderGiftCard() throws Exception{

    }
    @Test
    public void testPlaceRandomOrderDebitCard() throws Exception{

    }
    @Test
    public void testPlaceRandomOrderPayPalCard() throws Exception{

    }
    @Test
    public void testInsufficientFundsSubwayCard() throws Exception{

    }
    @Test
    public void testExpiredDateVisaCard() throws Exception{

    }
    @Test
    public void testAddMultipleTypesPaymentCard() throws Exception{

    }
    @Test
    public void testRemoveMultipleTypesPaymentCard() throws Exception{

    }
    @Test
    public void testEditMultipleTypesPaymentCard() throws Exception{

    }

}
