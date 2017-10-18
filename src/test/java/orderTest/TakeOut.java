package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Menu;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.CartData;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import orderTest.PlaceRandomOrder;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

/**
 * Created by e001599 on 27/07/17.
 */
public class TakeOut extends SubwayAppBaseTest {

    MobileUser mobileUser;
    RemoteOrderCustomer user;
    Store store = JdbcUtil.getStoreDetails();
    HomePage homePage;
    OrdersPage ordersPage;
    LandingPage landingPage;
    PlaceRandomOrder placeRandomOrder;
    Menu menu;
    String strMenuCategoryName="All Sandwiches";
    String strTaxCategoryName="HOT";
    String strOrderType="INDIVIDUAL";
    PurchaseHistoryPage purchaseHistoryPage;

@Test
    //DFA-9359
    public void takeOutNoTaxforCA() throws Exception {
        Store store = JdbcUtil.getStoreDetails("CA",false,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item");
        ordersPage.placeOrderForHotColdItemsInDineIn("All Sandwiches", mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(user);

    }
    //DFA-9483
    @Test
    public void takeOutNoTaxforOH() throws Exception {
        Store store = JdbcUtil.getStoreDetails("OH",false,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item");
        ordersPage.placeOrderForHotColdItemsInDineIn("All Sandwiches", mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(user);

    }

    @Test
    //DFA-9367
    public void kidsValueMealTaxCA() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        user= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        // mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderKids("Kids' Meal", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }

    @Test
    //DFA-9490
    public void kidsValueMealTaxOH() throws Exception {
        //ordersPage.validateTax();
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        user= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        // mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderKids("Kids' Meal", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }

    //DFA-10485
    @Test
    public void FreshValueMealWithCoffeeCA() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        user= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        //mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderFreshValueMeal("All Sandwiches", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }
    //DFA-10536
    @Test
    public void FreshValueMealWithCoffeeOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        user= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderFreshValueMeal("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }


    @Test
//DFA-10486
    public void certificateDiscountwithHotItemsCA() throws Exception{
        store= JdbcUtil.getStateSpecificStoreDetails("CA",true);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        user = remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        user = myWayRewards.validateTokensandCerts(homePage, user);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        CartData.createNewCart(user, store.getLocationCode());
        homePage=ordersPage.addingHotandColdToCart(store,"TakeOut");
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);

    }
    //DFA-10537
    @Test
    public void certificateDiscountwithHotItemsOH() throws Exception{
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        user = remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        user = myWayRewards.validateTokensandCerts(homePage, user);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        CartData.createNewCart(user, store.getLocationCode());
        homePage=ordersPage.addingHotandColdToCart(store,"TakeOut");
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
        //ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");

    }


    @Test
    //DFA-10484
    public void kidsValueMealTaxwithToyCA() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderKidswithToy("Kids' Meal", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }

    //DFA-10535
    @Test
    public void kidsValueMealTaxwithToyOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderKidswithToy("Kids' Meal", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }




}






