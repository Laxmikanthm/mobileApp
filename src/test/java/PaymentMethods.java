import Base.SubwayAppBaseTest;
import azureApi.serviceUtils.AzureIdentityApi;
import enums.Country;
import org.openqa.selenium.internal.Lock;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.PayPalPage.PayPalPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pages.SubwayPage.SubwayPage;
import pojos.tenders.SubwayCard;
import pojos.user.MobileUser;
import snaplogicApi.serviceUtils.RegisterUser;

/**
 * Created by e002243 on 03-03-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class PaymentMethods extends SubwayAppBaseTest {
    MobileUser mobileUser;


    @Test
    public void addCreditCard() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addCreditorDebitCard(subwayPage, mobileUser);

        //Assert

    }

    @Test
    public void addDebitCard() throws Exception {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        mobileUser.registerNewUserHeadless(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
        addCardPage.addCreditorDebitCard(subwayPage, mobileUser);
        //Assert

    }

    //works fine but have open question
   /* @Test
    public void addGiftCard() throws Exception {
        try

        {
            mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
            //mobileUser.registerNewUserHeadless(mobileUser);
            mobileUser = RegisterUser.registerAUser(mobileUser);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            SubwayPage subwayPage = menuPage.addPaymentMethods();
            AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
            addCardPage.addGiftCard(subwayPage, mobileUser);
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        } catch (Exception ex)

        {
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        }
    }*/


        @Test
        public void addPayPal () throws Exception{

            MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
            mobileUser.registerNewUserHeadless(mobileUser);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            SubwayPage subwayPage = menuPage.addPaymentMethods();
            AddCardPage addCardPage = subwayPage.getAddCardPageInstance();
            addCardPage.addPayPal(subwayPage, mobileUser);
            //Assert
        }
    }


