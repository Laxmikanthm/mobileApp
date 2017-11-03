package pages.CustomizePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.PickerPage.PickerPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.CustomizedItem.Customizer;
import pojos.CustomizedItem.CustomizerDetails;
import utils.Logz;

import java.util.List;

public abstract class CustomizePage<T extends AppiumDriver> extends MobileBasePage {
    public CustomizePage(AppiumDriver driver) {
        super( driver );
    }

    public static CustomizePage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new CustomizePageIOS( (IOSDriver) driver );
            case "Android":
                return new CustomizePageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }

    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    String androidPickerList = "android.widget.TextView";

    abstract MobileButton getAddTopping() throws Exception;//add_ingredient

    abstract MobileTextBox getPickerName() throws Exception;

    abstract MobileTextBox getModifierName() throws Exception;

    abstract MobileTextBox getCalories() throws Exception;

    abstract MobileTextBox getBreadCalories() throws Exception;

    abstract MobileTextBox getPrice() throws Exception;

    abstract MobileButton getBread() throws Exception;

    abstract MobileTextBox getToastIt() throws Exception;

    abstract MobileButton getToastItIcon() throws Exception;

    abstract MobileButton getLooksGood() throws Exception;

    abstract MobileTextBox getBreadTitle() throws Exception;
    //CustomizerPage
    abstract MobileButton getBackIcon() throws Exception;//toolbar_close
    abstract MobileTextBox getTitleText() throws Exception;//title
    abstract MobileTextBox getBreadSizeText() throws Exception;//subtitle_size
    abstract MobileTextBox getBreadCalorieText() throws Exception;//subtitle_size 	| 790.0*

   //click on ? scroll assert 3 tultip
    abstract MobileButton getHelpIcon() throws Exception;//ftue_help_icon
    abstract MobileTextBox getBreadFtue() throws Exception; //breadftue //class android.widget.RelativeLayout
    abstract MobileTextBox getaddFtue() throws Exception; //addftue
    abstract MobileTextBox getIngredientFtueText() throws Exception; //ingredientftuetext
    abstract MobileTextBox getDisclaimerText() throws Exception;//nutritional_disclaimer
    abstract MobileTextBox getIngredientNameText() throws Exception;//ingredient_name_textview
    abstract MobileTextBox getIngredientCaloriesText() throws Exception;//ingredient_calories_textview
    abstract MobileButton getAddToBagButton() throws Exception;//addToBag Add to Bag | $7.75
    //click on ingredient  ingredient_selected_text, remove, done
    // option1_image, option1_text
    //option2_image, option2_text(dx , 2x)
    //option3_image, option3_text
//Calories breakdown page
abstract MobileTextBox getCalorieInfoIcon() throws Exception; //calorie_info
    //abstract MobileTextBox getIngredientNameText() throws Exception;//ingredient_name_textview (list)
    //abstract MobileTextBox getIngredientCaloriesText() throws Exception;//ingredient_calories_textview
    abstract MobileTextBox getDisclaimer() throws Exception;//disclaimer_textview
//done button // done_button

    //Meat
    //assert title -getTitleText
    //getDisclaimerText assert
    abstract MobileButton getDoneButton() throws Exception;//done / looks good
    //get customizernames list by class name - android.widget.TextView
    abstract MobileTextBox getIngredientText() throws Exception;//ingredient_text
    abstract MobileTextBox getCalorieCountText() throws Exception;//calorie_count 160 Cals
    abstract MobileTextBox getModifyText() throws Exception; // ist by class name - android.widget.TextView





    //Assert badge is slected -- badge
    By customizerName = By.id( "" );
    By customizerPciker = By.id( "ingredient_text" );
    By breadName = By.id( "bread_top" );
    String breadNameText = "";
    CustomizedItem customizedItem;
    public CustomizePage randomCustomization(CustomizedItem customizedItem) throws Exception {
        this.customizedItem = customizedItem;
        selectBreads( customizedItem );
        PickerPage pickerPage = goToPickerPage();
        pickerPage.selectCustomizerIngredients( customizedItem );
        getDoneButton().click();
        return CustomizePage.get( (AppiumDriver) driver );
    }

    private PickerPage goToPickerPage() throws Exception{
        getAddTopping().click();
        return PickerPage.get( (AppiumDriver)driver );
    }

    private void selectBreads(CustomizedItem customizedItem) throws Exception {
        try {
            Logz.step( "##### Started selecting a bread #####" );
          //  getBread().click();
          List<WebElement> breadElement =   commonElements.getElements( By.id( "data_layout" ), By.id( "data_layout" )  );
          int index = breadElement.size();
          breadElement.get( index-1 ).click();
            List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
            for (Customizer customizer : customizers) {
                if (customizer.getCustomizerName().contains( "Breads" )) {
                    List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();
                    int breadCount = customizedItem.getProductDetail().getOptionGroups()[0].getOptions()[0].getAttributes().length;
                    for (int i = 0; i < breadCount; i++) {
                        breadNameText = customizerDetails.get( 0 ).getModifierName().trim();
                        Logz.step( "Bread Name: " + breadNameText);
                        if (!getBreadTitle().getText().contains( breadNameText )) {
                            commonElements.swipe( (AppiumDriver) driver, "Left" );
                        }
                    }
                   // Assert.assertEquals( getBreadCalories().getText(), customizerDetails.get( 0 ).getCalories() + " Cals" );
                    if (!customizerDetails.get( 0 ).getModifierName().trim().contains( "Wrap" )) {
                        Assert.assertEquals( getToastIt().getText(), BaseTest.getStringfromBundleFile( "ToastItText" ) );
                        if (!customizerDetails.get( 1 ).getModifierName().contains( "Not Toasted" )) {
                            getToastItIcon().click();
                        }
                    }
                    clickLooksGoodButton();
                }
            }
            Logz.step( "##### Ended selecting " + breadNameText + " #####" );
        }catch(Exception ex){
            throw new Exception( "Unable to select " + breadNameText + "\n"+ex.getMessage());
        }
    }



    private void clickLooksGoodButton() throws Exception{
        Assert.assertEquals( getLooksGood().getText(), BaseTest.bundle.getString("LooksGood") );
        getLooksGood().click();
    }

    public void assertCustomizePageDetails() throws Exception{
        commonElements.getElementListCount( By.id( "data_layout"), By.id( "data_layout"), (AppiumDriver)driver) ;
    }
    private void assertProductNameInCustomizerPage() throws Exception{

        try {
            Logz.step("##### Started asserting product name in Product Details page #####");
            Assert.assertEquals(getTitleText().getText(), customizedItem.getCustomizedProductDetail().getProductName());
            Assert.assertEquals( getAddToBagButton().getText(), BaseTest.getStringfromBundleFile( "AddToBagText" ) + " | $"+customizedItem.getCustomizedProductDetail().getPrice() );
            Logz.step("##### Ended asserting product name in Product Details page #####");

        }catch (Exception ex) {
            throw new Exception("Unable to assert product name in Product Details page\n"+ ex.getMessage());
        }

    }
}
