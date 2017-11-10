package pages.LandingPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 3/1/17.
 */
public class LandingPageAndroid extends LandingPage{
    public LandingPageAndroid(AndroidDriver driver) throws Exception{
        super(driver);
    }

    public AndroidButton getLoginButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("signIn"), "Sign In with existing user Link");

        return button;
    }

    public AndroidButton getRegistrationButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("signUp"), "Register button");

        return button;
    }

    public AndroidButton getSkipButton() throws Exception {
        AndroidButton skipButton = new AndroidButton ((AndroidDriver)driver, By.id("android:id/button3"), "Skip Button");

        return skipButton;
    }

}
