package pages.SearchStore;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by E003705 on 17-03-2017.
 */
public class SearchStoreIOS extends SearchStore {

    public SearchStoreIOS(IOSDriver driver) {
        super(driver);
    }

    public IOSTextBox getSearchByZipCode() throws Exception {

        IOSTextBox Textbox = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='" + BaseTest.bundle.getString("UserNameiOS") + "']"), "username text field");

        return Textbox;
    }

    public IOSButton getSearchButton() throws Exception {

        IOSButton searchButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return searchButton;
    }

    public IOSButton getOkPopupButton() throws Exception {

        IOSButton okPopupButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return okPopupButton;
    }

    public IOSButton getAllowButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getToggleView() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getMobileOrdering() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getOpenNow() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDriveThru() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getServesBreakfast() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getOpenHours() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRecentlyVisited() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getPreviousSearches() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }
}