package pages.UserProfilePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pages.HomePage.HomePage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

public abstract class UserProfilePage<T extends AppiumDriver> extends MobileBasePage {

    public UserProfilePage(AppiumDriver driver) {
        super(driver);
    }
    public static UserProfilePage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new UserProfilePageIOS((IOSDriver) driver);
            case "Android":
                return new UserProfilePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    abstract MobileButton getEmailAddress() throws Exception;
    abstract MobileButton getFullName() throws Exception;
    abstract MobileButton getInitials() throws Exception;
    abstract MobileButton getPurchaseHistory() throws Exception;

    public HomePage assertEmailDisplayName(RemoteOrderCustomer mobileUser) throws Exception{
        try {
            Logz.step("Asserting user email in menu page ");
            String initials = mobileUser.getFirstName().substring(0, 1) +""+ mobileUser.getLastName().substring(0, 1);
            Assert.assertEquals(getEmailAddress().getText(), mobileUser.getEmailAddress());
            Assert.assertEquals(getFullName().getText(), mobileUser.getFirstName() + " " + mobileUser.getLastName());
            Assert.assertEquals(getInitials().getText(), initials);
            Logz.step("Asserted user email in menu page ");
        }catch (Exception ex){
            throw new Exception("Unable to assert user email in menu page\n" +ex.getMessage());
        }

        return HomePage.get((AppiumDriver) driver);
    }
    public PurchaseHistoryPage goToPurchaseHistoryPage() throws Exception{
        Logz.step("##### Navigating to Purchase History Page #####");

        getPurchaseHistory().click();
        Logz.step("##### Navigated to Purchase History Page #####");
        return PurchaseHistoryPage.get((AndroidDriver)driver);
    }
    public UserProfilePage assertUserLoggedIn(RemoteOrderCustomer mobileUser) throws Exception{
        try {
            Logz.step("Asserting user is logged in ");
           /* String actualUser = getOrderButton().getText();
            String expectedUser = BaseTest.getStringfromBundleFile("OrderButton");
            Assert.assertEquals(actualUser, expectedUser);*/
            assertEmailDisplayName(mobileUser);
            Logz.step("Asserted user is logged in ");

        }catch (Exception ex){
            throw new Exception("Unable to assert user is logged in\n" +ex.getMessage());
        }

        return UserProfilePage.get((AppiumDriver) driver);
    }
    public UserProfilePage logout() throws Exception
    {
        try {
            /*scrollToElement(logout,0.9,0.5);
            getLogOut().isReady();
            getLogOut().click();
            logOutInpopupButton();*/
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return UserProfilePage.get((AppiumDriver) driver);
    }
}
