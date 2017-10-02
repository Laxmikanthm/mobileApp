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
    public void placeCustomizedOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void placeCustomizedOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Breakfast, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Breakfast, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void placeCustomizedOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.ChoppedSalads, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.KidsMeal, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Sides, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeCustomizedOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Drinks, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
}
