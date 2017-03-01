import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.FindYourSubWayPage.FindYourSubWayPage;
import pages.MenuPage.MenuPage;
import pojos.MobileUser;

/**
 * Created by e002243 on 17-02-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class UpdateProfileTest extends SubwayAppBaseTest {


    @Test
    public void updateProfile()throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
        LandingPage landingPage = goToHomePage(HomePage.class, "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        MobileUser mobUser = new MobileUser(false, Country.UnitedStates);
        mobileUser.setFirstName(mobUser.getFirstName());
        mobileUser.setLastName(mobUser.getLastName());
        menuPage= menuPage.updateProfileInfo(mobileUser);
        Assert.assertEquals(mobileUser.getFirstName()+mobileUser.getLastName(), menuPage.getUserInformation());
        menuPage.logout();
    }
}

