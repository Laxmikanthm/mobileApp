package orderTest;

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
  // Store store;
   Store store = JdbcUtil.getLoyaltyStoreDetails();



    @Test
    public void placeOrderAllSandwiches() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
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


    @Test
    public void OrderAMeal() throws Exception {
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, store.getAddress1(), ordersPage);
        ordersPage.clickOnPlaceOrder();
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
    }

}
