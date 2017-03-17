package pages.SearchStore;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
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
        // AndroidButton searchButton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='com.subway.mobile.subwayapp03:id/search']"), "Search Button");

        return searchButton;
    }

    public AndroidTextBox getSearchByZipCode() throws Exception {

        AndroidTextBox searchByZipCode = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.EditText[@text='"+BaseTest.bundle.getString("SearchInputBox")+"']"), "Search by Zip Code text field");
        // AndroidTextBox searchByZipCode = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@text='Search by Zip Code']"), "Search Button");


        return searchByZipCode;
    }

    public MobileButton getOkPopupButton() throws Exception {

        AndroidButton okButton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("OkButton")+"']"), "Ok button");

        return okButton;
    }

    public MobileButton getAllowButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Allow")+"']"), "Allow button");

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

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("ToggleView")+"']"), "Toggle button");

        return button;
    }

    public MobileButton getOpenHours() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("OpenHours")+"']"), "Open 24Hours button");

        return button;
    }

}
