package pages.SidesPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
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
    MobileTextBox getItemCountText() throws Exception {
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
    MobileTextBox getSidesDescriptionText() throws Exception {
        return null;
    }

    @Override
    MobileButton getItemSelectFlavor() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getAddToBag() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getSidesPriceCaloriesList() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getFlavorSidesTitleText() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
