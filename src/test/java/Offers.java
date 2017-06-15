import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E001599 on 13-06-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml", "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class Offers extends SubwayAppBaseTest {
    MobileUser mobileUser;
     Store store = JdbcUtil.getStoreDetails();

    @BeforeClass(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
       // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("garybowman@qasubway.com");
        mobileUser.setPassword("Subway1234");
        return mobileUser;

    }



    @Test
    @DirtiesContext
    public void redeemOffer() throws Exception {

        //RegisterUser.registerAUserWithoutCardLink(mobileUser);

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);

     /*   MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();*/
      //  RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
     //   remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
     //   SearchStore searchStore = homePage.apply();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore("19428");
        ordersPage.placeRandomOrderwithRedeemOffers("All Sandwiches", mobileUser, "200 W Ridge Pike");


    }


    @Test
    @DirtiesContext
    public void redeemOfferandCertificate() throws Exception {

        //RegisterUser.registerAUserWithoutCardLink(mobileUser);

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);

     /*   MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();*/
        //  RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        //   remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        //   SearchStore searchStore = homePage.apply();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore("19428");
        ordersPage.placeOrderwithRedeemOffersandCertificates("All Sandwiches", mobileUser, "200 W Ridge Pike");


    }


}
