import Base.SubwayAppBaseTest;
import cardantApiFramework.pojos.AppUser;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.SubwayAppHomePage;
import pages.LoginPage.LoginPage;
import pages.RegistrationPage.RegistrationPage;

/**
 * Created by Sujit on 1/26/17.
 */
@ContextConfiguration("classpath:MobileAppBeans.xml")
public class UserLoginTest extends SubwayAppBaseTest {


    @Test
    public void userLogin() throws Exception {
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.getHomepageClass(), "MobileApp");
        LoginPage loginPage = homePage.gotoLogInPage();
        loginPage.login();
    }

    @Test
    public void createUser() throws Exception{
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.getHomepageClass(), "MobileApp");
        RegistrationPage registrationPage = homePage.gotoRegistrationPage();
        registrationPage.signUp();
    }
}