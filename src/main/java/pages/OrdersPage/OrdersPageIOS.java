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

    public MobileLabel getStoreNames() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getSelectRestaurantButton() throws Exception {

        IOSButton selectRestaurantButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return selectRestaurantButton;
    }

    public IOSButton getStartOrderButton() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }

    public IOSButton getCatagoryItem() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
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

    public IOSButton getMakeItAMeal() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }
    public IOSButton getDrinks() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSButton getDrinksAddToBag() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSButton getChange() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSTextBox getSpecialInstructions() throws Exception {

        IOSTextBox specialInstructions = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return specialInstructions;
    }

    public IOSButton getAddIngredient() throws Exception {

        IOSButton AddIngredient = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return AddIngredient;
    }

    public IOSButton getAddBag() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }

    public IOSButton getModify() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDone() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getLess() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getMore() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegular() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegularInSauce() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegularCheeseOrDeluxe() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getExtraCheeseOrDoubleMeat() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getToastIt() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getEdit() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getAddAnother() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDeleteItem() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getSomethingElse() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRemove() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public MobileLabel getSubItem() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getBackButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getSixInchOption() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

}
