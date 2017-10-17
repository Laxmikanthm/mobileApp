package favoriteTest;

import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    public void testAddOrderAsFavoriteFromOrderConfirmationPage() throws Exception {
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
    @Test
    public void testAddOrderAsFavoriteFromHomePage() throws Exception {
        //assert item is added as favorite in favorite page


    }
    @Test
    public void testReorderFavoritesFromFavoritePage() throws Exception {

    }
    @Test
    public void testCustomizeFavoritesFromFavoritePage() throws Exception {

    }
    @Test
    public void testUnFavoritesFromFavoritePage() throws Exception {

    }
    @Test
    public void testOrderFavoritesWithSubwayCard() throws Exception {

    }
    @Test
    public void testOrderFavoritesWithDebitCard() throws Exception {

    }
    @Test
    public void testOrderFavoritesWithSplitPayment() throws Exception {

    }
    @Test
    public void testOrderMaxFavoriteItems() throws Exception {

    }


}
