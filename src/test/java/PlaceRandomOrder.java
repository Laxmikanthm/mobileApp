import Base.SubwayAppBaseTest;
import enums.Country;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pages.SearchStore.SearchStore;
import pages.SubwayPage.SubwayPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.Orders.Order;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class PlaceRandomOrder extends SubwayAppBaseTest {
    MobileUser mobileUser;


    @Test
    public void placeOrderAllSandwiches() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser, storeName);


    }
    @Test
    public void placeOrderSubwayFreshFit() throws Exception
    {
        
        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("SUBWAY Fresh Fit®", mobileUser, storeName);
    }

    @Test
    public void placeOrderBreakfast() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Breakfast", mobileUser, storeName);
    }

    @Test
    public void placeOrderPersonalPizza() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Personal Pizza", mobileUser, storeName);
    }

    @Test
    public void placeOrderChoppedSalads() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Chopped Salads", mobileUser, storeName);
}

    @Test
    public void placeOrderSUBWAYFreshFitforKids() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Kids' Meal", mobileUser, storeName);
    }

    @Test
    public void placeOrderSides() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Sides", mobileUser, storeName);
    }

    @Test
    public void placeOrderDrinks() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("Drinks", mobileUser, storeName);
    }


    @Test
    public void OrderAMeal() throws Exception
    {
        By ItemList= By.id("com.subway.mobile.subwayapp03:id/item_options");
        By ItemFromSides= By.id("com.subway.mobile.subwayapp03:id/side_title_1");
        By ItemFromDrinks= By.id("com.subway.mobile.subwayapp03:id/drink_title");
        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage, mobileUser, paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore("06460");
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, storeName);
        Assert.assertTrue(ordersPage.isElementPresent(ItemList),"ItemList is present in Make It A Meal dropdown");
        Assert.assertTrue(ordersPage.isElementPresent(ItemFromSides),"One item from Sides is present in Make It A Meal dropdown");
        Assert.assertTrue(ordersPage.isElementPresent(ItemFromDrinks),"One item from Drinks is present in Make It A Meal dropdown");
        ordersPage.clickOnPlaceOrder();
    }


}
