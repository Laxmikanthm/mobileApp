package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import java.util.List;
import utils.*;
import org.openqa.selenium.WebElement;

/**
 * Created by e002243 on 10-03-2017.
 */
public abstract class OrdersPage<T extends AppiumDriver> extends MobileBasePage {

    public OrdersPage(AppiumDriver driver) {
        super(driver);
    }

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

    public void placeOrder(String subCategoryName) throws Exception {
        try {

            getPlaceOrder().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public List<WebElement> customizeItems() throws Exception {
        try {
            getCustomize().click();

        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return null;
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
}





