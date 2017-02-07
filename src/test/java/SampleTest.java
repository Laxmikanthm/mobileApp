import Base.SubwayAppBaseTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.HomePage.SubwayAppHomePage;
import pages.LoginPage.LoginPage;

/**
 * Created by Sujit on 1/26/17.
 */
public class SampleTest extends SubwayAppBaseTest {


    @Test
    public void mobileApp() throws Exception {
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.class, "MobileApp");
        LoginPage loginPage = homePage.openMenu().gotoLogInPage();
        loginPage.login();

    }
}