package pages.PickerPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PickerPageIOS extends PickerPage {
    public PickerPageIOS(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileTextBox getTitleText(String title) throws Exception {
        return null;
    }

    @Override
    MobileTextBox getIngredientText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getCalorieCountText() throws Exception {
        return null;
    }

    @Override
    MobileTextBox getModifyText() throws Exception {
        return null;
    }

    @Override
    MobileButton getModifyButton() throws Exception {
        return null;
    }

    @Override
    MobileButton getCheeseText() throws Exception {
        return null;
    }

    @Override
    MobileButton getVeggiesText() throws Exception {
        return null;
    }

    @Override
    MobileButton getEggText() throws Exception {
        return null;
    }

    @Override
    MobileButton getMeatText() throws Exception {
        return null;
    }

    @Override
    MobileButton getExtrasText() throws Exception {
        return null;
    }

    @Override
    MobileButton getSeasoningsText() throws Exception {
        return null;
    }

    @Override
    MobileButton getSaucesText() throws Exception {
        return null;
    }

    @Override
    List<WebElement> getIngredientList() throws Exception {
        return null;
    }


}
