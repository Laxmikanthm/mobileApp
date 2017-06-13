import Base.Order;
import Base.SubwayAppBaseTest;
import cardantApiFramework.utils.JdbcUtil;
import enums.Country;
import enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.BeforeClass;
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
 * Created by e002243 on 27-04-2017.
 */
@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class OrderwithGiftcardCredit extends SubwayAppBaseTest {

    @Autowired
    Order order;
    MobileUser mobileUser;
    @BeforeClass(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {

        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        return mobileUser;

    }

    @Test
    @DirtiesContext
    public void orderWithGiftCardCredit() throws  Exception
    {
        String paymentTypeCreditCard = "CreditCard";
        String paymentTypeGiftCard="GiftCard";
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.addPayment(mobileUser,PaymentMethod.SUBWAYCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(order.getZipCode());
        ordersPage.placeRandomOrder(order.getCategoryAllSandwiches(), mobileUser, order.getStoreName());
    }
}
