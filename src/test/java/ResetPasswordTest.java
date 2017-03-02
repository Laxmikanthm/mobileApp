import Base.SubwayAppBaseTest;
import enums.Country;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pojos.MobileUser;

/**
 * Created by E003705 on 01-03-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class ResetPasswordTest extends SubwayAppBaseTest {

    @Test
    public void resetPassword()throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.gotoMenuPage();
        ContactInformationPage contactInformation= menuPage.getContactInformation();
        ForgotYourPasswordPage forgotYourPasswordPage = contactInformation.getPasswordField();
        mobileUser.setEmailAddress("sksushmakamlakar@gmail.com");
        mobileUser.setPassword("Subway12345");
        loginPage = forgotYourPasswordPage.setNewPassword(mobileUser);
        loginPage.loginAfterResetPassoword(mobileUser);

    }
}
