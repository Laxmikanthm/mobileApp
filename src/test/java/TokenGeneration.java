import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
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
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E001599 on 25-05-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml", "classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class TokenGeneration extends SubwayAppBaseTest {

    MobileUser mobileUser;

    @BeforeClass(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        return mobileUser;
    }


    @Test
    @DirtiesContext
    public void tokenGeneration() throws Exception {
      //  mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
      //  RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        String tokenValue = homePage.tokenValue();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(13, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        Thread.sleep(3000);
        tokenValue = homePage.tokenValue();
        Assert.assertEquals("50", tokenValue);


    }

    @Test
    @DirtiesContext
    public void certificateGeneration() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        Thread.sleep(3000);
        HomePage homePage = loginPage.login(mobileUser);
        String tokenValue = homePage.tokenValue();
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        remoteOrder.placeRandomOrderForGivenNumberOfTokens(50, PaymentMethod.CREDITCARD);
        MyWayRewards myWayRewards = homePage.getTokensSparkle();
        myWayRewards.getSwipe();
        Thread.sleep(3000);
       // tokenValue = homePage.tokenValue();
        //Assert.assertEquals("200", tokenValue);
       // ValidateCertificate();


    }

}
