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
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PlaceRandomOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
   Store store;
    RemoteOrderCustomer remoteOrderCustomer;
   // Store store = JdbcUtil.getStoreDetails();



    @Test
    public void placeOrderAllSandwiches() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser, "I-95 Northbound");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
//DFA-9183
    @Test
    public void placeOrderSubwayFreshFit() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser, "I-95 Northbound");
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
//DFA-9181
    @Test
    public void placeOrderBreakfast() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
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
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser, "I-95 Northbound");
    }
//DFA-9183
    @Test
    public void placeOrderChoppedSalads() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser, "I-95 Northbound");
    }
//DFA-9183
    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser, "I-95 Northbound");
    }

    @Test
    public void placeOrderSides() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrderSides("Sides", mobileUser, "I-95 Northbound");
    }

    @Test
    public void placeOrderDrinks() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser, "I-95 Northbound");
    }


    @Test
    public void OrderAMeal() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
        remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460", ordersPage);
        ordersPage.clickOnPlaceOrder();
    }
//DFA-9165
    //Place Order for more than 6 times...R2
    @Test
    public void placeOrderforMoreThanSixTimes() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.ValidatingPlacingOrderForSixTimes(mobileUser, store.getAddress1(), homePage);

    }


}
