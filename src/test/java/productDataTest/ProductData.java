package productDataTest;

import Base.SubwayAppBaseTest;
import Enums.BreadSize;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.LocationData;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.ProductClass;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.ProductGroup;
import cardantApiFramework.utils.JdbcUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.OrdersPage.OrdersPage;
import pages.ProductDetailsPage.ProductDetailsPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.user.MobileUser;
import util.MobileApi;

import java.util.List;

public class ProductData extends SubwayAppBaseTest {

    MobileUser mobileUser;
    Store store = JdbcUtil.getLoyaltyStoreDetails();
    LandingPage landingPage;
    OrdersPage ordersPage;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    CustomizedItem customizedItem;

    @Test
    public void testProductDetailsAllSandwichesFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.FOOTLONG, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);

    }

    @Test
    public void testProductDetailsAllSandwichesSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);
    }
    @Test
    public void testProductDetailsSubwayFreshFitFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.FOOTLONG, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);

    }

    @Test
    public void testProductDetailsSubwayFreshFitSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("SUBWAYFreshFit"), BreadSize.SIXINCH, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);

    }
    @Test
    public void testProductDetailsBreakfastFootLongFootLong() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.FOOTLONG, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);
    }

    @Test
    public void testProductDetailsBreakfastSixInch() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("Breakfast"), BreadSize.SIXINCH, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);

    }
    @Test
    public void testProductDetailsKidsMeal() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("KidsMeal"), BreadSize.NONE, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);
    }
    @Test
    public void testProductDetailsChoppedSalad() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.NONE );
        productDetailsPage =   landingPage.logInSelectProductThenGoToProductDetailsPage(mobileUser,
                BaseTest.getStringfromBundleFile("ChoppedSalads"), BreadSize.NONE, store, customizedItem);
        productDetailsPage.assertProductDetails(mobileUser, customizedItem);
        
    }
   /* @Test
    public void testProductDetailsSides() throws Exception{

    }
    @Test
    public void testProductDetailsDrinks() throws Exception{

    }*/
    /* @Test(invocationCount = 10)
    public void testProductDetailsAllSandwiches() throws Exception{
        landingPage = goToHomePage(LandingPage.getLandingPageClass(), "MobileApp");
        mobileUser = landingPage.registerUser("MarneyBoxer@qasubway.com");
        mobileUser.setStoreID( 10813 );
        CustomizedItem customizedItem =  MobileApi.getCustomizedItemDetails( mobileUser, BaseTest.getStringfromBundleFile("AllSandwiches"), BreadSize.SIXINCH );
        System.out.println("customized::::: " + customizedItem.getCustomizedProductDetail().getProductName());
        List<ProductGroup> productGroups = LocationData.getStoreMenu(mobileUser, mobileUser.getStoreID());
        List<ProductClass> productClass = productGroups.get( 0 ).getProductClasses();
        for(int i = 0; i< productClass.size(); i++){
            System.out.println("product :::: " +productClass.get( i ).getName());
        }
       if(customizedItem.getCustomizedProductDetail().getProductName().contains("Corned Beef Reuben")){

            Assert.assertTrue( false );
       }

    }*/

}
