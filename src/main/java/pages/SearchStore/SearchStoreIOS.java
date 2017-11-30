package pages.SearchStore;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by E003705 on 17-03-2017.
 */
public class SearchStoreIOS extends SearchStore {

    public SearchStoreIOS(IOSDriver driver) {
        super(driver);
    }

    public IOSTextBox getSearchByZipCode() throws Exception {
        IOSTextBox searchByZipCode = new IOSTextBox((IOSDriver) driver, By.xpath("//XCUIElementTypeTextField"), "Search by zip code text field");
        return searchByZipCode;
    }

    public IOSButton getSearchButton() throws Exception {

        IOSButton searchButton = new IOSButton((IOSDriver) driver, By.name("icMagnifyingGlassSmGrey"), "Search button");

        return searchButton;
    }

    public IOSButton getOkPopupButton() throws Exception {

        IOSButton okPopupButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return okPopupButton;
    }

    public IOSButton getAllowButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getToggleView() throws Exception {

        IOSButton toggleView = new IOSButton((IOSDriver) driver, By.name("icListView"), "ToggleView button");

        return toggleView;
    }

    public IOSButton getMobileOrdering() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getOpenNow() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDriveThru() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getServesBreakfast() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getOpenHours() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRecentlyVisited() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getPreviousSearches() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getSearchKeyButton() throws Exception {

        IOSButton searchBtn = new IOSButton((IOSDriver) driver, By.name(BaseTest.getStringfromBundleFile("SearchLabel")), "Search button");
        return searchBtn;
    }

    public IOSButton getSelectRestaurantButton() throws Exception {

        IOSButton selectRestaurantButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return selectRestaurantButton;
    }

    public IOSButton getSearchArea() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SearchKey")), "Search button");

        return button;
    }

    public IOSButton getLocaion() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SearchKey")), "Search button");

        return button;
    }

    public IOSLabel getMapView() throws Exception{
        IOSLabel label = new IOSLabel((IOSDriver)driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SearchKey")), "Search button");
        return label;
    }

    protected By getAddressLocation(String address) throws Exception{
        return By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText[contains(@name,'" + address + "')]");
    }
}