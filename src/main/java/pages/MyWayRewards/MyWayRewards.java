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
import kobieApi.pojos.Loyalty;
import kobieApi.pojos.Summaries;
import kobieApi.serviceUtils.KobieClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pojos.user.RemoteOrderCustomer;

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

    abstract MobileButton getGotIt() throws Exception;

    abstract MobileButton getToolbarClose() throws Exception;

    By Swipe = By.id("com.subway.mobile.subwayapp03:id/reward_page_text");

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

    public void getSwipe() throws Exception {
        List<WebElement> elements = getElements(Swipe);
        for (int i = 0; i < 3; i++) {
            WebElement ele = elements.get(0);
            MobileElement element = (MobileElement) ele;
            Thread.sleep(3000L);

            element.swipe(SwipeElementDirection.LEFT, 500);

        }
        getGotIt().click();
        getToolbarClose().click();

    }
    public void toolBarClose()throws Exception
    {
        getToolbarClose().click();
    }
    public int getTokens(RemoteOrderCustomer remoteOrderCustomer) throws Exception
    {
        List<Summaries> summaries=remoteOrderCustomer.getLoyaltyLookup().getLoyalty().getSummaries();
        int tokens=0;
        for(int i=0;i<summaries.size();i++)
        {
            if(summaries.get(i).getRewardType()=="Points")
            {

                tokens=Integer.parseInt(summaries.get(i).getAvailable());
                tokens=+tokens;
            }
        }
        return tokens;

    }

    public void validateTokens(RemoteOrderCustomer remoteOrderCustomer, HomePage homePage)throws Exception
    {
            int tokens=getTokens(remoteOrderCustomer);
             homePage.tokenValue();
        Assert.assertEquals(tokens,Integer.parseInt(homePage.tokenValue()));
    }
    public void validateCertificate(RemoteOrderCustomer remoteOrderCustomer, HomePage homePage)throws Exception
    {
        Loyalty loyalty=new Loyalty(remoteOrderCustomer);
        remoteOrderCustomer= KobieClient.getLoyaltyLookup(loyalty,remoteOrderCustomer);
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),homePage.certsCount());

    }
}