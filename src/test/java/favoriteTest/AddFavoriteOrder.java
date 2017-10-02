package favoriteTest;

import Base.Order;
import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
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
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
/**
 * Created by e002243 on 19-04-2017.
 */
public class AddFavoriteOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    RemoteOrderCustomer remoteOrderCustomer;
    LandingPage landingPage;
    HomePage homePage;
    OrdersPage ordersPage;

    @Autowired
    Base.Order order1;



    //DFA-7675_DFA-7241
    @Test
    @DirtiesContext
    public void addFavoriteReOrder_7675_7241() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.logInAddCreditCard(mobileUser);
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);
        ordersPage.placeFavouriteReOrder(mobileUser);
        homePage.validateTokens(remoteOrderCustomer);

    }

    //DFA-9157
    @Test
    @DirtiesContext
    public void UnFavouriteOrder_9157() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.removeFavouriteOrder(order1.getCategoryAllSandwiches(), mobileUser, store.getAddress1(), remoteOrderCustomer);
        homePage.validateTokens(remoteOrderCustomer);
        //ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }


    //DFA-9157
  /*  @Test
    public void addFavoriteOrder_9157() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.logInAddCreditCard(mobileUser);
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder(BaseTest.getStringfromBundleFile("AllSandwiches"), mobileUser, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);

    }*/
    @Test
    public void addFavoriteOrder_9157() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        RemoteOrderCustomer user = landingPage.registerUser("LarisaWoolliams@qasubway.com");
        //HomePage homePage = landingPage.logInAddCreditCard(mobileUser);
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage =  loginPage.login(user);
        OrdersPage ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder(BaseTest.getStringfromBundleFile("AllSandwiches"), remoteOrderCustomer, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);

    }
}
