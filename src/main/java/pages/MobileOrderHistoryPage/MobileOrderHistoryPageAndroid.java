package pages.MobileOrderHistoryPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 19-04-2017.
 */
public class MobileOrderHistoryPageAndroid extends MobileOrderHistoryPage {

    public MobileOrderHistoryPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }


    public AndroidButton getFavorite() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("FavoriteOrder")), "FavoriteOrder button");
        return button;
    }
    public AndroidButton getFavoriteSaveButton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("FavoriteOrderSaveButton")), "Save button");
        return button;
    }
    public AndroidTextBox getFavoriteOrderName() throws Exception {
        AndroidTextBox userNameTextbox = new AndroidTextBox((AndroidDriver) driver, By.id(BaseTest.bundle.getString("NameYourFavorite")), "NameYourFavorite field");
        return userNameTextbox;
    }
    public MobileButton getBackButton() throws Exception {
        AndroidButton backButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        return backButton;
    }


}
