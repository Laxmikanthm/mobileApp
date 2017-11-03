package orderTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
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

}
