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

    String strTaxCategoryName="HOT";
    String strOrderType="INDIVIDUAL";
    Menu menu;

/*

    public RO_CartActions AddTAXItemToTheCart(String strStateProveCode, String strOrderType, String strTaxCategoryName, String strMenuCategoryName, int nQuantity, boolean IsDineIn, boolean IsR2Pilot) throws Exception{
        homeActions = new RO_HomeActions(driver);
        findAStoreActions = homeActions.GotoFindAStorePage();
        Logz.step("Getting store details");
        findAStoreActions.storeInfo = JdbcUtil.getStoreDetails(strStateProveCode, IsDineIn, IsR2Pilot);
        roMenuCategoryActions = findAStoreActions.SearchStoresForOrder(strOrderType, false);
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        Menu menu = JdbcUtil.getHotColdMenuItem(findAStoreActions.storeInfo.getStoreNumber(), strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item");
        roCartActions =  roMenuCategoryActions.AddMenuItemToCart(strMenuCategoryName, menu, nQuantity);
        return  roCartActions;
        roCartActions =  roOrderActions.AddTAXItemToTheCart( hmBundleFile.get("ohProveCode"), hmBundleFile.get("Individual"),  hmBundleFile.get("cold"), hmBundleFile.get("allsandwiches"), 1, true, true );
    }*/

    //DFA-9361
    @Test
    public void dineInHotItemsCA() throws Exception {
        Store store = JdbcUtil.getStoreDetails("CA",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
        //Assertion yet to be implemented. (i) Asserting Order History, (ii) Email verification
    }
    //DFA-9485
    @Test
    public void dineInHotItemsOH() throws Exception {
        Store store = JdbcUtil.getStoreDetails("OH",true,true);
        mobileUser=setCountryName();
        mobileUser=RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        Logz.step("Getting " + strMenuCategoryName + " Menu Details");
        menu=JdbcUtil.getHotColdMenuItem(String.valueOf(store.getLocationCode()),strMenuCategoryName,strTaxCategoryName,strOrderType);
        Logz.step("Received " + menu.getProductName() + " menu item");
        ordersPage.placeOrderForHotColdItemsInDineIn(strMenuCategoryName, mobileUser, store.getAddress1(),menu);
        homePage.validateTokens(mobileUser);
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
