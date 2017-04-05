import Base.SubwayAppBaseTest;
import enums.Country;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

import java.util.List;

/**
 * Created by E003705 on 03-04-2017.
 */
public class EditCardAndPlaceOrder extends SubwayAppBaseTest {
    MobileUser mobileUser;

    //After clicking on  edit check whether selected product is displayed or not
    @Test
    public void editCartVerifyPlaceOrder() throws Exception{

        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        String aVal = ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, storeName);
        String eVal = ordersPage.getSubItemInfo();
        Assert.assertEquals(aVal,eVal);
        ordersPage.placeAnOrder();
    }

    //When clicked on Add another button same product needs to be added
    @Test
    public void editCartAddAnotherVerifyPlaceOrder() throws Exception{

        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, storeName);
        ordersPage.getSubItemInfo();
        List<Integer> sizeOfSubItems = ordersPage.addAnotherSameItem();
        Assert.assertEquals(sizeOfSubItems.get(1),sizeOfSubItems.get(0));
        ordersPage.placeAnOrder();

    }

    //In edit page use should be able to remove the selected product
    @Test
    public void editCartDeleteItemVerifyPlaceOrder() throws Exception{

        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, storeName);
        ordersPage.getSubItemInfo();
        List<Integer> sizeOfSubItems = ordersPage.addAnotherSameItem();
        ordersPage.removeItem();
        Assert.assertEquals(sizeOfSubItems.get(0),sizeOfSubItems.get(1));
        ordersPage.placeAnOrder();

    }

    //When clicked on Something else button user should be able to select different product from the category item
    @Test
    public void editCartSomethingElseVerifyPlaceOrder() throws Exception{

        String storeName = "CT Turpike West Southbound 2, Milford, CT 06460";
        mobileUser = new MobileUser(false, Country.UnitedStates, 54589);
        mobileUser = RegisterUser.registerAUserWithoutCardLink(mobileUser);
        RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
        Order order = remoteOrder.placeRandomOrderWithSpecificProduct("All Sandwiches");
        LandingPage landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        LoginPage loginPage = landingPage.gotoLogInPage();
        HomePage homePage=loginPage.login(mobileUser);
        SearchStore searchStore = homePage.findYourSubWay();
        OrdersPage ordersPage=searchStore.findYourStore("06460");
        String aItem = ordersPage.editCartAndPlaceAnOrder("All Sandwiches",mobileUser, storeName);
        //ScrollMethod
        ordersPage.addAnotherNewItem();
        String eItem = ordersPage.editCartAndPlaceAnOrder("SUBWAY Fresh Fit™",mobileUser, storeName);
        Assert.assertEquals(aItem,eItem);
        ordersPage.placeOrder();
    }

}
