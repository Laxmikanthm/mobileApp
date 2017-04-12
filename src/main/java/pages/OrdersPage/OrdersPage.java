package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.OptionItem;
import cardantApiFramework.utils.NumberUtil;
import com.thoughtworks.selenium.condition.Text;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;

import java.util.ArrayList;
import java.util.List;
import utils.*;
import org.openqa.selenium.WebElement;
import java.lang.String;
import java.util.Random;

/**
 * Created by e002243 on 10-03-2017.
 */
public abstract class OrdersPage<T extends AppiumDriver> extends MobileBasePage {

    public OrdersPage(AppiumDriver driver) {
        super(driver);
    }

   /* protected TextView storeNameTextView;*/

    abstract MobileLabel getStoreNames() throws Exception;

    abstract MobileButton getSelectRestaurantButton() throws Exception;

    abstract MobileButton getStartOrderButton() throws Exception;

    abstract MobileButton getAddToBag() throws Exception;

    abstract MobileButton getPlaceOrder() throws Exception;

    abstract MobileButton getGotIt() throws Exception;

    abstract MobileButton getCategory(String Category) throws Exception;

    abstract MobileButton getSubCategory(String Category) throws Exception;

    abstract MobileButton getCustomize() throws Exception;

    abstract MobileButton getMakeItAMeal() throws Exception;

    abstract MobileButton getDrinks() throws Exception;

    abstract MobileButton getDrinksAddToBag() throws Exception;

    abstract MobileButton getChange() throws Exception;

    abstract MobileTextBox getSpecialInstructions() throws Exception;

    abstract MobileButton getAddIngredient() throws Exception;

    abstract MobileButton getAddBag() throws Exception;

    abstract MobileButton getModify() throws Exception;

    abstract MobileButton getDone() throws Exception;

    abstract MobileButton getLess() throws Exception;

    abstract MobileButton getRegular() throws Exception;

    abstract MobileButton getMore() throws Exception;

    abstract MobileButton getRegularCheeseOrDeluxe() throws Exception;

    abstract MobileButton getExtraCheeseOrDoubleMeat() throws Exception;

    abstract MobileButton getRegularInSauce() throws Exception;

    abstract MobileButton getToastIt() throws Exception;

    abstract MobileButton getEdit() throws Exception;

    abstract MobileButton getAddAnother() throws Exception;

    abstract MobileButton getDeleteItem() throws Exception;

    abstract MobileButton getSomethingElse() throws Exception;

    abstract MobileButton getRemove() throws Exception;

    abstract MobileLabel getSubItem() throws Exception;
    abstract MobileButton getBackButton() throws Exception;
    abstract MobileButton getSixInchOption() throws Exception;
    abstract MobileButton getToolTipExtras() throws Exception;
    abstract MobileButton getToolTipForSwipe() throws Exception;

    Random rn = new Random();
    int firstrandnum;
    int nextrandnum;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }


    public static OrdersPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new OrdersPageIOS((IOSDriver) driver);
            case "Android":
                return new OrdersPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }


    public void placeRandomOrder(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            selectCategory(order.getCart().getProductDetail().getProductGroup().getName());
            selectSubCategory(order.getCart().getProductDetail().getProductClass().getName());
            getAddToBag().click();
            getPlaceOrder().click();
            //Return and assert the order item
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeRandomOrderAMeal(Order order, MobileUser mobileUser, String storeName) throws Exception {
        try {
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getAddToBag().click();
            getMakeItAMeal().click();
            getDrinks().click();
            getDrinksAddToBag().click();
            getPlaceOrder().click();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void searchStore(String storeName) throws Exception {
        try {

            getStoreList(driver);
            ((AndroidDriver) driver).findElement(By.xpath("//*[@text='" + storeName + "']")).click();

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectCategory(String categoryName) throws Exception {
        try {
            getCategory(categoryName).click();

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectSubCategory(String subCategoryName) throws Exception {
        try {

            ((AndroidDriver) driver).findElement(By.xpath("//*[@text='" + subCategoryName + "']")).click();

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeOrder() throws Exception {
        try {
            getPlaceOrder().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void getItemType() throws Exception{
        try{
            getSixInchOption().click();
        }catch (Exception ex){

        }
    }


    public void selectItemTypeAndClickCustomize(Order order) throws Exception {
        try {
            String FullName = order.getCart().getProductDetail().getName();
            String[] Itemtype = FullName.split(" ");
            if(!Itemtype[0].equals("FOOTLONG")) {
                getSixInchOption().isReady();
                getSixInchOption().click();
            }
            getCustomize().click();
            } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    /* Need to find better Solution*/
    public static void getStoreList(RemoteWebDriver driver) throws Exception {
        List<WebElement> list = driver.findElements((By.xpath("//*[@resource-id='com.subway.mobile.subwayapp03:id/stores_list']//android.widget.RelativeLayout")));
        //for(WebElement ele : list){
        if (list.get(1).findElement(By.id("com.subway.mobile.subwayapp03:id/address")).getText().contains("1365 Boston Post Road, Milford, CT 06460")) {
            System.out.println(list.get(1).getLocation().getY());
            int x = list.get(1).getLocation().getX();
            int y1 = list.get(1).getLocation().getY();
            int y2 = list.get(0).getLocation().getY();
            ((AppiumDriver) driver).swipe(x, y1, x, y2, 1000);
        }

    }

    public void placeRandomOrderSpecialInstructions(String menuItem, MobileUser mobileUser, String storeName, String specialInstructions) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            selectCategory(order.getCart().getProductDetail().getProductGroup().getName());
            selectSubCategory(order.getCart().getProductDetail().getProductClass().getName());
            getAddToBag().click();
            getPlaceOrder().click();
            // remoteOrder.addRandomInstructions(specialInstructions);

            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);

        }
    }

    public void addIngredient() throws Exception {
        try {
            getAddIngredient().isReady();
            getAddIngredient().click();
            getAddIngredient().click();
            getAddIngredient().click();
            getAddIngredient().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectBackButton()  throws Exception
    {
        try{
            getBackButton().waitForClickable();
            getBackButton().click();
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public String editCartAndPlaceAnOrder(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            selectCategory(order.getCart().getProductDetail().getProductGroup().getName());
            selectSubCategory(order.getCart().getProductDetail().getProductClass().getName());
            String aSubItem = order.getCart().getProductDetail().getProductClass().getName();
            return aSubItem;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectCategoryAndSubcategory(Order order, String storeName) throws Exception {
        try {

            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            selectCategory(order.getCart().getProductDetail().getProductGroup().getName());
            selectSubCategory(order.getCart().getProductDetail().getProductClass().getName());
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String getSubItemInfo() throws Exception {
        try {
            getAddToBag().click();
            getEdit().isReady();
            getEdit().click();
            getSubItem().isReady();
            String eSubItem = getSubItem().getText();
            return eSubItem;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeAnOrder() throws Exception{
        try {
            selectBackButton();
            getPlaceOrder().click();
            getGotIt().click();
        }
        catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<Integer> addAnotherSameItem() throws Exception{
        try {
            ArrayList<Integer> subItems = new ArrayList<Integer>();
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            getAddAnother().isReady();
            getAddAnother().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            subItems.add(previousList+1);
            subItems.add(afterList);
            return subItems;
        }
        catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addAnotherNewItem() throws Exception{
        try{
            getAddToBag().isReady();
            getAddToBag().click();
            getSomethingElse().isReady();
            getSomethingElse().click();
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public List<Integer> removeItem() throws Exception{
        try{
            ArrayList<Integer> subItems = new ArrayList<Integer>();
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            getRemove().isReady();
            getRemove().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            subItems.add(previousList);
            subItems.add(afterList+1);
            return subItems;
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public void addToCartAndPlaceOrder() throws Exception{
        try{
            getAddBag().isReady();
            getAddBag().click();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        }catch (Exception ex){

        }
    }


    public void getModifyList() throws Exception{
        try{
            int modify = ((AndroidDriver)driver).findElements(By.xpath("//android.widget.TextView[@text='Modify']")).size();
            if (modify>0){
                getModify().click();
            }
        }catch(Exception ex){

        }


    }

    public void getQuantityOfItem(By quantityBy) throws Exception {
        try {
                List<WebElement> quantity = driver.findElements((quantityBy));
                if (quantity.size() > 0) {
                    quantity.get(rn.nextInt(quantity.size())).click();
                }
        }catch(Exception ex){

            }
    }

    public void selectRandomItems(List<WebElement> list, By locator) throws Exception {
        firstrandnum = rn.nextInt(list.size());
        nextrandnum = rn.nextInt(list.size());
        if (firstrandnum!=nextrandnum){
            list.get(rn.nextInt(list.size())).click();
            getModifyList();
            getQuantityOfItem(locator);
        } else {
            nextrandnum = rn.nextInt(list.size());
            list.get(rn.nextInt(list.size())).click();
            getModifyList();
            getQuantityOfItem(locator);
        }

    }



    public List<WebElement> findElements(By by){

        return driver.findElements(by);
    }

    public void customizeOrder(MobileUser mobileUser, Order order) throws Exception{
        try {
            By extraIngredientsBy, InnerIngredientsBy, quantityBy;
            if (driver instanceof AndroidDriver) {
                extraIngredientsBy = By.xpath("//android.widget.HorizontalScrollView[@resource-id='com.subway.mobile.subwayapp03:id/category_tabs']//android.widget.TextView");
                InnerIngredientsBy = By.id("ingredient_text");
                quantityBy = By.xpath("//android.widget.RelativeLayout[@resource='com.subway.mobile.subwayapp03:id/bottom_sheet']");
            } else {
                extraIngredientsBy = null;
                InnerIngredientsBy = null;
                quantityBy = null;
            }
            addIngredient();
            //swipe veggies to middle
            List<WebElement> extraIngredients = driver.findElements((extraIngredientsBy));
            for (int m = 0; m <= order.getCart().getOptions().length; m++) {
                for (int i = 0; i <= extraIngredients.size(); i++) {
                    //swipe veggies to middle

                    String name = extraIngredients.get(i).getText();
                    if (name.equalsIgnoreCase(order.getCart().getOptions()[m+2].getOptionGroup())) {
                        extraIngredients.get(i).click();
                        if(name.equalsIgnoreCase("cheese"))
                            ClickonItem(order.getCart().getOptions()[m+2].getValue(), InnerIngredientsBy);
                        else {
                            ClickonItem(order.getCart().getOptions()[m + 2].getName(), InnerIngredientsBy);
                        }
                        break;
                    }
                }
            }
        }
        catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void ClickonItem(String name, By InnerIngredientsBy){
        boolean flag = true;
        do {
            List<WebElement> innerIngredients = driver.findElements((InnerIngredientsBy));
            for (int i = 0; i<=innerIngredients.size(); i++){
                if(i==innerIngredients.size()){
                    //scroll;
                    flag =false;
                    break;
                }
                if(innerIngredients.get(i).getText().equalsIgnoreCase(name)){
                    innerIngredients.get(i).click();
                    if(innerIngredients.get(i).findElements(By.xpath("//parent::android.widget.RelativeLayout[@id='main_layout']/following-sibling::android.widget.LinearLayout[@id='modify_layout']")).size()>0)
                        innerIngredients.get(i).findElement(By.xpath("//parent::android.widget.RelativeLayout[@id='main_layout']/following-sibling::android.widget.LinearLayout[@id='modify_layout']")).click();
                    flag =false;
                    break;
                }
            }
        }while (flag);
    }

    public void modify(String value, By quantityBy){
        List<WebElement> mod = driver.findElements((quantityBy));
        for(int i = 0; i<=mod.size(); i++){
            if(i==mod.size()){

            }

        }

    }
}





