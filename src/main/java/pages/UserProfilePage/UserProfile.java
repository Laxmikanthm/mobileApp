package pages.UserProfilePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pages.HomePage.HomePage;
import pojos.user.MobileUser;
import utils.Logz;

public abstract class UserProfile<T extends AppiumDriver> extends MobileBasePage {

    public UserProfile(AppiumDriver driver) {
        super(driver);
    }
    public static UserProfile get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new UserProfileIOS((IOSDriver) driver);
            case "Android":
                return new UserProfileAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    abstract MobileButton getEmailAddress() throws Exception;
    abstract MobileButton getFullName() throws Exception;
    abstract MobileButton getInitials() throws Exception;

    public HomePage assertEmailDisplayName(MobileUser mobileUser) throws Exception{
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
}
