package userIdentityTest;

import Base.Order;
import Base.SubwayAppBaseTest;

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
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by E003705 on 01-03-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class ResetPasswordTest extends SubwayAppBaseTest {

    @Autowired
    Order order;
    MobileUser mobileUser;


    @Test
    @DirtiesContext
    public void resetPassword()throws Exception {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.gotoMenuPage();
        ContactInformationPage contactInformation= userProfilePage.getContactInformation();
        ForgotYourPasswordPage forgotYourPasswordPage = contactInformation.getPasswordField();
        mobileUser.setPassword(order.getUpdatePassword());
        loginPage = forgotYourPasswordPage.setNewPassword(mobileUser);
        landingPage.gotoLogInPage();
        loginPage.loginAfterResetPassoword(mobileUser);

    }
}
