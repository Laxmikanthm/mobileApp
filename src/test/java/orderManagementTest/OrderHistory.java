package orderManagementTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.PaymentResponse;
import enums.PaymentMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 24-05-2017.
 */

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class OrderHistory extends SubwayAppBaseTest {

    MobileUser mobileUser;
    //DFA-7115
    @Test
    public void verifyOrderHistory() throws Exception
    {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        PaymentResponse paymentResponse=remoteOrder.placeRandomOrder(1, PaymentMethod.CREDITCARD);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        userProfilePage.assertMobileOrderHistory(paymentResponse.getOrderNumber());


    }
}
