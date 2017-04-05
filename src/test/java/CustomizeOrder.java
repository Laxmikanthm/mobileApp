import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
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

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class CustomizeOrder extends SubwayAppBaseTest {


    @Test
    public void placeCustomizeOrderAllSandwiches() throws Exception
    {
        int store = 54589;
        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, store);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.selectCategoryAndSubcategory("All Sandwiches", mobileUser, storeName);
        ordersPage.selectItemTypeAndClickCustomize("FOOTLONG");
        Order order = new Order();
        ordersPage.customizeOrder(mobileUser,order);


    }
}
