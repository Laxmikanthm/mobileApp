package pages.HomePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageAndroid extends SubwayAppHomePage {

    public HomePageAndroid(AndroidDriver driver){
        super(driver);
    }


    public AndroidButton getLoginButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("LoginButton")), "Login button");

        return button;
    }

    public AndroidButton getRegistrationButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("RegisterButton")), "Register button");

        return button;
    }
}
