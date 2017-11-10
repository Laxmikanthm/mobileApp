package pages.DrinksPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
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
    List<WebElement> getItemFlavorList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElements(By.id("flavor_text_item"));
    }

    @Override
    WebElement getDrinks() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElement(By.id("product_title"));
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
