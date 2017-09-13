import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E003705 on 28-02-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class ForgotPassword extends SubwayAppBaseTest  {

    @Autowired
    Order order;
    MobileUser mobileUser;

    //DFA-9172_DFA-5490_DFA-5489_DFA-5488_DFA-5487_DFA-5486_DFA-5485_DFA-5484
    @Test
    @DirtiesContext
    public void forgotPassword()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 12921);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        ForgotYourPasswordPage forgotPasswordPage= loginPage.forgotPassword();
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);
    }


}
