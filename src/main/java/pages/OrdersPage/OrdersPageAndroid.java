package pages.OrdersPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("product_add_to_bag"), "Add to bag button");        return button;
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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("change_time"), "Change field");
        return button;
    }

    public AndroidTextBox getSpecialInstructions() throws Exception {
        AndroidTextBox specialInstructions = new AndroidTextBox((AndroidDriver) driver, By.id("instructions_edit_text"), "Type Instructions field");
        return specialInstructions;
    }

    public MobileButton getAddIngredient() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("add_ingredient"), "Add Ingredient button");
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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("Less")+"']"), "Less Button");
        return button;
    }

    public MobileButton getMore() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("More")+"']"), "More Button");
        return button;
    }

    public MobileButton getRegularInSauce() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("RegularSauce")+"']"), "Regular In sauce Button");
        return button;
    }

    public MobileButton getRegular() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("Regular")+"']"), "Regulars Button");
        return button;
    }


    public MobileButton getRegularCheeseOrDeluxe() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("option2_layout"), "RegularCheeseOrDeluxe button");
        return button;
    }

    public MobileButton getExtraCheeseOrDoubleMeat() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("option3_layout"), "ExtraCheeseOrDoubleMeat button");
        return button;
    }

    public MobileButton getToastIt() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("toasted_image"), "ToastIt button");
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
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("delete_button"), "DeleteItem button");
        return button;
    }

    public MobileButton getSomethingElse() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("SomethingElse")+"']"), "SomethingElse Button");
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

    public MobileButton getToolTipExtras() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("firstTooltip")+"']"), "ToolTip button");
        return button;
    }

    public MobileButton getToolTipForSwipe() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("SwipeTooltip")+"']"), "SwipeTooltip button");
        return button;
    }
    public MobileButton getCookies() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("SwipeTooltip")+"']"), "SwipeTooltip button");
        return button;
    }

    public MobileButton getDirections() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.LinearLayout[@resource-id='"+BaseTest.bundle.getString("Directions")+"']"), "Directions button");
        return button;
    }


    public MobileLabel getSwitchStoreName() throws Exception{
        AndroidLabel switchNameLabel = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("SwitchStoreName")+"']"), "SwitchStoreName");
        return switchNameLabel;
    }

    public MobileLabel getItems() throws Exception {
        AndroidLabel items = new AndroidLabel((AndroidDriver) driver, By.id("product_group_header"), "Items label");
        return items;
    }

    public MobileButton getExpandArrow() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("item_title_layout"), "Expand Button in MakeItAMeal");
        return button;
    }

    public MobileButton getSelectFlavor() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("flavor_selector"), "SelectFlavor Button in MakeItAMeal");
        return button;
    }

    public MobileButton getItemSelectFlavor() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("flavor_text_item"), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
    public MobileButton getFavouriteIcon() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("favorite_animation"), "Expand Button in MakeItAMeal");
        return button;
    }
    public MobileButton getFavouriteSave() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("android:id/button1"), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
    public MobileTextBox getFavouriteText() throws Exception{
        AndroidTextBox button = new AndroidTextBox((AndroidDriver) driver, By.id("editTextName"), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
    public MobileButton getFavourites() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("product_group_header"), "Select Favourites");
        return button;
    }
    public MobileButton getFavouriteAddToBag() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("product_add_to_bag"), "Select Favourites  Add to Bag");
        return button;
    }
    public MobileButton getUnFavouriteIcon() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("favorite"), "Select Favourites  Add to Bag");
        return button;
    }
    public MobileButton getRemoveFavourite() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("android:id/button1"), "Remove Favourites ");
        return button;
    }
    public MobileLabel getSubTotal() throws Exception{
        AndroidLabel button = new AndroidLabel((AndroidDriver) driver, By.id("item_price"), "Sub Total Amount");
        return button;
    }
    public MobileLabel getRewardsAmt() throws Exception{
        AndroidLabel button = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView"), "Rewards Amount");
        return button;
    }
    public MobileLabel getOrderNumber() throws Exception{
        AndroidLabel switchNameLabel = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("orderNumber")+"']"), "OrderNumber");
        return switchNameLabel;
    }
    public MobileLabel getErrorTitle() throws Exception{
        AndroidLabel switchNameLabel = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("errorTitle")+"']"), "Error Title");
        return switchNameLabel;

    }
    public MobileLabel getErrorMessage() throws Exception{
        AndroidLabel switchNameLabel = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("errorMessage")+"']"), "Error Message");
        return switchNameLabel;

    }
    public MobileButton getErrorOk() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("android:id/button1"), "ErrorOk ");
        return button;
    }

    public MobileButton getpopupGotIt() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("android:id/button1"), "Popup GotIt");
        return button;
    }
    public MobileLabel getTaxPrice() throws Exception{
        AndroidLabel button = new AndroidLabel((AndroidDriver) driver, By.id("tax_amount"), "Tax Price ");
        return button;
    }
    public MobileButton getCustomizeOrder() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("customize"), "Customize Order Button");
        return button;
    }
    public MobileButton getDineIn() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("dine_in_button"), "DineIn Button");
        return button;
    }

    public MobileButton getToGo() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("to_go_button"), "ToGo Button");
        return button;
    }


//    public MobileLabel getTotalAmount() throws Exception{
//        AndroidLabel switchNameLabel = new AndroidLabel((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("OrderTotalAmount")+"']"), "Order Total Amount");
//        return switchNameLabel;
//
//    }
//

    public MobileButton getTotalAmount() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("ordertotal_amount"), "get total amount");
        return button;
    }
    
    public MobileButton getSubmitOrder() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("submit_order"), "submit order button");
        return button;
    }
    
    public MobileButton getGrandTotalAmount() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("order_total_amount"), "get grand total amount");
        return button;
    }
    
    public MobileButton getTotal() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("total"), "get total");
        return button;
    }
    
    public MobileButton getProfile() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("profile"), "profile icon");
        return button;
    }
    
    public MobileButton getSeeDetails() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("check_details"), "See details link");
        return button;
    }


    public MobileButton getChips() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("Chips")+"']"), "Chips Button");
        return button;

    }
    public MobileButton getCustomizebread() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("data_layout"), "Select Bread");
        return button;
    }
    public MobileButton getlooksgoodbutton() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("done_button"), "Looks Good Button");
        return button;
    }

    public MobileButton getChipsFlavor() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("ChipsFlavor")+"']"), "Chips Flavor Button");
        return button;

    }

    public MobileLabel getOrderNumInOrderConfirmation() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("order_number"), "OrderNumberInConfirmationPage");
        return label;
    }

    public MobileLabel getItemName() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("item_title"), "ItemNameInConfirmationPage");
        return label;
    }

    public MobileLabel getOrderTotalAmount() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("ordertotal_amount"), "OrderTotalAmountInConfirmationPage");
        return label;
    }

    public MobileLabel getSides() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("side_title_1"), "Sides");
        return label;
    }

    public MobileLabel getLiquids() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("drink_title"), "Liquids/Drinks");
        return label;
    }

    public MobileButton getSidesChange() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("side_change"), "Change in Sides");
        return button;
    }

    public MobileButton getDrinksChange() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("drink_change"), "Change in Drinks");
        return button;
    }

    public MobileLabel getFlavourDropDown() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver, By.id("flavor_selector_text"), "Liquids/Drinks");
        return label;
    }


    public MobileButton getFullMenu() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("view_full_menu_text"), "See Full menu");
        return button;
    }


}
