package pages.FavouritePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by E001599 on 09-11-2017.
 */
public class FavouritePageAndroid extends FavouritePage{
    public FavouritePageAndroid(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }
    public MobileButton getFavourites() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("Favourites")), "Select Favourites");
        return button;
    }
    public MobileButton getPrice() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("price_one_option"), "Select Price");
        return button;
    }
    public MobileButton getIngrediants() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("product_items"), "Select ProductItems");
        return button;
    }
    public MobileButton getName() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("favorite_name"), "Select Favourites");
        return button;
    }
}
