import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import kobieApi.serviceUtils.KobieClient;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
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
 * Created by E001599 on 29-05-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml", "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class Certificates extends SubwayAppBaseTest {

    MobileUser[] mobileUser;
    Store store = JdbcUtil.getStoreDetails();
  @BeforeClass
  public void init() throws Exception {
      for(int i =0; i<4; i++) {
          mobileUser[i] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
          RegisterUser.registerAUserWithoutCardLink(mobileUser[i]);
      }
       /* mobileUser.setEmailAddress("Lavi@mailinator.com");
        mobileUser.setPassword("Subway123");*/
  }



    @Test
    @DirtiesContext
    public void redeemCertificate() throws Exception {

        Store store = JdbcUtil.getStoreDetails();
        mobileUser[0] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser[0]);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser[0]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[0], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        RemoteOrder remoteOrder = mobileUser[0].getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.apply();
        searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.placeRandomOrderwithRedeemCertificate("All Sandwiches", mobileUser[0], store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history


    }
    @Test
    @DirtiesContext

    public void verifyCertificate() throws Exception {

        Store store = JdbcUtil.getStoreDetails();
        mobileUser[1] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser[1]);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser[1]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[1], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser[1].getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);

        //cetification Generation through kobie..


    }
    @Test
    @DirtiesContext
    public void redeemMultipleCertificate() throws Exception {

        mobileUser[2].setEmailAddress("test4_may15_2017@mailinator.com");//user who is having multiple certificates
        mobileUser[2].setPassword("Subway2017");
       // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser[2]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[2], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        //RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
      //  remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.placeRandomOrderwithRedeemMultipleCertificate("All Sandwiches", mobileUser[2], store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }

    public void redeemExpiredCertificate() throws Exception{
        mobileUser[2].setEmailAddress("test3_june@mailinator.com");//user who is having multiple certificates
        mobileUser[2].setPassword("Subway2017");
        // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser[2]);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser[2], PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage = searchStore.findYourStore(store.getZipCode());
        ordersPage.placeRandomOrderwithExpiredCertificate("All Sandwiches", mobileUser[2], store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history


    }
}
