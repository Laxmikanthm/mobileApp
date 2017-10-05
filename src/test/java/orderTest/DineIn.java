package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
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
 * Created by e001599 on 01/08/17.
 */
public class DineIn extends SubwayAppBaseTest{

    MobileUser mobileUser;
    Store store;
    RemoteOrderCustomer remoteOrderCustomer;
    // Store store = JdbcUtil.getStoreDetails();

    //DFA-9361
    @Test
    public void dineInHotItemsCA() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomwithDineInHotTax("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9485
    @Test
    public void dineInHotItemsOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomwithDineInHotTax("All Sandwiches", mobileUser, "1134 Hebron Rd., Heath");
        homePage.validateTokens(remoteOrderCustomer);
    }

    //DFA-10487
    @Test
    public void certDiscountwithAllItemsInDineInCA() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-10538
    @Test
    public void certDiscountwithAllItemsInDineInOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-10484
    @Test
    public void takeouttaxkidsvalueMealsandwichandtoyCA() throws  Exception{
        mobileUser = new MobileUser(false,Country.UnitedStates,10808 );
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(),"MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage = homePage.findStore("95932");
        ordersPage.placeRandomToastedKidsMeal("Kids' Meal",mobileUser,"1031 Bridge St");
        homePage.validateTokens(remoteOrderCustomer);
    }
    //DFA-10535
    @Test
    public void takeouttaxkidsvalueMealsandwichandtoyOH() throws  Exception{
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false,Country.UnitedStates,10846 );
        remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(),"MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage = homePage.findStore("43056");
        ordersPage.placeRandomToastedKidsMeal("Kids' Meal",mobileUser,"1134 Hebron Rd., Heath");
        homePage.validateTokens(remoteOrderCustomer);
    }



}
