package pages.SearchStore;


import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.keyboard.AndroidKeyboard;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;
import org.openqa.selenium.winium.KeyboardSimulatorType;
import pages.HomePage.HomePage;
import pages.OrdersPage.OrdersPage;

import pojos.user.MobileUser;
import utils.Logz;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;

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
    abstract MobileButton getSearchKeyButton() throws Exception;

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

    public void searchStoreByZipCode(String store) throws Exception {
        okPopUp();
        getSearchButton().click();
        getSearchByZipCode().isReady();
        getSearchByZipCode().getControl().clear();
        /*if (driver instanceof AndroidDriver)
            ((AndroidDriver) driver).pressKeyCode(EditorInfo.IME_ACTION_SEARCH);
        else
            getSearchKeyButton().tap();*/
        getSearchByZipCode().setText(store);
        getSearchKeyButton().click();

    }

    public void allowPopUp() throws Exception
    {
        try{
            if(driver instanceof AndroidDriver) {
                int d=((AndroidDriver)driver).findElements(By.xpath("//android.widget.Button[@text='Allow']")).size();
                if(d>0)
                {
                    getAllowButton().isReady();
                    getAllowButton().click();
                }
            }else{
                int d=((IOSDriver)driver).findElements(By.id("permission_allow_button")).size();
                if(d>0)
                {
                    getAllowButton().isReady();
                    getAllowButton().click();
                }
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public void okPopUp() throws Exception
    {
        try{
            if(driver instanceof AndroidDriver) {
                int d=((AndroidDriver)driver).findElements(By.xpath("//android.widget.Button[@text='OK']")).size();
                if(d>0)
                {
                    getOkPopupButton().isReady();
                    getOkPopupButton().click();

                }
            }else{
                int d=((IOSDriver)driver).findElements(By.xpath("//android.widget.Button[@text='OK']")).size();
                if(d>0)
                {
                    getOkPopupButton().isReady();
                    getOkPopupButton().click();


                }
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void toggleView() throws Exception
    {
        try{
            if(driver instanceof AndroidDriver) {
                int d = ((AndroidDriver) driver).findElements(By.id("toggle_view")).size();
                if(d>0)
                {
                    getToggleView().isReady();
                    getToggleView().click();
                }
            }else{
                int d = ((IOSDriver) driver).findElements(By.id("toggle_view")).size();
                if(d>0)
                {
                    getToggleView().isReady();
                    getToggleView().click();
                }

            }

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public OrdersPage findYourStore(String zipCode) throws Exception
    {
        try{
            okPopUp();
            allowPopUp();
            okPopUp();
            Logz.info(driver.getSessionId().toString());
            Thread.sleep(20000);
            toggleView();
            okPopUp();
            toggleView();
            if(zipCode.contains("-"))
            {
                zipCode=zipCode.split("-")[0];
            }
            searchStoreByZipCode(zipCode);
            return OrdersPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}
