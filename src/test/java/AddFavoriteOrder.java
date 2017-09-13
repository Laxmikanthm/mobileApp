import Base.Order;
import Base.SubwayAppBaseTest;
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
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 19-04-2017.
 */
public class AddFavoriteOrder extends SubwayAppBaseTest {

MobileUser mobileUser;
Store store;
RemoteOrderCustomer remoteOrderCustomer;

//Store store=JdbcUtil.getStoreDetails();


//DFA-9157
    @Test
    public void addFavoriteOrder() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("06405");
       // ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser, "I-95 Northbound");
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);

    }
    //DFA-7675_DFA-7241
    @Test
    @DirtiesContext
    public void addFavoriteReOrder() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("19428");
       // ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser, "I-95 Northbound");
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);
        ordersPage.placeFavouriteReOrder(mobileUser);
        homePage.validateTokens(remoteOrderCustomer);

    }
//DFA-9157_DFA-8352
    @Test
    @DirtiesContext
    public void UnFavouriteOrder()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("19428");
       // ordersPage.removeFavouriteOrder(order1.getCategoryAllSandwiches(),mobileUser, "200 W Ridge Pike",remoteOrderCustomer);
        homePage.validateTokens(remoteOrderCustomer);
        //ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }

}
