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
 * Created by e002243 on 19-04-2017.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class TermsandConditions extends SubwayAppBaseTest {

    MobileUser mobileUser;
    @Test
    public void verifyTermandConditions() throws Exception
    {

        By termsAndConditionsTextLocator = By.id("android:id/content");
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        menuPage.getabout();
        menuPage.navigatetoTermsandConditions();
        Assert.assertTrue(menuPage.isElementPresent(termsAndConditionsTextLocator),"Terms and conditions Text present in the Terms and conditions page");

    }
}
