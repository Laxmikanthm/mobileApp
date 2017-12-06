package orderTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Enums.BreadSize;
import Enums.Menu;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.SearchStore.SearchStore;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

public class PlaceCustomizedOrder extends SubwayAppBaseTest {

//Store store = new Store(  );
 Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;


    @Test
    public void testPlaceCustomizedOrderAllSandwichesFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG, store);
    }
    @Test
    public void testPlaceCustomizedOrderAllSandwichesSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH, store);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG, store);
    }
    @Test
    public void testPlaceCustomizedOrderSubwayFreshFitSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH, store);
    }
    @Test
    public void testPlaceCustomizedOrderBreakfastFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG, store);

    }
    @Test
    public void testPlaceCustomizedOrderBreakfastSixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH, store);

    }
    @Test
    public void testPlaceCustomizedOrderChoppedSalads() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.NONE, store);

    }
    @Test
    public void testPlaceCustomizedOrderKidsMeal() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE, store);
    }
    @Test
    public void testPlaceCustomizedOrderSubOfTheDayFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.FOOTLONG, store);

    }

    @Test
    public void testPlaceCustomizedOrderSubOfTheDaySixInch() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("SubOfTheDay"), BreadSize.SIXINCH, store);

    }

    @Test
    public void testPlaceCustomizedPersonalPizzaFootLong() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("PersonalPizza"), BreadSize.NONE, store);
    }
    @Test
    public void testPlaceCustomizedOrderFlatizzas() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeCustomizedOrderThenAssert(BaseTest.getStringfromBundleFile("Flatizzas"), BreadSize.NONE, store);
    }
    /*
    
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
    }*/
  /* @Test
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

    }*/
    //mobileUser = landingPage.registerUser("LarisaWoolliams@qasubway.com");

  /*  RemoteOrder remoteOrder;
    @Autowired
    Base.Order ord;
    MobileUser mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();
    @BeforeClass
    public void init() throws Exception {

        remoteOrder = mobileUser.getCart().getRemoteOrder();

    }

    @Test
    public void placeCustomizeOrderAllSandwiches() throws Exception
    {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage =searchStore.findYourStore(ord.getZipCode());
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct(ord.getCategoryAllSandwiches());
        ordersPage.selectItemTypeAndClickCustomize(order);
        ordersPage.customizeOrder(mobileUser,order);
        ordersPage.addToCartAndPlaceOrder();

    }*/
}
