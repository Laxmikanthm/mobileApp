package pages.CustomizePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pojos.CustomizedItem.CustomizedItem;
import pojos.CustomizedItem.Customizer;
import pojos.CustomizedItem.CustomizerDetails;

import java.util.List;

public abstract class CustomizePage<T extends AppiumDriver> extends MobileBasePage {
    public CustomizePage(AppiumDriver driver) {
        super(driver);
    }
    public static CustomizePage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new CustomizePageIOS((IOSDriver) driver);
            case "Android":
                return new CustomizePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    CommonElements commonElements = new CommonElements((AppiumDriver)driver);
    abstract MobileButton getAddTopping() throws Exception;
    abstract MobileButton getLess() throws Exception;
    abstract MobileButton getMore() throws Exception;
    abstract MobileButton getPickerName() throws Exception;
    abstract MobileButton getModifierName() throws Exception;
    abstract MobileButton getCalories() throws Exception;
    abstract MobileButton getPrice() throws Exception;

    By customizerName = By.id("");
    By customizerPciker = By.id("");
    public CustomizePage randomCustomization(CustomizedItem customizedItem) throws Exception{
        //select bread
        //select toasted/not toasted
        selectBreads(customizedItem);
        //click on add topping
        getAddTopping().click();
        selectIngredients(customizedItem);

        return CustomizePage.get((AppiumDriver)driver);
    }

    private void selectIngredients(CustomizedItem customizedItem) throws Exception{
        //Click on Meat
        //Click on vaggigs
        //Click on sesoning
        //click on sauches
        //click on cheeses
        List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
        for(Customizer customizer: customizers){
            customizer.getCustomizerName();
            commonElements.swipeAndClick(customizerName, customizerName, customizer.getCustomizerName(), "Left");
            List<CustomizerDetails> customizerDetails =   customizer.getCustomizerDetails();
            for(CustomizerDetails customizerDetail: customizerDetails){
                commonElements.scrollAndClick(customizerPciker, customizerPciker, customizerDetail.getPickerName());
                assertCustomizerDetails(customizerDetail);
                if(customizerDetail.getModifierName().contains("Less")){
                getLess().click();
                }else if(customizerDetail.getModifierName().contains("More")) {
                    getMore();
                }

            }
        }

    }
    private void selectBreads(CustomizedItem customizedItem) throws Exception{
        //Click on Bread
//select a bread click
        List<Customizer> customizers = customizedItem.getCustomizedProductDetail().getCustomizer();
        for(Customizer customizer: customizers) {
            //customizer.getCustomizerName();
            if (customizer.getCustomizerName().contains("bread")) {
                List<CustomizerDetails> customizerDetails = customizer.getCustomizerDetails();
                for (CustomizerDetails customizerDetail : customizerDetails) {
                    commonElements.scrollAndClick(customizerPciker, customizerPciker, customizerDetail.getPickerName());
                    assertCustomizerDetails(customizerDetail);
                    if (customizerDetail.getModifierName().contains("Less")) {
                        getLess().click();
                    } else if (customizerDetail.getModifierName().contains("More")) {
                        getMore();
                    }

                }
            }
        }
    }

    private void assertCustomizerDetails(CustomizerDetails customizerDetail) throws Exception{
        Assert.assertEquals(getModifierName().getText(), customizerDetail.getPickerName());
        Assert.assertEquals(getModifierName().getText(), customizerDetail.getModifierName());
        Assert.assertEquals(getPrice().getText(), customizerDetail.getPrice());
        Assert.assertEquals(getCalories().getText(), customizerDetail.getCalories());
    }
}
