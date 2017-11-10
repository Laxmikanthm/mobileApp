package pages.PurchaseHistoryPage;

import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSWebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PurchaseHistoryPageIOS extends PurchaseHistoryPage {
    public PurchaseHistoryPageIOS(IOSDriver driver) {
        super(driver);
    }

    @Override
    List<WebElement>  getPaymentMethod() throws Exception {
        return null;
    }

    @Override
    List<WebElement>  getEarnedTokensText() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getOrderList() throws Exception{
        return new IOSWebElement((IOSDriver) driver, "order list").getWebElements( By.id("order_header"));

    }

    @Override
    MobileButton getOrderListText() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getOrderNumberList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "order number list").getWebElements(By.xpath("//android.widget.TextView[contains(@text,'Order')]"));
    }

    @Override
    List<WebElement> getProductTitleList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "product title list").getWebElements(By.id("product_title"));
    }


    @Override
    List<WebElement> getOrderTimeAddressList() throws Exception {
        return new IOSWebElement((IOSDriver) driver, "order time and address list").getWebElements(By.id("order_time_address"));
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

    @Override
    By getEarnedTokens() throws Exception {
        return By.id("earned_tokens_text");
    }


}
