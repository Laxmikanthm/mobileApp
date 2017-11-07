package favoriteTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.UserProfilePage.UserProfilePage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 20-04-2017.
 */

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class CreateanResubmitFavoriteOrder extends SubwayAppBaseTest {

    RemoteOrder remoteOrder;
    @Autowired
    Base.Order order;
    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;
    Store store=JdbcUtil.getLoyaltyStoreDetails();
    UserProfilePage userProfilePage;

    @Test
    @DirtiesContext
    public void resubmitFavoriteOrder() throws Exception
    {
        mobileUser=setCountryName();
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrder(order.getCategoryAllSandwiches(), mobileUser, order.getStoreName());
        userProfilePage = homePage.gotoMenuPage();
        MobileOrderHistoryPage mobileOrderHistoryPage= userProfilePage.getOrderHistory();
        mobileOrderHistoryPage.addFavoriteOrder();
        homePage.selectBackButton();
        userProfilePage.goHome();
        ordersPage.clickOnPlaceOrder();
    }
}
