package userIdentityTest;

import Base.SubwayAppBaseTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 19-04-2017.
 */
@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class TermsandConditions extends SubwayAppBaseTest {
    MobileUser mobileUser;
//DFA-9174
    @Test
    public void verifyTermandConditions() throws Exception
    {
        mobileUser=setCountryName();
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        UserProfilePage userProfilePage = homePage.getUserDetails();
        userProfilePage.getabout();
        userProfilePage.navigatetoTermsandConditions();
        userProfilePage.assertTermsAndConditionsTexts();
    }
}
