package orderTest;

import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.SearchStore.SearchStore;
import pages.UserProfilePage.UserProfilePage;
import pages.YourOrderPage.YourOrderPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

public class EditYourOrder extends SubwayAppBaseTest {

    RemoteOrder remoteOrder;
    RemoteOrderCustomer remoteOrderCustomer;

    Store store= JdbcUtil.getLoyaltyStoreDetails();
    MobileUser mobileUser;

    LandingPage landingPage;
    OrdersPage ordersPage;
    PurchaseHistoryPage purchaseHistoryPage;
    UserProfilePage userProfilePage;
    YourOrderPage yourOrderPage;

    /*@Autowired
    Base.Order ord;
    Base.Order order;*/

   /* @Test
    public void placeRandomOrderAndDeleteToppings() throws Exception
    {
        mobileUser=setCountryName();
        mobileUser= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct(ord.getCategoryAllSandwiches());
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage =searchStore.findYourStore(store.getZipCode());
        ordersPage.placeCustomizeOrder("All Sandwiches", store.getAddress1(),order);
        ordersPage.selectItemTypeAndClickCustomize(order);
        ordersPage.deleteToppings();

    }*/
    //After clicking on  edit check whether selected product is displayed or not
    @Test
    @DirtiesContext
    public void editCartVerifyPlaceOrder() throws Exception{
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser, PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.assertProduct(ordersPage.editCartAndPlaceAnOrder("All Sandwiches",remoteOrder, store.getAddress1()),ordersPage.getSubItemInfo());
        ordersPage.placeAnOrder();
    }

    //When clicked on Add another button same product needs to be added
    @Test
    @DirtiesContext
    public void editCartAddAnotherVerifyPlaceOrder() throws Exception{
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",remoteOrder, store.getAddress1());
        ordersPage.getSubItemInfo();
        ordersPage.assertEditCartAddAnother();
        ordersPage.placeAnOrder();

    }

    //In edit page use should be able to remove the selected product
    @Test
    @DirtiesContext
    public void editCartDeleteItemVerifyPlaceOrder() throws Exception{
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",remoteOrder,store.getAddress1());
        ordersPage.getSubItemInfo();
        ordersPage.assertEditCartDeleteItem();
        ordersPage.placeAnOrder();

    }

    //When clicked on Something else button user should be able to select different product from the category item
    @Test
    @DirtiesContext
    public void editCartSomethingElseVerifyPlaceOrder() throws Exception{

        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        String aItem = ordersPage.editCartAndPlaceAnOrder("All Sandwiches",remoteOrder, store.getAddress1());
        ordersPage.addAnotherNewItem();
        String eItem = ordersPage.editCartAndPlaceAnOrder("8 Under 6",remoteOrder, store.getAddress1());
        ordersPage.assertEditCartSomethingElseVerify(aItem,eItem);
        ordersPage.clickOnPlaceOrder();
    }
    //DFA-8844_DFA-8741
    @Test
    @DirtiesContext
    public void addMoreItemsAtCheckOut() throws Exception
    {
        mobileUser=setCountryName();
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        userProfilePage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.addMoreItemsatCheckOut("All sandwiches", mobileUser, store.getAddress1());
        userProfilePage = homePage.gotoMenuPage();
        MobileOrderHistoryPage mobileOrderHistoryPage= userProfilePage.getOrderHistory();
        mobileOrderHistoryPage.addFavoriteOrder();
        homePage.selectBackButton();
        userProfilePage.goHome();
        homePage.assertFavoriteOrder(homePage.favoriteOrderName(),mobileOrderHistoryPage.favoriteOrderName());


    }

    /*@Test
    @DirtiesContext
    public void OrderSpecialInstructions() throws Exception
    {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderSpecialInstructions("All Sandwiches", mobileUser, store.getAddress1(), order.getSpecialInstructions());
    }*/

    @Test
    public void testCancelRemoveItemFromEditYourOrderPage() throws Exception{

    }

    @Test
    //Verify item from Edit order page
    public void testItemFromEditYourOrderPage() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.placeEditOrderThenAssert(BaseTest.getStringfromBundleFile("AllSandwiches"),BreadSize.NONE,store);
    }

    @Test
    //Add item from Edit order page
    public void testAddItemFromEditYourOrderPage() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.assertEditFunctionalityInEditOrder(mobileUser,BaseTest.getStringfromBundleFile("AllSandwiches"),BreadSize.NONE,"AddSameItem");

    }

    @Test
    //Delete the item which is already added
    public void testRemoveItemFromEditYourOrderPage() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.assertEditFunctionalityInEditOrder(mobileUser,BaseTest.getStringfromBundleFile("AllSandwiches"),BreadSize.NONE,"DeleteItem");

    }

    @Test
    //Add another item by clicking on Something Else button
    public void testAddAnotherItemFromEditYourOrderPage() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        ordersPage = landingPage.logInSelectStore(mobileUser, store).goToOrderPage();
        ordersPage.assertEditFunctionalityInEditOrder(mobileUser,BaseTest.getStringfromBundleFile("AllSandwiches"),BreadSize.NONE,"AddOtherItem");

    }

    @Test
    public void testCancelRemoveSidesFromEditYourOrderPage() throws Exception{

    }
    @Test
    public void testRemoveSidesFromEditYourOrderPage() throws Exception{

    }
    @Test
    public void testAddAnotherChipsDrinkCookieFromEditYourOrderPage() throws Exception{

    }

    @Test
    public void testEditCreditCardFromEditYourOrderPage() throws Exception{

    }
}
