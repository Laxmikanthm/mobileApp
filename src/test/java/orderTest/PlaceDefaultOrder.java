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

public class PlaceDefaultOrder extends SubwayAppBaseTest {

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
    public void placeDefaultOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void placeDefaultOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Breakfast, homePage, BreadSize.FOOTLONG);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Breakfast, homePage, BreadSize.SIXINCH);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void placeDefaultOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.ChoppedSalads, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.KidsMeal, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Sides, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
    @Test
    public void placeDefaultOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        // mobileUser = landingPage.registerUser();
        mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        ordersPage = landingPage.logInSelectStore(mobileUser, store.getZipCode());
        purchaseHistoryPage = ordersPage.placeDefaultOrder(Menu.Drinks, homePage, BreadSize.NONE);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }
}
