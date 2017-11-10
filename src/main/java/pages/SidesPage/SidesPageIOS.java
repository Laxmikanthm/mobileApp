package pages.SidesPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SidesPageIOS extends SidesPage{
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    public SidesPageIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getSelectFlavor() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getItemFlavorList() throws Exception {
        return null;
    }

    @Override
    WebElement getSides() throws Exception {
        return null;
    }

    @Override
    WebElement getItemFlavor() throws Exception {
        return null;
    }

    @Override
    MobileButton getItemSelectFlavor() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
