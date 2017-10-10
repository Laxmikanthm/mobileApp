package pages.PurchaseHistoryPage;

import base.gui.controls.mobile.generic.MobileButton;
import io.appium.java_client.AppiumDriver;

public class PurchaseHistoryPageIOS extends PurchaseHistoryPage{
    public PurchaseHistoryPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getPaymentMethod() throws Exception {
        return null;
    }

    @Override
    MobileButton getEarnedTokensText() throws Exception {
        return null;
    }
}
