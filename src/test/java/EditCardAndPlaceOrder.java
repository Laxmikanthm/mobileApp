import Base.SubwayAppBaseTest;
import Base.Order;
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
import org.testng.annotations.BeforeTest;
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
import java.util.List;

/**
 * Created by E003705 on 03-04-2017.
 */


@ContextConfiguration({"classpath:MobileAppBeans.xml","classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})

public class EditCardAndPlaceOrder extends SubwayAppBaseTest {

    MobileUser mobileUser;

    @BeforeTest(alwaysRun = true)
    public MobileUser userRegistration()throws Exception
    {
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        return mobileUser;

    }

    //After clicking on  edit check whether selected product is displayed or not
    @Test
    @DirtiesContext
    public void editCartVerifyPlaceOrder() throws Exception{

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        String aVal = ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
        String eVal = ordersPage.getSubItemInfo();
        Assert.assertEquals(aVal,eVal);
        ordersPage.placeAnOrder();
    }

    //When clicked on Add another button same product needs to be added
    @Test
    @DirtiesContext
    public void editCartAddAnotherVerifyPlaceOrder() throws Exception{

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
        ordersPage.getSubItemInfo();
        List<Integer> sizeOfSubItems = ordersPage.addAnotherSameItem();
        Assert.assertEquals(sizeOfSubItems.get(1),sizeOfSubItems.get(0));
        ordersPage.placeAnOrder();

    }

    //In edit page use should be able to remove the selected product
    @Test
    @DirtiesContext
    public void editCartDeleteItemVerifyPlaceOrder() throws Exception{

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
        ordersPage.getSubItemInfo();
        List<Integer> sizeOfSubItems = ordersPage.addAnotherSameItem();
        ordersPage.removeItem();
        Assert.assertEquals(sizeOfSubItems.get(0),sizeOfSubItems.get(1));
        ordersPage.placeAnOrder();

    }

    //When clicked on Something else button user should be able to select different product from the category item
    @Test
    @DirtiesContext
    public void editCartSomethingElseVerifyPlaceOrder() throws Exception{

        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        MenuPage menuPage = homePage.getUserDetails();
        AddCardPage addCardPage = menuPage.gotoAddPaymentMethods();
        addCardPage.addPayment(mobileUser,PaymentMethod.CREDITCARD);
        addCardPage.selectBackButton();
        menuPage.goHome();
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        String aItem = ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
        ordersPage.addAnotherNewItem();
        String eItem = ordersPage.editCartAndPlaceAnOrder("SUBWAY Fresh Fit®",mobileUser, "CT Turpike West Southbound 2, Milford, CT 06460");
        Assert.assertEquals(aItem,eItem);
        ordersPage.clickOnPlaceOrder();
    }

}
