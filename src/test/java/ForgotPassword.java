import Base.SubwayAppBaseTest;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import org.springframework.test.context.ContextConfiguration;
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
public class ForgotPassword extends SubwayAppBaseTest  {
    MobileUser mobileUser;


    @Test
    public void forgotPassword()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
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
