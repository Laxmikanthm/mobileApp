/**
 * Created by test-user on 5/23/17.
 */
import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.MyWayRewards.MyWayRewards;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E001599 on 17-05-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class MyWayTokenTracker extends SubwayAppBaseTest {


    MobileUser mobileUser;

   /*@BeforeTest(alwaysRun = true)
   public MobileUser userRegistration() throws Exception {
       mobileUser = new MobileUser(false, Country.UnitedStates, 2224);
       RegisterUser.registerAUserWithoutCardLink(mobileUser);

       return mobileUser;
   }*/

    @Test
    @DirtiesContext
    public void tokenTracker()throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        // RegisterUser.registerAUserWithoutCardLink(mobileUser);
        mobileUser.setEmailAddress("kavuru@mailinator.com");
        mobileUser.setPassword("Subway123");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        String tokenValue = homePage.tokenValue();
        String tokenMessage = homePage.tokenMessage(tokenValue);
        homePage.tokenTracker(tokenValue, tokenMessage);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(13, PaymentMethod.CREDITCARD);
        homePage.refreshPage();
        homePage.tokenTracker(tokenValue, tokenMessage);
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(13, PaymentMethod.CREDITCARD);
        homePage.refreshPage();
        homePage.tokenTracker(tokenValue, tokenMessage);
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(26, PaymentMethod.CREDITCARD);
        homePage.refreshPage();
        homePage.tokenTracker(tokenValue, tokenMessage);


    }
}