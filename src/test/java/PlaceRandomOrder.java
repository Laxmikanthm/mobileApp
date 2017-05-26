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
import pojos.Store;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

import java.util.ArrayList;

import static pojos.RemoteOrder.order;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PlaceRandomOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
    //ArrayList<MobileUser> user;
    //ArrayList<MobileUser> mobileUsers;


    /*@BeforeClass(alwaysRun = true)
    public void userRegistration()throws Exception {

        user = new ArrayList<MobileUser>();
        //mobileUsers=new ArrayList<MobileUser>();
        for (int i = 1; i <= 9; i++) {
            mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            user.add(mobileUser);
        }

    }*/

    @BeforeClass(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        return mobileUser;

    }

    @Test
    @DirtiesContext
    public void placeOrderAllSandwiches() throws Exception
    {
        /*mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        mobileUser.setEmailAddress("sushmatest@mailinator.com");
        mobileUser.setPassword("Subway123");*/
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
        //ordersPage.placeRandomOrder1("All Sandwiches", mobileUser, "Paseo de Diego #15 Rio Piedras, PR 00925");
        //ordersPage.placeRandomOrder("All Sandwiches", mobileUser, "Paseo de Diego #15 Rio Piedras, PR 00925");
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser,JdbcUtil.getStoreDetails().getAddress1()+" "+JdbcUtil.getStoreDetails().getCity()+","+JdbcUtil.getStoreDetails().getStateProvCode());
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
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser, JdbcUtil.getStoreDetails().getAddress1()+" "+JdbcUtil.getStoreDetails().getCity()+","+JdbcUtil.getStoreDetails().getStateProvCode());
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
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.placeRandomOrder("Breakfast", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.placeRandomOrderSides("Sides", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.placeRandomOrderDrinks("Drinks", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
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
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460",ordersPage);
        ordersPage.clickOnPlaceOrder();
    }


}
