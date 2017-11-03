package pages.PickerPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
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
import pages.ModifierPage.ModifierPage;
import pages.ProductDetailsPage.ProductDetailsPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.CustomizedItem.Customizer;
import pojos.CustomizedItem.CustomizerDetails;
import util.Utils;
import utils.Logz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class PickerPage<T extends AppiumDriver> extends MobileBasePage {
    public PickerPage(AppiumDriver driver) {
        super( driver );
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    String customizerName;

    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    By customizerPicker = By.id( "ingredient_text" );
    String androidPickerList = "android.widget.TextView";
    By modifierList = By.id( "modify_layout" );

    abstract MobileTextBox getTitleText() throws Exception;//title

    abstract MobileTextBox getIngredientText() throws Exception;//ingredient_text

    abstract MobileTextBox getCalorieCountText() throws Exception;//calorie_count 160 Cals

    abstract MobileTextBox getModifyText() throws Exception; // ist by class name - android.widget.TextView

    abstract MobileButton getModifyButton() throws Exception;// modify_layout
    abstract MobileButton getCheeseText() throws Exception;
    abstract MobileButton getVeggiesText() throws Exception;
    abstract MobileButton getEggText() throws Exception;
    abstract MobileButton getMeatText() throws Exception;
    abstract MobileButton getExtrasText() throws Exception;
    abstract MobileButton getSeasoningsText() throws Exception;
    abstract MobileButton getSaucesText() throws Exception;


    public static PickerPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new PickerPageIOS( (IOSDriver) driver );
            case "Android":
                return new PickerPageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }

    CustomizedItem customizedItem;

    public void selectIngredients(Customizer customizer) throws Exception {
        List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();

        switch (customizer.getCustomizerName()) {
            case "Cheese":
                selectCheeseIngredient( customizerDetails, isExtrasCheeseAvailable() );
                break;
            case "Extras":
                selectExtrasIngredient( customizerDetails );
                break;
            case "Meat":
                selectMeatIngredient( customizerDetails, isDoubleMeatAvailable() );
                break;
            case "Veggies":
                selectOtherIngredient( customizerDetails );
                break;
            case "Sauces":
                selectOtherIngredient( customizerDetails );
                break;
            case "Seasoning":
                selectOtherIngredient( customizerDetails );
                break;
            case "Egg":
                selectOtherIngredient( customizerDetails );
                break;

            default:
                Logz.step( "No picker ingredient is found to select" );

        }


        //   List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();
            /*if (customizer.getCustomizerName().contains( "Cheese" )) {
                selectCheeseIngredient( customizerDetails );
            } else if (customizer.getCustomizerName().contains( "Extras" )) {
                selectExtrasIngredient( customizerDetails );
            } else if (customizer.getCustomizerName().contains( "Meat" )) {
                selectMeatIngredient( customizerDetails );
            } else {
                selectOtherIngredient( customizerDetails );
            }
            i++;
        }*/
    }

    private void selectCheeseIngredient(List<CustomizerDetails> customizerDetails, boolean extraCheeseAvailable) throws Exception {
        try {

            for (CustomizerDetails customizerDetail : customizerDetails) { //"Monterey Cheddar (shredded)"
                if (customizerDetail.getModifierName().contains( "No Cheese" )) {
                    Logz.step( "Cheese is Not Selected" + customizerName );
                } else {
                    customizerName = customizerDetail.getModifierName();
                    selectIngredient( customizerName, customizerDetail );
                    selectCheeseModifier( customizerDetail, extraCheeseAvailable );
                }
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    private void selectMeatIngredient(List<CustomizerDetails> customizerDetails, boolean isDoubleMeatAvailable) throws Exception {
        try {
            for (CustomizerDetails customizerDetail : customizerDetails) {
                /*if (customizerDetails.size() > 1) {
                    customizerName = customizerDetail.getPickerName();
                    selectIngredient( customizerName, customizerDetail );
                }*/
              //  selectIngredient( customizerName, customizerDetail );
                selectCheeseModifier( customizerDetail, isDoubleMeatAvailable );

            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }

    }

    private void selectExtrasIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try {
            for (CustomizerDetails customizerDetail : customizerDetails) {
                if (!(customizerDetail.getPickerName().contains( "Deluxe" )
                        || customizerDetail.getPickerName().contains( "Extra Cheese" )
                        || customizerDetail.getPickerName().contains( "Double Meat" ))) {
                    customizerName = customizerDetail.getPickerName();
                    selectIngredient( customizerName, customizerDetail );
                }

            }
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }

    }

    private boolean isExtrasCheeseAvailable() throws Exception {
        boolean extraCheese = false;
        try {
            for (Customizer customizer : customizedItem.getCustomizedProductDetail().getCustomizer()) {
                if (customizer.getCustomizerName().contains( "Extras" )) {
                    List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();
                    for (CustomizerDetails customizerDetail : customizerDetails) {
                        if (customizerDetail.getPickerName().contains( "Extra Cheese" )) {
                            extraCheese = true;
                        }

                    }
                }
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
        return extraCheese;
    }

    private boolean isDoubleMeatAvailable() throws Exception {
        boolean extraCheese = false;
        try {
            for (Customizer customizer : customizedItem.getCustomizedProductDetail().getCustomizer()) {
                if (customizer.getCustomizerName().contains( "Extras" )) {
                    List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();
                    for (CustomizerDetails customizerDetail : customizerDetails) {
                        if (customizerDetail.getPickerName().contains( "Double Meat" )) {
                            extraCheese = true;
                        }

                    }
                }
            }


        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
        return extraCheese;
    }

    private void selectOtherIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try {
            Random random = new Random();
            int customizedList = 0;
            int index = random.nextInt( customizedList );
            selectIngredient( customizerName, customizerDetails.get( index ) );
           /* int i = 0;
            while (i < 2) {
                if (customizerDetails.size() > 5) {
                    customizedList = customizerDetails.subList( 1, 5 ).size();
                } else {
                    customizedList = customizerDetails.size();
                }
                int index = random.nextInt( customizedList );
                customizerName = customizerDetails.get( index ).getPickerName();
                selectIngredient( customizerName, customizerDetails.get( index ) );
                customizerDetails.remove( index );// removing so same index will not select next random selection
                i++;
            }*/
            selectModifier();
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    public void selectCustomizerIngredients(CustomizedItem customizedItem) throws Exception {
        this.customizedItem = customizedItem;
        //List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
       // List<WebElement> picker = commonElements.getElementListByClass( androidPickerList, androidPickerList, (AppiumDriver) driver );

      /*  int i = 0;
        while (i < 3) {
            int index = Utils.selectRandomItem( customizers.subList( 1, customizers.size() ).size() );
            Logz.step( "Picker Name: " + customizers.get( index ).getCustomizerName() );
            for (WebElement pick : picker.subList( 1, 6 )) {
                if (pick.getText().contains( customizers.get( index ).getCustomizerName() )) {
                    pick.click();
                    selectIngredients( customizers.get( index ) );

                } else {
                    if (customizers.get( index ).getCustomizerName().contains( "Meat" )) {
                        commonElements.swipe( (AppiumDriver) driver, "Right" );
                    } else {
                        commonElements.swipe( (AppiumDriver) driver, "Left" );
                    }

                }

            }
            customizers.remove( index ); // removing so same index will not select next random selection
            i++;
        }*/
        /*List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();

        switch (customizer.getCustomizerName()) {
            case "Cheese":
                selectCheeseIngredient( customizerDetails, isExtrasCheeseAvailable() );
                break;
            case "Extras":
                selectExtrasIngredient( customizerDetails );
                break;
            case "Meat":
                selectMeatIngredient( customizerDetails, isDoubleMeatAvailable() );
                break;
            case "Veggies":
                selectOtherIngredient( customizerDetails );
                break;
            case "Sauces":
                selectOtherIngredient( customizerDetails );
                break;
            case "Seasoning":
                selectOtherIngredient( customizerDetails );
                break;
            case "Egg":
                selectOtherIngredient( customizerDetails );
                break;

            default:
                Logz.step( "No picker ingredient is found to select" );
*/
        List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
        int i = 0;
        while (i < 4) {
            int index = Utils.selectRandomItem( customizers.subList( 1, customizers.size() ).size() );
            List<CustomizerDetails> customizerDetails = customizers.get( index ).getCustomizerDetails();
            switch (customizers.get( index ).getCustomizerName()) {
                case "Meat":
                    commonElements.swipe( (AppiumDriver) driver, "Right" );
                    getMeatText().click();
                    selectMeatIngredient( customizerDetails, isDoubleMeatAvailable() );
                    break;
                case "Extras":
                    commonElements.swipe( (AppiumDriver) driver, "Left" );
                    getExtrasText().click();
                    selectExtrasIngredient( customizerDetails );
                    break;
                case "Sauces":
                    getSaucesText().click();
                    selectOtherIngredient( customizerDetails );
                    break;
                case "Veggies":
                    getVeggiesText().click();
                    selectOtherIngredient( customizerDetails );
                    break;
                case "Seasonings":
                    getSeasoningsText().click();
                    selectOtherIngredient( customizerDetails );
                    break;
                case "Cheese":
                    getCheeseText().click();
                    selectCheeseIngredient( customizerDetails, isExtrasCheeseAvailable() );
                    break;
                case "Egg":
                    getEggText().click();
                    selectOtherIngredient( customizerDetails );
                    break;
                default:
                    Logz.step( "No picker ingredient is found to select" );

            }
            customizers.remove( index );
            i++;
        }


    }

    private void assertPickerDetails(CustomizerDetails customizerDetail) throws Exception {
       /* Assert.assertEquals( getModifierName().getText(), customizerDetail.getPickerName() );
       // Assert.assertEquals( getModifierName().getText(), customizerDetail.getModifierName() );
       // Assert.assertEquals( getPrice().getText(), customizerDetail.getPrice() );
        Assert.assertEquals( getCalories().getText(), customizerDetail.getCalories() );*/
    }

    private ModifierPage goToModifierPage(WebElement pickerName) throws Exception {
        Logz.step( "##### Navigating to ModifierPage #####" );
        pickerName.click();
        return ModifierPage.get( (AppiumDriver) driver );
    }

    private ModifierPage goToModifierPage() throws Exception {
        Logz.step( "##### Navigating to ModifierPage #####" );

        getModifyButton().click();


        return ModifierPage.get( (AppiumDriver) driver );
    }

    private void selectCheeseModifier(CustomizerDetails customizerDetail, boolean isModifierAvailable) throws Exception {
        try {
            Logz.step( "##### Selecting Modifier Option #####" );
            if (customizedItem.getMenuName().contains( BaseTest.getStringfromBundleFile( "KidsMeal" ) )) {
                if (customizerDetail.getPickerName().contains( "Cheese" ) || customizerDetail.getPickerName().contains( "Meat" )) {
                    if (commonElements.isAvailable( modifierList, modifierList )) {
                        throw new Exception( "Modify button is present in " + customizerDetail.getPickerName() + " option - Kids Meal menu " );
                    }
                }
            } else {
                if (isModifierAvailable) {
                    List<WebElement> allElements = commonElements.getElements( modifierList, modifierList );
                    for (WebElement element : allElements) {
                        ModifierPage modifierPage = goToModifierPage( element );
                        modifierPage.selectCheeseModifier();
                    }
                    Logz.step( "##### Selected Modifier Option #####" );
                }
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    private void selectModifier() throws Exception {
        try {
            Logz.step( "##### Selecting Modifier Option #####" );
            List<WebElement> allElements = commonElements.getElements( modifierList, modifierList );
            for (WebElement element : allElements) {
                ModifierPage modifierPage = goToModifierPage( element );
                modifierPage.selectModifier();
            }
            Logz.step( "##### Selected Modifier Option #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    private void selectIngredient(String pickerName, CustomizerDetails customizerDetail) throws Exception {
        Logz.step( "##### Selecting Picker ingredient Name: " + customizerName + " #####" );
        commonElements.scrollAndClick( customizerPicker, customizerPicker, pickerName );
        /*List<WebElement> elementList =  commonElements.getElements(customizerPicker, customizerPicker );
        for(WebElement element: elementList){
            element.getText();
            element.click();
        }*/

        Logz.step( "##### Selected Picker ingredient Name: " + customizerName + " #####" );
        assertProductNameInPickerPage();
    }

    private PickerPage assertProductNameInPickerPage() throws Exception {

        try {
            Logz.step( "##### Started asserting product name in Product Details page #####" );
            //  Assert.assertEquals(getTitleText().getText(), customizedItem.getCustomizedProductDetail().getProductName());
            Logz.step( "##### Ended asserting product name in Product Details page #####" );

        } catch (Exception ex) {
            throw new Exception( "Unable to assert product name in Product Details page\n" + ex.getMessage() );
        }


        return PickerPage.get( (AppiumDriver) driver );
    }

}
