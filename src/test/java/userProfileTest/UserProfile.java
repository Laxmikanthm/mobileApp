package userProfileTest;

import Base.SubwayAppBaseTest;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LandingPage.LandingPage;
import pages.LoginPage.LoginPage;
import pages.UserProfilePage.UserProfilePage;
import pojos.user.MobileUser;
import pojos.user.RegisterUser;

public class UserProfile extends SubwayAppBaseTest {

    MobileUser mobileUser;
    LandingPage landingPage;
    UserProfilePage userProfilePage;

    //DFA-10885
    @Test
    public void verifyEmailPreferencesPage() throws Exception {
        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage.verifyEmailPreference(); // what are we asserting here?

    }

    //DFA-9174_DFA-9134
    @Test
    public void verifyPrivacyPolicy() throws Exception {

        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage.getabout();
        userProfilePage.navigatetoPrivacyPolicy();
        userProfilePage.assertPrivacyPolicyTexts();
    }

    //DFA-9174
    @Test
    public void verifyTermsAndConditions() throws Exception {
        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage.getabout();
        userProfilePage.navigatetoTermsandConditions();
        userProfilePage.assertTermsAndConditionsTexts();
    }

    //DFA-9172
    @Test
    public void updateProfile() throws Exception {
        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage = userProfilePage.updateProfileInfo( mobileUser );
        userProfilePage.assertUpdateProfile( mobileUser );
        userProfilePage.logout();
    }

    //DFA-9174_DFA-10092_DFA-10048_DFA-9134
    @Test
    public void verifyHelpPage() throws Exception {

        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage.verifyHelp();
        userProfilePage.assertHelpPageTexts();
    }

    //DFA-9134
    @Test
    public void verifyAppVersion_9134() throws Exception
    {
        landingPage = goToHomePage( LandingPage.getLandingPageClass(), "MobileApp" );
        mobileUser = landingPage.registerUser();
        userProfilePage = landingPage.logIn( mobileUser ).goToUserProfilePage();
        userProfilePage.getabout();
        userProfilePage.assertAppVersionTexts();

    }


}
