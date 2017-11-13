package pages.DrinksPage;

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

public class DrinksPageAndroid  extends DrinksPage{
    public DrinksPageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public MobileButton getSelectFlavor() throws Exception{
        return  new AndroidButton((AndroidDriver) driver, By.id("flavor_selector"), "Select Flavor dropdown");
    }

    @Override
    MobileTextBox getFlavorDrinksTitleText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("flavor_selector"), "Select Flavor dropdown");
    }

    @Override
    MobileTextBox getFlavorPriceText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("flavor_text_item"), "Select Flavor dropdown");
    }

    @Override
    MobileTextBox getFlavorCaloriesText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("flavor_calorie_text"), "Select Flavor dropdown");
    }

    @Override
    MobileTextBox getDrinksDescriptionText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("product_text"), "Select Flavor dropdown");

    }//product_text

    @Override
    WebElement getDrinksText() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElement(By.id("product_title"));
    }

    @Override
    MobileTextBox getDrinksPriceText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("product_text"), "Select Flavor dropdown");
    }

    @Override
    MobileTextBox getDrinksCaloriesText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("product_text"), "Select Flavor dropdown");
    }

    @Override
    List<WebElement> getDrinksPriceCaloriesList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElements(By.className("android.widget.TextView"));
    }

    @Override
    MobileTextBox getItemCountText() throws Exception {
        return  new AndroidTextBox((AndroidDriver) driver, By.id("page_count"), "getItemCountText");
    }


    @Override
    List<WebElement> getItemFlavorList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElements(By.id("flavor_text_item"));
    }



    @Override
    WebElement getItemFlavor() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElement(By.id("flavor_text_item"));
    }

    public MobileButton getItemSelectFlavor() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("SelectItemInSides")), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
}
