package pages.MyWayRewards;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.android.AndroidWebElement;
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
import kobieApi.pojos.CertificatesList;
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
import util.Utils;
import utils.Logz;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    abstract MobileLabel getCertsmyreward() throws Exception;
    abstract List<WebElement> getRewardsList() throws Exception;
    abstract List<WebElement> getRewardsDetails(WebElement rewards) throws Exception;

    Dimension size;
    public int rewards = 0;
    String expDate;
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

    public void swipeForTokens() throws Exception {
        List<WebElement> elements = getElements(Swipe);
        for (int i = 0; i < 3; i++) {
            WebElement ele = elements.get(0);
            Thread.sleep(3000L);
            swipeLeft(ele);
        }
        getGotIt().click();
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

    public HomePage assertTokensAndCertificates(RemoteOrderCustomer user) throws Exception {
        swipeForTokens();
        Thread.sleep(3000);
        Assert.assertEquals(getActualMyLoyaltyDetails(user),getExpectedMyLoyaltyDetails(user));
        return HomePage.get((AppiumDriver) driver);

    }
    private pojos.MyLoyalty getActualMyLoyaltyDetails(RemoteOrderCustomer user) throws Exception{
        pojos.MyLoyalty actualMyLoyalty = new pojos.MyLoyalty();
        Logz.step("Started asserting certificates from MyWayRewards page");
        actualMyLoyalty.setTokens(gettokensmyreward().getText());
        List<Certificates> certificatesList = new ArrayList<>();
        for(WebElement we: getRewardsList()){
            Certificates certificates = new Certificates();
            for(WebElement ele: getRewardsDetails(we)){
                if(ele.getAttribute("id").equals("rewards_count")){
                    ele.getText();
                    //Split the tokens
                    String amount[] = ele.getText().split( " " );
                    certificates.setAmount((amount[0]));
                } else if (we.getAttribute("id").equals("expire_date")) {
                    certificates.setExpirationDate(we.getText());
                }
            }
            certificatesList.add(certificates);
            }
            actualMyLoyalty.setCertificates(certificatesList);
        return actualMyLoyalty;
    }

    private pojos.MyLoyalty getExpectedMyLoyaltyDetails(RemoteOrderCustomer user) throws Exception{
        pojos.MyLoyalty expectedMyLoyalty = new pojos.MyLoyalty();
        user = MobileApi.getLoyaltyLookUp(user);
        //Condition for tokens and Summaries=null
        int bonus = 0;
        int points = 0;
        if(user.getLoyaltyLookup().getLoyalty().getSummaries()!=null){
            Logz.step("Tokens are available in MyLoyalty page");
            List<Summaries> summaries = user.getLoyaltyLookup().getLoyalty().getSummaries();
            for (Summaries summaries1 : summaries) {
                if (summaries1.getBucketId() == "30") {
                    String[] tokens = summaries1.getAvailable().split(".");
                    points = Integer.parseInt(tokens[0]);
                }
                if (summaries1.getBucketId() == "31") {
                    String[] tokens = summaries1.getAvailable().split(".");
                    bonus = Integer.parseInt(tokens[0]);
                }
            }
            expectedMyLoyalty.setTokens(String.valueOf(points+bonus));
        }else{
            Logz.step("Tokens are not available");
        }
        if(user.getLoyaltyLookup().getCertificates().getCertificatesList()!=null){
            Logz.step("Certificates are available in My Loyalty page");
            List<CertificatesList> certificates = user.getLoyaltyLookup().getCertificates().getCertificatesList();
            List<Certificates> certificates1 = new ArrayList<>();
            for(CertificatesList certificatesList:certificates) {
                Certificates certList = new Certificates();
                certList.setAmount("$"+certificatesList.getAmount().split(".")[0]);
                //Change date format to
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yy");
                expDate = Utils.formatDateTime(certificatesList.getExpirationDate(),"yyyy-MM-dd hh:mm:ss a", "MMMM dd, yyyy | hh:mma");
                String expirationDate = DATE_FORMAT.format(expDate);
                certList.setExpirationDate(expirationDate);
                certificates1.add(certList);
                expectedMyLoyalty.setCertificates(certificates1);
            }
        }else{
            Logz.step("Certificates are not available");
        }
        return expectedMyLoyalty;
    }

}
