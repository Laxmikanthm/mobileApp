package myLoyaltyTest; /**
 * Created by test-user on 5/23/17.
 */
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.PaymentMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MyWayRewards.MyWayRewards;
import pages.UserProfilePage.UserProfilePage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

/**
 * Created by E001599 on 17-05-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class Tokens extends SubwayAppBaseTest {


    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;
    Store store=JdbcUtil.getStoreDetails();
    //DFA-9139_DFA-7615_DFA-7112
    @Test
    @DirtiesContext
    public void tokenTracker()throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        AddCardPage addCardPage = userProfilePage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        userProfilePage.goHome();
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(13, PaymentMethod.CREDITCARD);
        tokenValue= homePage.getTokenTrackerValue();
        Assert.assertEquals("50", tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(13, PaymentMethod.CREDITCARD);
        tokenValue= homePage.getTokenTrackerValue();
        Assert.assertEquals("100", tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(26, PaymentMethod.CREDITCARD);
        tokenValue= homePage.getTokenTrackerValue();
        Assert.assertEquals("200", tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);


    }
    @Test
    public void tokenGeneration() throws Exception {
        try {
            mobileUser=setCountryName();
            remoteOrderCustomer = RegisterUser.registerAUserWithoutCardLink(mobileUser);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            remoteOrder.placeRandomOrderForGivenNumberOfTokens(2, PaymentMethod.CREDITCARD);
            MyWayRewards myWayRewards = homePage.getTokensSparkle();
            myWayRewards.validateTokensandCerts(homePage,remoteOrderCustomer);

        } catch (Exception ex) {
            Logz.error("As tokens are not same as api");
            throw ex;
        }
    }

}
