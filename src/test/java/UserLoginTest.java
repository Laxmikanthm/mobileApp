import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by Sujit on 1/26/17.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class UserLoginTest extends SubwayAppBaseTest {


    @Test
    public void userLogin() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        loginPage.login(mobileUser);
    }

    @Test
    public void createUser() throws Exception{
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        RegistrationPage registrationPage = landingPage.gotoRegistrationPage();
        registrationPage.signUp();
    }

    @Test
    public void userLogout() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage= loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        menuPage.logout();
    }
}