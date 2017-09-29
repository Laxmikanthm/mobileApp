import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 19-04-2017.
 */
public class AddFavoriteOrder extends SubwayAppBaseTest {

MobileUser mobileUser;
Store store=JdbcUtil.getLoyaltyStoreDetails();
RemoteOrderCustomer remoteOrderCustomer;



//DFA-9157
    @Test
    public void addFavoriteOrder_9157() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder("All Sandwiches", mobileUser, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);

    }
    //DFA-7675_DFA-7241
    @Test
    @DirtiesContext
    public void addFavoriteReOrder_7675_7241() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder("All Sandwiches", mobileUser, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);
        ordersPage.placeFavouriteReOrder(mobileUser);
        homePage.validateTokens(remoteOrderCustomer);

    }
//DFA-9157
    @Test
    @DirtiesContext
    public void UnFavouriteOrder_9157()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
       remoteOrderCustomer=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.removeFavouriteOrder("All Sandwiches",mobileUser, store.getAddress1(),remoteOrderCustomer);
        homePage.validateTokens(remoteOrderCustomer);
        //ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }

}
