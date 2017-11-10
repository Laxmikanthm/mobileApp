package orderTest;

import Base.SubwayAppBaseTest;
import homePageTest.HomePage;
import org.testng.annotations.Test;
import pages.LandingPage.LandingPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.MobileUser;

public class YourOrder extends SubwayAppBaseTest {

    @Test(invocationCount = 10)
    public void LogIn() throws Exception {
       LandingPage landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp");
       MobileUser mobileUser = landingPage.registerUser("NancyBottoms@qasubway.com");
       pages.HomePage.HomePage homePage =  landingPage.logIn( mobileUser );
        UserProfilePage userProfilePage = homePage.goToUserProfilePage();
        userProfilePage.logout();

    }

   /* @Test
    public void testYourOrderDefaultOrder() throws Exception {
        //picking up from assertion
        //ready today assertion
        //your order assertion
        //make it a meal assertion
        //want to add more to your order assertion
        //view full menu  assertion - clicking on should navigate to menu page
        //special instructions assertion
        //order total assertion
        //place order assertion in home page
        //place order
        //assert order confirmation in checkout page and home page

    }

    @Test
    public void testYourOrderDefaultOrderMakeItAMeal() throws Exception {
        //place order
        //assert order confirmation in checkout page and home page

    }

    @Test
    public void testYourOrderCustomizeOrder() throws Exception {
        //select an item - navigate to your order page
        //Click on customize and customize the order
        //assert customized order
        //place order
        //assert order confirmation in checkout page and home page

    }


    @Test
    public void testYourOrderCustomizeOrderMakeItAMeal() throws Exception {
        //place order
        //assert order confirmation in checkout page and home page

    }

    @Test
    public void testYourOrderCustomizeOrderReadyTodayAtChange() throws Exception {
        //select an item - navigate to your order page
        //ready today assertion
        //change ready today time
        //assert time is changed
        //place order
        //assert the pick time in home page

    }

    @Test
    public void testYourOrderCustomizeOrderViewFullMenu() throws Exception {
        //select 2 items (foolong and sixinch)
        //place order
        //assert order confirmation in checkout page and home page

    }

    @Test
    public void testYourOrderCustomizeOrderChangePaymentType() throws Exception {
        //select 2 items (foolong and sixinch)
        //place order
        //assert order confirmation in checkout page and home page

    }
    @Test
    public void testYourOrderDefaultOrderAddFavorites() throws Exception {
        //select 2 items (foolong and sixinch)
        //place order
        //assert order confirmation in checkout page and home page

    }
    @Test
    public void testEmptyBagAssertion() throws Exception {
        //select 2 items (foolong and sixinch)
        //place order
        //assert order confirmation in checkout page and home page

    }*/

}
