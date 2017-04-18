package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.SwipeElementDirection;
import base.test.BaseTest;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.OptionItem;
import cardantApiFramework.utils.NumberUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
    abstract MobileLabel getItems() throws Exception;
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

    abstract MobileButton getCookies() throws Exception;
    abstract MobileButton getDirections() throws Exception;


    abstract MobileLabel getSwitchStoreName() throws Exception;

    Random rn = new Random();
    int firstrandnum;
    int nextrandnum;
    public String itemName = null;

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

            By storeNamesLocator = By.id("com.subway.mobile.subwayapp03:id/address");
            By categoryLocator = By.id("com.subway.mobile.subwayapp03:id/product_group_header");
            By sidesOrDrinks = By.id("com.subway.mobile.subwayapp03:id/product_title");
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollToItemAndClick(storeNamesLocator, storeName, 1600, 3000);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            String CategoryItem = order.getCart().getProductDetail().getProductGroup().getName();
            if(!CategoryItem.equalsIgnoreCase("Sides")||!CategoryItem.equalsIgnoreCase("Drinks")){
                scrollToItemAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), 1600, 3000);
                scrollToItemAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), 1600, 3000);
            }else{
                scrollToItemAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), 1600, 3000);
                String subCategoryName = order.getCart().getProductDetail().getProductClass().getName();
                swipeLeftOrRight(sidesOrDrinks, subCategoryName , 500, "Left");
            }
            getAddToBag().click();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeRandomOrderAMeal(String menuItem, MobileUser mobileUser, String storeName, String moreToYourOrder) throws Exception {
        try {
            By storeNamesLocator = By.id("com.subway.mobile.subwayapp03:id/address");
            By categoryLocator = By.id("com.subway.mobile.subwayapp03:id/product_group_header");
            String subcategoryLocator = "com.subway.mobile.subwayapp03:id/product_group_header";
            By drinkslocator = By.id("com.subway.mobile.subwayapp03:id/product_title");
//            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
//            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);

            scrollToItemAndClick(storeNamesLocator, storeName, 1600, 3000);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            scrollToItemAndClick(categoryLocator, "All Sandwiches", 1600,3000);
            scrollToItemAndClick(categoryLocator, "Cold Cut Combo", 1600, 3000);
            getAddToBag().click();
            getMakeItAMeal().click();
            getDrinks().click();
            swipeLeftOrRight(drinkslocator, "21oz Fountain Drink", 500, "Left");
            getCookies().click();
            getDrinksAddToBag().click();
            getPlaceOrder().click();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void scrollToItemAndClick(By locator, String itemName, int endY, int Duration) {
        boolean flag = false;
        while (getItems(locator).size() > 0) {
            List<WebElement> allElements = getElements(locator);

            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getText().equals(itemName)) {
                    allElements.get(i).click();
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                WebElement element = allElements.get(allElements.size() - 1);
                MobileElement ele = (MobileElement) element;
                int x = ele.getLocation().getX();
                int y = ele.getLocation().getY();
                ((AppiumDriver) driver).swipe(x, y, x, y - endY, Duration);

            }
            if (flag == true) {
                break;
            }
        }
    }


    public void swipeLeftOrRight(By locator, String subProductName, int duration, String direction) throws Exception {
        boolean flag = false;
        int match = 0;

        while (getNames(locator).size() > 0) {
            List<WebElement> allElements = getNames(locator);

            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getText().equals(subProductName)) {

                    match++;
                }
                if (match > 0 && i == 0) {
                    flag = true;
                    break;
                } else {
                    WebElement ele = allElements.get(0);
                    MobileElement element = (MobileElement) ele;
                    Thread.sleep(10000L);
                    if (direction.equals("Left")) {
                        element.swipe(SwipeElementDirection.LEFT, duration);
                    } else {
                        element.swipe(SwipeElementDirection.RIGHT, duration);
                    }
                }
            }

            if (flag == true) {
                break;
            }
        }
    }


    public void scroolToElement(By locator) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int Startpoint = (int) (dimensions.getHeight() * 0.9);
            int scrollEnd = (int) (dimensions.getHeight() * 0.5);
            ((AndroidDriver) driver).swipe(200, Startpoint, 200, scrollEnd, 2000);
        }
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }

    public List<WebElement> getItems(By locator) {
        List<WebElement> storesList = ((AndroidDriver) driver).findElements(locator);
        return storesList;
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

    public void getItemType() throws Exception {
        try {
            getSixInchOption().click();
        } catch (Exception ex) {

        }
    }


    public void selectItemTypeAndClickCustomize(Order order) throws Exception {
        try {
            String FullName = order.getCart().getProductDetail().getName();
            String[] Itemtype = FullName.split(" ");
            if (!Itemtype[0].trim().equals("FOOTLONG™")) {
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

    public void selectBackButton() throws Exception {
        try {
            getBackButton().waitForClickable();
            getBackButton().click();
        } catch (Exception ex) {
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

    public void placeAnOrder() throws Exception {
        try {
            selectBackButton();
            getPlaceOrder().click();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<Integer> addAnotherSameItem() throws Exception {
        try {
            ArrayList<Integer> subItems = new ArrayList<Integer>();
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            getAddAnother().isReady();
            getAddAnother().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            subItems.add(previousList + 1);
            subItems.add(afterList);
            return subItems;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addAnotherNewItem() throws Exception {
        try {
            getAddToBag().isReady();
            getAddToBag().click();
            getSomethingElse().isReady();
            getSomethingElse().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<Integer> removeItem() throws Exception {
        try {
            ArrayList<Integer> subItems = new ArrayList<Integer>();
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            getRemove().isReady();
            getRemove().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_items_recycler")).size();
            subItems.add(previousList);
            subItems.add(afterList + 1);
            return subItems;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addToCartAndPlaceOrder() throws Exception {
        try {
            getAddBag().isReady();
            getAddBag().click();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {

        }
    }


    public void getModifyList() throws Exception {
        try {
            int modify = ((AndroidDriver) driver).findElements(By.xpath("//android.widget.TextView[@text='Modify']")).size();
            if (modify > 0) {
                getModify().click();
            }
        } catch (Exception ex) {

        }


    }

    public void getQuantityOfItem(By quantityBy) throws Exception {
        try {
            List<WebElement> quantity = driver.findElements((quantityBy));
            if (quantity.size() > 0) {
                quantity.get(rn.nextInt(quantity.size())).click();
            }
        } catch (Exception ex) {

        }
    }

    public void selectRandomItems(List<WebElement> list, By locator) throws Exception {
        firstrandnum = rn.nextInt(list.size());
        nextrandnum = rn.nextInt(list.size());
        if (firstrandnum != nextrandnum) {
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


    public List<WebElement> findElements(By by) {

        return driver.findElements(by);
    }

    public void customizeOrder(MobileUser mobileUser, Order order) throws Exception {
        try {
            By extraIngredientsBy, InnerIngredientsBy, quantityBy = null;
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
            WebElement ele = driver.findElement(By.id("category_tabs"));
            int width = ele.getSize().getWidth();
            AndroidElement veggies = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Veggies']"));
            if (veggies.getLocation().getX() > width / 2)
                veggies.swipe(SwipeElementDirection.LEFT, 500);
            else
                veggies.swipe(SwipeElementDirection.RIGHT, 500);
            for (int m = 0; m < order.getCart().getOptions().length; m++) {
                List<WebElement> extraIngredients = driver.findElements((extraIngredientsBy));
                for (int i = 0; i < extraIngredients.size(); i++) {
                    String name = extraIngredients.get(i).getText();
                    if (name.equalsIgnoreCase(order.getCart().getOptions()[m + 2].getOptionGroup())) {
                        extraIngredients.get(i).click();
                        if (name.equalsIgnoreCase("cheese"))
                            ClickonItem(order.getCart().getOptions()[m + 2].getValue(), InnerIngredientsBy);
                        else {
                            ClickonItem(order.getCart().getOptions()[m + 2].getName(), InnerIngredientsBy);
                        }
                        //Select quantity method
                        break;
                    }
                    try {
                        if (extraIngredients.get(i).getText().equalsIgnoreCase("veggies") ||
                                extraIngredients.get(i).getText().equalsIgnoreCase("sauces") ||
                                extraIngredients.get(i).getText().equalsIgnoreCase("seasonings"))
                            veggies.swipe(SwipeElementDirection.LEFT, 1200);
                    } catch (Exception e) {
                        Logz.info("End of screen");
                    }
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void ClickonItem(String name, By InnerIngredientsBy) {
        boolean flag = true;
        do {
            List<WebElement> innerIngredients = driver.findElements((InnerIngredientsBy));
            for (int i = 0; i <= innerIngredients.size(); i++) {
                if (i == innerIngredients.size()) {
                    //scroll;
                    flag = false; //turn this on if you are not implementing scroll. if not it will go into infinite loop
                    break;
                }
                itemName = innerIngredients.get(i).getText();
                By itemBy;
                if (itemName.equalsIgnoreCase(name)) {
                    if (driver instanceof AndroidDriver)
                        itemBy = By.xpath("//android.widget.TextView[@text ='" + itemName + "' ]/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout");
                    else
                        itemBy = null;
                    innerIngredients.get(i).click();
                    if (driver.findElements(itemBy).size() > 0 && !itemName.equalsIgnoreCase("cheese"))
                        driver.findElement(itemBy).click();
                    flag = false;
                    break;
                }
            }
        } while (flag);
    }


    public List<WebElement> getNames(By locator) {
        List<WebElement> namesList = ((AndroidDriver) driver).findElements(locator);

        return namesList;
    }

    public void swipeOrRight(By locator, String subProductName, int duration, String direction) throws Exception {
        boolean flag = false;
        int match = 0;

        while (getNames(locator).size() > 0) {
            List<WebElement> allElements = getNames(locator);

            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getText().equals(subProductName)) {

                    match++;
                }
                if (match > 0 && i == 0) {
                    flag = true;
                    break;
                } else {
                    WebElement ele = allElements.get(0);
                    MobileElement element = (MobileElement) ele;
                    Thread.sleep(10000L);
                    if (direction.equals("Left")) {
                        element.swipe(SwipeElementDirection.LEFT, duration);
                    } else {
                        element.swipe(SwipeElementDirection.RIGHT, duration);
                    }
                }
            }

            if (flag == true) {
                break;
            }
        }
    }


    public void scrollToElement(By locator, long startpoint, long endpoint) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int Startpoint = (int) (dimensions.getHeight() * startpoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endpoint);//0.5
            ((AppiumDriver) driver).swipe(200, Startpoint, 200, EndPoint, 2000);
        }
    }

    public void modify(String value, By quantityBy) {
        List<WebElement> mod = driver.findElements((quantityBy));
        for (int i = 0; i <= mod.size(); i++) {
            if (i == mod.size()) {

            }

        }

    }

    public void selectRestaurant() throws Exception {
        getSelectRestaurantButton().click();
    }

    public String switchStoreName() throws Exception {
        getSwitchStoreName().isReady();
        return getSwitchStoreName().getText();
    }


}





