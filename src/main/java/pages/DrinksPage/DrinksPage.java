package pages.DrinksPage;

import Base.SubwayAppBaseTest;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pojos.CustomizedItem.CustomizedItem;

public abstract class DrinksPage<T extends AppiumDriver> extends MobileBasePage {
    public DrinksPage(AppiumDriver driver) {
        super(driver);
    }

    public static DrinksPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new DrinksPageIOS((IOSDriver) driver);
            case "Android":
                return new DrinksPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public DrinksPage placeDrinksOrder(CustomizedItem customizedItem) throws Exception{
        //ToDo
        return DrinksPage.get((AppiumDriver)driver);
    }
}
