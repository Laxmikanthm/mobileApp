import Base.SubwayAppBaseTest;
import Base.Order;
import cardantApiFramework.pojos.Store;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCardPage.AddCardPage;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;
import java.util.List;

/**
 * Created by E003705 on 03-04-2017.
 */


@ContextConfiguration({"classpath:order-data.xml"})
@TestExecutionListeners(inheritListeners = false, listeners =
        {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})

public class EditCardAndPlaceOrder extends SubwayAppBaseTest {

    RemoteOrder remoteOrder;
    @Autowired
    Order order;
    MobileUser mobileUser;
    Store store=JdbcUtil.getLoyaltyStoreDetails();
    @BeforeClass
    public void init() throws Exception {



    }
    //After clicking on  edit check whether selected product is displayed or not
    @Test
    @DirtiesContext
    public void editCartVerifyPlaceOrder() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        ordersPage.assertProduct(ordersPage.editCartAndPlaceAnOrder(order.getCategoryAllSandwiches(),remoteOrder, store.getAddress1()),ordersPage.getSubItemInfo());
        ordersPage.placeAnOrder();
    }

    //When clicked on Add another button same product needs to be added
    @Test
    @DirtiesContext
    public void editCartAddAnotherVerifyPlaceOrder() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, store.getLocationCode());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(store.getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.editCartAndPlaceAnOrder(order.getCategoryAllSandwiches(),remoteOrder, order.getStoreName());
        ordersPage.getSubItemInfo();
        ordersPage.assertEditCartAddAnother();
        ordersPage.placeAnOrder();

    }

    //In edit page use should be able to remove the selected product
    @Test
    @DirtiesContext
    public void editCartDeleteItemVerifyPlaceOrder() throws Exception{
        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        ordersPage.editCartAndPlaceAnOrder(order.getCategoryAllSandwiches(),remoteOrder, order.getStoreName());
        ordersPage.getSubItemInfo();
        ordersPage.assertEditCartDeleteItem();
        ordersPage.placeAnOrder();

    }

    //When clicked on Something else button user should be able to select different product from the category item
    @Test
    @DirtiesContext
    public void editCartSomethingElseVerifyPlaceOrder() throws Exception{

        mobileUser = new MobileUser(false, Country.UnitedStates, JdbcUtil.getOnlineStore());
        RegisterUser.registerAUserWithoutCardLink(mobileUser);
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        HomePage homePage = landingPage.getUserLoginAndAddingCard(mobileUser,PaymentMethod.CREDITCARD);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore(JdbcUtil.getStoreDetails().getZipCode());
        remoteOrder = mobileUser.getCart().getRemoteOrder();
        String aItem = ordersPage.editCartAndPlaceAnOrder(order.getCategoryAllSandwiches(),remoteOrder, order.getStoreName());
        ordersPage.addAnotherNewItem();
        String eItem = ordersPage.editCartAndPlaceAnOrder(order.getCategorySUBWAYFreshFit(),remoteOrder, order.getStoreName());
        ordersPage.assertEditCartSomethingElseVerify(aItem,eItem);
        ordersPage.clickOnPlaceOrder();
    }

}
