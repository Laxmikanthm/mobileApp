import Base.SubwayAppBaseTest;

import azureApi.serviceUtils.AzureIdentityApi;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
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

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class PaymentMethods extends SubwayAppBaseTest {
    List<SubwayCard> cards =null;
    MobileUser mobileUser;


    @Test
    public void addCreditCard() throws Exception {
        String paymentType = "CreditCard";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,paymentType);
        Assert.assertTrue(addCardPage.checkCreditCardElementPresence(),"Credit Card got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }

    @Test
    public void addDebitCard() throws Exception {
        String paymentType = "DebitCard";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,paymentType);
        Assert.assertTrue(addCardPage.checkDebitCardElementPresence(),"Debit Card got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }

    @Test
    public void addGiftCard() throws Exception {
        try

        {
            String paymentType = "GiftCard";
            mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
            //mobileUser.registerNewUserHeadless(mobileUser);
            //RegisterUser.registerAUser(mobileUser);
            //cards.add(0,SubwayCard.getSubwayCardFromDB(pojos.enums.Lock.TRUE));
            mobileUser.setEmailAddress("sushma.kamlakar@cigniti.com");
            mobileUser.setPassword("Cigniti@123");
            mobileUser.setSubwayCards(cards);
            LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
            LoginPage loginPage = landingPage.gotoLogInPage();
            HomePage homePage = loginPage.login(mobileUser);
            MenuPage menuPage = homePage.getUserDetails();
            AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
            addCardPage.addPayment(mobileUser,paymentType);
            Assert.assertTrue(addCardPage.checkGiftCardElementPresence(),"Subway Card got added successfully");
            addCardPage.selectBackButton();
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        } catch (Exception ex){
            new SubwayCard().lockSubwayCard(mobileUser, pojos.enums.Lock.FALSE);
            AzureIdentityApi.deleteUserFromAzure(mobileUser.getEmailAddress());
        }
    }


    @Test
    public void addPayPal () throws Exception{
        String paymentType = "Paypal";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage = loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,paymentType);
        Assert.assertTrue(addCardPage.checkPayPalElementPresence(),"Paypal Card/account got added successfully");
        addCardPage.selectBackButton();
        menuPage.logout();

    }

}



