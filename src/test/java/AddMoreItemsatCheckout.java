import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pages.SubwayPage.SubwayPage;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 17-04-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class AddMoreItemsatCheckout extends SubwayAppBaseTest {

    MobileUser mobileUser;
    @Test
    public void addMoreItemsAtCheckOut() throws Exception
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


    }
}
