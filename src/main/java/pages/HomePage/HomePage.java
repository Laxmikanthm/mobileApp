package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
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
import pages.MenuPage.MenuPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;
import pojos.user.RemoteOrderCustomer;

import java.util.List;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class HomePage<T extends AppiumDriver> extends MobileBasePage {

    public HomePage(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public static HomePage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new HomePageIOS((IOSDriver) driver);
            case "Android":
                return new HomePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    abstract MobileButton getMenu() throws Exception;
    abstract MobileButton getOrderButton() throws Exception;
    abstract MobileButton getFindButton() throws Exception;
    abstract MobileButton getFindYourSubWay()throws Exception;
    abstract MobileButton getFindSubWayNearYou()throws Exception;
    abstract MobileButton getAllowLocation()throws Exception;
    abstract MobileButton getStoreView()throws Exception;
    abstract MobileButton getBackButton() throws Exception;
    abstract MobileButton getFindAnotherSubway()throws Exception;
    abstract MobileLabel getYourFavoriteOrderName() throws Exception;
    abstract MobileButton getFavoritesAddIcon() throws Exception;
    abstract MobileLabel getTokenValue() throws Exception;
    abstract MobileLabel getZeroTokenMessage() throws Exception;
    abstract MobileLabel getCertificatesMessage() throws Exception;
    abstract MobileLabel getTokenMessage() throws Exception;
    abstract MobileLabel getRedeemText() throws Exception;
    abstract MobileButton getTellMeHow() throws Exception;
    abstract MobileButton getStartAnotherOrder() throws Exception;
    abstract MobileButton getAnimationSparkle() throws Exception;
    abstract MobileButton getStartAnother() throws Exception;
    abstract MobileButton getRewardsApply() throws Exception;
    abstract MobileButton getRedeemButton() throws Exception;

    public int certValue=0;
    public int certCount=0;

  //  By Offers=By.xpath("com.subway.mobile.subwayapp03:id/promo_card_stack");
   // By Offers=By.xpath("//android.support.v7.widget.RecyclerView[@id='com.subway.mobile.subwayapp03:id/promo_card_stack']/android.support.v7.widget.RecyclerView");
By Offers=By.xpath("//android.support.v7.widget.RecyclerView[@class='android.support.v7.widget.RecyclerView']/android.widget.RelativeLayout");
    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }

    public void getOffers()throws Exception {
        List<WebElement> elements = getElements(Offers);
        for (int i = 0; i < elements.size(); i++) {

            Thread.sleep(3000L);
            List<WebElement> elements2=getElements(By.xpath("//android.support.v7.widget.RecyclerView[@class='android.support.v7.widget.RecyclerView']/android.widget.RelativeLayout[@index="+0+"]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[@index="+0+"]"));
            WebElement ele2=elements2.get(0);
             if(ele2.getText().equals("Redeem Now"))
             {
                elements2.get(0).click();
                i=elements.size();


             }
             else {
                 By offerElement=By.xpath("//android.support.v7.widget.RecyclerView[@class='android.support.v7.widget.RecyclerView']/android.widget.RelativeLayout[@index="+i+"]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
                 List<WebElement> elements1=getElements(offerElement);
                 WebElement ele = elements1.get(0);
                 MobileElement element = (MobileElement) ele;
                 element.swipe(SwipeElementDirection.LEFT, 500);
             }


        }
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public MenuPage gotoMenuPage() throws Exception {
        try {
            this.getMenu().click();
            return MenuPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public MenuPage getUserDetails() throws Exception
    {
        try{
            this.getMenu().waitForClickable();
            this.getMenu().click();
            return MenuPage.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public SearchStore findYourSubWay() throws Exception
    {
        try{

            getFindYourSubWay().click();
            return SearchStore.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public SearchStore findNearbySubway() throws Exception
    {
        try{
            getFindSubWayNearYou().click();
            return SearchStore.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public SearchStore findAnotherSubway() throws Exception
    {
        try{
            getFindAnotherSubway().click();
            return SearchStore.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public void selectBackButton()  throws Exception
    {

        getBackButton().waitForClickable();
        getBackButton().click();

    }

    public String favoriteOrderName() throws  Exception
    {
        return getYourFavoriteOrderName().getText();
    }
    public void reSubmitFavoriteOrder() throws  Exception
    {
        getFavoritesAddIcon().click();
    }
    public String tokenValue()throws Exception
    {
        return getTokenValue().getText();
    }
    public String zeroTokenMessage()throws Exception
    {
        return getZeroTokenMessage().getText();
    }

    public String tokenMessage(String tokenValue)throws Exception
    {
        if(tokenValue.equals("0")) {
            return getZeroTokenMessage().getText();
        }
        else
            return getTokenMessage().getText();

    }
    public MyWayRewards tellMeHow()throws Exception
    {
        try {
            getTellMeHow().click();
            return MyWayRewards.get((AppiumDriver) driver);
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }
    public void startAnotherOrder()throws Exception
    {
        try {
            getStartAnotherOrder().click();

        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }
    public void refreshPage()throws Exception
    {
        ((AndroidDriver) driver).navigate().refresh();
    }

    public void tokenTracker(String tokenValue,String tokenMessage) throws Exception
    {


        if ((Integer.parseInt(tokenValue)) == 0) {
            if (zeroTokenMessage().equals("Eat, earn, and get royally rewarded.")) {
                System.out.println("user has zero tokens");
            }
            MyWayRewards rewards = tellMeHow();
            rewards.getSwipe();
        }
        if (Integer.parseInt(tokenValue) >= 50)  {
            if (tokenMessage.equals("Wow, you're really racking up those - way to go")) {
                System.out.println("user has greater than 50 and less than 100 tokens");

            }
        }
        if (Integer.parseInt(tokenValue) >= 100 ) {
            if (tokenMessage.equals("So close! You can almost taste the \n" +
                    "\n" +
                    "rewards now!")) {
                System.out.println("user has greater than 100 and less than 200 tokens!");
            }
        }
        if ((Integer.parseInt(tokenValue) == 200)) {
            if (tokenMessage.equals("You've earned a free reward")) {
                System.out.println("So Close! You can almost taste the rewards now!");
            }
        }
    }
    public MyWayRewards getTokensSparkle()throws Exception
    {
        getAnimationSparkle().click();
        return MyWayRewards.get((AppiumDriver) driver);
    }
    public OrdersPage addSomethingElse()throws Exception
    {

        getStartAnother().click();
        return OrdersPage.get((AppiumDriver) driver);
    }
    public int certsCount() throws Exception
    {
        String cert[]=getCertificatesMessage().getText().split(" ");
        certValue=Integer.parseInt(cert[0].substring(1));
        certCount=certValue/2;
        return certCount;
    }
    public SearchStore apply()throws Exception
    {
        String cert[]=getCertificatesMessage().getText().split(" ");
        certValue=Integer.parseInt(cert[0].substring(1));
        if(certValue>2)
        {
            System.out.println("Apply for multiple Certificates");
        }
        getRewardsApply().click();
        return SearchStore.get((AppiumDriver)driver);

    }
    public String getTokenTrackerValue()throws Exception {
        MyWayRewards myWayRewards = getTokensSparkle();
        myWayRewards.getSwipe();
       String tokenValue = tokenValue();
       return tokenValue;
    }

    public void assertFavoriteOrder(String actualFavoriteOrderName, String expectedFacoriteOrderName)
    {
        try{
            Assert.assertEquals(actualFavoriteOrderName, expectedFacoriteOrderName);

        }catch(Throwable e)
        {

        }
    }
    public OrdersPage findStore(String zipCode)throws Exception
    {
        SearchStore searchStore = findYourSubWay();
        searchStore.findYourStore(zipCode);
        return OrdersPage.get((AppiumDriver) driver);
    }
    public int getTokens(RemoteOrderCustomer remoteOrderCustomer) throws Exception
    {
        List<Summaries> summaries=remoteOrderCustomer.getLoyaltyLookup().getLoyalty().getSummaries();
        int tokens=0;
        for(int i=0;i<summaries.size();i++)
        {
            if(summaries.get(i).getRewardType().equals("Points"))
            {

                int tokens1=(int)Double.parseDouble(summaries.get(i).getAvailable());
                tokens+=tokens1;
            }
        }
        return tokens;

    }
    public void validateTokens(RemoteOrderCustomer remoteOrderCustomer)throws Exception
    {
        Loyalty loyality=new Loyalty(remoteOrderCustomer);
        remoteOrderCustomer= KobieClient.getLoyaltyLookup(loyality,remoteOrderCustomer);
        List<Summaries> summaries=remoteOrderCustomer.getLoyaltyLookup().getLoyalty().getSummaries();
        int tokens=getTokens(remoteOrderCustomer);
        tokenValue();
        Assert.assertEquals(tokens,Integer.parseInt(tokenValue()));
    }
    public void validateCertificate(RemoteOrderCustomer remoteOrderCustomer)throws Exception
    {
        Loyalty loyalty=new Loyalty(remoteOrderCustomer);
        remoteOrderCustomer= KobieClient.getLoyaltyLookup(loyalty,remoteOrderCustomer);
        Assert.assertEquals(remoteOrderCustomer.getLoyaltyLookup().getCertificates().getCertificateCount(),certsCount());

    }
}



