package productDataTest;

import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pages.ProductDetailsPage.ProductDetailsPage;
import pojos.user.MobileUser;

public class ProductData extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;

    @Test
    public void testProductDetailsAllSandwichesFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        landingPage.productDetailsAssertion(BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG, store);
    }

   /* @Test
    public void testProductDetailsAllSandwichesSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH);
        productDetailsPage.assertProductDetails( mobileUser);
    }
    @Test
    public void testProductDetailsSubwayFreshFitFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG);
        productDetailsPage.assertProductDetails( mobileUser);

    }
    @Test
    public void testProductDetailsSubwayFreshFitSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH);
        productDetailsPage.assertProductDetails( mobileUser);

    }
    @Test
    public void testProductDetailsBreakfastFootLongFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG);
        productDetailsPage.assertProductDetails( mobileUser);

    }
    @Test
    public void testProductDetailsBreakfastSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH);
        productDetailsPage.assertProductDetails( mobileUser);

    }
    @Test
    public void testProductDetailsKidsMeal() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE);
        productDetailsPage.assertProductDetails( mobileUser);
    }
    @Test
    public void testProductDetailsChoppedSalad() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser();
        homePage = landingPage.logInSelectStore(mobileUser, store);
        productDetailsPage =  homePage.goToProductDetailsPage(mobileUser, BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.SIXINCH);
        productDetailsPage.assertProductDetails( mobileUser);
    }*/
   /* @Test
    public void testProductDetailsSides() throws Exception{

    }
    @Test
    public void testProductDetailsDrinks() throws Exception{

    }*/

}
