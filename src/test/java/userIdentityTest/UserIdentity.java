package userIdentityTest;
import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})

public class UserIdentity extends SubwayAppBaseTest {
    @Autowired
    MobileUser mobileUser;
    LandingPage landingPage;
    RegistrationPage registrationPage;
    UserProfilePage userProfilePage;
    HomePage homePage;
    ForgotYourPasswordPage forgotYourPasswordPage;
    UserProfilePage profilePage;
    LoginPage loginPage;

    @Test
    public void testRegisterNewUser() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        registrationPage = landingPage.gotoRegistrationPage();
        mobileUser = landingPage.getUser();
        homePage = registrationPage.signUp(mobileUser);
        profilePage = homePage.goToUserProfilePage();
        profilePage.assertUserLoggedIn(mobileUser).logout();
    }

    //DFA-9172_DFA-5490_DFA-5489_DFA-5488_DFA-5487_DFA-5486_DFA-5485_DFA-5484
    @Test
    public void forgotPassword()throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        loginPage =  landingPage.gotoLogInPage();
        forgotYourPasswordPage = loginPage.goToForgotPasswordPage();
        loginPage = forgotYourPasswordPage.setNewPassword(mobileUser);
        loginPage.loginAfterResetPassoword(mobileUser);
    }

    @Test
    @DirtiesContext
    public void resetPassword()throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        userProfilePage =  landingPage.logIn(mobileUser).goToUserProfilePage();
        ContactInformationPage contactInformation= userProfilePage.getContactInformation();
        forgotYourPasswordPage = contactInformation.getPasswordField();
        loginPage = forgotYourPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);

    }
   /*
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
   @Test
    public void testUserLoginLogout() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        homePage = loginPage.login(mobileUser);
        profilePage = homePage.goToUserProfilePage();
        profilePage.assertUserLoggedIn(mobileUser).logout();
               // .assertUserLoggedOut();
    }*/

   /* @Test
    @DirtiesContext
    public void resetPassword()throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        homePage = loginPage.login(mobileUser);
        menuPage = homePage.gotoMenuPage();

        ContactInformationPage contactInformation= menuPage.getContactInformation();
        forgotPasswordPage = contactInformation.getPasswordField();
        mobileUser.setPassword(order.getUpdatePassword());
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);

    }
    //DFA-9172_DFA-5490_DFA-5489_DFA-5488_DFA-5487_DFA-5486_DFA-5485_DFA-5484
    @Test
    @DirtiesContext
    public void goToForgotPasswordPage()throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        forgotPasswordPage= loginPage.goToForgotPasswordPage();
        loginPage = forgotPasswordPage.setNewPassword(mobileUser);
        loginPage.loginAfterResetPassoword(mobileUser);
    }

    //DFA-9174
    @Test
    public void verifyTermandConditions() throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        homePage = loginPage.login(mobileUser);
        menuPage = homePage.getUserDetails();
        menuPage.getabout();
        menuPage.navigatetoTermsandConditions();
        menuPage.assertTermsAndConditionsTexts();
    }*/
}
