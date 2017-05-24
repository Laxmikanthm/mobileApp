package pages.MyWayRewards;

        import base.gui.controls.mobile.generic.MobileButton;
        import base.gui.controls.mobile.generic.MobileLabel;
        import base.gui.controls.mobile.generic.MobileTextBox;
        import base.gui.controls.mobile.generic.PasswordTextBox;
        import base.pages.mobile.MobileBasePage;
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.SwipeElementDirection;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.ios.IOSDriver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import pages.LoginPage.LoginPageAndroid;
        import pages.LoginPage.LoginPageIOS;

        import java.util.List;

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
    By Swipe = By.xpath("//android.widget.LinearLayout[@resource-id='com.subway.mobile.subwayapp03:id/page_indicator_layout']/android.widget.ImageView");


    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }
    public void getSwipe()throws Exception
    {
        List<WebElement> elements=getElements(Swipe);
        for(int i=0;i<elements.size()-1;i++)
        {
            WebElement ele = elements.get(i);
            MobileElement element = (MobileElement) ele;
            Thread.sleep(10000L);

            element.swipe(SwipeElementDirection.LEFT, 2000);

        }
        elements.size();
    }
}