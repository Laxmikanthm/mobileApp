import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 19-04-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class AddFavoriteOrder extends SubwayAppBaseTest {

    @Autowired
    Order order1;

MobileUser mobileUser;
Store store;

//Store store=JdbcUtil.getStoreDetails();



    @BeforeClass(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {

        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        /*mobileUser.setEmailAddress("june8th@mailinator.com");
        mobileUser.setPassword("Subway123");*/
        return mobileUser;

    }

    @Test
    @DirtiesContext
    public void addFavoriteOrder() throws Exception
    {

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06460");
        ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser, "I-95 East Northbound 1");
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue());
        homePage.addSomethingElse();
        //Assert.assertEquals(orderPage.favoriteOrderName(), orderPage.favorite());
        ordersPage.placeFavouriteReOrder(mobileUser, store.getAddress1());

    }
    @Test
    @DirtiesContext
    public void UnFavouriteOrder()throws Exception
    {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06460");
        ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser,store.getAddress1());
        ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }

}
