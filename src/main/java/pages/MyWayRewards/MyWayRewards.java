package pages.MyWayRewards;

        import base.gui.controls.mobile.generic.MobileButton;
        import base.gui.controls.mobile.generic.MobileLabel;
        import base.gui.controls.mobile.generic.MobileTextBox;
        import base.gui.controls.mobile.generic.PasswordTextBox;
        import base.pages.mobile.MobileBasePage;
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.ios.IOSDriver;
        import pages.LoginPage.LoginPageAndroid;
        import pages.LoginPage.LoginPageIOS;

/**
 * Created by E001599 on 18-05-2017.
 */
public abstract class MyWayRewards<T extends AppiumDriver> extends MobileBasePage {
    public MyWayRewards(AppiumDriver driver) {
        super(driver);
    }


    public static MyWayRewards get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new MyWayRewardsIOS((IOSDriver) driver);
            case "Android":
                return new MyWayRewardsAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}