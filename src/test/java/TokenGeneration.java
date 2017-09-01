import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import kobieApi.pojos.SaleTerminal;
import kobieApi.serviceUtils.Kobie;
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
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

/**
 * Created by E001599 on 25-05-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class TokenGeneration extends SubwayAppBaseTest {

    MobileUser mobileUser;
    RemoteOrderCustomer remoteOrderCustomer;

    @Test
    public void tokenGeneration() throws Exception {
        try {
            mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
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
