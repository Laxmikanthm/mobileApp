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

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("SignInButton")), "Sign In with existing user");

        return button;
    }

    public AndroidButton getRegistrationButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("RegisterButton")), "Register button");

        return button;
    }

   /* public AndroidButton getSkipButton() throws Exception {
        AndroidButton skipButton = new AndroidButton ((AndroidDriver)driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SkipButton") + "']"), "Skip Button");

        return skipButton;
    }*/
    public AndroidButton getSkipButton() throws Exception {
        AndroidButton skipButton = new AndroidButton ((AndroidDriver)driver, By.id(BaseTest.bundle.getString("SkipButton")), "Skip Button");

        return skipButton;
    }

}
