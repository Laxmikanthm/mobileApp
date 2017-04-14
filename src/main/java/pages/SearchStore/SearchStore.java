package pages.SearchStore;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.HomePage.HomePage;
import pages.OrdersPage.OrdersPage;
import pages.OrdersPage.OrdersPageAndroid;
import pages.OrdersPage.OrdersPageIOS;
import pojos.user.MobileUser;

/**
 * Created by E003705 on 17-03-2017.
 */
public abstract class SearchStore<T extends AppiumDriver> extends MobileBasePage {

    public SearchStore(AppiumDriver driver) { super(driver); }

    abstract MobileButton getSearchButton() throws Exception;
    abstract MobileTextBox getSearchByZipCode() throws Exception;
    abstract MobileButton getAllowButton() throws Exception;
    abstract MobileButton getOkPopupButton() throws Exception;
    abstract MobileButton getToggleView() throws Exception;
    abstract MobileButton getMobileOrdering() throws Exception;
    abstract MobileButton getOpenNow() throws Exception;
    abstract MobileButton getDriveThru() throws Exception;
    abstract MobileButton getServesBreakfast() throws Exception;
    abstract MobileButton getOpenHours() throws Exception;
    abstract MobileButton getRecentlyVisited() throws Exception;
    abstract MobileButton getPreviousSearches() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public static SearchStore get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new SearchStoreIOS((IOSDriver) driver);
            case "Android":
                return new SearchStoreAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void searchStoreByZipCode(String store) throws Exception
    {
        try{
            getSearchButton().click();
            //getSearchByZipCode().setText(mobileUser.getPostalCode());

            getSearchByZipCode().isReady();
            getSearchByZipCode().getControl().clear();
            //   getSearchByZipCode().setText("06460");
            ((AppiumDriver)driver).findElement(By.xpath("//*[@text='Search by Zip Code']")).sendKeys("06460");
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void allowPopUp() throws Exception
    {
        try{
            int d=((AndroidDriver)driver).findElements(By.xpath("//*[@text='Allow']")).size();
            if(d>0)
            {
                getAllowButton().click();
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void okPopUp() throws Exception
    {
        try{
            int d=((AppiumDriver)driver).findElements(By.xpath("//*[@text='OK']")).size();
            if(d>0)
            {
                getOkPopupButton().click();

            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void toggleView() throws Exception
    {
        try{
            if(driver instanceof AndroidDriver) {
                int d = ((AppiumDriver) driver).findElements(By.xpath("//android.widget.ImageView[@resource-id='com.subway.mobile.subwayapp03:id/toggle_view']")).size();
                if(d>0)
                {
                    getToggleView().click();
                }
            }else{
                
            }

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public OrdersPage findYourStore(String store) throws Exception
    {
        try{
            okPopUp();
            allowPopUp();
            toggleView();
            searchStoreByZipCode(store);
            return OrdersPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}
