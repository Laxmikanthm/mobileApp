import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FindYourSubWayPage.FindYourSubWayPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pojos.MobileUser;

/**
 * Created by E003705 on 28-02-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class ForgotPassword extends SubwayAppBaseTest  {


    @Test
    public void forgotPassword()throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
        LandingPage landingPage = goToHomePage(HomePage.class, "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        ForgotYourPasswordPage forgotPasswordPage= loginPage.forgotPassword();
        mobileUser.setPassword("Sub@123");
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        loginPage.loginAfterResetPassoword(mobileUser);
    }
}