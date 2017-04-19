import Base.SubwayAppBaseTest;
import enums.Country;
import junit.framework.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pages.SubwayPage.SubwayPage;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 19-04-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class AddFavoriteOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
    @Test
    public void addFavoriteOrder() throws Exception
    {

        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addMethodForPayment(subwayPage,mobileUser,paymentType);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrder("All Sandwiches", mobileUser, storeName);
        menuPage= homePage.gotoMenuPage();
        MobileOrderHistoryPage mobileOrderHistoryPage= menuPage.getOrderHistory();
        mobileOrderHistoryPage.addFavoriteOrder();
        homePage.selectBackButton();
        menuPage.goHome();

        Assert.assertEquals(mobileOrderHistoryPage.favoriteOrderName(), homePage.favoriteOrderName());


    }
}
