import Base.SubwayAppBaseTest;
import enums.Country;
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
 * Created by e002243 on 17-02-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class UpdateProfileTest extends SubwayAppBaseTest {
    MobileUser mobileUser;


    @Test
    public void updateProfile()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        MobileUser mobUser = new MobileUser(false, Country.UnitedStates, 54588);
        menuPage= menuPage.updateProfileInfo(mobUser);
        Assert.assertEquals(mobUser.getFirstName()+" "+mobUser.getLastName(), menuPage.getUserInformation());
        menuPage.logout();
    }
}

