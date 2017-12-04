package pages.PickerPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PickerPageAndroid extends PickerPage{
    public PickerPageAndroid(AppiumDriver driver) {
        super( driver );
    }

    @Override
    MobileTextBox getTitleText(String title) throws Exception {
        return new AndroidTextBox((AndroidDriver)driver, By.id("title"), "Click title");
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
        return new AndroidButton((AndroidDriver)driver, By.id("modify_layout"), "Click Modify");
    }

    @Override
    MobileButton getCheeseText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Cheese" )+"']"),"Cheese ");
    }

    @Override
    MobileButton getVeggiesText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Veggies" )+"']"),"Cheese ");

    }

    @Override
    MobileButton getEggText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Egg" )+"']"),"Cheese ");

    }

    @Override
    MobileButton getMeatText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Meat" )+"']"),"Cheese ");

    }

    @Override
    MobileButton getExtrasText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Extras" )+"']"),"Cheese ");

    }

    @Override
    MobileButton getSeasoningsText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Seasonings" )+"']"),"Cheese ");

    }

    @Override
    MobileButton getSaucesText() throws Exception {
        return new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+ BaseTest.getStringfromBundleFile( "Sauces" )+"']"),"Sauces ");

    }
}
