package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 10-03-2017.
 */
public class OrdersPageIOS extends OrdersPage {

    public OrdersPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public IOSTextBox getSearchByZipCode() throws Exception {

        IOSTextBox userNameTextbox  = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+ BaseTest.bundle.getString("UserNameiOS")+"']"), "username text field");

        return userNameTextbox;
    }

    public MobileLabel getStoreNames() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getSearchButton() throws Exception {

        IOSButton searchButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return searchButton;
    }
    public IOSButton getSelectRestaurantButton() throws Exception {

        IOSButton selectRestaurantButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return selectRestaurantButton;
    }

    public IOSButton getStartOrderButton() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }

    public IOSButton getDenyButton() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }
    public IOSButton getCatagoryItem() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }
    public IOSButton getOkPopupButton() throws Exception {

        IOSButton okPopupButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return okPopupButton;
    }
    public IOSButton getAddToBag() throws Exception {

        IOSButton addToBag = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return addToBag;
    }

    public IOSButton getCustomize() throws Exception {

        IOSButton addToBag = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return addToBag;
    }

    public IOSButton getPlaceOrder() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }
    public IOSButton getGotIt() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }
    public IOSButton getCategory(String category) throws Exception {

        IOSButton categoryItem = new IOSButton((IOSDriver) driver, (MobileBy.AccessibilityId(category)), "Category Item button");

        return categoryItem;
    }
    public IOSButton getSubCategory(String subCategory) throws Exception {

        IOSButton subCategoryItem = new IOSButton((IOSDriver) driver, (MobileBy.AccessibilityId(subCategory)), "Sub Category Item button");

        return subCategoryItem;
    }

}