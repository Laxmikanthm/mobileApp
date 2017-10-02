package userIdentityTest;
import Base.Order;
import Base.SubwayAppBaseTest;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
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
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import pojos.user.RemoteOrderCustomer;

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})

public class UserIdentity extends SubwayAppBaseTest {
    @Autowired
    RemoteOrderCustomer mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    MenuPage menuPage;
    HomePage homePage;
    ForgotYourPasswordPage forgotPasswordPage;


    @Test
    public void testRegisterNewUser() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        registrationPage = landingPage.gotoRegistrationPage();
        mobileUser = landingPage.getUser();
        homePage = registrationPage.signUp(mobileUser);
        homePage.assertUserLoggedIn(mobileUser);
    }

    @Test
    public void testUserLoginLogout() throws Exception {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        homePage = loginPage.login(mobileUser);
        menuPage = homePage.assertUserLoggedIn(mobileUser);
        menuPage.logout().assertUserLoggedOut();
    }

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
    public void forgotPassword()throws Exception
    {
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser(BaseTest.getStringfromBundleFile("IdentityUser"));
        loginPage = landingPage.gotoLogInPage();
        forgotPasswordPage= loginPage.forgotPassword();
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
