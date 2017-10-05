package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

/**
 * Created by e002243 on 17-04-2017.
 */

/*
@ContextConfiguration("classpath:Order-data.xml")
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
*/

public class AddMoreItemsatCheckout extends SubwayAppBaseTest {

    RemoteOrder remoteOrder;
    RemoteOrderCustomer remoteOrderCustomer;
    /*@Autowired
    Base.Order order;*/
    MobileUser mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();


    //DFA-8844_DFA-8741
    @Test
    @DirtiesContext
    public void addMoreItemsAtCheckOut() throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        remoteOrderCustomer= RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.addMoreItemsatCheckOut("All sandwiches", mobileUser, store.getAddress1());
        menuPage= homePage.gotoMenuPage();
        MobileOrderHistoryPage mobileOrderHistoryPage= menuPage.getOrderHistory();
        mobileOrderHistoryPage.addFavoriteOrder();
        homePage.selectBackButton();
        menuPage.goHome();
        homePage.assertFavoriteOrder(homePage.favoriteOrderName(),mobileOrderHistoryPage.favoriteOrderName());


    }

}
