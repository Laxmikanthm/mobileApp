package pages.SidesPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;

public abstract class SidesPage<T extends AppiumDriver> extends MobileBasePage {
    public SidesPage(AppiumDriver driver) {
        super(driver);
    }

    public static SidesPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new SidesPageIOS((IOSDriver) driver);
            case "Android":
                return new SidesPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public HomePage placeSidesOrder(CustomizedItem customizedItem) throws Exception{
//ToDo
        return HomePage.get((AppiumDriver)driver);
    }

}
