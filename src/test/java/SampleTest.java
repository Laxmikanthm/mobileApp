import Base.SubwayAppBaseTest;
import org.testng.annotations.Test;
import pages.HomePage.SubwayAppHomePage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;

/**
 * Created by Sujit on 1/26/17.
 */
public class SampleTest extends SubwayAppBaseTest {


    @Test
    public void kioskFlow() throws Exception {
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.class, "mobileApp");
        LoginPage loginPage = homePage.openMenu().gotoLogInPage();


    }
}