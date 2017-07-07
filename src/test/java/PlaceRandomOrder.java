import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;


/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml", "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PlaceRandomOrder extends SubwayAppBaseTest {

    MobileUser[] mobileUser = new MobileUser[10];
   Store store;
    RemoteOrderCustomer remoteOrderCustomer;
   // Store store = JdbcUtil.getStoreDetails();

    @BeforeClass
    public void init() throws Exception {
        for (int i = 0; i < 1; i++) {
            mobileUser[i] = new MobileUser(false, Country.UnitedStates, 54588);
            RegisterUser.registerAUserWithoutCardLink(mobileUser[i]);
           // mobileUser[0].setEmailAddress("lavi@mailinator.com");
           // mobileUser[0].setPassword("Subway1234");

        }
    }

    @Test
    public void placeOrderAllSandwiches() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[0],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06460");
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser[0], "I-95 East Northbound 1");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void placeOrderSubwayFreshFit() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[0],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06460");
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser[0], "I-95 East Northbound 1");
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void placeOrderBreakfast() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[0],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Boolean timePresent = ordersPage.getTimeComparision(store);
        if (timePresent) {
            ordersPage.placeRandomOrder("Breakfast", mobileUser[0], store.getAddress1());
           // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//verifying order in order History

        } else {
            //Assert 'Breakfast Not available' alert popup message
            Logz.step("Breakfast time is over.");
            ordersPage.placeRandomOrderForInvalidBreakfastTime("Breakfast", mobileUser[0], store.getAddress1());
        }
    }

    @Test
    public void placeOrderPersonalPizza() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[4],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser[4], store.getAddress1());
    }

    @Test
    public void placeOrderChoppedSalads() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[5],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser[5], store.getAddress1());
    }

    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[6],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser[6], store.getAddress1());
    }

    @Test
    public void placeOrderSides() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[1],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderSides("Sides", mobileUser[7], store.getAddress1());
    }

    @Test
    public void placeOrderDrinks() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[1],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser[8], store.getAddress1());
    }


    @Test
    public void OrderAMeal() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[1],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser[9], "CT Turpike West Southbound 2, Milford, CT 06460", ordersPage);
        ordersPage.clickOnPlaceOrder();
    }

    //Place Order for more than 6 times...R2
    @Test
    public void placeOrderforMoreThanSixTimes() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[1],PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.ValidatingPlacingOrderForSixTimes(mobileUser[0], store.getAddress1(), homePage);

    }


}
