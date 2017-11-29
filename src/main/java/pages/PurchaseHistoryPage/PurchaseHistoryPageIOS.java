package pages.PurchaseHistoryPage;


import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.gui.controls.mobile.ios.IOSWebElement;
import base.test.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pojos.CustomizedItem.CustomizedItem;
import pojos.PurchaseHistoryDetails;
import utils.Logz;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryPageIOS extends PurchaseHistoryPage {
    public PurchaseHistoryPageIOS(IOSDriver driver) {
        super(driver);
    }

    @Override
    List<WebElement> getPaymentMethod() throws Exception {
        return null;
    }

    @Override
    List<WebElement>  getEarnedTokensText() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getOrderList() throws Exception{
        return new IOSWebElement((IOSDriver) driver, "order list").getWebElements( By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));

    }

    @Override
    MobileButton getOrderListText() throws Exception {
        //return new IOSButton((IOSDriver) driver, By.xpath("//XCUIElementTypeNavigationBar[@name='" + BaseTest.getStringfromBundleFile("PurchaseHistoryTitle") + "']"), BaseTest.getStringfromBundleFile("PurchaseHistoryTitle") +" button");
        return new IOSButton((IOSDriver) driver, By.xpath("//XCUIElementTypeStaticText[@name='ORDER']"), "Order list");
    }

    @Override
    List<WebElement> getOrderNumberList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "order number list").getWebElements(By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther"));
    }

    @Override
    List<WebElement> getProductTitleList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "product title list").getWebElements(By.id("product_title"));
    }

    @Override
    MobileTextBox getProductTitle(String productTitle) throws Exception {
        return new IOSTextBox((IOSDriver) driver, By.xpath("//XCUIElementTypeStaticText[@name='" + productTitle + "']"), "PurchaseHistory button");
    }


    @Override
    List<WebElement> getOrderTimeAddressList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "order time and address list").getWebElements(By.xpath("//XCUIElementTypeStaticText[@name='ORDER']"));
    }


    @Override
    List<WebElement> getProductDescriptionList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "product description list").getWebElements(By.id("product_description"));
    }


    @Override
    List<WebElement> getOrderTotalList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "order total list").getWebElements(By.id("order_total"));
    }


    @Override
    List<WebElement>  getReceiptHeaderText() throws Exception {
        return null;
    }

    List<WebElement> getOrderDetails(WebElement element) throws Exception{
        return element.findElements(By.xpath("//XCUIElementTypeStaticText"));
    }

    @Override
    By getEarnedTokens() throws Exception {
        return By.id("earned_tokens_text");
    }


}
