import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import enums.Country;
import enums.PaymentMethod;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e001599 on 01/08/17.
 */
public class DineIn extends SubwayAppBaseTest{

    MobileUser mobileUser;
    Store store;
    RemoteOrderCustomer remoteOrderCustomer;
    // Store store = JdbcUtil.getStoreDetails();



    @Test
    public void dineInHotItems() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        //remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("DarelleToler@qasubway.com");
        mobileUser.setPassword("Subway1234");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        //ordersPage.placeRandomwithDineInHotTax("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void dineInMeals() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        //remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("DarelleToler@qasubway.com");
        mobileUser.setPassword("Subway1234");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomwithDineInMeals("Kids' Meal", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

}
