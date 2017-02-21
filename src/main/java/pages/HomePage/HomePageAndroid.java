package pages.HomePage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageAndroid extends SubwayAppHomePage {


    public HomePageAndroid(AndroidDriver driver) throws Exception {
        super(driver);
        setBys();
    }


    public AndroidButton getLoginButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("LoginButton")), "Login button");

        return button;
    }

    public AndroidButton getRegistrationButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("RegisterButton")), "Register button");

        return button;
    }


    private void setBys() {

        bys = new HashMap<String, By>();
        bys.put("MenuBtnBy", By.id("com.subway.mobile.subwayapp03:id/profile"));
    }
}
