package pages.OrderConfirmationPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.gui.controls.mobile.ios.IOSWebElement;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPageIOS  extends OrderConfirmationPage{
    public OrderConfirmationPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getGotIt() throws Exception {
        return new IOSButton((IOSDriver) driver, By.id(BaseTest.getStringfromBundleFile("GotItText")), BaseTest.getStringfromBundleFile("GotItText"));
    }
    @Override
    WebElement getPickupTimeHeader() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "").getWebElement(By.id("READY TODAY AT"));
    }

    @Override
    MobileTextBox getItemTitle(String itemTitle) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id(itemTitle), itemTitle + " text");
    }

    @Override
    MobileTextBox getItemPrice(String price) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.xpath("//XCUIElementTypeStaticText[@name='" + price + "']/following-sibling::XCUIElementTypeStaticText[1]"), price + " text");
    }

    @Override
    MobileTextBox getFlavorItemTitle() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getTotalText(String price) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.xpath("//XCUIElementTypeStaticText[@name='" + price + "']/following-sibling::XCUIElementTypeStaticText[2]"), price + " text");
    }

    @Override
    MobileTextBox getPickupTimeHeaderText() throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.id("READY TODAY AT"), "READY TODAY AT");
    }
}
