package userProfileTest;

import Base.SubwayAppBaseTest;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 18-04-2017.
 */
public class HelpPage extends SubwayAppBaseTest {


    MobileUser mobileUser;
//DFA-9174_DFA-10092_DFA-10048_DFA-9134
    @Test
    public void verifyHelpPage() throws Exception
    {
        try {
            mobileUser=setCountryName();
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            UserProfilePage userProfilePage = homePage.getUserDetails();
            userProfilePage.verifyHelp();
            userProfilePage.assertHelpPageTexts();
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }
}
