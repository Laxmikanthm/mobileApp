package pages.HomePage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.LoginPage.LoginPage;
import pages.MenuPage.MenuPage;
import pages.RegistrationPage.RegistrationPage;

import java.util.Map;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class SubwayAppHomePage<T extends AppiumDriver> extends MobileBasePage {

    private pages.HomePage.SubwayAppHomePage SubwayAppHomePage;
    protected Map<String, By> bys;

    public SubwayAppHomePage(AppiumDriver driver) throws Exception {
        super(driver);
        skip();
    }

    abstract MobileButton getLoginButton() throws Exception;
    Button skipButton;
    Button menuPageButton;
    Button logOutButton;
    Button confirmLogOutButton;

    abstract MobileButton getRegistrationButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public LoginPage gotoLogInPage() throws Exception {
        try {
            this.getLoginButton().click();
            return LoginPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public RegistrationPage gotoRegistrationPage() throws Exception {
        getRegistrationButton().click();
        return RegistrationPage.get((AppiumDriver) driver);
    }

    public static Class getHomepageClass() throws Exception {

        String mobilePlatform = "Android";

        if (mobilePlatform.equalsIgnoreCase("IOS")) {
            return HomePageIOS.class;
        } else
            return HomePageAndroid.class;
    }

    public void skip() throws Exception

    {
        getSkipButton().click();
    }

    public Button getSkipButton() throws Exception {
        if (skipButton == null) {
            skipButton = new Button (driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SkipButton") + "']"), "");
        }
        return skipButton;
    }


    public MenuPage gotoMenuPage() throws Exception {
        try {
            this.getMenuPageButton().click();
            return MenuPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public Button getMenuPageButton() throws Exception {
        if (menuPageButton == null) {
            menuPageButton = new Button(driver, bys.get("MenuBtnBy"), "Menu button");
        }
        return menuPageButton;
    }
    }



