package pages.OrdersPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 10-03-2017.
 */
public class OrdersPageAndroid extends OrdersPage {

    public OrdersPageAndroid(AndroidDriver driver)
    {
        super(driver);
    }

    public MobileLabel getStoreNames() throws Exception {
        AndroidLabel storeNames = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("StoreAddress")+"']"), "Store Address label");
        return storeNames;
    }

    public MobileButton getSelectRestaurantButton() throws Exception {
        AndroidButton selectRestaurantButton = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("SelectRestaurant")+"']"), "Select Restaurant Button");
        return selectRestaurantButton;
    }

    public MobileButton getStartOrderButton() throws Exception {
        AndroidButton startOrder = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("StartOrder")+"']"), "Start Order button");
        return startOrder;
    }

    public MobileButton getAddToBag() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("AddToBag")+"']"), "Add to bag button");
        return button;
    }

    public MobileButton getCustomize() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("Customize")+"']"), "Customize button");
        return button;
    }

    public MobileButton getPlaceOrder() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("PlaceOrder")+"']"), "Place Order button");
        return button;
    }
    public MobileButton getGotIt() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("GotIt")+"']"), "GotIt button");
        return button;
    }

    public MobileButton getCategory(String category) throws Exception{
        AndroidButton button = new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+category+"']"),"Category Item: "+category);
        return button;
    }

    public MobileButton getSubCategory(String subCategory) throws Exception{
        AndroidButton button = new AndroidButton(((AndroidDriver)driver), By.xpath("//android.widget.TextView[@text='"+subCategory+"']"),"Sub Category Item");
        return button;
    }

    public MobileButton getMakeItAMeal() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("MakeItAMeal")+"']"), "Make It a Meal Button");
        return button;
    }

    public MobileButton getDrinks() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.RelativeLayout[@resource-id='"+BaseTest.bundle.getString("Drinks")+"']"), "Drinks Button");
        return button;
    }
    public MobileButton getDrinksAddToBag() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("DrinksAddToBag")+"']"), "Drinks Button");
        return button;
    }

    public MobileButton getChange() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("Change")), "Change field");
        return button;
    }

    public AndroidTextBox getSpecialInstructions() throws Exception {
        AndroidTextBox specialInstructions = new AndroidTextBox((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("MakeItAMeal")+"']"), "Make It a Meal Button");
        return specialInstructions;
    }

    public MobileButton getAddIngredient() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("AddIngredient")), "Add Ingredient button");
        return button;
    }

    public MobileButton getAddBag() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@resource-id='"+BaseTest.bundle.getString("AddToBagInIngredient")+"']"), "AddToBagInIngredient Button");
        return button;
    }

    public MobileButton getModify() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Modify")+"']"), "Modify button");
        return button;
    }

    public MobileButton getDone() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("Done")+"']"), "Done button");
        return button;
    }

    public MobileButton getLess() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("Less")+"']"), "Less Button");
        return button;
    }

    public MobileButton getMore() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("More")+"']"), "More Button");
        return button;
    }

    public MobileButton getRegularInSauce() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("RegularSauce")+"']"), "Regular In sauce Button");
        return button;
    }

    public MobileButton getRegular() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("Regular")), "Regular button");
        return button;
    }

    public MobileButton getRegularCheeseOrDeluxe() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("RegularCheeseOrDeluxe")), "RegularCheeseOrDeluxe button");
        return button;
    }

    public MobileButton getExtraCheeseOrDoubleMeat() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("ExtraCheeseOrDoubleMeat")), "ExtraCheeseOrDoubleMeat button");
        return button;
    }

    public MobileButton getToastIt() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("ToastIt")), "ToastIt button");
        return button;
    }

    public MobileButton getEdit() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Edit")+"']"), "Edit button");
        return button;
    }

    public MobileButton getAddAnother() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("AddAnother")+"']"), "AddAnother button");
        return button;
    }

    public MobileButton getDeleteItem() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("DeleteItem")), "DeleteItem button");
        return button;
    }

    public MobileButton getSomethingElse() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("SomethingElse")+"']"), "SomethingElse button");
        return button;
    }

    public MobileButton getRemove() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='"+BaseTest.bundle.getString("Remove")+"']"), "Remove button");
        return button;
    }

    public MobileLabel getSubItem() throws Exception {
        AndroidLabel subItem = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("SubItem")+"']"), "SubItem label");
        return subItem;
    }

    public MobileButton getBackButton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.className("android.widget.ImageButton"), "Back button");
        return button;
    }

    public MobileButton getSixInchOption() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.RelativeLayout[@resource-id='"+BaseTest.bundle.getString("SixInch")+"']"), "SixInch label");
        return button;
    }

}
