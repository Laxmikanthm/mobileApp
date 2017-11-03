package userIdentityTest;

import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by Sujit on 1/26/17.
 */
/*
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
*/
public class UserLoginTest extends SubwayAppBaseTest {

    /*@Autowired
    Order order;*/
    MobileUser mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();


    @Test
    public void userLogin() throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        loginPage.login(mobileUser);
    }

    @Test
    public void createUser_4929() throws Exception {
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        RegistrationPage registrationPage = landingPage.gotoRegistrationPage();
        registrationPage.signUp();
    }

    @Test
    public void userLogout_8820() throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        userProfilePage.logout();
    }
}
