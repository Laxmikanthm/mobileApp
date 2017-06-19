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

    MobileUser mobileUser;
    Store store=JdbcUtil.getStoreDetails();
    RemoteOrder remoteOrder;


    @BeforeClass
    public void init() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
       /* mobileUser.setEmailAddress("Lavi@mailinator.com");
        mobileUser.setPassword("Subway123");*/
        remoteOrder = mobileUser.getCart().getRemoteOrder();

    }

    @Test
    @DirtiesContext
    public void placeOrderAllSandwiches() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("All Sandwiches", remoteOrder,store.getAddress1());
    }

    @Test
    @DirtiesContext
    public void placeOrderSubwayFreshFit() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®",  remoteOrder,store.getAddress1());
    }

    @Test
    @DirtiesContext
    public void placeOrderBreakfast() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        Boolean timePresent=ordersPage.getTimeComparision(store.getBreakStartTime(),store.getBreakEndTime(),store.getTimeZone());
        if (timePresent) {
            ordersPage.placeRandomOrder("Breakfast", remoteOrder,store.getAddress1());
            Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//Asserting each time token generation.
            menuPage.validateMobileOrderHistory(ordersPage.orderValue);//verifying order in order History

        }
        else
        {
            Logz.step("Breakfast time is over.");
        }

    }

    @Test
    @DirtiesContext
    public void placeOrderPersonalPizza() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Personal Pizza", remoteOrder,store.getAddress1());
    }

    @Test
    @DirtiesContext
    public void placeOrderChoppedSalads() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Chopped Salads", remoteOrder,store.getAddress1());
}

    @Test
    @DirtiesContext
    public void placeOrderSUBWAYFreshFitforKids() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Kids' Meal", remoteOrder,store.getAddress1());
    }

    @Test
    @DirtiesContext
    public void placeOrderSides() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrderSides("Sides", remoteOrder,store.getAddress1());
    }

    @Test
    @DirtiesContext
    public void placeOrderDrinks() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrderDrinks("Drinks", remoteOrder,store.getAddress1());
    }


    @Test
    @DirtiesContext
    public void OrderAMeal() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", remoteOrder, "CT Turpike West Southbound 2, Milford, CT 06460",ordersPage);
        ordersPage.clickOnPlaceOrder();
    }

    //Place Order for more than 6 times...R2
    @Test
    @DirtiesContext
    public void placeOrderforMoreThanSixTimes() throws Exception
    {
        Store store=JdbcUtil.getStoreDetails();//getting online Store Details
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();//Added Credit Payment Method.
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("19428");//searching the store
        for(int i=0;i<=6;i++) {
            ordersPage.placeRandomOrderForSixTimes("Sides", mobileUser, "200 W Ridge Pike",i,homePage);//Plcaing order more than 6 times
           Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//Asserting each time token generation.
            menuPage.validateMobileOrderHistory(ordersPage.orderValue);//verifying order in order History


        }
    }


}
