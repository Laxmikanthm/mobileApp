package orderTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
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
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    PurchaseHistoryPage purchaseHistoryPage;


    @Test
    public void testPlaceDefaultOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
      // mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("DefaultOrderUser"));
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.AllSandwiches, BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        // mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("DefaultOrderUser"));
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.SUBWAYFreshFit, BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false) //bug: DFA-8911
    public void testPlaceDefaultOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.Breakfast, BreadSize.FOOTLONG);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test (enabled = false)
    public void testPlaceDefaultOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.Breakfast, BreadSize.SIXINCH);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
       // mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("DefaultOrderUser"));
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.ChoppedSalads, BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test
    public void testPlaceDefaultOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.KidsMeal, BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false)
    public void testPlaceDefaultOrderSides() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.Sides, BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false)
    public void testPlaceDefaultOrderDrinks() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        homePage = ordersPage.placeDefaultOrder(Menu.Drinks, BreadSize.NONE);
        purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);
    }

    @Test(enabled = false)
    public void testPlaceDefaultOrder2ItemsAllSandwich() throws Exception {

    }

    @Test(enabled = false)
    public void testPlaceDefaultOrderMaxItemsFreshFits() throws Exception {

    }
    @Test(enabled = false)
    public void testPlaceDefaultOrderSubOfTheDayFootLong() throws Exception {

    }
    @Test(enabled = false)
    public void testPlaceDefaultOrderSubOfTheDaySixInch() throws Exception {

    }
    ////homePage = ordersPage.goToHomePage();
    // mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("DefaultOrderUser"));
}
