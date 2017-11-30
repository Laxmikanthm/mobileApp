package orderTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.testng.annotations.Test;
import Enums.BreadSize;
import Enums.Menu;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

public class PlaceDefaultOrder extends SubwayAppBaseTest {

    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    MobileUser mobileUser;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;

    //we have to check first if the menu is returning from API then proceed  further else come out from the test

    @Test
    public void testPlaceDefaultOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG, store);
    }

    @Test
    public void testPlaceDefaultOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH, store);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG, store);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH, store);
    }

    @Test //bug: DFA-8911
    public void testPlaceDefaultOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert( BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG, store);

    }

    @Test //bug: DFA-8911
    public void testPlaceDefaultOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH, store);

    }


    @Test
    public void testPlaceDefaultOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert( BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.NONE, store);
    }

    @Test
    public void testPlaceDefaultOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE, store);
    }


    @Test
    public void testPlaceDefaultOrderSubOfTheDayFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.FOOTLONG, store);

    }

    @Test
    public void testPlaceDefaultOrderSubOfTheDaySixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.SIXINCH, store);

    }

    @Test
    public void testPlaceDefaultOrderPersonalPizzaFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("PersonalPizza"), BreadSize.NONE, store);
    }
    @Test
    public void testPlaceDefaultOrderFlatizzas() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrderThenAssert(BaseTest.getStringfromBundleFile("Flatizzas"), BreadSize.NONE, store);
    }


    @Test
    public void testPlaceDefaultOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("KasperIvers@qasubway.com");//DorolisaWiddup@qasubway.com
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.placeSidesDrinksDefaultOrderThenAssert(mobileUser, BaseTest.getStringfromBundleFile("SidesMenu"));

    }

    @Test
    public void testPlaceDefaultOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();//HerminaPadell@qasubway.com
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.placeSidesDrinksDefaultOrderThenAssert(mobileUser, BaseTest.getStringfromBundleFile("DrinksMenu"));
    }

    //DFA-9165
    //Place Order for more than 6 times...R2
    @Test
    public void placeOrderForMoreThanSixTimes() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.validatingPlacingOrderForSixTimes(mobileUser, store.getAddress1());

    }

    @Test(enabled = false)
    public void placeOrder8Under6() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage.placeRandomOrder("8 Under 6", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }


    //Signature Wraps Flatizzas™
    ////homePage = ordersPage.goToHomePage();OsmondOrred@qasubway.com NancyBottoms@qasubway.com

   /* MobileUser mobileUser;
    // Store store;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
*/

/*
    @Test
    public void placeOrderAllSandwiches() throws Exception {
        mobileUser=setCountryName();
        mobileUser= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9183
    @Test
    public void placeOrderSubwayFreshFit() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9181
    @Test
    public void placeOrderBreakfast() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Boolean timePresent = ordersPage.getTimeComparision(store);
        if (timePresent) {
            ordersPage.placeRandomOrder("Breakfast", mobileUser, store.getAddress1());
            // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//verifying order in order History

        } else {
            //Assert 'Breakfast Not available' alert popup message
            Logz.step("Breakfast time is over.");
            ordersPage.placeRandomOrderForInvalidBreakfastTime("Breakfast", mobileUser, "I-95 Northbound");
        }
    }

    @Test
    public void placeOrderPersonalPizza() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
    }
    //DFA-9183
    @Test
    public void placeOrderChoppedSalads() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
    }
    //DFA-9183
    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
    }

    @Test
    public void placeOrderSides() throws Exception {
        mobileUser=setCountryName();
        //remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("northruplorek@qasubway.com");
        mobileUser.setPassword("Subway1234");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderSides("Sides", mobileUser, store.getAddress1());
    }

    @Test
    public void placeOrderDrinks() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser, store.getAddress1());
    }



    //DFA-9165
    //Place Order for more than 6 times...R2
    @Test
    public void placeOrderforMoreThanSixTimes() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.ValidatingPlacingOrderForSixTimes(mobileUser, store.getAddress1(), homePage);

    }

    @Test
    public void placeOrder8Under6() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("8 Under 6", mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }*/
}
