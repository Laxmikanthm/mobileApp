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
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPageAndroid;
import pages.ForgotPasswordPage.ForgotYourPasswordPageIOS;
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
        Thread.sleep(15000);
        skip();
    }

    public static SubwayAppHomePage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new HomePageIOS((IOSDriver) driver);
            case "Android":
                return new HomePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    abstract MobileButton getLoginButton() throws Exception;
    Button skipButton;
    Button menuPageButton;
    Button orderButton;
    Button findButton;

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

            //skipButton = new Button (driver, By.id("android:id/button2"), "");
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

    public Button getOrderButton() throws Exception {
        if (orderButton == null) {
            orderButton = new Button (driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("OrderButton") + "']"), "");
        }
        return orderButton;
    }

    public Button getFindButton() throws Exception {
        if (findButton == null) {
            findButton = new Button (driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "");
        }
        return findButton;
    }

    }



