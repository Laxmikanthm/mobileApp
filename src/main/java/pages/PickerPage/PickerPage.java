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

   // String customizerName;

    CommonElements commonElements = new CommonElements( (AppiumDriver) driver );
    By customizerPicker = By.id( "ingredient_text" );
    String androidPickerList = "android.widget.TextView";
    By modifierList = By.id( "modify_layout" );

    abstract MobileTextBox getTitleText(String title) throws Exception;//title

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

    public void selectIngredients(Customizer customizer) throws Exception {
        List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();

        switch (customizer.getCustomizerName()) {
            case "Cheese":
                //selectCheeseIngredient( customizerDetails, isExtrasCheeseAvailable() );
                break;
            case "Extras":
                selectExtrasIngredient( customizerDetails );
                break;
            case "Meat":
              //  selectMeatIngredient( customizerDetails, isDoubleMeatAvailable() );
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

    private void selectCheeseIngredient(CustomizedItem customizedItem, List<CustomizerDetails> customizerDetails) throws Exception {
        try {

            for (CustomizerDetails customizerDetail : customizerDetails) { //"Monterey Cheddar (shredded)"
                if (customizerDetail.getModifierName().contains( "No Cheese" )) {
                    Logz.step( "Cheese is Not Selected" + customizerDetail.getModifierName( ));
                } else {
                    selectIngredient( customizerDetail.getModifierName() );

                }
            }
            selectCheeseModifier( customizedItem, customizerDetails, isExtrasCheeseAvailable(customizedItem) );
        } catch (Exception ex) {
            throw new Exception( "Unable to select picker\n" + ex.getMessage() );
        }
    }

    private void selectMeatIngredient(CustomizedItem customizedItem, List<CustomizerDetails> customizerDetails)  throws Exception {
        try {
                selectCheeseModifier( customizedItem, customizerDetails, isDoubleMeatAvailable( customizedItem ) );

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizedItem.getMenuName() + "\n" + ex.getMessage() );
        }

    }

    private void selectExtrasIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try {
            for (CustomizerDetails customizerDetail : customizerDetails) {
                if (!(customizerDetail.getPickerName().contains( "Deluxe" )
                        || customizerDetail.getPickerName().contains( "Extra Cheese" )
                        || customizerDetail.getPickerName().contains( "Double Meat" ))) {
                    selectIngredient( customizerDetail.getPickerName() );

                }

            }
        } catch (Exception ex) {
            throw new Exception( "Unable to select:  customizerName \n" + ex.getMessage() );
        }

    }

    private boolean isExtrasCheeseAvailable(CustomizedItem customizedItem) throws Exception {
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
            throw new Exception( "Unable to select: " + customizedItem.getMenuName() + "\n" + ex.getMessage() );
        }
        return extraCheese;
    }

    private boolean isDoubleMeatAvailable(CustomizedItem customizedItem) throws Exception {
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
            throw new Exception( "Unable to select: " + customizedItem.getMenuName() + "\n" + ex.getMessage() );
        }
        return extraCheese;
    }

    private void selectOtherIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try {
            Random random = new Random();
            int index = random.nextInt( customizerDetails.size() );
            selectIngredient( customizerDetails.get( index ).getPickerName());
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
            throw new Exception( "Unable to select: \n" + ex.getMessage() );
        }
    }

    public void selectCustomizerIngredients(CustomizedItem customizedItem) throws Exception {
        assertProductNameInPickerPage(customizedItem);

        List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
        int i = 0;
        while (i < 2) {
            int index = Utils.selectRandomItem( customizers.subList( 1, customizers.size() ).size() );
            List<CustomizerDetails> customizerDetails = customizers.get( index ).getCustomizerDetails();
            Logz.step( "picker name " + customizers.get( index ).getCustomizerName() );
            switch (customizers.get( index ).getCustomizerName()) {
                case "Meat":
                    commonElements.swipeNumberOfTime((AppiumDriver) driver, "Right", 1);
                    getMeatText().click();
                    selectMeatIngredient( customizedItem, customizerDetails );
                    break;
                case "Extras":
                    commonElements.swipeNumberOfTime((AppiumDriver) driver, "Left", 3);
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
                    selectCheeseIngredient(customizedItem, customizerDetails);
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

    private void selectCheeseModifier(CustomizedItem customizedItem, List<CustomizerDetails>  customizerDetails, boolean isModifierAvailable) throws Exception {
        try {
            Logz.step( "##### Selecting Modifier Option #####" );
            if (customizedItem.getMenuName().contains( BaseTest.getStringfromBundleFile( "KidsMeal" ) )) {
                for(CustomizerDetails customizerDetail: customizerDetails) {
                    if (customizerDetail.getPickerName().contains( "Cheese" ) || customizerDetail.getPickerName().contains( "Meat" )) {
                        if (commonElements.isAvailable( modifierList, modifierList )) {
                            throw new Exception( "Modify button is present in " + customizerDetail.getPickerName() + " option - Kids Meal menu " );
                        }
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
            throw new Exception( "Unable to select: " + customizedItem.getMenuName() + "\n" + ex.getMessage() );
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
            throw new Exception( "Unable to select: modifier\n" + ex.getMessage() );
        }
    }

    private void selectIngredient(String pickerName) throws Exception {
        Logz.step( "##### Selecting Picker ingredient Name: " + pickerName + " #####" );
        commonElements.scrollAndClick( customizerPicker, customizerPicker, pickerName);
        Logz.step( "##### Selected Picker ingredient Name: " + pickerName + " #####" );

    }

    private PickerPage assertProductNameInPickerPage(CustomizedItem customizedItem) throws Exception {

        try {
            Logz.step( "##### Started asserting product name in Product Details page #####" );
            Assert.assertEquals(getTitleText(customizedItem.getCustomizedProductDetail().getProductName()).getText(), customizedItem.getCustomizedProductDetail().getProductName());
            Logz.step( "##### Ended asserting product name in Product Details page #####" );

        } catch (Exception ex) {
            throw new Exception( "Unable to assert product name in Product Details page\n" + ex.getMessage() );
        }


        return PickerPage.get( (AppiumDriver) driver );
    }


}
