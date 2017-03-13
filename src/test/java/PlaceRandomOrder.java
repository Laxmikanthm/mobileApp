import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.Orders.Order;

/**
 * Created by e002243 on 10-03-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
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
      /*  Order order = new Order();
        ordersPage.placeRandomOrder(order,mobileUser,"CT Turpike West SouthBound 2",String"");
*/
    }
}
