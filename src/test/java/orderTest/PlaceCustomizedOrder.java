package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.annotations.Test;
import pages.Enums.BreadSize;
import pages.Enums.Menu;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.RemoteOrderCustomer;

public class PlaceCustomizedOrder extends SubwayAppBaseTest {

    RemoteOrderCustomer mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    // RemoteOrderCustomer user;
    LandingPage landingPage;
    OrdersPage ordersPage;
    LoginPage loginPage;
    HomePage homePage;
    UserProfilePage userProfilePagePage;
    PurchaseHistoryPage purchaseHistoryPage ;


    @Test
    public void testPlaceCustomizedOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.AllSandwiches, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceCustomizedOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.AllSandwiches, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();

        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.Breakfast, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.Breakfast, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceCustomizedOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.ChoppedSalads, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.KidsMeal, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.Sides, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void testPlaceCustomizedOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        userProfilePagePage = homePage.goToUserProfilePage();
        purchaseHistoryPage = userProfilePagePage.goToPurchaseHistoryPage();
        purchaseHistoryPage = ordersPage.placeCustomizedOrder(Menu.Drinks, homePage, BreadSize.NONE);
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
