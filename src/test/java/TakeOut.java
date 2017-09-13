import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e001599 on 27/07/17.
 */
public class TakeOut extends SubwayAppBaseTest {

    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;
    Store store = JdbcUtil.getStoreDetails();
    HomePage homePage;
    OrdersPage ordersPage;
    LandingPage landingPage;
    PlaceRandomOrder placeRandomOrder;

@Test
    //DFA-9359
    public void takeOutNoTaxforCA() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("CA",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        // mobileUser.setEmailAddress("DarelleToler@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomwithNoTax("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9483
    @Test
    public void takeOutNoTaxforOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        //mobileUser.setEmailAddress("aug30user@qasubway.com");
        //mobileUser.setPassword("Subway123");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomwithNoTax("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    //DFA-9367
    public void kidsValueMealTaxCA() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        // mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderKids("Kids' Meal", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }

    @Test
    //DFA-9490
    public void kidsValueMealTaxOH() throws Exception {
        //ordersPage.validateTax();
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        // mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderKids("Kids' Meal", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }

    //DFA-10485
    @Test
    public void FreshValueMealWithCoffeeCA() throws Exception {
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        //mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        //mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderFreshValueMeal("All Sandwiches", mobileUser, "1031 Bridge St");
        ordersPage.verifyOrderConformationReceipt();
    }
    //DFA-10536
    @Test
    public void FreshValueMealWithCoffeeOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        //ordersPage.validateTax();
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderFreshValueMeal("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }


    @Test
//DFA-10486
    public void certificateDiscountwithHotItemsCA() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = remoteOrderCustomer.getCart().getRemoteOrder();
        remoteOrderCustomer=remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1031 Bridge St");

    }
    //DFA-10537
    @Test
    public void certificateDiscountwithHotItemsOH() throws Exception{
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = remoteOrderCustomer.getCart().getRemoteOrder();
        remoteOrderCustomer=remoteOrder.getCustomer();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(200, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");

    }


    @Test
    //DFA-10484
    public void kidsValueMealTaxwithToyCA() throws Exception {
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

    //DFA-10535
    @Test
    public void kidsValueMealTaxwithToyOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        mobileUser.setEmailAddress("johnfrancis@qasubway.com");
        mobileUser.setPassword("Subway1234");
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderKidswithToy("Kids' Meal", mobileUser, "1134 Hebron Rd., Heath");
        ordersPage.verifyOrderConformationReceipt();
    }




}






