import Base.Order;
import Base.SubwayAppBaseTest;

import azureApi.serviceUtils.AzureIdentityApi;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pojos.tenders.SubwayCard;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

import java.util.List;

import java.util.List;

/**
 * Created by e002243 on 03-03-2017.
 */

@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class PaymentMethods extends SubwayAppBaseTest {
    List<SubwayCard> cards =null;
    MobileUser mobileUser;


//DFA-9175
    @Test
    @DirtiesContext
    public void addCreditCard_8818() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 19428);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        Assert.assertTrue(addCardPage.checkCreditCardElementPresence(),"Credit Card got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }


//DFA-9175
    @Test
    public void addDebitCard() throws Exception {
        mobileUser = new MobileUser(false, Country.UnitedStates, 19428);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.DEBITCARD);
        Assert.assertTrue(addCardPage.checkDebitCardElementPresence(),"Debit Card got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }
//DFA-9177
    @Test
    public void addGiftCard() throws Exception {
        try{
            mobileUser = new MobileUser(false, Country.UnitedStates, 19428);
            RegisterUser.registerAUserWithoutCardLink(mobileUser);
            cards.add(0,SubwayCard.getSubwayCardFromDB(pojos.enums.Lock.TRUE));
            mobileUser.setSubwayCards(cards);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
            addCardPage.addPayment(mobileUser,PaymentMethod.SUBWAYCARD);
            Assert.assertTrue(addCardPage.checkGiftCardElementPresence(),"Subway Card got added successfully");
            addCardPage.selectBackButton();
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        } catch (Exception ex){
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        }
    }
//DFA-9175
    @Test
    @DirtiesContext
    public void addPayPal() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, 19428);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.PAYPAL);
        Assert.assertTrue(addCardPage.checkPayPalElementPresence(),"Paypal Card/account got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }

}



