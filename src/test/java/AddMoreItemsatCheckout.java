import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 17-04-2017.
 */

@ContextConfiguration("classpath:Order-data.xml")
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class AddMoreItemsatCheckout extends SubwayAppBaseTest {

    @Autowired
    Base.Order order;
    MobileUser mobileUser;


    @Test
    @DirtiesContext
    public void addMoreItemsAtCheckOut() throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(order.getZipCode());
        ordersPage.addMoreItemsatCheckOut(order.getCategoryAllSandwiches(), mobileUser, order.getStoreName());
        menuPage= homePage.gotoMenuPage();
        MobileOrderHistoryPage mobileOrderHistoryPage= menuPage.getOrderHistory();
        mobileOrderHistoryPage.addFavoriteOrder();
        homePage.selectBackButton();
        menuPage.goHome();
        homePage.assertFavoriteOrder(homePage.favoriteOrderName(),mobileOrderHistoryPage.favoriteOrderName());


    }
}
