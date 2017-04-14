import Base.SubwayAppBaseTest;
import enums.Country;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E003705 on 01-03-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class ResetPasswordTest extends SubwayAppBaseTest {
    MobileUser mobileUser;

    @Test
    public void resetPassword()throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.gotoMenuPage();
        ContactInformationPage contactInformation= menuPage.getContactInformation();
        ForgotYourPasswordPage forgotYourPasswordPage = contactInformation.getPasswordField();
        mobileUser.setPassword("Subway12345");
        loginPage = forgotYourPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);

    }
}
