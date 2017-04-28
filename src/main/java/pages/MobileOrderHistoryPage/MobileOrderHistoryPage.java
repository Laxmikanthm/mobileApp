package pages.MobileOrderHistoryPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.Random;

/**
 * Created by e002243 on 19-04-2017.
 */
public abstract class MobileOrderHistoryPage<T extends AppiumDriver> extends MobileBasePage {

    Random random = new Random();
    String favoriteOrderName=null;
    public MobileOrderHistoryPage(AppiumDriver driver)
    {
        super(driver);
    }

    abstract MobileButton getFavorite() throws Exception;
    abstract MobileButton getFavoriteSaveButton() throws Exception;
    abstract MobileTextBox getFavoriteOrderName() throws Exception;
    abstract MobileButton getBackButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static MobileOrderHistoryPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new MobileOrderHistoryPageIOS((IOSDriver) driver);
            case "Android":
                return new MobileOrderHistoryPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void addFavoriteOrder() throws  Exception {

        try {
            favoriteOrderName="Subway"+random.nextInt(10);
            getFavorite().isReady();
            getFavorite().click();
            getFavoriteOrderName().setText(favoriteOrderName);
            HideKeyboard();
            getFavoriteSaveButton().waitForClickable();
            getFavoriteSaveButton();

        } catch (Exception ex)
        {
            throw  new Exception(ex);
    }

    }
    public void selectBackButton() throws Exception
    {

        getBackButton().waitForClickable();
        getBackButton().click();

    }
    public String favoriteOrderName() throws  Exception
    {
        return favoriteOrderName;
    }
    public void HideKeyboard()
    {
        AppiumDriver d = (AppiumDriver)driver;
        d.hideKeyboard();
    }
}
