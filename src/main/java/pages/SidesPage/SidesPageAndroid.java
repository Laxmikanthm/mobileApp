package pages.SidesPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SidesPageAndroid extends SidesPage{
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    public SidesPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public MobileButton getSelectFlavor() throws Exception{
        return  new AndroidButton((AndroidDriver) driver, By.id("flavor_selector"), "Select Flavor dropdown");
    }


    @Override
    List<WebElement> getItemFlavorList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "getItemFlavorList").getWebElements(By.id("flavor_text_item"));
    }

    @Override
    MobileTextBox getItemCountText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("page_count"), "page_count");
    }

    @Override
    WebElement getSides() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "Sides product_title").getWebElement(By.id("product_title"));
    }

    @Override
    WebElement getItemFlavor() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "Sides Flavors item").getWebElement(By.id("flavor_text_item"));
    }

    @Override
    MobileTextBox getSidesDescriptionText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("product_text"), "Select Flavor dropdown");
    }

    public MobileButton getItemSelectFlavor() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("SelectItemInSides")), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }

    @Override
    List<WebElement> getAddToBag() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "getItemFlavorList").getWebElements(By.id("product_add_to_bag"));
    }

    @Override
    List<WebElement> getSidesPriceCaloriesList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElements(By.className("android.widget.TextView"));
    }
    @Override
    MobileTextBox getFlavorSidesTitleText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("flavor_selector_text"), "Select Flavor dropdown");
    }

}
