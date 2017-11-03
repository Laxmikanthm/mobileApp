package pages.ModifierPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonElements.CommonElements;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizerDetails;
import utils.Logz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ModifierPage<T extends AppiumDriver> extends MobileBasePage {
    public ModifierPage(AppiumDriver driver) {
        super( driver );
    }

    public static ModifierPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new ModifierPageIOS( (IOSDriver) driver );
            case "Android":
                return new ModifierPageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }

    abstract MobileButton getLess() throws Exception;

    abstract MobileButton getMore() throws Exception;

    abstract MobileButton getRegular() throws Exception;

    abstract MobileButton getLooksGood() throws Exception;//done


    //modifier selection

    abstract MobileTextBox getIngredientSelectedText() throws Exception;//ingredient_selected_text

    abstract MobileTextBox getIngredientCalPriceText() throws Exception; //ingredient_cal_price / ingredient_cal/ingredient_price + $1.50 320.00 Cals

    //selector_layout(count on modifier)
    //option1_image, option1_text
    //option2_image, option2_text(dx , 2x)
    //option3_image, option3_text
//Cheese
    //ingredient_image , //ingredient_text, calorie_count//partial_nutritional_disclaimer
    //  listview_description Pick a cheese to add to your item.
    //modifier selection
    //option2_image, option2_text(dx , 2x)
    //option3_image, option3_text
    // veggies, Sauces, seasoning,  - 3 options
    //extra - dont have options ingredient_image, ingredient_text, calorie_count, selected_price
    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );

    public void selectModifier() throws Exception {
    switch (getRandomModifier()){
        case"Less":
            getLess().click();//less 1, regular 2
            break;
        case"More":
            getMore().click();
            break;
        case"Regular":
            getRegular().click();
            break;
            default:
                Logz.step( "Modifier is none" );
    }

       /* if (getRandomModifier().contains( "Less" )) {
            getLess().click();//less 1, regular 2
        } else if (getRandomModifier().contains( "More" )) {
            getMore().click();
        } else if (getRandomModifier().contains( "Regular" )) {
            getRegular().click();
        } else {
            Logz.step( "Modifier is none" );
        }*/
        getLooksGood().click();
    }

    public void selectCheeseModifier() throws Exception {

        switch (getRandomModifier()){
            case"More":
                getMore().click();
                break;
            case"Regular":
                getRegular().click();
                break;
            default:
                Logz.step( "Modifier is none" );
        }
        /*if (getRandomModifier().contains( "More" )) {
            getMore().click();
        } else if (getRandomModifier().contains( "Regular" )) {
            getRegular().click();
        } else {
            Logz.step( "Modifier is none" );
        }
        getMore().click();*/
        getLooksGood().click();

    }

    private String getRandomModifier() throws Exception {
        List<String> modifierNames = new ArrayList<>();
        modifierNames.add( "Less" );
        modifierNames.add( "More" );
        modifierNames.add( "Regular" );
        Random random = new Random();
        int index = random.nextInt( modifierNames.size() );
        return modifierNames.get( index ).toString();
    }


}
