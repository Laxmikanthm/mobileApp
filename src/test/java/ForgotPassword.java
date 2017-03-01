import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.SubwayAppHomePage;
import pages.LoginPage.LoginPage;

import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.FindYourSubWayPage.FindYourSubWayPage;
import org.testng.Assert;
import playground.fakeBrowserPages.browser.HomePage;
import pojos.MobileUser;

/**
 * Created by E003705 on 28-02-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class ForgotPassword extends SubwayAppBaseTest  {


    @Test
    public void forgotPassword()throws Exception
    {

        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.getHomepageClass(), "MobileApp");
        LoginPage loginPage = homePage.gotoLogInPage();
        ForgotYourPasswordPage forgotPasswordPage= loginPage.forgotPassword();
        homePage= forgotPasswordPage.forgotPassword();
        FindYourSubWayPage findYourSubWayPage= loginPage.loginAfterResetPassoword(forgotPasswordPage.getPasswordString());
        Assert.assertTrue(findYourSubWayPage.findYourSubWayButton(),"Verified Forgot Password");
    }
}
