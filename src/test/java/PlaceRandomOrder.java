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
import utils.Logz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static pojos.RemoteOrder.order;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PlaceRandomOrder extends SubwayAppBaseTest {

   MobileUser[] mobileUser = new MobileUser[10];
    Store store = JdbcUtil.getStoreDetails();

    @BeforeClass
    public void init() throws Exception {
        for(int i =0; i<1; i++) {
            mobileUser[i] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
            RegisterUser.registerAUserWithoutCardLink(mobileUser[i]);
        }
       /* mobileUser.setEmailAddress("Lavi@mailinator.com");
        mobileUser.setPassword("Subway123");*/
    }

    @Test
    public void placeOrderAllSandwiches() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[1]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[1], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser[1], store.getAddress1());
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void placeOrderSubwayFreshFit() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[2]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[2],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®",  mobileUser[2], store.getAddress1());
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void placeOrderBreakfast() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[0]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[0],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        Boolean timePresent=ordersPage.getTimeComparision(store.getBreakStartTime(),store.getBreakEndTime(),store.getTimeZone());
        if (timePresent) {
            ordersPage.placeRandomOrder("Breakfast", mobileUser[0], store.getAddress1());
            menuPage.assertMobileOrderHistory(ordersPage.orderValue);//verifying order in order History

        }
        else
        {
            //Assert 'Breakfast Not available' alert popup message
            Logz.step("Breakfast time is over.");
        }
    }

    @Test
    public void placeOrderPersonalPizza() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[4]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[4],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser[4], store.getAddress1());
    }

    @Test
    public void placeOrderChoppedSalads() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[5]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[5],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser[5], store.getAddress1());
}

    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[6]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[6],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser[6], store.getAddress1());
    }

    @Test
    public void placeOrderSides() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[7]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[7],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrderSides("Sides", mobileUser[7], store.getAddress1());
    }

    @Test
    public void placeOrderDrinks() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[8]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[8],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser[8], store.getAddress1());
    }


    @Test
    public void OrderAMeal() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser[9]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[9],PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser[9], "CT Turpike West Southbound 2, Milford, CT 06460",ordersPage);
        ordersPage.clickOnPlaceOrder();
    }

    //Place Order for more than 6 times...R2
    @Test
    public void placeOrderforMoreThanSixTimes() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser[0]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[0], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();//Added Credit Payment Method.
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());//searching the store
        for(int i=0;i<=6;i++) {
            ordersPage.placeRandomOrderForSixTimes("Sides", mobileUser[0], store.getAddress1(),i,homePage);//Plcaing order more than 6 times
            Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//Asserting each time token generation.
            menuPage.assertMobileOrderHistory(ordersPage.orderValue);//verifying order in order History


        }
    }


}
