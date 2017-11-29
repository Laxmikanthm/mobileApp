package pages.SearchStore;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by E003705 on 17-03-2017.
 */
public class SearchStoreAndroid extends SearchStore {

    public SearchStoreAndroid(AndroidDriver driver){
        super(driver);
    }

    public MobileButton getSearchButton() throws Exception {
        AndroidButton searchButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+ BaseTest.bundle.getString("Search")+"']"), "Start Order button");
        return searchButton;
    }

    public AndroidTextBox getSearchByZipCode() throws Exception {
        AndroidTextBox searchByZipCode = new AndroidTextBox((AndroidDriver) driver, By.id("search"), "SearchInputBox button");
        return searchByZipCode;
    }

    public MobileButton getOkPopupButton() throws Exception {
        AndroidButton okButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("OkButton")+"']"), "Ok button");
        return okButton;
    }

    public MobileButton getAllowButton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("Allow")+"']"), "Allow button");
        return button;
    }

    public MobileButton getMobileOrdering() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("MobileOdering")+"']"), "Mobile Ordering button");
        return button;
    }

    public MobileButton getOpenNow() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("OpenNow")+"']"), "Open Now button");
        return button;
    }

    public MobileButton getDriveThru() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("DriveThru")+"']"), "Drive Thru button");
        return button;
    }

    public MobileButton getServesBreakfast() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("BreakFast")+"']"), "Serves Breakfast button");
        return button;
    }

    public MobileButton getToggleView() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("toggle_view"), "ToggleView button");
        return button;
    }

    public MobileButton getOpenHours() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("OpenHours")+"']"), "Open 24Hours button");
        return button;
    }

    public MobileButton getRecentlyVisited() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("RecentlyVisited")+"']"), "RecentlyVisited field");
        return button;
    }

    public MobileButton getPreviousSearches() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("PreviousSearches")+"']"), "PreviousSearches field");
        return button;
    }

    public MobileButton getSearchKeyButton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("search_button"), "Search Button");
        return button;

    }

    public MobileButton getSelectRestaurantButton() throws Exception {
        AndroidButton selectRestaurantButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("SelectRestaurant")+"']"), "Select Restaurant Button");
        return selectRestaurantButton;
    }

    public MobileButton getSearchArea() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("search_area"), "Search This Area Button");
        return button;
    }

    public MobileButton getLocaion() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("my_location"), "LocationImage Button");
        return button;
    }

    public MobileLabel getMapView() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("mapView"),"Map View Image");
        return label;
    }

    protected By getAddressLocation(String address) throws Exception{
        return By.id("address");
    }
}
