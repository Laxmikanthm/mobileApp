package pages.YourOrderPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.test.BaseTest;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.gui.controls.mobile.ios.IOSWebElement;
import base.test.BaseTest;
import base.gui.controls.mobile.ios.IOSLabel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YourOrderPageIOS  extends YourOrderPage{
    public YourOrderPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    WebElement getPickupTimeHeader() throws Exception {
        return new IOSWebElement((IOSDriver)driver, "Pickup Time Header text").getWebElement(   By.id(BaseTest.getStringfromBundleFile("PickingUpFrom")));
    }

    @Override
    MobileTextBox getItemTitle(String itemTitle) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id(itemTitle), "Item title text");
    }

    MobileTextBox getItemTitle() throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id("item_title"), "Item title text");
    }

    @Override
    MobileTextBox getItemPrice(String itemPrice) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id(itemPrice), "Item price text");
    }

    MobileTextBox getItemPrice() throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id("item_price"), "Item price text");
    }

     MobileLabel getTaxPrice() throws Exception{
        return  null;
    }

    public MobileButton getFullMenu() throws Exception {
        return null;
    }

    @Override
    MobileButton getTotalText() throws Exception {
        return getPlaceOrder();
    }

    @Override
    MobileTextBox getPickupTimeHeaderText() throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id(BaseTest.getStringfromBundleFile("PickingUpFrom")), "Pickup Time Header text");
    }

    @Override
    MobileButton getPlaceOrder() throws Exception {
        return new IOSButton((IOSDriver) driver, By.xpath("//XCUIElementTypeButton[contains(@name,'" + BaseTest.getStringfromBundleFile("PlaceOrderText") + "')]"), BaseTest.getStringfromBundleFile("PlaceOrderText"));
    }


    public MobileLabel getcertificatemessage() throws Exception {
        IOSButton tokenscount = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return null;
    }
    public MobileLabel randommethod() throws Exception {
        IOSButton tokenscount = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toolbar_close"), "ToolBar Close Button");
        return null;
    }

    public MobileButton getManage() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("android:id/button1"), "Remove Favourites ");
        return button;
    }

    public MobileLabel getRewardsAmt() throws Exception{
        IOSLabel label = new IOSLabel((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/subtotal"), "Remove Favourites ");
        return label;
    }

    public WebElement getMakeitaMeal() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return null;
    }

    public WebElement ViewfullMenu() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return null;
    }

    @Override
    MobileButton getDineIn() throws Exception {
        return null;
    }

    public String getTotalPrice() throws Exception{
        return getTotalText().getText().split(" ")[3].trim().substring(1);
    }

    MobileTextBox getItemName() throws Exception {
        return null;
    }

    MobileTextBox getItemCost() throws Exception {
        return null;
    }

}
