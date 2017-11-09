package favoriteTest;

import Base.Order;
import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
/**
 * Created by e002243 on 19-04-2017.
 */
public class AddFavoriteOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    HomePage homePage;
    OrdersPage ordersPage;



    //DFA-9157
    @Test
    public void addFavoriteOrder_9157() throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeFavouriteOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.NONE, store);

    }
    //DFA-7675_DFA-7241
    @Test
    @DirtiesContext
    public void addFavoriteReOrder_7675_7241() throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser=landingPage.addFavouriteOrderThroughApi(ordersPage);
        landingPage.placeFavouriteReOrderThenAssert(mobileUser, store);

    }
    //DFA-9157
    @Test
    @DirtiesContext
    public void UnFavouriteOrder_9157()throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser=landingPage.addFavouriteOrderThroughApi(ordersPage);
        landingPage.placeUnFavouriteOrderThenAssert(mobileUser, store);

    }

}
