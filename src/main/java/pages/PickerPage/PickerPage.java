package pages.PickerPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonElements.CommonElements;
import pages.ModifierPage.ModifierPage;
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


    abstract MobileButton getModifyButton() throws Exception;// modify_layout

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
                    selectCheeseIngredient( customizerDetails );
                    break;
                case "Extras":
                    selectExtrasIngredient( customizerDetails );
                    break;
                case "Meat":
                    selectMeatIngredient( customizerDetails );
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

    private void selectCheeseIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try {

            for (CustomizerDetails customizerDetail : customizerDetails) {
                if (customizerDetail.getModifierName().contains( "Monterey Cheddar (shredded)" ) || customizerDetail.getModifierName().contains( "No Cheese" )) {
                    Logz.step( "Cheese is Not Selected" + customizerName );
                } else {
                    customizerName = customizerDetail.getModifierName();
                    selectIngredient(customizerName, customizerDetail);
                    selectCheeseModifier( customizerDetail );
                }
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    private void selectMeatIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try{
        for (CustomizerDetails customizerDetail : customizerDetails) {
            customizerName = customizerDetail.getPickerName();
            selectIngredient(customizerName, customizerDetail);
        }
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }

    }

    private void selectExtrasIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try{
        for (CustomizerDetails customizerDetail : customizerDetails) {
            if (!(customizerDetail.getPickerName().contains( "Deluxe" )
                    || customizerDetail.getPickerName().contains( "Extra Cheese" )
                    || customizerDetail.getPickerName().contains( "Double Meat" ))) {
                customizerName = customizerDetail.getPickerName();
                selectIngredient(customizerName, customizerDetail);
            }

        }
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }

    }

    private void selectOtherIngredient(List<CustomizerDetails> customizerDetails) throws Exception {
        try{
            Random random = new Random();
            int customizedList = 0;
        int i = 0;
        while (i < 2) {
            if(customizerDetails.size()>8){
                customizedList = customizerDetails.subList( 1,  8).size();
            }else {
                customizedList = customizerDetails.size();
            }
            int index =  random.nextInt( customizedList );
            customizerName = customizerDetails.get( index ).getPickerName();
            selectIngredient(customizerName, customizerDetails.get( index ));
             customizerDetails.remove(index);
            i++;
        }
            selectModifier();
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }

    public void selectCustomizerIngredients(CustomizedItem customizedItem) throws Exception {
        List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
        List<WebElement> picker = commonElements.getElementListByClass( androidPickerList, androidPickerList, (AppiumDriver) driver );
        int i =  0;
        while (i<3){
            int index =  Utils.selectRandomItem(customizers.subList( 1, customizers.size() ).size());
            customizers.get( index ).getCustomizerName();
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
            i++;
        }

        /*for (Customizer customizer : customizers.subList( 1, customizers.size() )) {
            for (WebElement pick : picker.subList( 1, 6 )) {
                if (pick.getText().contains( customizer.getCustomizerName() )) {
                    pick.click();
                    selectIngredients( customizer );

                } else {
                    if (customizer.getCustomizerName().contains( "Meat" )) {
                        commonElements.swipe( (AppiumDriver) driver, "Right" );
                    } else {
                        commonElements.swipe( (AppiumDriver) driver, "Left" );
                    }

                }

            }
        }*/


    }

    private void assertPickerDetails(CustomizerDetails customizerDetail) throws Exception {
        /*Assert.assertEquals( getModifierName().getText(), customizerDetail.getPickerName() );
        Assert.assertEquals( getModifierName().getText(), customizerDetail.getModifierName() );
        Assert.assertEquals( getPrice().getText(), customizerDetail.getPrice() );
        Assert.assertEquals( getCalories().getText(), customizerDetail.getCalories() );*/
    }

    private ModifierPage goToModifierPage(String pickerName) throws Exception {
        Logz.step( "##### Navigating to ModifierPage #####" );
        return ModifierPage.get( (AppiumDriver) driver );
    }

    private ModifierPage goToModifierPage() throws Exception {
        Logz.step( "##### Navigating to ModifierPage #####" );
        getModifyButton().click();
        return ModifierPage.get( (AppiumDriver) driver );
    }

    private void selectCheeseModifier(CustomizerDetails customizerDetail) throws Exception {
        try{
            Logz.step( "##### Selecting Modifier Option #####" );
                if (customizerDetail.getPickerName().contains( "Cheese" )) {
                    ModifierPage modifierPage = goToModifierPage();
                    modifierPage.selectCheeseModifier();
                }
            Logz.step( "##### Selected Modifier Option #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }
    private void selectModifier() throws Exception {
        try{
            Logz.step( "##### Selecting Modifier Option #####" );
            List<WebElement> allElements = commonElements.getElements(modifierList, modifierList);
            for (int i = 0; i < allElements.size(); i++) {
                allElements.get(i).click();
                ModifierPage modifierPage = goToModifierPage(customizerName);
                modifierPage.selectModifier( );
            }
            Logz.step( "##### Selected Modifier Option #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + customizerName + "\n" + ex.getMessage() );
        }
    }
    private void selectIngredient(String pickerName, CustomizerDetails customizerDetail) throws Exception{
        Logz.step( "##### Selecting Picker ingredient Name: " + customizerName + " #####" );
        commonElements.scrollAndClick( customizerPicker, customizerPicker, pickerName);
        Logz.step( "##### Selected Picker ingredient Name: " + customizerName + " #####" );
        assertPickerDetails( customizerDetail );
    }

}
