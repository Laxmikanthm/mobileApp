package favoriteTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
import util.MobileApi;

public class OrderFavorites extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    RemoteOrderCustomer remoteOrderCustomer;
    LandingPage landingPage;
    HomePage homePage;
    OrdersPage ordersPage;

    @Autowired
    Base.Order order1;


    //DFA-9157
    @Test
    public void addFavoriteOrder() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        //homePage = landingPage.logIn(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder(order1.getCategoryAllSandwiches(), mobileUser, store.getAddress1());
        homePage.validateTokens(remoteOrderCustomer);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);

    }

    @Test
    @DirtiesContext
    public void reOrderFavorites() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("FavoriteUser"));
      //  homePage = landingPage.logIn(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        MobileApi.removeAddFavorite(mobileUser, 2);
        ordersPage.placeFavouriteReOrder(mobileUser);
        homePage.validateTokens(remoteOrderCustomer);

    }

    //DFA-9157
    @Test
    @DirtiesContext
    public void UnFavouriteOrder() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("FavoriteUser"));
       // homePage = landingPage.logIn(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        MobileApi.removeAddFavorite(mobileUser, 2);
        ordersPage.removeFavouriteOrder(order1.getCategoryAllSandwiches(), mobileUser, store.getAddress1(), remoteOrderCustomer);
        homePage.validateTokens(remoteOrderCustomer);
        //ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }

    //orderFavoritesWithSubwayCard
    // orderFavoritesWithDebitCard
    //orderFavoritesWithSplitPayment
    //addFavoriteFromOrderHistory
    //orderMaxFavoriteItems(Assert max alert pop up)
    //

}
