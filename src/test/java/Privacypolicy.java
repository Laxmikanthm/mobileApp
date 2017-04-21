import Base.SubwayAppBaseTest;
import enums.Country;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 20-04-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class Privacypolicy extends SubwayAppBaseTest {

    MobileUser mobileUser;
    @Test
    public void verifyAppVersion() throws Exception
    {
        By appVersionLocator= By.xpath("//android.widget.TextView[@text='Version']");

        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        menuPage.getabout();
        Assert.assertTrue(menuPage.checkElemetnPresence(),"Privacy Statment Text present in the Privacypolicy");


    }
}
