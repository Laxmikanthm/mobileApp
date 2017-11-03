package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;

public class PlaceMealOrder extends SubwayAppBaseTest {
    MobileUser mobileUser;
    LandingPage landingPage;
    HomePage homePage;
    OrdersPage ordersPage;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    @Test
    public void OrderAMeal() throws Exception {
        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser =  landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.orderForMakeItAMeal("All Sandwiches", mobileUser, store.getAddress1(), ordersPage);
        ordersPage.clickOnPlaceOrder();
    }
    @Test
    public void testPlaceDefaultOrderWithMeal() throws Exception{

    }

    @Test
    public void testPlaceCustomizedOrderWithMeal() throws Exception{

    }


    @Test
    public void testMakeItMealPage() throws Exception{

    }
    @Test
    public void testSelectFountainDrinkAndCookies() throws Exception{

    }
    @Test
    public void testSelectBottledDrinkAndChips() throws Exception{

    }
    @Test
    public void testSelectSameCategoryOfDrinks() throws Exception{

    }
    @Test
    public void testSelectSameCategoryOfSides() throws Exception{

    }
    @Test
    public void testSelectBottledDrinkAndCookies() throws Exception{

    }

}
