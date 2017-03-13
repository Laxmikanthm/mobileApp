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

/**
 * Created by E003705 on 28-02-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class ForgotPassword extends SubwayAppBaseTest  {


    @Test
    public void forgotPassword()throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.skip();
        /*RegistrationPage registrationPage = landingPage.gotoRegistrationPage();
        HomePage homePage = registrationPage.signUp();
        MenuPage menuPage= homePage.getUserDetails();
        menuPage.logout();*/
        LoginPage loginPage = landingPage.gotoLogInPage();
        ForgotYourPasswordPage forgotPasswordPage= loginPage.forgotPassword();
        mobileUser.setPassword("Subway12345");
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        loginPage.loginAfterResetPassoword(mobileUser);
    }


}
