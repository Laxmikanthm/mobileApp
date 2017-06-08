package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pages.MenuPage.MenuPage;
import pages.MyWayRewards.MyWayRewards;
import pages.OrdersPage.OrdersPage;
import pages.SearchStore.SearchStore;

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
    abstract MobileLabel getTokenMessage() throws Exception;
    abstract MobileButton getTellMeHow() throws Exception;
    abstract MobileButton getStartAnotherOrder() throws Exception;
    abstract MobileButton getAnimationSparkle() throws Exception;
    abstract MobileButton getStartAnother() throws Exception;
    abstract MobileButton getRewardsApply() throws Exception;

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
    public SearchStore apply()throws Exception
    {
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
}



