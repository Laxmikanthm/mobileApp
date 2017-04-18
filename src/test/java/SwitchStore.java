import Base.SubwayAppBaseTest;
import enums.Country;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
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
 * Created by E003705 on 04-04-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class SwitchStore extends SubwayAppBaseTest {
    MobileUser mobileUser;


    @Test
    public void selectOtherStore() throws Exception{

        int store = 54589;
        String paymentType = "CreditCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        String storeName1="1 River St, Milford, CT 06460";
        By storeNamesLocator=By.id("com.subway.mobile.subwayapp03:id/address");

        mobileUser = new MobileUser(false, Country.UnitedStates, store);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.scrollToItemAndClick(storeNamesLocator,storeName,1600,3000);
        ordersPage.selectRestaurant();
        homePage.findAnotherSubway();
        searchStore.findYourStore("06460");
        ordersPage.scrollToItemAndClick(storeNamesLocator,storeName1,1600,3000);
        String actualStoreName= ordersPage.switchStoreName();
        ordersPage.selectRestaurant();
        Assert.assertEquals(actualStoreName,storeName1);

    }
}
