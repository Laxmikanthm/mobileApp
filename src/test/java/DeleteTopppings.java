import Base.SubwayAppBaseTest;
import enums.Country;
import org.openqa.selenium.WebElement;
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

import java.util.List;

/**
 * Created by e002243 on 23-05-2017.
 */

@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class DeleteTopppings  extends SubwayAppBaseTest {

    @Autowired
    Base.Order ord;
    MobileUser mobileUser;

    @Test
    public void placeRandomOrderAndDeleteToppings() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        //RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("gopal.boyina@cigniti.com");
        mobileUser.setPassword("Cigniti@123");
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage =searchStore.findYourStore(ord.getZipCode());
        ordersPage.placeCustomizeOrder("All Sandwiches", mobileUser, ord.getStoreName(),order);
        ordersPage.selectItemTypeAndClickCustomize(order);
        ordersPage.deleteToppings();

    }
}
