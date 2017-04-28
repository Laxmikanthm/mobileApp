import Base.SubwayAppBaseTest;
import enums.Country;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
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
        String paymentType = "DebitCard";
        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        String specialInstructions ="Required more salt";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        /*mobileUser.setEmailAddress("sushma.kamlakar@cigniti.com");
        mobileUser.setPassword("Cigniti@123");*/
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,paymentType);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.placeRandomOrderSpecialInstructions("All Sandwiches", mobileUser, storeName, specialInstructions);

    }
}
