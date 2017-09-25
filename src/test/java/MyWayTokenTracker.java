/**
 * Created by test-user on 5/23/17.
 */
import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class MyWayTokenTracker extends SubwayAppBaseTest {


    MobileUser mobileUser;
    Store store=JdbcUtil.getStoreDetails();
    //DFA-9139_DFA-7615_DFA-7112
    @Test
    @DirtiesContext
    public void tokenTracker()throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getLoyaltyStoreDetails().getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
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
}
