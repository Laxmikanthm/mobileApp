import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;

/**
 * Created by E003705 on 05-04-2017.
 */

@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class CustomizeOrder extends SubwayAppBaseTest {

    @Autowired
    Base.Order order;

    @Test
    public void placeCustomizeOrderAllSandwiches() throws Exception
    {
        int store = 54589;
        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        //mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("sushma.kamlakar@cigniti.com");
        mobileUser.setPassword("Cigniti@123");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        //OrdersPage ordersPage = landingPage.findYourStore("06460");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage =searchStore.findYourStore("06460");
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        //ordersPage.selectCategoryAndSubcategory(Order, storeName);
        ordersPage.selectItemTypeAndClickCustomize(order);
        //ordersPage.selectCategoryAndSubcategory("All Sandwiches", mobileUser, storeName);
        //ordersPage.selectItemTypeAndClickCustomize("FOOTLONG");
        ordersPage.customizeOrder(mobileUser,order);
        ordersPage.addToCartAndPlaceOrder();

    }
}
