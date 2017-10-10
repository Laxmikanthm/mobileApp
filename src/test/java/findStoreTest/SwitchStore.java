package findStoreTest;

import Base.SubwayAppBaseTest;
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

/**
 * Created by E003705 on 04-04-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class SwitchStore extends SubwayAppBaseTest {

    @Autowired
    Base.Order order;
    MobileUser mobileUser;


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
        OrdersPage ordersPage=searchStore.findYourStore(order.getZipCode());
        ordersPage.selectRestaurant(order.getStoreName());
        homePage.findAnotherSubway();
        searchStore.findYourStore(order.getZipCode());
        ordersPage.selectRestaurant();
        ordersPage.assertSwitchStore(ordersPage.switchStoreName(order.getStoreName1()),order.getStoreName1());


    }

    @Test(enabled = false)
    public void testFindAnotherSubwaySelectionInHomePage() throws Exception{

    }
    @Test(enabled = false)
    public void testFindAnotherSubwaySelectionInMenuPage() throws Exception{

    }
}
