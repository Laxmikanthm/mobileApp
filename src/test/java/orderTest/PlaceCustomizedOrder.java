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
import pojos.user.RemoteOrderCustomer;

public class PlaceCustomizedOrder extends SubwayAppBaseTest {

    RemoteOrderCustomer mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage ;


    @Test
    public void testPlaceCustomizedOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceCustomizedOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceCustomizedOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("SidesMenu"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeCustomizedOrder(BaseTest.getStringfromBundleFile("DrinksMenu"), BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
   @Test
   public void testPlaceCustomizedOrder2ItemsAllSandwich()throws Exception{

   }
    @Test
    public void testPlaceCustomizedOrderMaxItemsFreshFits()throws Exception{

    }
    @Test
    public void testPlaceCustomizedOrderSubOfTheDayFootLong() throws Exception {

    }
    @Test
    public void testPlaceCustomizedOrderSubOfTheDaySixInch() throws Exception {

    }
    //mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
}
