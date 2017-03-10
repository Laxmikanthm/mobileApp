import Base.SubwayAppBaseTest;
import enums.Country;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pojos.Orders.Order;
import pojos.user.MobileUser;

/**
 * Created by e002243 on 10-03-2017.
 */
public class PlaceRandomOrder extends SubwayAppBaseTest {


    @Test
    public void placeOrder() throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.skip();
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        OrdersPage ordersPage = homePage.findYourSubWay();
        ordersPage.deny();
        Order order = new Order();
        ordersPage.placeRandomOrder(order,mobileUser,"CT Turpike West SouthBound 2","");

    }
}
