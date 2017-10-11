package pages.OrderConfirmationPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePage;
import pages.NamePage.NamePage;
import pages.NamePage.NamePageAndroid;
import pages.NamePage.NamePageIOS;

public abstract class OrderConfirmationPage<T extends AppiumDriver> extends MobileBasePage {
    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }
    public static OrderConfirmationPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new OrderConfirmationPageIOS((IOSDriver) driver) {
                };
            case "Android":
                return new OrderConfirmationPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public HomePage assertTotalAmountInYourOrderPage() throws Exception{

        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertLoyaltyDisplay() throws Exception{
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertOrderSummaryInYourOrderPage() throws Exception{
        return HomePage.get((AppiumDriver)driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
