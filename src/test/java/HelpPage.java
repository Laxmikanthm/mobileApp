import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 18-04-2017.
 */
public class HelpPage extends SubwayAppBaseTest {


    MobileUser mobileUser;
//DFA-9174_DFA-10092_DFA-10048_DFA-9134
    @Test
    public void verifyHelpPage() throws Exception
    {
        try {
            mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getLoyaltyStoreDetails().getLocationCode());
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            menuPage.verifyHelp();
            menuPage.assertHelpPageTexts();
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }
}
