package pages.MenuPage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.HomePage.SubwayAppHomePage;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class MenuPage<T extends AppiumDriver> extends MobileBasePage {

    public MenuPage(AppiumDriver driver) throws Exception {
        super(driver);
        logOut();
    }

    protected abstract void menuPageButton();

    private MenuPage MenuPage;
    private SubwayAppHomePage SubwayAppHomePage;
    Button logOutButton;


    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static MenuPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new MenuPageIOS((IOSDriver) driver);
            case "Android":
                return new MenuPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public MenuPage logOutFromApp() throws Exception {
        MenuPage = SubwayAppHomePage.openMenuPage();
        MenuPage = MenuPage.logOut();
        return MenuPage;
    }

    public pages.MenuPage.MenuPage logOut() throws Exception

    {
        getLogOutButton().click();
        return null;
    }

    public Button getLogOutButton() throws Exception {
        if (logOutButton == null) {
            logOutButton = new Button(driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("LogOut") + "']"), "");
        }
        return logOutButton;
    }
}


