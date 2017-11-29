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
     List<WebElement> getPaymentMethod() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "payment and rewards text").getWebElements(By.id("payment_method"));

    }

    @Override
    List<WebElement> getEarnedTokensText() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "earned myway token text").getWebElements(By.id("earned_tokens_text")); //this should work
    }
    @Override
    List<WebElement> getOrderList() throws Exception{
        return new AndroidWebElement((AndroidDriver) driver, "order list").getWebElements( By.id("order_header"));

    }

    @Override
    MobileButton getOrderListText() throws Exception {
        return new AndroidButton( (AndroidDriver)driver, By.id( "order_header" ), "order_header is ready" );
    }

    @Override
    List<WebElement> getOrderNumberList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "order number list").getWebElements(By.xpath("//android.widget.TextView[contains(@text,'"+BaseTest.getStringfromBundleFile("Order")+"')]"));
    }

    @Override
    List<WebElement> getProductTitleList() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "product title list").getWebElements(By.id("product_title"));
    }

    @Override
    List<WebElement> getProductTitle() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver,"getProductTitle").getWebElements(   By.id("product_title"));
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
    By getEarnedTokens() throws Exception {
        return By.id("earned_tokens_text");
    }

    @Override
    List<WebElement> getReceiptHeaderText() throws Exception {
        return new AndroidWebElement((AndroidDriver) driver, "Item text").getWebElements(By.xpath("//android.widget.TextView[@text='"+BaseTest.getStringfromBundleFile("items")+"']"));
    }

//    @Override
//    MobileTextBox getPaymentRewardsHeaderText() throws Exception {
//        return null;
//    }

}
