package pages.SearchStore;


import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.keyboard.AndroidKeyboard;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.utils.JdbcUtil;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.winium.KeyboardSimulatorType;
import pages.HomePage.HomePage;
import pages.OrdersPage.OrdersPage;

import pojos.user.MobileUser;
import utils.Logz;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.VK_ENTER;

/**
 * Created by E003705 on 17-03-2017.
 */


public abstract class SearchStore<T extends AppiumDriver> extends MobileBasePage {

    public SearchStore(AppiumDriver driver) {
        super(driver);
    }

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

    abstract MobileButton getSelectRestaurantButton() throws Exception;
    abstract MobileButton getSearchArea() throws Exception;
    abstract MobileButton getLocaion() throws Exception;
    abstract MobileLabel getMapView() throws Exception;

    Store store= new Store();
    By Address = MobileBy.AccessibilityId("Google Map");
    By storeNamesLocator = By.id("address");
    Dimension size;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static SearchStore get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

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


    public void allowPopUp() throws Exception {
        try {
            if (driver instanceof AndroidDriver) {
                int d = ((AndroidDriver) driver).findElements(By.xpath("//android.widget.Button[@text='Allow']")).size();
                if (d > 0) {
                    getAllowButton().isReady();
                    getAllowButton().click();
                }
            } else {
                int d = ((IOSDriver) driver).findElements(By.id("permission_allow_button")).size();
                if (d > 0) {
                    getAllowButton().isReady();
                    getAllowButton().click();
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void okPopUp() throws Exception {
        try {
            if (driver instanceof AndroidDriver) {
                int d = ((AndroidDriver) driver).findElements(By.xpath("//android.widget.Button[@text='OK']")).size();
                if (d > 0) {
                    getOkPopupButton().isReady();
                    getOkPopupButton().click();
                }
            } else {
                int d = ((IOSDriver) driver).findElements(By.xpath("//android.widget.Button[@text='OK']")).size();
                if (d > 0) {
                    getOkPopupButton().isReady();
                    getOkPopupButton().click();
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void toggleView() throws Exception {
        try {
            if (driver instanceof AndroidDriver) {
                int d = ((AndroidDriver) driver).findElements(By.id("toggle_view")).size();
                if (d > 0) {
                    getToggleView().isReady();
                    getToggleView().click();
                }
            } else {
                int d = ((IOSDriver) driver).findElements(By.id("toggle_view")).size();
                if (d > 0) {
                    getToggleView().isReady();
                    getToggleView().click();
                }
            }

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public OrdersPage findYourStore(String zipCode) throws Exception {
        try {
            okPopUp();
            allowPopUp();
            Thread.sleep(5000);
            okPopUp();
            Thread.sleep(5000);
            Logz.info(driver.getSessionId().toString());
            Thread.sleep(20000);
            toggleView();
            Thread.sleep(5000);
            okPopUp();
            //toggleView();
            if (zipCode.contains("-")) {
                zipCode = zipCode.split("-")[0];
            }
            searchStoreByZipCode(zipCode);
            //toggleView();
            return OrdersPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public OrdersPage findLocationOfStore(Store store) throws Exception {
        try {
            okPopUp();
            allowPopUp();
            Thread.sleep(2000);
            okPopUp();
            Thread.sleep(2000);
            if(getMapView().getControl().isDisplayed()) {
                Location loc = new Location(Double.parseDouble(store.getLatitude()), Double.parseDouble(store.getLongitude()), 900);
                ((AppiumDriver) driver).setLocation(loc);
                getLocaion().isReady();
                getLocaion().click();
                Thread.sleep(2000);
                swipeToLocation();
                if (getSearchArea().getControl().isDisplayed()) {
                    getSearchArea().click();
                    Logz.step("Available store card gets displayed");
                } else {
                    Logz.error("No stores are available");
                }
                Thread.sleep(3000);
                okPopUp();
                toggleView();
            }
            else{
                 Logz.error("Map View is not available");
            }
            return OrdersPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);
        return elementsList;
    }

    public void swipeToLocation() throws Exception
    {
        List<WebElement> elements = getElements(Address);
        for (int i = 0; i < 3; i++) {
            WebElement ele = elements.get(0);
            Thread.sleep(3000L);
            swipeRight(ele);
            }
    }

    public void swipeRight(WebElement element)
    {
        size=driver.manage().window().getSize();
        int x2 = (int) (size.width * 0.80);
        TouchAction action = new TouchAction((MobileDriver)driver);
        action.longPress(element).moveTo(x2,580).release().perform();

    }
}
