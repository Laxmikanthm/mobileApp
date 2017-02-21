package pages.MenuPage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.HomePage.SubwayAppHomePage;

import java.util.Map;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class MenuPage<T extends AppiumDriver> extends MobileBasePage {
    protected Map<String, By> bys;

    public MenuPage(AppiumDriver driver) throws Exception {
        super(driver);
    }

    private MenuPage MenuPage;
    private SubwayAppHomePage SubwayAppHomePage;
    Button menuPageButton;
    Button logOutButton;
    Button confirmLogOutButton;


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
    public MenuPage openMenuPage() throws Exception {
        this.getLogOutButton().click();
        this.getConfirmLogOutButton().click();
        return null;
    }

    public Button getLogOutButton() throws Exception {
        if (logOutButton == null) {
            logOutButton = new Button(driver, bys.get("LogoutBtnBy"), "Logout button");
        }
        return logOutButton;
    }

    public Button getConfirmLogOutButton() throws Exception {
        if (confirmLogOutButton == null) {
            confirmLogOutButton = new Button (driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("ConfirmLogOutButton") + "']"), "");
        }
        return confirmLogOutButton;
    }
}


