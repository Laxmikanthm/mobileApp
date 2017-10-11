package pages.CustomizePage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class CustomizePage<T extends AppiumDriver> extends MobileBasePage {
    public CustomizePage(AppiumDriver driver) {
        super(driver);
    }
    public static CustomizePage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new CustomizePageIOS((IOSDriver) driver);
            case "Android":
                return new CustomizePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    public CustomizePage randomCustomization() throws Exception{

        return CustomizePage.get((AppiumDriver)driver);
    }
}
