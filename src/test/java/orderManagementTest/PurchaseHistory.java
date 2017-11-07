package orderManagementTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.PaymentResponse;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
//import pages.MenuPage.MenuPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import util.MobileApi;

/**
 * Created by e002243 on 24-05-2017.
 */

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PurchaseHistory extends SubwayAppBaseTest {

    MobileUser mobileUser;
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
  //  MenuPage menuPage;
    PurchaseHistoryPage purchaseHistoryPage;

//    //DFA-7115
//    @Test
//    public void verifyOrderHistory() throws Exception
//    {
//        mobileUser=setCountryName();
//        RegisterUser.registerAUserWithoutCardLink(mobileUser);
//        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
//        PaymentResponse paymentResponse=remoteOrder.placeRandomOrder(1, PaymentMethod.CREDITCARD);
//        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
//        LoginPage loginPage = landingPage.gotoLogInPage();
//        HomePage homePage=loginPage.login(mobileUser);
//        MenuPage menuPage = homePage.getUserDetails();
//        menuPage.assertMobileOrderHistory(paymentResponse.getOrderNumber());
//
//
//    }



    //DFA-7115
    @Test
    public void verifyOrderHistory() throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        MobileApi.placeOrder(2,1,mobileUser); // where should I keep the method
       // mobileUser = landingPage.getUser("CedMayne@qasubway.com");// CedMayne@qasubway.com//"AngeBaistow@qasubway.com",54588
        homePage = landingPage.gotoLogInPage().login(mobileUser);
        homePage.goToUserProfilePage().goToPurchaseHistoryPage().assertPlacedOrderDetailsInPurchaseHistoryPage(mobileUser);


    }



    @Test(enabled = false)
    public void testPurchaseHistoryLayout() throws Exception{
        //assert purchase history info icon, header, details, back icon
        //assert back icon, assert previous page, return back
        //assert purchase history header
        //assert purchase history footer
        //assert purchase history list details
    }

    @Test(enabled = false)
    public void testPurchaseHistoryMax() throws Exception{
        //assert purchase history info icon, header, details, back icon
        //assert back icon, assert previous page, return back
        //assert purchase history header
        //assert purchase history footer
        //assert purchase history list details
    }
}
