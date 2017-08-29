import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import enums.Country;
import enums.PaymentMethod;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e001599 on 27/07/17.
 */
public class TakeOut extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store;
    RemoteOrderCustomer remoteOrderCustomer;
    // Store store = JdbcUtil.getStoreDetails();
    HomePage homePage;
    OrdersPage ordersPage;
    LandingPage landingPage;
    PlaceRandomOrder placeRandomOrder;


   // @Test
    public void takeOutNoTax() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        //remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("DarelleToler@qasubway.com");
        mobileUser.setPassword("Subway1234");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomwithNoTax("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }



    @Test
    public void kidsValueMealTax() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderKids("Kids' Meal", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }


    @Test
    public void FreshValueMealWithCoffee() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderFreshValueMeal("All Sandwiches", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }

    @Test
    public void kidsValueMealTaxwithToy() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderKidswithToy("Kids' Meal", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }




}






