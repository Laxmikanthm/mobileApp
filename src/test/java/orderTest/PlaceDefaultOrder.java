package orderTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.annotations.Test;
import Enums.BreadSize;
import Enums.Menu;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;

public class PlaceDefaultOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;


    @Test
    public void testPlaceDefaultOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test //bug: DFA-8911
    public void testPlaceDefaultOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG, store);

    }

    @Test //bug: DFA-8911
    public void testPlaceDefaultOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH, store);

    }


    @Test
    public void testPlaceDefaultOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }


    @Test
    public void testPlaceDefaultOrderSubOfTheDayFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrder(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.FOOTLONG, store);

    }

    @Test
    public void testPlaceDefaultOrderSubOfTheDaySixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrder(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.SIXINCH, store);

    }

    @Test
    public void testPlaceDefaultOrderPersonalPizzaFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeDefaultOrder(BaseTest.getStringfromBundleFile("PersonalPizza"), BreadSize.NONE, store);
    }


    @Test(enabled = false)
    public void testPlaceDefaultOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("SidesMenu"), store);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false)
    public void testPlaceDefaultOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(mobileUser, BaseTest.getStringfromBundleFile("DrinksMenu"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false)
    public void testPlaceDefaultOrder2ItemsAllSandwich() throws Exception {

    }

    @Test(enabled = false)
    public void testPlaceDefaultOrderMaxItemsFreshFits() throws Exception {

    }
    ////homePage = ordersPage.goToHomePage();
    // mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("DefaultOrderUser"));
}
