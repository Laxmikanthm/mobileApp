package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.MenuPage.MenuPage;
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
           // getAllowLocation().click();
            //getStoreView().click();
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



}



