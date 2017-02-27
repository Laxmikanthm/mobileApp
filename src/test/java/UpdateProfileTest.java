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
        ContactInformationPage contactInformationPage= subWayPage.getContactInformation();
        NamePage namepage= contactInformationPage.getNameField();
        contactInformationPage=namepage.updateFirstNameLastName();
        String eFirstNameLastName=namepage.getFirstNameLastName();

        //namepage = contactInformationPage.getPasswordField();
        PhonePage phonePage= contactInformationPage.getPhoneField();
        contactInformationPage= phonePage.updatePhoneNumber();
        // subWayPage= contactInformationPage.selectBackButton();
//        String AfirstNameLastName=  subWayPage.getUserInformation();
//        String EfirstNameLastName= namepage.getFirstNameLastName();

        String aFirstNameLastName=subWayPage.getUserInformation();

        System.out.println(eFirstNameLastName+"--"+aFirstNameLastName);
        Assert.assertEquals(namepage.getFirstNameLastName(),subWayPage.getUserInformation());
        subWayPage.logout();
        subWayPage.logOutInpopupButton();


    }
}

