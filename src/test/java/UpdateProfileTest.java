import Base.SubwayAppBaseTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactInformationPage.ContactInformationPage;
import pages.HomePage.SubwayAppHomePage;
import pages.LoginPage.LoginPage;
import pages.FindYourSubWayPage.FindYourSubWayPage;
import pages.NamePage.NamePage;
import pages.PhonePage.PhonePage;
import pages.SubWayPage.SubWayPage;

/**
 * Created by e002243 on 17-02-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class UpdateProfileTest extends SubwayAppBaseTest {

    @Test
    public void userLogin() throws Exception {
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.getHomepageClass(), "MobileApp");
        LoginPage loginPage = homePage.gotoLogInPage();
        loginPage.login();
    }

    @Test
    public void updateProfile()throws Exception
    {
        SubwayAppHomePage homePage = goToHomePage(SubwayAppHomePage.getHomepageClass(), "MobileApp");
        LoginPage loginPage = homePage.gotoLogInPage();
        FindYourSubWayPage SubWayhomePage=loginPage.login();
        SubWayPage subWayPage= SubWayhomePage.getUserDetails();
        ContactInformationPage contactInforPage= subWayPage.getContactInformation();
        NamePage namepage= contactInforPage.getNameField();
        ContactInformationPage contactInforPage1=namepage.updateFirstNameLastName();
        contactInforPage1.selectBackButton();
        subWayPage.logout();
        subWayPage.logOutInpopupButton();
      /*  NamePage namepage1= contactInforPage.getPasswordField();
        PhonePage namepage2= contactInforPage.getPhoneField();
        ContactInformationPage contactInforPage2= namepage2.updatePhoneNumber();
        SubWayPage subWayPage1= contactInforPage2.selectBackButton();
        String AfirstNameLastName=  subWayPage1.getUserInformation();
        String EfirstNameLastName=namepage1.getFirstNameLastName();
        Assert.assertEquals(AfirstNameLastName,EfirstNameLastName);
*/

    }
}

