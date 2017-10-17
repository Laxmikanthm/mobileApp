package orderTest;

import Base.SubwayAppBaseTest;

import cardantApiFramework.pojos.Menu;
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
import utils.Logz;


/**
 * Created by e001599 on 01/08/17.
 */
public class DineIn extends SubwayAppBaseTest{

    MobileUser mobileUser;
    Store store;
    String strStateProvCode1;
    String strStateProvCode2;
    String strMenuCategoryName="All Sandwiches";

    String strTaxCategoryName="COLD";
    String strOrderType="INDIVIDUAL";
    Menu menu;
    LandingPage landingPage;
    HomePage homePage;
    OrdersPage ordersPage;

    //DFA-9361
    @Test
    public void dineInHotItemsCA() throws Exception {
        store = JdbcUtil.getStoreDetails("CA",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item from "+strTaxCategoryName+" category");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    @Test
    public void dineInColdItemsCA() throws Exception {
        store = JdbcUtil.getStoreDetails("CA",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item from "+strTaxCategoryName+" category");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9485
    @Test
    public void dineInHotItemsOH() throws Exception {
        store = JdbcUtil.getStoreDetails("OH",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item from "+strTaxCategoryName+" category");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
    }

    @Test
    public void dineInColdItemsOH() throws Exception {
        store = JdbcUtil.getStoreDetails("CA",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item from "+strTaxCategoryName+" category");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }

    //DFA-10487
    @Test
    public void certDiscountwithAllItemsInDineInCA() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10808);
        mobileUser= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("95932");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-10538
    @Test
    public void certDiscountwithAllItemsInDineInOH() throws Exception {
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 10846);
        mobileUser= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore("43056");
        ordersPage.placeRandomOrderCertDiscountwithHotItems("All Sandwiches", mobileUser, "1031 Bridge St");
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-10484
    @Test
    public void takeouttaxkidsvalueMealsandwichandtoyCA() throws  Exception{
        mobileUser = new MobileUser(false,Country.UnitedStates,10808 );
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(),"MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage = homePage.findStore("95932");
        ordersPage.placeRandomToastedKidsMeal("Kids' Meal",mobileUser,"1031 Bridge St");
        homePage.validateTokens(mobileUser);
    }
    //DFA-10535
    @Test
    public void takeouttaxkidsvalueMealsandwichandtoyOH() throws  Exception{
        store= JdbcUtil.getStateSpecificStoreDetails("OH",true);
        mobileUser = new MobileUser(false,Country.UnitedStates,10846 );
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(),"MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage = homePage.findStore("43056");
        ordersPage.placeRandomToastedKidsMeal("Kids' Meal",mobileUser,"1134 Hebron Rd., Heath");
        homePage.validateTokens(mobileUser);
    }



}
