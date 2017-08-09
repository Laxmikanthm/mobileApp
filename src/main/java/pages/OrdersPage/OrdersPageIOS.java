package pages.OrdersPage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.android.AndroidTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.gui.controls.mobile.ios.IOSTextBox;
import base.test.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by e002243 on 10-03-2017.
 */
public class OrdersPageIOS extends OrdersPage {

    public OrdersPageIOS(IOSDriver driver)
    {
        super(driver);
    }

    public MobileLabel getStoreNames() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public MobileLabel getItems() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getSelectRestaurantButton() throws Exception {

        IOSButton selectRestaurantButton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return selectRestaurantButton;
    }

    public IOSButton getStartOrderButton() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }

    public IOSButton getCatagoryItem() throws Exception {

        IOSButton startOrderbutton = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return startOrderbutton;
    }

    public IOSButton getAddToBag() throws Exception {

        IOSButton addToBag = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return addToBag;
    }

    public IOSButton getCustomize() throws Exception {

        IOSButton addToBag = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return addToBag;
    }

    public IOSButton getPlaceOrder() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }
    public IOSButton getGotIt() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }
    public IOSButton getCategory(String category) throws Exception {

        IOSButton categoryItem = new IOSButton((IOSDriver) driver, (MobileBy.AccessibilityId(category)), "Category Item button");

        return categoryItem;
    }
    public IOSButton getSubCategory(String subCategory) throws Exception {

        IOSButton subCategoryItem = new IOSButton((IOSDriver) driver, (MobileBy.AccessibilityId(subCategory)), "Sub Category Item button");

        return subCategoryItem;
    }

    public IOSButton getMakeItAMeal() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }
    public IOSButton getDrinks() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSButton getDrinksAddToBag() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSButton getChange() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSTextBox getSpecialInstructions() throws Exception {

        IOSTextBox specialInstructions = new IOSTextBox((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return specialInstructions;
    }

    public IOSButton getAddIngredient() throws Exception {

        IOSButton AddIngredient = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return AddIngredient;
    }

    public IOSButton getAddBag() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }

    public IOSButton getModify() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDone() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getLess() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getMore() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegular() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegularInSauce() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRegularCheeseOrDeluxe() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getExtraCheeseOrDoubleMeat() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getToastIt() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getEdit() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getAddAnother() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getDeleteItem() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getSomethingElse() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public IOSButton getRemove() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return button;
    }

    public MobileLabel getSubItem() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getBackButton() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getSixInchOption() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getToolTipExtras() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getToolTipForSwipe() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public IOSButton getCookies() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getDirections() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }

    public MobileLabel getSwitchStoreName() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }

    public IOSButton getExpandArrow() throws Exception {

        IOSButton placeOrder = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return placeOrder;
    }

    public IOSButton getSelectFlavor() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }

    public IOSButton getItemSelectFlavor() throws Exception {

        IOSButton Button = new IOSButton((IOSDriver) driver, By.xpath("//UIAStaticText[@label='"+BaseTest.bundle.getString("SignInButtoniOS")), "Login button");

        return Button;
    }
    public MobileButton getFavouriteIcon() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/favorite_animation"), "Expand Button in MakeItAMeal");
        return button;
    }
    public MobileButton getFavouriteSave() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("FavouriteSaveButton")), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
    public MobileTextBox getFavouriteText() throws Exception{
        IOSTextBox button = new IOSTextBox((IOSDriver) driver, By.id(BaseTest.bundle.getString("FavouriteEditText")), "SelectItemInSides Button in MakeItAMeal");
        return button;
    }
    public MobileButton getFavourites() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/product_group_header"), "Select Favourites");
        return button;
    }
    public MobileButton getRewardsApply() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Apply")+"']"), "Apply button");
        return button;
    }
    public MobileButton getFavouriteAddToBag() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/product_add_to_bag"), "Select Favourites  Add to Bag");
        return button;
    }
    public MobileButton getUnFavouriteIcon() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/product_detail_header"), "Select Favourites  Add to Bag");
        return button;
    }
    public MobileButton getRemoveFavourite() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("android:id/button1"), "Remove Favourites ");
        return button;
    }
    public MobileLabel getSubTotal() throws Exception{
        IOSLabel button = new IOSLabel((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/subtotal"), "Remove Favourites ");
        return button;
    }
    public MobileLabel getRewardsAmt() throws Exception{
        IOSLabel button = new IOSLabel((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/rewards_amount"), "Remove Favourites ");
        return button;
    }
    public MobileLabel getOrderNumber() throws Exception{
        IOSLabel switchNameLabel = new IOSLabel((IOSDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("orderNumber")+"']"), "OrderNumber");
        return switchNameLabel;
    }
    public MobileLabel getErrorTitle() throws Exception{
        IOSLabel switchNameLabel = new IOSLabel((IOSDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("errorTitle")+"']"), "OrderNumber");
        return switchNameLabel;

    }
    public MobileLabel getErrorMessage() throws Exception{
        IOSLabel switchNameLabel = new IOSLabel((IOSDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("errorMessage")+"']"), "OrderNumber");
        return switchNameLabel;

    }
    public MobileButton getErrorOk() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("errorOk")), "ErrorOk ");
        return button;
    }
    public MobileButton getpopupGotIt() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("popupGot")), "Popup GotIt");
        return button;
    }
    public MobileLabel getTaxPrice() throws Exception{
        IOSLabel button = new IOSLabel((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/tax_amount"), "Tax Price ");
        return button;
    }
    public MobileButton getCustomizeOrder() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("CutomizeOrder")), "Popup GotIt");
        return button;
    }
    public MobileButton getDineIn() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id(BaseTest.bundle.getString("DineIn")), "DineIn Button");
        return button;
    }


    public MobileButton getToGo() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/to_go_button"), "go to button");
        return button;
    }

    public MobileButton getTotalAmount() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/ordertotal_amount"), "get total amount");
        return button;
    }

    public MobileButton getSubmitOrder() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/submit_order"), "submit order button");
        return button;
    }

    public MobileButton getGrandTotalAmount() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/order_total_amount"), "get grand total amount");
        return button;
    }

    public MobileButton getTotal() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/total"), "get total");
        return button;
    }

    public MobileButton getProfile() throws Exception {

        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/profile"), "profile icon");
        return button;
    }

    public MobileButton getSeeDetails() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/check_details"), "See details link");
        return button;
    }







}
