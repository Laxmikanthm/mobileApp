import Base.Order;
import Base.SubwayAppBaseTest;
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
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.Store;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PlaceRandomOrder extends SubwayAppBaseTest {

    @Autowired
    Order order;
    MobileUser mobileUser;

    cardantApiFramework.pojos.Store store=JdbcUtil.getStoreDetails();


    @Test
    @DirtiesContext
    public void placeOrderAllSandwiches() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderSubwayFreshFit() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderBreakfast() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrder("Breakfast", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderPersonalPizza() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderChoppedSalads() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser, order.getStoreName());
}

    @Test
    @DirtiesContext
    public void placeOrderSUBWAYFreshFitforKids() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderSides() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrderSides("Sides", mobileUser, order.getStoreName());
    }

    @Test
    @DirtiesContext
    public void placeOrderDrinks() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser, order.getStoreName());
    }


    @Test
    @DirtiesContext
    public void OrderAMeal() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, order.getStoreName(),ordersPage);
        ordersPage.clickOnPlaceOrder();
    }


}
