import Base.Order;
import Base.SubwayAppBaseTest;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
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
@ContextConfiguration("classpath:MobileAppBeans.xml")
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class ForgotPassword extends SubwayAppBaseTest  {

    @Autowired
    Order order;
    MobileUser mobileUser;

    @Test
    public void forgotPassword()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, order.getStoreNumber());
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        ForgotYourPasswordPage forgotPasswordPage= loginPage.forgotPassword();
        mobileUser.setPassword("Subway@12345");
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);
    }


}
