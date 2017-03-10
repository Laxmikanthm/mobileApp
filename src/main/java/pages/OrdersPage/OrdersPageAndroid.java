package pages.OrdersPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 10-03-2017.
 */
public class OrdersPageAndroid extends OrdersPage {

    public OrdersPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }

    public MobileButton getSearchButton() throws Exception {
        AndroidButton searchButton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("SearchInputBox")+"']"), "Search Input Box");

        return searchButton;
    }

    public AndroidTextBox getSearchByZipCode() throws Exception {

        AndroidTextBox searchByZipCode = new AndroidTextBox((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("SearchInputBox")+"']"), "Search by Zip Code text field");

        return searchByZipCode;
    }

    public MobileLabel getStoreNames() throws Exception {

        AndroidLabel storeNames = new AndroidLabel((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("StoreAddress")+"']"), "Store Address label");

        return storeNames;
    }

    public MobileButton getSelectRestaurantButton() throws Exception {

        AndroidButton selectRestaurantButton = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("SelectRestaurant")+"']"), "Select Restaurant button");

        return selectRestaurantButton;
    }

    public MobileButton getStartOrderButton() throws Exception {

        AndroidButton startOrder = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("StartOrder")+"']"), "Start Order button");

        return startOrder;
    }

    public MobileButton getDenyButton() throws Exception {

        AndroidButton startOrder = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Deny")+"']"), "Deny button");

        return startOrder;
    }

}
