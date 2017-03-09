import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.SubwayPage.SubwayPage;
import pojos.user.MobileUser;

/**
 * Created by e002243 on 03-03-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class PaymentMethods extends SubwayAppBaseTest {


    @Test
    public void addCreditCard() throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        addCardPage.addCardDetails(mobileUser);

    }

    @Test
    public void addDebitCard() throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodDebitCard();
        addCardPage.addCardDetails(mobileUser);

    }

    @Test
    public void addGiftCard() throws Exception
    {
        MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodGiftCard();
        addCardPage.addSubwayCardDetails();

    }
}
