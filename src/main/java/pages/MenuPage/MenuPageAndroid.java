package pages.MenuPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.HashMap;

/**
 * Created by nikesh on 2/20/17.
 */

    public class MenuPageAndroid extends MenuPage {

    public MenuPageAndroid(AndroidDriver driver) throws Exception {
        super(driver);
        setBys();
    }
    private void setBys() {

        bys = new HashMap<String, By>();
        bys.put("LogoutBtnBy", By.id("com.subway.mobile.subwayapp03:id/logout"));
    }
}





