package pages.PurchaseHistoryPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.generic.MobileButton;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PurchaseHistoryPageAndroid extends PurchaseHistoryPage {
    public PurchaseHistoryPageAndroid(AppiumDriver driver) {
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
}
