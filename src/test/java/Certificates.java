import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import kobieApi.pojos.Loyalty;
import kobieApi.pojos.Summaries;
import kobieApi.serviceUtils.Kobie;
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
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

import java.util.List;

/**
 * Created by E001599 on 29-05-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml", "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class Certificates extends SubwayAppBaseTest {

    MobileUser[] mobileUser=new MobileUser[3];
    Store store = JdbcUtil.getStoreDetails();
  @BeforeClass
  public void init() throws Exception {
      for(int i =0; i<1; i++) {
          mobileUser[i] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
          RegisterUser.registerAUserWithoutCardLink(mobileUser[i]);
      }

  }


    @Test
    public void redeemCertificate() throws Exception {

        Store store = JdbcUtil.getStoreDetails();
        //mobileUser[0] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
       // RegisterUser.registerAUserWithoutCardLink(mobileUser[0]);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[0],PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser[0].getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        RemoteOrderCustomer remoteOrderCustomer=remoteOrder.customer;
        myWayRewards.validateTokens(remoteOrderCustomer,homePage);
        String MdmId=remoteOrderCustomer.getGuestID();
        Kobie.generateCertificates(MdmId);
        myWayRewards=homePage.getTokensSparkle();
        myWayRewards.toolBarClose();
        myWayRewards.validateCertificate(remoteOrderCustomer,homePage);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithRedeemCertificate("All Sandwiches",remoteOrder, store.getAddress1());
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certsCount());
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        //menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history


    }
    @Test

    public void verifyCertificate() throws Exception {

        Store store = JdbcUtil.getStoreDetails();
        mobileUser[1] = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser[1]);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[1],PaymentMethod.CREDITCARD);
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser[1].getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        RemoteOrderCustomer remoteOrderCustomer=remoteOrder.customer;
        myWayRewards.validateTokens(remoteOrderCustomer, homePage);
        String MdmId=remoteOrderCustomer.getGuestID();
        Kobie.generateCertificates(MdmId);
        myWayRewards=homePage.getTokensSparkle();
        myWayRewards.toolBarClose();
        myWayRewards.validateCertificate(remoteOrderCustomer,homePage);



    }
    @Test
    @DirtiesContext
    public void redeemMultipleCertificate() throws Exception {

        mobileUser[2].setEmailAddress("test4_may15_2017@mailinator.com");//user who is having multiple certificates
        mobileUser[2].setPassword("Subway2017");
       // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[2],PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser[2].getCart().getRemoteOrder();
       remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        RemoteOrderCustomer remoteOrderCustomer=remoteOrder.customer;
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        myWayRewards.validateCertificate(remoteOrderCustomer,homePage);
        String MdmId=remoteOrderCustomer.getGuestID();
        Kobie.generateCertificates(MdmId);
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithRedeemMultipleCertificate("All Sandwiches", mobileUser[2], store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
       // menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history

    }

    public void redeemExpiredCertificate() throws Exception{

        // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage=landingPage.getUserLoginAndAddingCard(mobileUser[2],PaymentMethod.CREDITCARD);
        RemoteOrder remoteOrder = mobileUser[2].getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards=homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        RemoteOrderCustomer remoteOrderCustomer=remoteOrder.customer;
        String MdmId=remoteOrderCustomer.getGuestID();
        Kobie.generateCertificates(MdmId);
        myWayRewards=homePage.getTokensSparkle();
        myWayRewards.toolBarClose();
        Loyalty loyalty=new Loyalty(remoteOrderCustomer);
        remoteOrderCustomer=KobieClient.getLoyaltyLookup(loyalty,remoteOrderCustomer);
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certsCount());
        OrdersPage ordersPage=homePage.findStore(store.getZipCode());
        ordersPage.placeRandomOrderwithExpiredCertificate("All Sandwiches", mobileUser[2], store.getAddress1());
        Assert.assertEquals(ordersPage.Rewards,homePage.certValue);//validating Certificates
        Assert.assertEquals(String.valueOf(ordersPage.tokens),homePage.tokenValue().toString());//validating tokens
        //menuPage.assertMobileOrderHistory(ordersPage.orderValue);//validating order history


    }
}
