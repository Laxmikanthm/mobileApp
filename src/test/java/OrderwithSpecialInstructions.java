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
import pages.OrdersPage.OrdersPage;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pages.SearchStore.SearchStore;
import pages.SubwayPage.SubwayPage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

/**
 * Created by e002243 on 23-03-2017.
 */

@ContextConfiguration("classpath:MobileAppBeans.xml")
public class OrderwithSpecialInstructions extends SubwayAppBaseTest {
    MobileUser mobileUser;

    @Test
    public void OrderSpecialInstructions() throws Exception
    {

        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        String specialInstructions ="Required more salt";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        SubwayPage subwayPage = menuPage.addPaymentMethods();
        ChoosePaymentMethodPage choosePaymentMethodPage = subwayPage.addPaymentMethod();
        AddCardPage addCardPage = choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
        PaymentMethodsPage paymentMethodsPage= addCardPage.addCardDetails(mobileUser);
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrderSpecialInstructions("Sides", mobileUser, storeName,specialInstructions);

    }
}
