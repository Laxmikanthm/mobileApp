package pages.MyWayRewards;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.pages.mobile.MobileBasePage;
import com.amazonaws.services.opsworks.model.App;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import kobieApi.pojos.Certificates;
import kobieApi.pojos.Loyalty;
import kobieApi.pojos.Summaries;
import kobieApi.serviceUtils.Kobie;
import kobieApi.serviceUtils.KobieClient;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pojos.user.RemoteOrderCustomer;
import org.openqa.selenium.interactions.touch.FlickAction;
import util.MobileApi;

import java.time.Duration;
import java.util.List;

/**
 * Created by E001599 on 18-05-2017.
 */
public abstract class MyWayRewards<T extends AppiumDriver> extends MobileBasePage {
    public MyWayRewards(AppiumDriver driver) {
        super(driver);
    }


    public static MyWayRewards get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

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

    abstract MobileLabel gettokensmyreward() throws Exception;

    abstract MobileButton getToolbarClose() throws Exception;

    Dimension size;

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
            Thread.sleep(3000L);
            swipeLeft(ele);
        }
        getGotIt().click();
        getToolbarClose().click();

    }

    public void swipeLeft(WebElement element) throws Exception {

        size = driver.manage().window().getSize();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        TouchAction action = new TouchAction((MobileDriver) driver);
        action.longPress(element.getLocation().getX() + (int) (width + 200), element.getLocation().getY()).moveTo(100, 1500).release().perform();

    }

    public void swipeRight(WebElement element) {
        size = driver.manage().window().getSize();
        int x2 = (int) (size.width * 0.80);
        TouchAction action = new TouchAction((MobileDriver) driver);
        action.longPress(element).moveTo(x2, 580).release().perform();

    }

    public void toolBarClose() throws Exception {
        getToolbarClose().click();
    }

    public int getTokens(RemoteOrderCustomer remoteOrderCustomer) throws Exception {
        List<Summaries> summaries = remoteOrderCustomer.getLoyaltyLookup().getLoyalty().getSummaries();
        int tokens = 0;
        for (int i = 0; i < summaries.size(); i++) {
            if (summaries.get(i).getRewardType() == "Points") {

                tokens = Integer.parseInt(summaries.get(i).getAvailable());
                tokens = +tokens;
            }
        }
        return tokens;

    }

    public void validateTokens(RemoteOrderCustomer remoteOrderCustomer, HomePage homePage) throws Exception {
        int tokens = getTokens(remoteOrderCustomer);
        homePage.tokenValue();
        Assert.assertEquals(tokens, Integer.parseInt(homePage.tokenValue()));
    }

    public void validateCertificate(RemoteOrderCustomer remoteOrderCustomer, HomePage homePage) throws Exception {
        String MdmId = remoteOrderCustomer.getGuestID();
        Kobie.generateCertificates(MdmId);
        Loyalty loyalty = new Loyalty(remoteOrderCustomer);
        remoteOrderCustomer = KobieClient.getLoyaltyLookup(loyalty, remoteOrderCustomer);
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(), homePage.certsCount());

    }

    public RemoteOrderCustomer validateTokensandCerts(HomePage homePage, RemoteOrderCustomer remoteOrderCustomer) throws Exception {
        getSwipe();
        Thread.sleep(3000);
        if (homePage.getTokens(remoteOrderCustomer) >= 200) {
           /*String MdmId = remoteOrderCustomer.getGuestID();
           Kobie.generateCertificates(MdmId);
           homePage.getTokensSparkle();
            toolBarClose();*/
            remoteOrderCustomer = homePage.validateCertificate(remoteOrderCustomer);

        }
        homePage.validateTokens(remoteOrderCustomer);
        return remoteOrderCustomer;
    }

    public HomePage assertTokensAndCertificates(RemoteOrderCustomer user,boolean tokenCertificatesAdded) throws Exception {
    /*    user = MobileApi.getLoyaltyLookUp(user);
            String tokencount = gettokensmyreward().getText();
              if (user.getConfirmToken() != null) {
                   Assert.assertEquals(user.getConfirmToken(), tokencount);
                   Logz.step("tokens asserted");
                   } else {
                          Logz.step("Tokens are not available");
                          }
            int myrewardcertcount = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/rewards_count")).size();
               if (myrewardcertcount > 0) {
                     int myreardspagecertcount = Integer.parseInt(getCertsmyreward().getText());
                     Assert.assertEquals(user.getLoyaltyLookup().getCertificates().getCertificateCount(), myreardspagecertcount);
                     } else {
                             Logz.step("Certificates not avalable");

                            }*/

        pojos.MyLoyalty actualMyLoyalty = getActualMyLoyaltyDetails();
        pojos.MyLoyalty expectedMyLoyalty = getExpectedMyLoyaltyDetails(user);
        if(tokenCertificatesAdded) {
            actualMyLoyalty = getActualMyLoyaltyDetails();
            expectedMyLoyalty = getExpectedMyLoyaltyDetails(user);
        }else{
            // certificare control is not present();
        }
        Assert.assertEquals(actualMyLoyalty, expectedMyLoyalty);

        return HomePage.get((AppiumDriver) driver);

    }
    private pojos.MyLoyalty getActualMyLoyaltyDetails() throws Exception{
        pojos.MyLoyalty actualMyLoyalty = new pojos.MyLoyalty();
        //get and set data from ui to actualMyLoyalty object
        actualMyLoyalty.setTokens("get the token value");
        //actualMyLoyalty.setCertificates("get list of certificates");
        return actualMyLoyalty;
    }
    private pojos.MyLoyalty getExpectedMyLoyaltyDetails(RemoteOrderCustomer user) throws Exception{
        pojos.MyLoyalty expectedMyLoyalty = new pojos.MyLoyalty();
        user = MobileApi.getLoyaltyLookUp(user);
        //get and set data from api to expectedMyLoyalty
        expectedMyLoyalty.setTokens("get the token value");
      //  expectedMyLoyalty.setCertificates("get list of certificates");
        return expectedMyLoyalty;
    }

}
