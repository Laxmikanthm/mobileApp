package favoriteTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Enums.BreadSize;
import pages.Enums.Menu;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.RemoteOrderCustomer;

public class OrderFavorites extends SubwayAppBaseTest {

    RemoteOrderCustomer mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    // RemoteOrderCustomer user;
    LandingPage landingPage;
    OrdersPage ordersPage;
    LoginPage loginPage;
    HomePage homePage;
    UserProfilePage userProfilePagePage;
    PurchaseHistoryPage purchaseHistoryPage ;



    public OrderFavorites() throws Exception {
    }


    //DFA-9157
    @Test
    public void addOrderAsFavorite() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
       // mobileUser = landingPage.registerUser();
        mobileUser =  landingPage.registerUser("LarisaWoolliams@qasubway.com");
        loginPage = landingPage.gotoLogInPage();
        HomePage homePage =  loginPage.login(mobileUser);
        //HomePage homePage = landingPage.logInAddCreditCard(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        ordersPage.placeFavouriteRandomOrder(BaseTest.getStringfromBundleFile("AllSandwiches"), mobileUser, store.getAddress1());
        homePage.validateTokens(mobileUser);
        homePage.addSomethingElse();
        Assert.assertEquals(ordersPage.favoriteOrderName(), ordersPage.favoriteOrderName);


    }


   /* @Test
    @DirtiesContext
    public void reOrderFavorites() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser(BaseTest.getStringfromBundleFile("FavoriteUser"));
      //  homePage = landingPage.logIn(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        MobileApi.removeAddFavorite(mobileUser, 2);
        ordersPage.placeFavouriteReOrder(mobileUser);
        homePage.validateTokens(user);

    }

    //DFA-9157
    @Test
    @DirtiesContext
    public void UnFavouriteOrder() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        user = landingPage.registerUser(BaseTest.getStringfromBundleFile("FavoriteUser"));
       // homePage = landingPage.logIn(mobileUser);
        ordersPage = homePage.findStore(store.getZipCode());
        MobileApi.removeAddFavorite(mobileUser, 2);
        ordersPage.removeFavouriteOrder(order1.getCategoryAllSandwiches(), mobileUser, store.getAddress1(), user);
        homePage.validateTokens(user);
        //ordersPage.removeFavouriteOrder(mobileUser,store.getAddress1());


    }*/

    //orderFavoritesWithSubwayCard
    // orderFavoritesWithDebitCard
    //orderFavoritesWithSplitPayment
    //addFavoriteFromOrderHistory
    //orderMaxFavoriteItems(Assert max alert pop up)
    //

}
