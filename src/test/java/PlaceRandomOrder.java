import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
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
    public void placeOrder() throws Exception
    {
        int store = 54588;
        String storeName = "CT Turpike West SouthBound 2";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.skip();
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        OrdersPage ordersPage = homePage.findYourSubWay();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.placeRandomOrder(remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches"), mobileUser, storeName);
    }
}
