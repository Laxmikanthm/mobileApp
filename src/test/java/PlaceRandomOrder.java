import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pages.SubwayPage.SubwayPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.Orders.Order;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class PlaceRandomOrder extends SubwayAppBaseTest {



    @Test
    public void placeOrderAllSandwiches() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches"), mobileUser, storeName);

    }
    @Test
    public void placeOrderSubwayFreshFit() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        String subCategoryName="Bacon, Egg & Cheese";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("SUBWAY Fresh Fit™"), mobileUser, storeName);

    }
    @Test
    public void placeOrderBreakfast() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("Breakfast"), mobileUser, storeName);

    }

    @Test
    public void placeOrderPersonalPizza() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("Personal Pizza"), mobileUser, storeName);

    }

    @Test
    public void placeOrderChoppedSalads() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("Chopped Salads"), mobileUser, storeName);

    }

    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception
    {
        int store = 54589;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("SUBWAY Fresh Fit for Kids®"), mobileUser, storeName);

    }

    @Test
    public void placeOrderSides() throws Exception
    {
        int store = 54588;
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("Sides"), mobileUser, storeName);

    }

}
