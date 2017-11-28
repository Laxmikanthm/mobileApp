package findStoreTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;

/**
 * Created by E003705 on 04-04-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class SwitchStore extends SubwayAppBaseTest {

    @Autowired
    MobileUser mobileUser;
    LandingPage landingPage;
    RemoteOrderCustomer user;
    HomePage homePage;
    OrdersPage ordersPage;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    SearchStore searchStore;



    @Test
    @DirtiesContext
    public void selectOtherStore() throws Exception
    {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.selectRestaurant(store.getAddress1());
        homePage.findAnotherSubway();
        searchStore.findYourStore(store.getZipCode());
        ordersPage.selectRestaurant();
        ordersPage.assertStoreDetails();


    }

    @Test(enabled = false)
    public void testFindAnotherSubwaySelectionInHomePage() throws Exception{

    }
    @Test(enabled = false)
    public void testFindAnotherSubwaySelectionInMenuPage() throws Exception{

    }

    @Test
    public void testSwicthStore() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser();
        homePage = landingPage.logIn(user);
        ordersPage = homePage.selectStore(store);
        ordersPage.assertStoreDetails();
    }

    @Test
    public void testSelectAnotherStore() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser();
        homePage = landingPage.logIn(user);
        homePage= searchStore.selectStoreAndAssert();

    }
}
