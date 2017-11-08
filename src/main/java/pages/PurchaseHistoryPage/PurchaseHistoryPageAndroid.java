package pages.PurchaseHistoryPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.android.AndroidWebElement;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.MobileWebElement;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PurchaseHistoryPageAndroid extends PurchaseHistoryPage {
    public PurchaseHistoryPageAndroid(AndroidDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getPaymentMethod() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.id("payment_method"), "getPaymentMethod");
    }

    @Override
    MobileButton getEarnedTokensText() throws Exception {
        return new AndroidButton((AndroidDriver) driver, By.id("earned_tokens_text"), "getEarnedTokensText");
    }
    @Override
    List<WebElement> getOrderList() throws Exception{
        return new AndroidWebElement((AndroidDriver) driver, "order list").getWebElements( By.id("order_header"));

    }

    @Override
    List<WebElement> getOrderNumberList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order number list").getWebElements(By.xpath("//android.widget.TextView[contains(@text,'Order')]"));
    }

    @Override
    List<WebElement> getProductTitleList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "product title list").getWebElements(By.id("product_title"));
    }


    @Override
    List<WebElement> getOrderTimeAddressList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order time and address list").getWebElements(By.id("order_time_address"));
    }


    @Override
    List<WebElement> getProductDescriptionList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "product description list").getWebElements(By.id("product_description"));
    }


    @Override
    List<WebElement> getOrderTotalList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order total list").getWebElements(By.id("order_total"));
    }

    @Override
    MobileTextBox getReceiptHeaderText() throws Exception {
//com.subway.mobile.subwayapp03:id/item_header
        return new AndroidTextBox((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/item_receipt"),"order total list");
    }

//    @Override
//    MobileTextBox getPaymentRewardsHeaderText() throws Exception {
//        return null;
//    }

}
