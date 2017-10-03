package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
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
 * Created by E003705 on 05-04-2017.
 */

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class CustomizeOrder extends SubwayAppBaseTest {

    RemoteOrder remoteOrder;
    @Autowired
    Base.Order ord;
    MobileUser mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();
    @BeforeClass
    public void init() throws Exception {

        remoteOrder = mobileUser.getCart().getRemoteOrder();

    }

    @Test
    public void placeCustomizeOrderAllSandwiches() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage =searchStore.findYourStore(ord.getZipCode());
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct(ord.getCategoryAllSandwiches());
        ordersPage.selectItemTypeAndClickCustomize(order);
        ordersPage.customizeOrder(mobileUser,order);
        ordersPage.addToCartAndPlaceOrder();

    }
}