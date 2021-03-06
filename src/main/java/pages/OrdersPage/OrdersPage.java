package pages.OrdersPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.browser.Generic;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import cardantApiFramework.pojos.Store;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.CartData;
import cardantApiFramework.utils.JdbcUtil;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.testng.Assert;

import pages.AddCardPage.AddCardPage;
import pages.CommonElements.CommonElements;
import pages.CustomizePage.CustomizePage;
import Enums.BreadSize;
import Enums.Menu;
import Enums.Tax;
import pages.DrinksPage.DrinksPage;
import pages.FavouritePage.FavouritePage;
import pages.HomePage.HomePage;
import pages.UserProfilePage.UserProfilePage;
import pages.OffersPage.OffersPage;
import pages.OrderConfirmationPage.OrderConfirmationPage;
import pages.ProductDetailsPage.ProductDetailsPage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pages.SidesPage.SidesPage;
import pages.YourOrderPage.YourOrderPage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.OfferDetails;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import pojos.user.RemoteOrderCustomer;
import util.MobileApi;
import util.Utils;
import utils.*;
import org.openqa.selenium.WebElement;

import java.lang.String;


/**
 * Created by e002243 on 10-03-2017.
 */
public abstract class OrdersPage<T extends AppiumDriver> extends MobileBasePage {

    public OrdersPage(AppiumDriver driver) {
        super(driver);
    }

    abstract MobileLabel getItems() throws Exception;

    abstract MobileButton getSelectRestaurantButton() throws Exception;

    abstract MobileButton getStartOrderButton() throws Exception;

    abstract MobileButton getAddToBag() throws Exception;

    abstract MobileButton getPlaceOrder() throws Exception;

    abstract MobileButton getGotIt() throws Exception;

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

    abstract MobileButton getFullMenu() throws Exception;

    abstract MobileButton getEdit() throws Exception;

    abstract MobileButton getAddAnother() throws Exception;

    abstract MobileButton getDeleteItem() throws Exception;

    abstract MobileButton getSomethingElse() throws Exception;

    abstract MobileButton getRemove() throws Exception;

    abstract MobileLabel getSubItem() throws Exception;

    abstract MobileLabel getSubTotal() throws Exception;

    abstract MobileButton getBackButton() throws Exception;

    abstract MobileButton getSixInchOption() throws Exception;

    abstract MobileButton getToolTipExtras() throws Exception;

    abstract MobileButton getToolTipForSwipe() throws Exception;

    abstract MobileButton getCookies() throws Exception;

    abstract MobileButton getDirections() throws Exception;

    abstract MobileLabel getSwitchStoreName() throws Exception;

    abstract MobileLabel getRewardsAmt() throws Exception;

    abstract MobileLabel getOrderNumber() throws Exception;

    abstract MobileLabel getErrorTitle() throws Exception;

    abstract MobileLabel getErrorMessage() throws Exception;

    abstract MobileLabel getTaxPrice() throws Exception;

    abstract MobileButton getExpandArrow() throws Exception;

    abstract MobileButton getSelectFlavor() throws Exception;

    abstract MobileButton getItemSelectFlavor() throws Exception;

    abstract MobileButton getFavouriteSave() throws Exception;

    abstract MobileButton getFavouriteIcon() throws Exception;

    abstract MobileTextBox getFavouriteText() throws Exception;

    abstract MobileButton getFavourites() throws Exception;

    abstract MobileButton getFavouriteAddToBag() throws Exception;

    abstract MobileButton getUnFavouriteIcon() throws Exception;

    abstract MobileButton getRemoveFavourite() throws Exception;

    abstract MobileButton getErrorOk() throws Exception;

    abstract MobileButton getpopupGotIt() throws Exception;

    abstract MobileButton getCustomizeOrder() throws Exception;

    abstract MobileButton getToGo() throws Exception;

    abstract MobileButton getCustomizebread() throws Exception;

    abstract MobileButton getlooksgoodbutton() throws Exception;

    abstract MobileButton getTotalAmount() throws Exception;

    //abstract MobileButton getTaxAmount() throws Exception;
    abstract MobileButton getSubmitOrder() throws Exception;

    abstract MobileButton getGrandTotalAmount() throws Exception;

    abstract MobileButton getTotal() throws Exception;

    abstract MobileButton getProfile() throws Exception;

    abstract MobileButton getSeeDetails() throws Exception;

    abstract MobileButton getChips() throws Exception;

    abstract MobileButton getChipsFlavor() throws Exception;

    abstract MobileLabel getOrderNumInOrderConfirmation() throws Exception;

    abstract MobileLabel getItemName() throws Exception;

    abstract MobileLabel getOrderTotalAmount() throws Exception;

    abstract MobileButton getDineIn() throws Exception;

    abstract MobileButton getDrinksChange() throws Exception;

    abstract MobileButton getSidesChange() throws Exception;

    abstract MobileLabel getSides() throws Exception;

    abstract MobileLabel getLiquids() throws Exception;

    abstract MobileLabel getFlavourDropDown() throws Exception;

    abstract By getProductGroupHeader(String product) throws Exception;

    abstract MobileLabel getAddress1() throws Exception;

    abstract MobileLabel getAddress2() throws Exception;

    abstract MobileLabel getAlertTitle() throws Exception;

    abstract MobileLabel getLoyaltyError() throws Exception;
    abstract MobileButton getBackArrowButton() throws Exception;

    Dimension size;

    Random random = new Random();
    public String favoriteOrderName = null;
    public String orderValue = null;
    RemoteOrder remoteOrder;
    RemoteOrderCustomer customer;
    public int Rewards = 0;
    boolean specificPickerSelection;
    AddCardPage addCardPage;
    UserProfilePage userProfilePage;
    HomePage homePage;
    TouchAction action = new TouchAction((MobileDriver) driver);
    CommonElements elements = new CommonElements((AppiumDriver) driver);
    cardantApiFramework.pojos.Menu menu;
    Store store = new Store();
    OrdersPage ordersPage;
    YourOrderPage yourOrderPage;


    /*This elements are for finding list of elements*/
    By storeNamesLocator = By.id("address");
    By categoryLocator = By.id("product_group_header");
    By sidesOrDrinks = By.id("product_title");
    By someThingElseLocator = By.id("something_else_text");
    By ItemList = By.id("item_options");
    By ItemFromSides = By.id("side_title_1");
    By ItemFromDrinks = By.id("drink_title");
    By specialInstructionsLabel = By.id("instructions_header");
    By FavouriteIconLocator = By.id("favorite_animation");
    By ManageLocator = By.id("manage_rewards");
    By itemPrice = By.id("item_price");
    By taxPriceLocator = By.id("tax_amount");
    By customizeLocator = By.id("customize");
    By rewardsAmt = By.id("rewards_amount");
    By totalAmount = By.id("ordertotal_amount");
    By coldCutCombo = By.partialLinkText("Cold Cut Combo");
    By coffee12oz = By.partialLinkText("12 oz Coffee");
    By moreDrinks = By.id("drinks");
    By fullMenu = By.id("view_full_menu_text");
    By makeItAMeal = By.id("make_it_a_meal_header");


    Random rn = new Random();
    int firstrandnum;
    int nextrandnum;
    public String itemName = null;
    public double price = 0.0;
    public int tokens = 0;
    public int tokens1 = 0;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static OrdersPage get(AppiumDriver driver) throws Exception {
        String platform = SubwayAppBaseTest.platformName;
        switch (platform) {
            case "iOS":
                return new OrdersPageIOS((IOSDriver) driver);
            case "Android":
                return new OrdersPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void payWithGiftCardAndCreditCard(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollAndClick(storeNamesLocator, storeName, "Up");
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            String CategoryItem = order.getCart().getProductDetail().getProductGroup().getName();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            String subCategoryName = order.getCart().getProductDetail().getProductClass().getName();
            swipe(sidesOrDrinks, subCategoryName, "Left");
            getAddToBag().click();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeRandomOrder(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            getOrderValue();
            getTokens(remoteOrder);
            getPlaceOrder().click();
            getGotIt().click();
            Assert.assertEquals(homePage.tokenValue().toString(), String.valueOf(tokens));


            //return specific page-````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeRandomToastedKidsMeal(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getCustomize().click();
            getCustomizebread().click();
            getToastIt().click();
            getlooksgoodbutton().click();
            getAddToBag().click();
            scrollToElement(totalAmount, 0.9, 0.2);
            verifyTaxCalculationInBag();
            getOrderValue();
            Thread.sleep(5000);
            getTokens(remoteOrder);
            getPlaceOrder().click();
            getGotIt().click();
            Assert.assertEquals(homePage.tokenValue().toString(), String.valueOf(tokens));

            //return specific page
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeRandomOrderKids(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().isReady();
            getAddToBag().click();
            getToGo().isReady();
            getToGo().click();
            scrollToElement(totalAmount, 0.9, 0.2);
            verifyTaxCalculationInBag();
            // addCardPage = menuPage.gotoAddPaymentMethods();
            //addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
            getProfile().isReady();
            //return specific page
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void verifyTaxCalculationInBag() throws Exception {
        String taxVal = getTaxPrice().getText();
        double taxPrice = Double.parseDouble(taxVal.substring(1));
        Assert.assertEquals(0.06, taxPrice);
    }


    public void placeRandomOrderFreshValueMeal(String menuItem, MobileUser mobileUser, String storeName, cardantApiFramework.pojos.Menu menu) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(String.valueOf(menuItem));
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            String[] strMenuItemName = menu.getProductName().split(" ", 2);
            scrollAndClick(categoryLocator, menu.getProductClassGroupName(), "Up");
            scrollAndClick(categoryLocator, strMenuItemName[1], "Up");
            if ((!strMenuItemName[0].contains("12")) || (!strMenuItemName[0].contains("FOOTLONG"))) {
                getSixInchOption().click();
            }
            getAddToBag().click();
            scrollToElement(makeItAMeal, 0.9, 0.2);
            getMakeItAMeal().click();
            String aValue = getDrinks().getText();
            getDrinksChange().click();
            //swipeAndClick Left side
            getFlavourDropDown();
            //select item from dropdown
            getAddToBag();
            verifyTaxValueForHotColdItem();
            getPlaceOrder().click();
            getGotIt().click();
            /*scrollAndClick(moreDrinks, "Drinks", "Up");
            getDrinks().isReady();
            swipeAndClick(coffee12oz, "12 oz Coffee", "Right");
            getAddToBag().click();
            getChips().isReady();
            getChips().click();
            getSelectFlavor().click();
            getChipsFlavor().click();
            getAddToBag().isReady();
            getAddToBag().click();
            scrollToElement(totalAmount, 0.9, 0.2);
            verifyTaxCalculationInBag();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
            getProfile().isReady();*/
            //return specific page
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void placeRandomOrderForInvalidBreakfastTime(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            getErrorTitle().getText();
            Assert.assertTrue(getErrorTitle().getText().equals("Error"));
            Assert.assertTrue(getErrorMessage().equals("Could not add FOOTLONG™" + order.getCart().getProductDetail().getProductClass().getName() + "at this time"));
            getErrorOk().click();

            //return specific page
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void addMoreItemsatCheckOut(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            getMakeItAMeal().isReady();
            scrollToElement(someThingElseLocator, 0.9, 0.5);
            getSomethingElse().isReady();
            getSomethingElse().click();
            Order order1 = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getItems().isReady();
            scrollAndClick(categoryLocator, order1.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order1.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void orderForMakeItAMeal(String menuItem, MobileUser mobileUser, String storeName, OrdersPage ordersPage) throws Exception {

        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getStartOrderButton().click();
            getItems().isReady();
            String CategoryItem = order.getCart().getProductDetail().getProductClass().getName();
            if (!CategoryItem.equalsIgnoreCase("Sides") || !CategoryItem.equalsIgnoreCase("Drinks")) {
                scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
                scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            } else {
                scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
                String subCategoryName = order.getCart().getProductDetail().getProductClass().getName();
                swipe(sidesOrDrinks, subCategoryName, "Left");
            }
            getAddToBag().isReady();
            getAddToBag().click();
            getMakeItAMeal().isReady();
            getMakeItAMeal().click();
            /*getExpandArrow().isReady();
            getExpandArrow().click();*/
            getPlaceOrder().isReady();
            assertTexts(ordersPage);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void assertTexts(OrdersPage ordersPage) throws Exception {
        try {
            Assert.assertTrue(ordersPage.isElementPresent(ItemList), "ItemList is present in Make It A Meal dropdown");
            Assert.assertTrue(ordersPage.isElementPresent(ItemFromSides), "One item from Sides is present in Make It A Meal dropdown");
            Assert.assertTrue(ordersPage.isElementPresent(ItemFromDrinks), "One item from Drinks is present in Make It A Meal dropdown");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void clickOnPlaceOrder() throws Exception {
        try {
            getPlaceOrder().click();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public boolean isElementPresent(By locator) throws Exception {
        try {
            int x = ((AppiumDriver) driver).findElements(locator).size();
            if (x > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String getOrderValue() throws Exception {
        String order1 = getOrderNumber().getText();
        String[] actualorderValue = order1.split(" ",4);
        orderValue = actualorderValue[3];
        Logz.step("Getting UI order number from Your Order page "+orderValue);
        return orderValue;

    }

    public String getOrderNum() throws Exception {
        String orderNumber = getOrderNumInOrderConfirmation().getText();
        return orderNumber;
    }

    public String getNameOfItem() throws Exception {
        String ItemName = getItemName().getText();
        return ItemName;
    }

    public String getOrderTotal() throws Exception {
        String OrderInTotal = getOrderTotalAmount().getText();
        return OrderInTotal;
    }

    public HomePage scrollAndClick(By locator, String itemName, String direction) throws Exception {
        boolean flag = false;
        while (getItems(locator).size() > 0) {
            List<WebElement> allElements = getElements(locator);
            if (allElements.size() == 0) {
                Logz.error("no stores available");

            }

            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getText().contains(itemName)) {
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

                // ((AppiumDriver) driver).swipeAndClick(x, y - 50, x, 150, 5000);
                   /* Dimension dimensions = driver.manage().window().getSize();
                    int height=dimensions.height/2;
                    int width=dimensions.width/2;
                int lowerY=(int)((dimensions.height)*0.9);
                int upperY=(int)((dimensions.height)*0.5);
*/
             /*   int Startpoint = element.getLocation().getX();
                    int scrollEnd =  element.getLocation().getY();*/
                Dimension dimensions = driver.manage().window().getSize();
                Double screenHeightStart = dimensions.getHeight() * 0.9;
                int scrollStart = screenHeightStart.intValue();
                Double screenHeightEnd = dimensions.getHeight() * 0.5;
                int scrollEnd = screenHeightEnd.intValue();
                //driver.swipeAndClick(0,scrollStart,0,scrollEnd,2000);
                for (int i = 0; i < getElements(locator).size(); i++) {
                    while (!(getElements(locator).get(i).getText().contains(itemName))) {
                        TouchAction action = new TouchAction((MobileDriver) driver);
                        action.longPress(0, scrollStart).moveTo(0, scrollEnd).release().perform();
                        boolean elementflag = false;
                        for (int j = 0; j < getElements(locator).size(); j++) {

                            if (getElements(locator).get(j).getText().contains(itemName)) {
                                getElements(locator).get(j).click();
                                elementflag = true;
                                break;
                            }

                        }
                        if (elementflag == true) {
                            break;
                        }
                    }
                    i = getElements(locator).size();
                }


            }
            if (flag == true) {
                break;
            }
        }
        return HomePage.get((AppiumDriver) driver);
    }


    public void swipe(By locator, String subProductName, String direction) throws Exception {
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
                    WebElement element = allElements.get(0);
                    MobileElement ele = (MobileElement) element;
                    Thread.sleep(5000L);
                    if (direction.equals("Left")) {
                        size = driver.manage().window().getSize();
                        int width = element.getSize().getWidth();
                        int height = element.getSize().getHeight();
                        TouchAction action = new TouchAction((MobileDriver) driver);
                        action.longPress(element.getLocation().getX() + (int) (width + 800), element.getLocation().getY()).moveTo(100, 1500).release().perform();

                        //element.swipeAndClick(SwipeElementDirection.LEFT, 500);
                    } else {
                        //element.swipeAndClick(SwipeElementDirection.RIGHT, 500);
                    }
                }
            }

            if (flag == true) {
                break;
            }
        }
    }


    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }

    public List<WebElement> getElementList(By locator) throws Exception {
        return new Generic((AndroidDriver) driver, By.id(""), "").getWebElements(By.linkText(""), "");

    }

    public List<WebElement> getItems(By locator) {
        List<WebElement> storesList = ((AndroidDriver) driver).findElements(locator);
        return storesList;
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
            if (!Itemtype[0].trim().equals("FOOTLONG™"))
                getCustomize().click();
            else {
                getSixInchOption().isReady();
                getSixInchOption().click();
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void placeRandomOrderSpecialInstructions(String menuItem, MobileUser mobileUser, String storeName, String specialInstructions) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            getPlaceOrder().isReady();
            scrollToElement(specialInstructionsLabel, 0.9, 0.5);
            getSpecialInstructions().setText(specialInstructions);
            getDriver().hideKeyboard();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);

        }
    }

    public void addIngredient() throws Exception {
        try {
            getAddIngredient().isReady();
            getAddIngredient().click();
            // getAddIngredient().click();
            // getAddIngredient().click();
            //  getAddIngredient().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectBackButton() throws Exception {
        try {
            getBackButton().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void selectBackArrowButton() throws Exception {
        try {
            getBackArrowButton().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void assertEditFunctionalityInEditOrder(MobileUser mobileUser, String menuName, BreadSize breadSize, String value) throws Exception{
        //Add another
        CustomizedItem customizedItem = MobileApi.getCustomizedItemDetails(mobileUser,menuName,breadSize);
        if(value == "AddSameItem"){
            editAndAssertAnOrder(customizedItem);
            getSubItemInfo();
            assertEditCartAddAnother();
            yourOrderPage.assertEditOrderDetailsInYourOrderPage(customizedItem);
            selectBackButton();
            assertEditInOrderDetails(mobileUser,yourOrderPage,customizedItem);
            //placeAnOrder();
        }
        //Delete Item
        if(value == "DeleteItem") {
            editAndAssertAnOrder(customizedItem);
            getSubItemInfo();
            assertEditCartDeleteItem();
            selectBackButton();
            assertEditInOrderDetails(mobileUser,yourOrderPage,customizedItem);
            placeAnOrder();
        }
        //Add from Something else
        if(value == "AddOtherItem") {
            String aItem = editAndAssertAnOrder(customizedItem);
            addAnotherNewItem();
            String eItem = editAndAssertAnOrder(customizedItem);
            assertEditCartSomethingElseVerify(aItem, eItem);
            assertEditInOrderDetails(mobileUser,yourOrderPage,customizedItem);
            clickOnPlaceOrder();
        }
    }


    public String editAndAssertAnOrder(CustomizedItem customizedItem) throws Exception {
        try {
            Logz.step("Select product menu "+customizedItem.getMenuName());
            elements.scrollAndClick(null,categoryLocator,customizedItem.getMenuName());
            Logz.step("Select item name "+customizedItem.getCustomizedProductDetail().getProductName());
            elements.scrollAndClick(null,categoryLocator,customizedItem.getCustomizedProductDetail().getProductName());
            String aSubItem = customizedItem.getProductDetail().getName();
            /*RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            elements.scrollAndClick(null,categoryLocator,order.getCart().getProductDetail().getProductGroup().getName());
            elements.scrollAndClick(null,categoryLocator,order.getCart().getProductDetail().getProductClass().getName());
            String aSubItem = order.getCart().getProductDetail().getProductClass().getName();*/
            Logz.step("Item from API is" +aSubItem);
            return aSubItem;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String editAndAssertAnOrder1(CustomizedItem customizedItem) throws Exception {
        try {
            Logz.step("Getting the product name from UI");
            String aSubItemname = customizedItem.getProductDetail().getName();
            /*String[] aSubItem  = aSubItemname.split(" ",2);
            Logz.step("Item from API is" +aSubItem[1]);*/
            Logz.step("Item from API is "+aSubItemname);
            return aSubItemname;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String editCartAndPlaceAnOrder(String menuItem, RemoteOrder remoteOrder, String storeName) throws Exception {
        try {

            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            scrollAndClick( storeNamesLocator, storeName, "Up" );
            //getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            String aSubItem = order.getCart().getProductDetail().getProductClass().getName();
            return aSubItem;
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }


    public String getSubItemInfo() throws Exception {
        try {
            //getAddToBag().click();
            getEdit().click();
            getSubItem().isReady();
            String eSubCategoryItem = getSubItem().getText();
           /*String[] itemName = eSubCategoryItem.split(" ", 2);
            String[] itemName = eSubCategoryItem.split(" ");
            String eSubItem = "";
            for (int i = 1; i < itemName.length; i++) {
                eSubItem = eSubItem + itemName[i] + " ";
            }
            String eSubItem = itemName[1];*/
            Logz.step("Item from UI in Edit order page is" +eSubCategoryItem);
            return eSubCategoryItem.trim();
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
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_item_name")).size();
            getAddAnother().isReady();
            getAddAnother().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_item_name")).size();
            subItems.add(previousList + 1);
            subItems.add(afterList);
            return subItems;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void addAnotherNewItem() throws Exception {
        try {
            By someThingElseLocator = By.id("com.subway.mobile.subwayapp03:id/something_else_text");
            getAddToBag().click();
            getPlaceOrder().isReady();
            scrollAndClick(someThingElseLocator, "Something Else", "Up");
            getSomethingElse().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<Integer> removeItem() throws Exception {
        try {
            ArrayList<Integer> subItems = new ArrayList<Integer>();
            int previousList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_item_name")).size();
            getDeleteItem().isReady();
            getDeleteItem().click();
            getRemove().isReady();
            getRemove().click();
            int afterList = driver.findElements(By.id("com.subway.mobile.subwayapp03:id/cart_item_name")).size();
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

    public boolean getTimeComparision(Store store) throws Exception {
        Boolean timePresent = false;
        String startTime = store.getBreakStartTime();
        String endTime = store.getBreakEndTime();
        String timeZone = store.getTimeZone();
        try {
            if (startTime.equals("00:00:00") && endTime.equals("00:00:00")) {
                timePresent = true;
                return timePresent;
            } else {


                Date today = new Date();

                DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

                //dispalying date on PST timezone
                if (timeZone.equals("Pacific Standard Time")) {
                    timeZone = "America/Los_Angeles";
                } else if (timeZone.equals("Eastern Standard Time")) {
                    timeZone = "America/New_York";
                } else if (timeZone.equals("Central Standard Time")) {
                    timeZone = "America/Chicago";
                }
                df.setTimeZone(TimeZone.getTimeZone(timeZone));
                String dateGmt = df.format(today);
                System.out.println("Date in  Timezone : " + dateGmt);
                System.out.println(dateGmt);
                String time = dateGmt.split(":", 2)[1];

                Date time1 = new SimpleDateFormat("HH:mm:ss").parse(startTime);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(time1);

                Date time2 = new SimpleDateFormat("HH:mm:ss").parse(endTime);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(time2);
                calendar2.add(Calendar.DATE, 1);

                Date d = new SimpleDateFormat("HH:mm:ss").parse(time);
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(d);
                calendar3.add(Calendar.DATE, 1);

                Date x = calendar3.getTime();
                if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {

                    timePresent = true;
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return timePresent;

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
            if (veggies.getLocation().getX() > width / 2) {
                //veggies.swipeAndClick(SwipeElementDirection.LEFT, 500);
            } else {

                //  veggies.swipeAndClick(SwipeElementDirection.RIGHT, 500);
            }
            List<WebElement> extraIngredients = driver.findElements((extraIngredientsBy));

            for (int m = 0; m < order.getCart().getOptions().length; m++) {

                for (int i = 0; i < extraIngredients.size(); i++) {
                    String name = extraIngredients.get(i).getText();

                    if (name.equalsIgnoreCase(order.getCart().getOptions()[m + 2].getOptionGroup())) {
                        String optionGroup = order.getCart().getOptions()[m + 2].getOptionGroup();
                        extraIngredients.get(i).click();

                        ClickonItem(order.getCart().getOptions()[m + 2].getName(), order.getCart().getOptions()[m + 2].getValue(), InnerIngredientsBy, optionGroup);


                        break;
                    }
                    try {
                        if (extraIngredients.get(i).getText().equalsIgnoreCase("veggies") ||
                                extraIngredients.get(i).getText().equalsIgnoreCase("sauces") ||
                                extraIngredients.get(i).getText().equalsIgnoreCase("seasonings")) ;
                        // veggies.swipeAndClick(SwipeElementDirection.LEFT, 1200);
                    } catch (Exception e) {
                        Logz.info("End of screen");
                    }

                }
            }
        } catch (Exception ex) {

            throw new Exception(ex);
        }
    }

    public void ClickonItem(String name, String value, By InnerIngredientsBy, String optionGroup) {

        By cheeseSubCategoryItem = By.id("com.subway.mobile.subwayapp03:id/ingredient_text");
        boolean flag = true;
        do {
            List<WebElement> innerIngredients = driver.findElements((InnerIngredientsBy));
            for (int i = 0; i <= innerIngredients.size(); i++) {
                if (i == innerIngredients.size()) {
                    //scroll;
                    //scrollToItemAndClick(cheeseSubCategoryItem, name, 1600,3000);
                    flag = false; //turn this on if you are not implementing scroll. if not it will go into infinite loop
                    break;
                }
                itemName = innerIngredients.get(i).getText();
                By itemBy;
                if (itemName.equalsIgnoreCase(name) && !(value.equalsIgnoreCase("None")) && !(name.equalsIgnoreCase("Tomatoes")) && !(name.equalsIgnoreCase("Cucumber")) && !(name.equalsIgnoreCase("Pepper"))) {
                    if (driver instanceof AndroidDriver)
                        itemBy = By.xpath("//android.widget.TextView[@text ='" + itemName + "' ]/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout");
                    else
                        itemBy = null;
                    innerIngredients.get(i).click();
                    if (driver.findElements(itemBy).size() > 0 && !itemName.equalsIgnoreCase("cheese"))
                        driver.findElement(itemBy).click();
                    if (!(optionGroup.equals("Extras"))) {
                        getModifyMethod(value);
                    }

                    flag = false;
                    break;
                }
            }
        } while (flag);
    }

    public void getModifyMethod(String modification) {
        try {
            switch (modification) {
                case "Less":
                    getLess().click();
                    getDone().click();
                    break;
                case "More":
                    getMore().click();
                    getDone().click();
                    break;
                case "Regular":
                    getRegular().click();
                    getDone().click();
                    break;
                case "None":
                    getDone().click();
                    break;
                default:
                    getDone().click();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<WebElement> getNames(By locator) {
        List<WebElement> namesList = ((AndroidDriver) driver).findElements(locator);
        return namesList;
    }


    public void scrollToElement(By locator, double startpoint, double endpoint) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int StartPoint = (int) (dimensions.getHeight() * startpoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endpoint);//0.5
            //((AppiumDriver) driver).swipeAndClick(200, Startpoint, 200, EndPoint, 2000);
            action.longPress(0, StartPoint).moveTo(0, EndPoint).release().perform();


        }
    }

    public void modify(String value, By quantityBy) {
        List<WebElement> mod = driver.findElements((quantityBy));
        for (int i = 0; i <= mod.size(); i++) {
            if (i == mod.size()) {

            }

        }

    }

    public void selectRestaurant(String storeName) throws Exception {
        try {
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getSelectRestaurantButton().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String favoriteOrderName() throws Exception {
        return favoriteOrderName;
    }

    public String favoriteItem() throws Exception {
        return favoriteOrderName;
    }

    public void selectRestaurant() throws Exception {
        try {
            getSelectRestaurantButton().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public String switchStoreName(String storeName1) throws Exception {
        try {
            scrollAndClick(storeNamesLocator, storeName1, "Up");
            getSwitchStoreName().isReady();
            return getSwitchStoreName().getText();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public HomePage placeFavouriteRandomOrder(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().click();
            Thread.sleep(5000);
            getTokens(remoteOrder);
            getPlaceOrder().click();
            Thread.sleep(10000);
            scrollToElement(FavouriteIconLocator, 0.9, 0.5);
            getFavouriteIcon().click();
            // getFavouriteText().click;
            favoriteOrderName = "Subway" + random.nextInt(10);
            getFavouriteText().setText(favoriteOrderName);
            getFavouriteSave().click();
            getpopupGotIt().click();
            getGotIt().click();
            Assert.assertEquals(String.valueOf(tokens), homePage.tokenValue().toString());
            return HomePage.get((AppiumDriver) driver);

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void placeCustomizeOrder(String menuItem, String storeName, Order order) throws Exception {
        try {
            By storeNamesLocator = By.id("com.subway.mobile.subwayapp03:id/address");
            By categoryLocator = By.id("com.subway.mobile.subwayapp03:id/product_group_header");
            By sidesOrDrinks = By.id("com.subway.mobile.subwayapp03:id/product_title");
            getDirections().isReady();
            scrollAndClick(storeNamesLocator, storeName, "Up");
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void deleteToppings() {
        try {
            By toppings = By.id("com.subway.mobile.subwayapp03:id/item_image");
            By deleteToppingTextLocator = By.id("com.subway.mobile.subwayapp03:id/ingredient_name_textview");

            //Get count before deleting toppings
            List<WebElement> toppingBeforeDelete = ((AndroidDriver) driver).findElements(toppings);
            WebElement element = toppingBeforeDelete.get(4);
            MobileElement mobileElement = (MobileElement) element;
            swipeLeft(element);
            //  mobileElement.swipeAndClick(SwipeElementDirection.LEFT,500);
            //Get count after deleting toppings
            List<WebElement> toppingAfterDelete = ((AndroidDriver) driver).findElements(toppings);
            Assert.assertEquals(toppingAfterDelete.size(), toppingBeforeDelete.size() - 1);


        } catch (Exception e) {

        }
    }

    public void placeRandomOrder1(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            By storeNamesLocator = By.id("com.subway.mobile.subwayapp03:id/address");
            By categoryLocator = By.id("com.subway.mobile.subwayapp03:id/product_group_header");
            By sidesOrDrinks = By.id("com.subway.mobile.subwayapp03:id/product_title");
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getDirections().isReady();
            scrollToItemAndClick1(storeNamesLocator, storeName, driver.manage().window().getSize().getHeight() - 300);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            getItems().isReady();
            scrollToItemAndClick1(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), driver.manage().window().getSize().getHeight() - 300);
            scrollToItemAndClick1(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), driver.manage().window().getSize().getHeight() - 300);
            getAddToBag().isReady();
            getAddToBag().click();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void scrollToItemAndClick1(By locator, String itemName, int endY) {
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
                // ((AppiumDriver) driver).swipeAndClick(x, y, x, y - endY, 3000);
                swipeLeft(element);
            }
            if (flag == true) {
                break;
            }
        }
    }

    public void swipeLeft(WebElement element) {
        size = driver.manage().window().getSize();
        int x1 = (int) (size.width * 0.20);
        TouchAction action = new TouchAction((MobileDriver) driver);
        action.longPress(element).moveTo(x1, 580).release().perform();

    }

    public void validateManageLocator() throws Exception {
        Logz.step("Manage Button verification in rewards has started ");
        scrollToElement(ManageLocator, 0.9, 0.5);
        Thread.sleep(5000);
        if (getRewardsAmt().getText().contains("$2 Reward")) {
            Logz.step("Rewards are available");
        } else {
            Logz.error("Rewards are not available to redeem/Zero rewards are getting displayed");
        }


    }

    public void storesAvailable() throws Exception {
        try {
            getDirections().isReady();
        } catch (Exception ex) {
            Logz.error("no stores available");
        }

    }

    public void placeRandomOrderwithRedeemCertificate(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {

            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            storesAvailable();
            HomePage homePage = scrollAndClick(storeNamesLocator, storeName, "Up");
            tokens = Integer.parseInt(homePage.tokenValue());
            homePage.apply();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            getAddToBag().isReady();
            getAddToBag().click();
            getOrderValue();
            Thread.sleep(20000);
            getTokens(remoteOrder);
            validateManageLocator();
            getPlaceOrder().waitForClickable();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
            Assert.assertEquals(String.valueOf(tokens), homePage.tokenValue().toString());
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void getAllFavourites() throws Exception {
        getFavourites().click();
    }

    public void placeFavouriteReOrder(MobileUser mobileUser) throws Exception {
        try {

            getItems().isReady();
            getAllFavourites();
            getFavouriteAddToBag().click();
            getPlaceOrder().click();
            getGotIt().click();

        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void removeFavouriteOrder(MobileUser mobileUser) throws Exception {
        try {

            getAllFavourites();
            getUnFavouriteIcon().isReady();
            getUnFavouriteIcon().click();
            getRemoveFavourite().isReady();
            getRemoveFavourite().click();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void getTokens(RemoteOrder remoteOrder) throws Exception {
        Thread.sleep(2000);
        scrollToElement(itemPrice, 0.9, 0.5);
        price = Double.parseDouble(getSubTotal().getText().substring(1));
        tokens1 = remoteOrder.computeTokens(price);
        tokens = tokens + tokens1;
    }

    public void assertProduct(String actualProductName, String expectedProductName) throws Exception {
        try {
            Logz.step("Asserting the API and UI items");
            Assert.assertEquals(actualProductName, expectedProductName);
            Logz.step("Asserted the API and UI items");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void assertEditCartAddAnother() throws Exception {
        try {
            List<Integer> sizeOfSubItems = addAnotherSameItem();
            Assert.assertEquals(sizeOfSubItems.get(1), sizeOfSubItems.get(0));
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void assertEditCartDeleteItem() throws Exception {
        try {
            List<Integer> sizeOfSubItems = addAnotherSameItem();
            removeItem();
            Assert.assertEquals(sizeOfSubItems.get(0), sizeOfSubItems.get(1));
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void assertEditCartSomethingElseVerify(String actualProduct, String expectedProduct) throws Exception {
        try {
            Assert.assertEquals(actualProduct, expectedProduct);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public HomePage assertStoreDetails() throws Exception {
        try {
            Logz.step("Getting the actual store value from UI");
            String actualStoreName = getAddress1() + getAddress2().getText();
            Logz.step(actualStoreName);
            Logz.step("Getting the expected store value from database");
            String expectedStoreName = store.getAddress1() + store.getAddress2();
            Logz.step(expectedStoreName);
            Assert.assertEquals(actualStoreName, expectedStoreName);
            return HomePage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public int rewardsValue() throws Exception {
        String amt[] = getRewardsAmt().getText().split("\\.");
        Rewards = Integer.parseInt(amt[0].substring(2));
        return Rewards;
    }

    public void placeRandomOrder(String menuItem, MobileUser mobileUser) throws Exception{
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            Logz.step("Selected MenuCategory is " + order.getCart().getProductDetail().getProductGroup().getName());
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            Logz.step("Selected MenuItemName is " + order.getCart().getProductDetail().getProductClass().getName());
            getAddToBag().click();
            getOrderValue();
            getTokens(remoteOrder);
            getPlaceOrder().click();
            getGotIt().click();
        }
        catch (Exception ex){
            throw new Exception();
        }

    }

    public void assertSeventhOrder(String menuItem, MobileUser mobileUser) throws Exception{
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct(menuItem);
            getItems().isReady();
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up");
            Logz.step("Selected MenuCategory is " + order.getCart().getProductDetail().getProductGroup().getName());
            scrollAndClick(categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up");
            Logz.step("Selected MenuItemName is " + order.getCart().getProductDetail().getProductClass().getName());
            getAddToBag().click();
            getOrderValue();
            getTokens(remoteOrder);
            getPlaceOrder().click();
            Assert.assertEquals(getAlertTitle().getText(), BaseTest.getStringfromBundleFile("LoyaltyErrorTitle"));
            Assert.assertEquals(getLoyaltyError().getText(), BaseTest.getStringfromBundleFile("LoyaltyMessage"));
            Logz.step("Loyalty error got displayed if order placed more than 6 times");
        }
        catch (Exception ex){
            throw new Exception();
        }

    }

    public HomePage placeRandomOrderForSixTimes(String menuItem, MobileUser mobileUser, int i) throws Exception {
        try {
           if (i == 0) {
                placeRandomOrder(menuItem,mobileUser);
                return HomePage.get((AppiumDriver) driver);
            }
            if(i<6){
                getStartOrderButton().click();
                placeRandomOrder(menuItem,mobileUser);
                return HomePage.get((AppiumDriver) driver);
            }
            if (i == 7) {
                assertSeventhOrder(menuItem,mobileUser);
            }
          goToHomePage();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return HomePage.get((AppiumDriver) driver);
    }

    public void placeRandomOrderwithRedeemMultipleCertificate(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            homePage.apply();
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().isReady();
            getAddToBag().click();
            getOrderValue();
            scrollToElement( ManageLocator, 0.9, 0.5 );
            rewardsValue();
            getPlaceOrder().click();
            getTokens( remoteOrder );
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeRandomOrderwithRedeemOffers(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            homePage.getOffers();
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            String subCategoryName = order.getCart().getProductDetail().getName();
            if (subCategoryName.equalsIgnoreCase( "Apple Slices" )) {
                getAddToBag().isReady();
            } else {
                swipe( sidesOrDrinks, subCategoryName, "Left" );
                getSelectFlavor().isReady();
                getSelectFlavor().click();
                getItemSelectFlavor().isReady();
                getItemSelectFlavor().click();
                getAddToBag().isReady();
            }
            getAddToBag().click();
            getPlaceOrder().isReady();
            //getOrderValue();
            //  scrollToElement(ManageLocator,0.9,0.5);
            //   getPlaceOrder().click();
            ////   getTokens(remoteOrder);
            // getGotIt().isReady();
            // getGotIt().click();
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeOrderwithRedeemOffersandCertificates(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue());
            homePage.apply();
            homePage.getOffers();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().isReady();
            getAddToBag().click();
            getPlaceOrder().isReady();
            scrollToElement( ManageLocator, 0.9, 0.5 );
            rewardsValue();
            //  getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeRandomOrderwithExpiredCertificate(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {

            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            homePage.apply();
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().isReady();
            getAddToBag().click();

            getOrderValue();
            getTokens( remoteOrder );
            scrollToElement( ManageLocator, 0.9, 0.5 );
            rewardsValue();
            //  getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void validatePlacingOrderForSixTimes(MobileUser mobileUser) throws Exception {
        for (int i = 0; i < 7; i++) {
                HomePage homePage = placeRandomOrderForSixTimes("All Sandwiches", mobileUser, i);//Placing order more than 6 times
                UserProfilePage userProfilePage = homePage.gotoMenuPage();
                userProfilePage.assertMobileOrderHistory(orderValue);
                selectBackArrowButton();
                userProfilePage.goHome();
                //Assert.assertEquals(String.valueOf(tokens), homePage.tokenValue().toString());//verifying order in order History
        }

    }


    public void placeRandomwithNoTax(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().click();
            getTaxValue();
            customizeOrder();
            customizeOrder( mobileUser, order );
            getTokens( remoteOrder );
            getGotIt().click();
            Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );

            //return specific page
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void getTaxValue() throws Exception {
        scrollToElement( taxPriceLocator, 0.9, 0.5 );
        String taxVal = getTaxPrice().getText();
        double taxPrice = Double.parseDouble( taxVal.substring( 1 ) );
        Assert.assertEquals( 0.00, taxPrice );
    }

    public void verifyTaxValueForHotColdItem() throws Exception {
        scrollToElement( totalAmount, 0.9, 0.5 );
        String aTaxVal = "0.00";
        if (getTaxPrice().getControl().isDisplayed()) {
            String eTaxVal = getTaxPrice().getText();
            if (!eTaxVal.contains( aTaxVal )) {
                Logz.step( "Validated Tax for Hot/Cold item in DineIn/TakeOut successfully" );
                Assert.assertNotEquals( aTaxVal, eTaxVal );
            } else {
                Logz.step( "Validated Tax for Cold item in TakeOut successfully" );
                Assert.assertEquals( aTaxVal, eTaxVal );
            }
        } else {
            Logz.step( "Validated Tax for Cold item in TakeOut successfully" );
        }

        /*if (!eTaxVal.contains("0.00")){
            Logz.step("Validated Tax for Hot/Cold item in DineIn successfully");
            Assert.assertNotEquals(aTaxVal, eTaxVal);
        }else {
            Logz.step("Validated Tax for Cold item in DineIn successfully");
            Assert.assertEquals(aTaxVal, eTaxVal);
        }*/
        //double taxPrice = Double.parseDouble(taxVal.substring(1));
    }

    public void verifyTaxValueForColdItem() throws Exception {
        scrollToElement( taxPriceLocator, 0.9, 0.5 );
        String aTaxVal = "0.00";
        String eTaxVal = getTaxPrice().getText();
        if (!eTaxVal.contains( aTaxVal )) {
            Logz.step( "Validated Tax for Cold item in ToGo successfully" );
        }
        //double taxPrice = Double.parseDouble(taxVal.substring(1));
        Assert.assertNotEquals( aTaxVal, eTaxVal );
    }

    public void customizeOrder() throws Exception {
        scrollToElement( customizeLocator, 0.9, 0.5 );
        getCustomizeOrder().click();


    }

    public void verifyOrderConformationReceipt() throws Exception {
        //have to be verify order conformation page
        getSeeDetails().isReady();
        getSeeDetails().click();
        getTaxValue();
    }

    public cardantApiFramework.pojos.Menu getMenuDetails(Store store, Tax tax) throws Exception {
        //menu = JdbcUtil.getHotColdMenuItem( String.valueOf( store.getLocationCode() ), Menu.AllSandwiches.toString(), tax.toString(), Tax.strOrderTypeIndividual.toString() );
        return menu;
    }

    public void validateTax() throws Exception {
        System.out.println( "############################" + CartData.getCartPrice( customer ).toString() );
    }

    public String getProductName(cardantApiFramework.pojos.Menu menu) {
        String[] strMenuItemName = menu.getProductName().split( " ", 2 );
        return strMenuItemName[1];

    }

    public void getStoreClick(String storeName) throws Exception {
        HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
        homePage.apply();
        getStartOrderButton().click();

    }

    public HomePage addingHotandColdToCart(MobileUser mobileUser, Store store, String type) throws Exception {
        getStoreClick( store.getAddress1() );
        cardantApiFramework.pojos.Menu menu = getMenuDetails( store, Tax.strTaxHotCategoryName );
        addingOrdertoBag( mobileUser, Menu.AllSandwiches, BreadSize.NONE, menu, store.getAddress1() );
        if (type.equals( "DineIn" )) {
            getDineIn().click();
        }
        getDineIn().click();
        goToFullMenu();
        menu = getMenuDetails( store, Tax.strTaxColdCategoryName );
        addingOrdertoBag( mobileUser, Menu.AllSandwiches, BreadSize.NONE, menu, store.getAddress1() );
        validateManageLocator();
        verifyTaxValueForHotColdItem();
        getPlaceOrder().click();
        Thread.sleep( 20000 );
        getTokens( remoteOrder );
        getGotIt().click();
        Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );
        return homePage.get( (AppiumDriver) driver );


    }

    public void addingOrdertoBag(MobileUser mobileUser, Menu menuItem, BreadSize breadSize, cardantApiFramework.pojos.Menu menu, String storeName) throws Exception {
        try {

            itemName = menuItem.toString();
            selectSpecificMenu( itemName );
            selectRandomProduct( breadSize );
            getAddToBag().click();


        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void goToFullMenu() throws Exception {
        scrollToElement( fullMenu, 0.9, 0.5 );
        getFullMenu().click();
    }

    public void placeRandomOrderCertDiscountwithHotItems(String menuItem, BreadSize breadSize) throws Exception {
        try {

            itemName = menuItem.toString();
            selectSpecificMenu( itemName );
            selectRandomProduct( breadSize );
            getAddToBag().isReady();
            getAddToBag().click();
            scrollAndClick( moreDrinks, "Drinks", "Up" );
            getDrinks().isReady();
            swipe( coffee12oz, "12 oz Coffee", "Right" );
            getAddToBag().click();
            getChips().isReady();
            getChips().click();
            getSelectFlavor().click();
            getChipsFlavor().click();
            getAddToBag().isReady();
            getAddToBag().click();
            scrollToElement( totalAmount, 0.9, 0.2 );
            verifyTaxCalculationInBag();
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
            getProfile().isReady();
            //return specific page
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }


    public void placeRandomwithDineInHotTax(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().click();
            verifyTaxCalculationInBag();
            customizeOrder();
            customizeOrder( mobileUser, order );
            verifyTaxCalculationInBag();
            getChips().click();
            getSelectFlavor().isReady();
            getSelectFlavor().click();
            getItemSelectFlavor().isReady();
            getItemSelectFlavor().click();
            getAddToBag().click();
            verifyTaxCalculationInBag();
            getDrinks().click();
            getAddToBag().click();
            verifyTaxCalculationInBag();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            Thread.sleep( 20000 );
            getTokens( remoteOrder );
            getGotIt().isReady();
            getGotIt().click();
            Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );

        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeOrderForHotColdItemsInDineIn(String menuItem, MobileUser mobileUser, String storeName, cardantApiFramework.pojos.Menu menu) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( String.valueOf( menuItem ) );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            String[] strMenuItemName = menu.getProductName().split( " ", 2 );
            scrollAndClick( categoryLocator, menu.getProductClassGroupName(), "Up" );
            scrollAndClick( categoryLocator, strMenuItemName[1], "Up" );
            if ((!strMenuItemName[0].contains( "12" )) || (!strMenuItemName[0].contains( "FOOTLONG" ))) {
                getSixInchOption().click();
            }
            getAddToBag().click();
            if (getDineIn().getControl().isDisplayed()) {
                Logz.step( "DineIn button got displayed in Your Order page" );
            } else {
                Logz.error( "DineIn button is not visible" );
            }
            getDineIn().click();
            verifyTaxValueForHotColdItem();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            Thread.sleep( 20000 );
            getTokens( remoteOrder );
            getGotIt().isReady();
            getGotIt().click();
            Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );

        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeOrderForHotColdItemsInToGo(String menuItem, MobileUser mobileUser, String storeName, cardantApiFramework.pojos.Menu menu) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( String.valueOf( menuItem ) );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            String[] strMenuItemName = menu.getProductName().split( " ", 2 );
            scrollAndClick( categoryLocator, menu.getProductClassGroupName(), "Up" );
            scrollAndClick( categoryLocator, strMenuItemName[1], "Up" );
            if ((!strMenuItemName[0].contains( "12" )) || (!strMenuItemName[0].contains( "FOOTLONG" ))) {
                getSixInchOption().click();
            }
            getAddToBag().click();
            if (getToGo().getControl().isDisplayed()) {
                Logz.step( "ToGo button got displayed in Your Order page" );
            } else {
                Logz.error( "ToGo button is not visible" );
            }
            getToGo().click();
            verifyTaxValueForHotColdItem();
            getPlaceOrder().isReady();
            getPlaceOrder().click();
            Thread.sleep( 20000 );
            getTokens( remoteOrder );
            getGotIt().isReady();
            getGotIt().click();
            Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );

        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }


    public void placeRandomOrderKidswithToy(String menuItem, MobileUser mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().isReady();
            getAddToBag().click();
            getToGo().isReady();
            getToGo().click();
            scrollToElement( totalAmount, 0.9, 0.2 );
            verifyTaxCalculationInBag();
            // addCardPage = menuPage.gotoAddPaymentMethods();
            //addCardPage.addPayment(mobileUser, PaymentMethod.CREDITCARD);
            getPlaceOrder().click();
            getGotIt().isReady();
            getGotIt().click();
            getProfile().isReady();
            //return specific page
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public HomePage placeFavouriteRandomOrder(String menuItem, RemoteOrderCustomer mobileUser, String storeName) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().click();
            Thread.sleep( 5000 );
            getPlaceOrder().click();
            Thread.sleep( 10000 );
            getTokens( remoteOrder );
            scrollToElement( FavouriteIconLocator, 0.9, 0.5 );
            getFavouriteIcon().click();
            // getFavouriteText().click;
            favoriteOrderName = "Subway" + random.nextInt( 10 );
            getFavouriteText().setText( favoriteOrderName );
            getFavouriteSave().click();
            getpopupGotIt().click();
            getGotIt().click();
            Assert.assertEquals( String.valueOf( tokens ), homePage.tokenValue().toString() );
            return HomePage.get( (AppiumDriver) driver );

        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    public void placeRandomOrder(String menuItem, RemoteOrderCustomer mobileUser, String storeName) throws Exception {
        try {
            remoteOrder = mobileUser.getCart().getRemoteOrder();
            Order order = remoteOrder.placeRandomOrderWithSpecificProduct( menuItem );
            getDirections().isReady();
            HomePage homePage = scrollAndClick( storeNamesLocator, storeName, "Up" );
            tokens = Integer.parseInt( homePage.tokenValue() );
            getStartOrderButton().click();
            getItems().isReady();
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductGroup().getName(), "Up" );
            scrollAndClick( categoryLocator, order.getCart().getProductDetail().getProductClass().getName(), "Up" );
            getAddToBag().click();
            getOrderValue();
            getPlaceOrder().click();
            Thread.sleep( 5000 );
            getTokens( remoteOrder );
            getGotIt().click();
            Assert.assertEquals( homePage.tokenValue().toString(), String.valueOf( tokens ) );


            //return specific page
        } catch (Exception ex) {
            throw new Exception( ex );
        }
    }

    //##########################################################################################################################
   // CustomizedItem customizedItem;
    By productGroupHeaderAndroid = By.id( "product_group_header" );
    By productGroupHeaderIOS = By.id( "product_group_header" );
    By getProductGroupLayoutAndroid = By.id( "product_group_layout" );
    By getProductGroupLayoutIOS = By.id( "product_group_layout" );
    boolean customized = false;


    public HomePage placeSidesDrinksDefaultOrderThenAssert(MobileUser mobileUser, String menuCategories, Store store) throws Exception {
        try {

            Logz.step("##### Started placing Default Order #####" + menuCategories);
            CustomizedItem customizedItemDetails = MobileApi.getSidesDrinksCustomizedItemDetails( mobileUser, menuCategories );
            Logz.step(" \nProduct Menu Name: "
                    + menuCategories + " \n Product Name:"
                    + customizedItemDetails.getProductDetail().getName()+  " \n Store Number: "
                    + store.getStoreNumber() +  " \n Store ZipCode: "
                    + store.getZipCode() + " \n Store Address: "
                    + store.getAddress1() );
            //cookies add to bag button is not clickable,
            if(!customizedItemDetails.getCustomizedProductDetail().getProductClassName().contains( BaseTest.getStringfromBundleFile(  "Cookies" ))){
                YourOrderPage yourOrderPage =  addDefaultSidesDrinksItemInCart(menuCategories, customizedItemDetails);
                placeSidesDrinksOrderAndAssert(mobileUser, yourOrderPage, customizedItemDetails);
            }

            Logz.step("##### Ended placing Default Order #####");
        } catch (Exception ex) {
            throw new Exception("Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage());
        }
        return HomePage.get((AppiumDriver) driver);

    }

    public HomePage placeDefaultOrder(MobileUser mobileUser, String menuCategories, BreadSize breadSize, Store store) throws Exception {
        try {
            customized = false;
            Logz.step( "##### Started placing Default Order #####" + menuCategories );
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            Logz.step(" \nProduct Menu Name: "
                    + menuCategories + " \n Product Name:"
                    + customizedItemDetails.getProductDetail().getName()+  " \n Store Number: "
                    + store.getStoreNumber() +  " \n Store ZipCode: "
                    + store.getZipCode() + " \n Store Address: "
                    + store.getAddress1() );
            addDefaultItemInCart( mobileUser, breadSize, customizedItemDetails );
            placeOrderAndAssert( mobileUser, menuCategories, store, customizedItemDetails );
            Logz.step( "##### Ended placing Default Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage() );
        }
        return HomePage.get( (AppiumDriver) driver );

    }

    public HomePage placeDefaultOrderforTax(MobileUser mobileUser, String menuCategories, Store store, cardantApiFramework.pojos.Menu menu, boolean isHot, boolean isDineIn, boolean isMakeitaMeal,boolean Mealwithcoffe) throws Exception {
        try {
            customized = false;
            Logz.step( "##### Started placing Default Order #####" + menuCategories );
            if(isHot){
                Logz.step( "##### Hot Item  to Select #####" + menu.getProductName() );
            }
            else {
                Logz.step( "##### Cold Item  to Select #####" +menu.getProductName() );
            }
            //CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            addDefaultItemInCartForTax( mobileUser,menuCategories, menu.getProductName());
            placeOrderAndAssertforTax( mobileUser,menu.getProductName(),menu.getProductPrice(),isDineIn,isMakeitaMeal,Mealwithcoffe);

            Logz.step( "##### Ended placing Default Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage() );
        }
        return HomePage.get( (AndroidDriver) driver );

    }

    public HomePage placeEditOrder(MobileUser mobileUser, String menuCategories, BreadSize breadSize, Store store) throws Exception {
        try {
            customized = false;
            Logz.step( "##### Started placing Default Order #####" + menuCategories );
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            addDefaultItemInCart( mobileUser, breadSize, customizedItemDetails );
            editOrderAndAssert(mobileUser,menuCategories,store,customizedItemDetails);
            Logz.step( "##### Ended placing Default Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage() );
        }
        return HomePage.get( (AndroidDriver) driver );

    }

    public HomePage productDetailsAssertion(MobileUser mobileUser, String menuCategories, BreadSize breadSize) throws Exception {
        try {
            customized = false;
            Logz.step("##### Started placing Default Order #####" + menuCategories);
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            String productName = selectMenuGetProductName( customizedItemDetails , breadSize);
            ProductDetailsPage productDetailsPage = goToProductDetailsPage( productName );
            if (!(customizedItemDetails.getCustomizedProductDetail().getBreadSize().contains( "FOOTLONG™" ) || breadSize.toString().contains( "none" ))) {
                if (MobileApi.getBreadOptionCount( customizedItemDetails, mobileUser ) > 1) {
                    getSixInchOption().click();
                }
            }
            productDetailsPage.assertProductDetails( mobileUser, customizedItemDetails );
            Logz.step("##### Started placing Order for certificates #####" + menuCategories);
            addDefaultItemInCart( mobileUser, breadSize, customizedItemDetails );
            placeOrderAndAssert(mobileUser, menuCategories, store, customizedItemDetails);
            Logz.step("##### Ended placing Default Order #####");
        } catch (Exception ex) {
            throw new Exception("Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage());
        }
        return HomePage.get((AppiumDriver) driver);

    }

    public HomePage placeCustomizedOrder(MobileUser mobileUser, String menuCategories, BreadSize breadSize, Store store, boolean specificPickerSelection) throws Exception {
        try {
            customized = true;
            this.specificPickerSelection = specificPickerSelection;
            Logz.step( "##### Started placing Customized Order #####" + menuCategories );
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            Logz.step(" \nProduct Menu Name: "
                    + menuCategories + " \n Product Name:"
                    + customizedItemDetails.getProductDetail().getName()+  " \n Store Number: "
                    + store.getStoreNumber() +  " \n Store ZipCode: "
                    + store.getZipCode() + " \n Store Address: "
                    + store.getAddress1() );
            addCustomizedItemInCart( mobileUser,  breadSize, customizedItemDetails );
            placeOrderAndAssert( mobileUser, menuCategories, store, customizedItemDetails );
            Logz.step( "##### Ended placing Customized Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage() );
        }
        return HomePage.get( (AppiumDriver) driver );
    }
    public HomePage placeFavouriteOrder(MobileUser mobileUser, String menuCategories, BreadSize breadSize, Store store) throws Exception {
        try {
            customized = false;
            Logz.step( "##### Started placing Customized Order #####" + menuCategories );
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            addCustomizedItemInCart( mobileUser, breadSize,customized, customizedItemDetails );
            placeFavouriteOrderAndAssert( mobileUser, menuCategories, store, customizedItemDetails);
            Logz.step( "##### Ended placing Customized Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage() );
        }
        return HomePage.get( (AndroidDriver) driver );
    }

    public HomePage placeRandomOrderMyLoyalty(int certRedeemCount) throws Exception {
        try {
            customized = false;
            Logz.step( "##### Started placing Random Order #####" );
            selectRandomItem();
            placeLoyaltyOrderAndAssert(certRedeemCount);
            Logz.step( "##### Ended placing Random Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Random Order:\n" + ex.getMessage() );
        }
        return HomePage.get( (AndroidDriver) driver );

    }

    public HomePage editRandomOrder() throws Exception {
        try {
            Logz.step( "##### Started placing Random Order #####" );
            selectRandomItem();
            getEdit().click();

            Logz.step( "##### Ended placing Random Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Random Order:\n" + ex.getMessage() );
        }
        return HomePage.get( (AndroidDriver) driver );

    }

    public HomePage placeSpecificOrderRedeemOffers(MobileUser mobileUser, String menuCategories, BreadSize breadSize, int certRedeemCount) throws Exception {
        try {
            OffersPage offersPage = goToOfferPage();
            OfferDetails offerDetails = offersPage.getOfferItemDetails( mobileUser );
            CustomizedItem customizedItemDetails = MobileApi.getCustomizedItemDetails( mobileUser, menuCategories, breadSize );
            Logz.step( "##### Started placing Random Order #####" );
            for (int i = 0; i < Integer.parseInt( offerDetails.getItemCount() ); i++) {
                selectSpecificItem( mobileUser, offerDetails.getMenuName(), offerDetails.getProductName(), offersPage.getOfferedBreadSize( offerDetails ), customizedItemDetails );
                //click on view item in your orderpage
            }
            //click on add to bag icon
            placeLoyaltyOrderAndAssert(certRedeemCount);
            Logz.step( "##### Ended placing Random Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Random Order:\n" + ex.getMessage() );
        }
        return HomePage.get( (AppiumDriver) driver );

    }

    private void assertOrderDetails(MobileUser mobileUser, YourOrderPage yourOrderPage, CustomizedItem customizedItem, boolean customized) throws Exception {
       String expectedTotal =  yourOrderPage.getTotalPrice();
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertOrderDetailsInYourOrderPage( customizedItem , customized).goToOrderConfirmationPage();
        HomePage homePage = orderConfirmationPage.assertOrderDetailsInOrderConfirmationPage( customizedItem , expectedTotal, customized);
       // homePage.validateTokens(mobileUser);
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage( mobileUser , customizedItem, expectedTotal);

    }

    private void assertOrderDetailsforTax(MobileUser mobileUser, YourOrderPage yourOrderPage,String Productname,boolean isDineIn,boolean isMakeitameal,boolean Mealwithcoffe,double Productprice) throws Exception {

        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertOrderDetailsInYourOrderPagefortax(Productname,isDineIn,isMakeitameal,Mealwithcoffe,Productprice).goToOrderConfirmationPage();
        HomePage homePage = orderConfirmationPage.assertOrderDetailsInOrderConfirmationPageforTax(Productname,Productprice);
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        // homePage.validateTokens(mobileUser);
        //purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage(  mobileUser ,customizedItem);

    }

    private void assertEditOrderDetails(MobileUser mobileUser, YourOrderPage yourOrderPage, CustomizedItem customizedItem, boolean customized) throws Exception {
        String expectedTotal =  yourOrderPage.getTotalPrice();
        assertProduct(editAndAssertAnOrder1(customizedItem),getSubItemInfo());
        //placeAnOrder();
        selectBackButton();
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertEditOrderDetailsInYourOrderPage(customizedItem ).goToOrderConfirmationPage();
        HomePage homePage = orderConfirmationPage.assertOrderDetailsInOrderConfirmationPage( customizedItem , expectedTotal, customized);
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        //homePage.validateTokens(mobileUser);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage( mobileUser , customizedItem, expectedTotal);

    }

    private void assertEditInOrderDetails(MobileUser mobileUser, YourOrderPage yourOrderPage, CustomizedItem customizedItem) throws Exception {
        String expectedTotal =  yourOrderPage.getTotalPrice();
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertEditOrderDetailsInYourOrderPage(customizedItem ).goToOrderConfirmationPage();
        HomePage homePage = orderConfirmationPage.assertOrderDetailsInOrderConfirmationPage( customizedItem, expectedTotal, customized );
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        homePage.validateTokens(mobileUser);
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage( mobileUser);

    }

    private void assertSidesDrinksOrderDetails(MobileUser mobileUser, YourOrderPage yourOrderPage, CustomizedItem customizedItem) throws Exception {
        String expectedTotal = "$" +  yourOrderPage.getTotalPrice();
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertSidesDrinksOrderDetailsInYourOrderPage( customizedItem ).goToOrderConfirmationPage();
        HomePage homePage = orderConfirmationPage.assertSidesDrinksOrderDetailsInOrderConfirmationPage( customizedItem , expectedTotal);
       // homePage.validateTokens(mobileUser);
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertSidesDrinksDetailsInPurchaseHistoryPage(customizedItem, expectedTotal);

    }
    private void assertFavouriteOrderDetails(MobileUser mobileUser, YourOrderPage yourOrderPage,CustomizedItem customizedItem) throws Exception {
        String expectedTotal =  yourOrderPage.getTotalPrice();
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertOrderDetailsInYourOrderPage( customizedItem, false ).goToOrderConfirmationPage();
        nameFavoriteItemAndClick();
        //Need to assert favoriteorder details through favopurite Object.
        HomePage homePage = orderConfirmationPage.assertFavouriteOrderDetailsInOrderConfirmationPage( mobileUser );
        FavouritePage favouritePage=homePage.goToFavouritePage();
        favouritePage.assertFavourites(mobileUser);
        PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage( mobileUser, customizedItem , expectedTotal);

    }
    private void placeSidesDrinksOrderAndAssert(MobileUser mobileUser, YourOrderPage yourOrderPage,  CustomizedItem customizedItem) throws Exception {
        assertSidesDrinksOrderDetails( mobileUser, yourOrderPage, customizedItem );

    }

    private void placeOrderAndAssert(MobileUser mobileUser, String menuCategories, Store store, CustomizedItem customizedItem) throws Exception {
        YourOrderPage yourOrderPage = goToYourOrderPage( customized );
        if (menuCategories.contains( "Breakfast" )) {
           boolean time = Utils.getTime( store );
            if (!time) {
                assertBreakfastUnavailablePopUp( customizedItem, store );
            } else {
                assertOrderDetails( mobileUser, yourOrderPage, customizedItem, customized );
            }
        } else {
            assertOrderDetails( mobileUser, yourOrderPage, customizedItem, customized);
        }

    }

    private void editOrderAndAssert(MobileUser mobileUser, String menuCategories, Store store, CustomizedItem customizedItem) throws Exception {
        YourOrderPage yourOrderPage = goToYourOrderPage( customized );
        if (menuCategories.contains( "Breakfast" )) {
            boolean time = Utils.getTime( store );
            if (!time) {
                assertBreakfastUnavailablePopUp( customizedItem, store );
            } else {
                assertOrderDetails( mobileUser, yourOrderPage, customizedItem ,customized);
            }
        } else {
            assertEditOrderDetails(mobileUser, yourOrderPage, customizedItem, customized);
        }

    }

    private void placeOrderAndAssertforTax(MobileUser mobileUser,String Productname, double Productprice,boolean isDineIn, boolean isMakeitameal,boolean Mealwithcoffe) throws Exception {
        YourOrderPage yourOrderPage = goToYourOrderPage( customized );

        assertOrderDetailsforTax( mobileUser, yourOrderPage,Productname,isDineIn,isMakeitameal,Mealwithcoffe,Productprice );
    }


    private void placeFavouriteOrderAndAssert(MobileUser mobileUser, String menuCategories, Store store,CustomizedItem customizedItem) throws Exception {
        YourOrderPage yourOrderPage = goToYourOrderPage(customized);

        if (menuCategories.contains( "Breakfast" )) {
            boolean time = Utils.getTime( store );
            if (!time) {
                assertBreakfastUnavailablePopUp( customizedItem, store );
            } else {
                assertFavouriteOrderDetails( mobileUser, yourOrderPage,customizedItem );
            }
        } else {
            assertFavouriteOrderDetails( mobileUser, yourOrderPage,customizedItem);
        }

    }

    public void nameFavoriteItemAndClick() throws Exception{
        elements.scrollToElement(null, FavouriteIconLocator, 0.9, 0.5);
        getFavouriteIcon().click();
        favoriteOrderName = "Subway" + random.nextInt( 10 );
        getFavouriteText().setText( favoriteOrderName );
        getFavouriteSave().click();
        getpopupGotIt().click();
        getGotIt().click();
    }

    public HomePage goToHomePage() throws Exception {
        Logz.step( "going to home page..." );
        return HomePage.get( (AppiumDriver) driver );

    }

    private CustomizePage goToCustomizePage() throws Exception {
        getCustomize().click();
        return CustomizePage.get( (AppiumDriver) driver );
    }

    private YourOrderPage goToYourOrderPage(boolean customized) throws Exception {
        Thread.sleep( 10000 );
        if (customized) {
            getAddBag().click();
        } else {
            getAddToBag().click();
        }
        return YourOrderPage.get( (AppiumDriver) driver );
    }



    private SidesPage goToSidesPage(String menuName) throws Exception {
        selectSpecificMenu(menuName);
        return SidesPage.get( (AppiumDriver) driver );
    }

    private DrinksPage goToDrinkPage(String menuName) throws Exception {
        selectSpecificMenu(menuName);
        return DrinksPage.get( (AppiumDriver) driver );
    }

    private OffersPage goToOfferPage() throws Exception {

        return OffersPage.get( (AppiumDriver) driver );
    }

    public void addDefaultItemInCart(MobileUser mobileUser, BreadSize breadSize, CustomizedItem customizedItemDetails) throws Exception {
        String productName = selectMenuGetProductName( customizedItemDetails, breadSize );
        selectSpecificProduct( mobileUser, productName, breadSize, false, customizedItemDetails );
    }

    public void addDefaultItemInCartForTax(MobileUser mobileUser, String smenu, String sItemName) throws Exception {
        selectMenuforTax( smenu );
        String splitProdname = selectMenuGetProductNameForTax(sItemName);
        selectSpecificProductfortax( mobileUser, splitProdname,sItemName);
    }



    public YourOrderPage  addDefaultSidesDrinksItemInCart(String menuName, CustomizedItem customizedItem) throws Exception {
        if (menuName.contains( "Sides" )) {
            SidesPage sidesPage = goToSidesPage(menuName);
             sidesPage.selectSidesOrder(customizedItem );
        } else {
            DrinksPage drinksPage = goToDrinkPage(menuName);
           drinksPage.selectDrinksOrder(customizedItem );
        }

       return YourOrderPage.get( (AppiumDriver)driver );
    }

    private String getProductName(String menuName, String productName) throws Exception {
        Logz.step( "Product Name is: " + productName );

        if (menuName.contains( "Chopped Salads" )) {
            if(productName.contains( "The" )){
                productName =  productName.substring( 4 );
            }
            return Utils.getConnectionString( productName, 0, "Chopped Salad" ).trim();
        } else if (menuName.contains( "Kids" )) {
            return Utils.getConnectionString( productName, 0, "Kids" ).trim();
        } else {

            if (productName.contains( "Sandwich" )) {
                productName = productName.replaceAll( "Sandwich", "" );
            }
            return productName.trim();
        }


    }

    public void selectMenuforTax(String Menuname) throws Exception {
        selectSpecificMenuscrolltax( Menuname );
    }

    public void addCustomizedItemInCart(MobileUser mobileUser,  BreadSize breadSize, CustomizedItem customizedItemDetails) throws Exception {
        String productName = selectMenuGetProductName( customizedItemDetails , breadSize);
        selectSpecificProduct( mobileUser, productName, breadSize, true, customizedItemDetails );
    }
    public void addCustomizedItemInCart(MobileUser mobileUser,  BreadSize breadSize,Boolean customize, CustomizedItem customizedItemDetails) throws Exception {
        String productName = selectMenuGetProductName( customizedItemDetails , breadSize);
        selectSpecificProduct( mobileUser, productName, breadSize, customize, customizedItemDetails );
    }

    public String selectMenuGetProductName(CustomizedItem customizedItem, BreadSize breadSize) throws Exception {
        selectSpecificMenu( customizedItem.getMenuName() );
        if(breadSize == BreadSize.NONE){
            return getProductName(  customizedItem.getMenuName() , customizedItem.getProductDetail().getName() );
        }else {
            return getProductName(  customizedItem.getMenuName() , customizedItem.getCustomizedProductDetail().getProductName() );
        }


    }

    public String selectMenuGetProductNameForTax(String sItemName) throws Exception {
        String ProdName[] = sItemName.split(" ",2);
        String splitProdname=ProdName[1];
        return splitProdname;
        //return getProductName(  customizedItem.getMenuName() , customizedItem.getCustomizedProductDetail().getProductName() );
    }


    private void assertBreakfastUnavailablePopUp(CustomizedItem customizedItem, Store store) throws Exception {
        String startTime = Utils.getBreakFastStartTimeRounded(store);
        String endTime = Utils.getBreakFastEndTimeRounded( store );
        String startEndTime = " "+startTime+" "+BaseTest.getStringfromBundleFile( "to" ) +" "+endTime+". ";
        Assert.assertEquals( getErrorTitle().getText(), BaseTest.getStringfromBundleFile( "BreakfastAlertTitle" ) );
        Assert.assertEquals( getErrorMessage().getText(), BaseTest.getStringfromBundleFile( "BreakfastAlertMsg1" )+ startEndTime + BaseTest.getStringfromBundleFile( "BreakfastAlertMsg2" ) );
        getErrorOk().click();
    }

    public YourOrderPage selectRandomItem() throws Exception {
        try {
            Logz.step( "##### Started placing Random Order #####" );
            //Get Menu Categories - click random menuCategories
            selectRandomMenu();
            //Get Product Details - click random Product
            selectRandomProduct( BreadSize.NONE );
            /*//Click Add to bag
            getAddToBag().click();*/
            Logz.step( "##### Ended placing Random Order #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to place Random Order:\n" + ex.getMessage() );
        }
        return YourOrderPage.get( (AppiumDriver) driver );

    }

    private void selectRandomMenu() throws Exception {
        try {
            Logz.step( "##### Selecting a random menu #####" );
            elements.scrollAndClick( getProductGroupLayoutIOS, getProductGroupLayoutAndroid, Utils.getRandomMenuName() );
            Logz.step( "##### Selected a random menu #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select Random menu\n" + ex.getMessage() );
        }


    }

    private void selectRandomProduct(BreadSize breadSize) throws Exception {
        try {
            Logz.step( "##### Selecting a random product #####" );
            List<WebElement> ProductList = elements.getElements( getProductGroupHeader(" ") );//product_list
            int getProductCount = ProductList.size();
            getProductCount = Utils.selectRandomItem( getProductCount );
            ProductList.get( getProductCount ).click();
            Logz.step( "##### Selected a random product #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select Random Product\n" + ex.getMessage() );
        }


    }


    private void selectSpecificItem(MobileUser mobileUser, String menuName, String productName, BreadSize breadSize, CustomizedItem customizedItem) throws Exception {
        Logz.step( "##### Started placing Default Order #####" );
        //Get Menu Categories - click random menuCategories
        selectSpecificMenu( menuName );
        //Get Product Details - click random Product
        selectSpecificProduct( mobileUser, productName, breadSize, false, customizedItem );
        getAddToBag().click();

    }

    private void selectSpecificMenu(String itemName) throws Exception {
        try {
            Logz.step( "##### Selecting a " + itemName + " menu #####" );
            elements.scrollAndClick( getProductGroupHeader(itemName), itemName, true );
            Logz.step( "##### Selected a " + itemName + " menu #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select " + itemName + " menu\n" + ex.getMessage() );
        }


    }

    private void selectSpecificMenuscrolltax(String Menuname) throws Exception {
        try {
            Logz.step( "##### Selecting a " + Menuname + " menu #####" );
            elements.scrollAndClicktax( productGroupHeaderIOS, productGroupHeaderAndroid, Menuname );
            Logz.step( "##### Selected a " + Menuname + " menu #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select " + Menuname + " menu\n" + ex.getMessage() );
        }


    }


    private void selectSpecificProduct(MobileUser mobileUser, String productName, BreadSize breadSize, boolean customized, CustomizedItem customizedItem ) throws Exception {
        try {
            Logz.step( "##### Selecting: " + productName + " #####" );
            ProductDetailsPage productDetailsPage;
            if(customizedItem.getMenuName().contains( BaseTest.getStringfromBundleFile( "Breakfast" ) )){
                productDetailsPage = goToBreakfastProductDetailsPage( productName );
            }else{

                productDetailsPage = goToProductDetailsPage( productName );
            }


            if (!(customizedItem.getCustomizedProductDetail().getBreadSize().contains( "FOOTLONG™" ) || breadSize.toString().contains( "none" ))) {
                if (MobileApi.getBreadOptionCount( customizedItem, mobileUser ) > 1) {
                    getSixInchOption().click();
                }
            }
            productDetailsPage.assertProductNameInProductDetailsPage( customizedItem );

            if (customized) {
                CustomizePage customizePage = productDetailsPage.goToCustomizePage();
                customizePage.randomCustomization( customizedItem, specificPickerSelection );
            }
            Logz.step( "##### Selected: " + productName + " #####" );
        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + productName + "\n" + ex.getMessage() );
        }

    }

    private void selectSpecificProductfortax(MobileUser mobileUser, String productName,String fullProductname) throws Exception {
        try {
            Logz.step( "##### Selecting: " + productName + " #####" );
            //ProductDetailsPage productDetailsPage;
            goToProductDetailsPage( productName );
            if (!(fullProductname.contains( "12" ))) {
                getSixInchOption().click();
            }

        } catch (Exception ex) {
            throw new Exception( "Unable to select: " + productName + "\n" + ex.getMessage() );
        }

    }

    private ProductDetailsPage goToProductDetailsPage(String productName) throws Exception {
        elements.scrollAndClick( getProductGroupHeader(productName), productName, true );
        return ProductDetailsPage.get( (AppiumDriver) driver );
    }

    private ProductDetailsPage goToBreakfastProductDetailsPage(String productName) throws Exception {
        elements.scrollAndClickBreakfast( getProductGroupHeader(productName), productName );
        return ProductDetailsPage.get( (AppiumDriver) driver );
    }
    private void placeLoyaltyOrderAndAssert(int certRedeemCount) throws Exception {
        YourOrderPage yourOrderPage = goToYourOrderPage( customized );
        OrderConfirmationPage orderConfirmationPage = yourOrderPage.assertLoyaltyDisplay(certRedeemCount);
        orderConfirmationPage.assertLoyaltyDisplay();
        /*PurchaseHistoryPage purchaseHistoryPage = homePage.goToPurchaseHistoryPage();
        purchaseHistoryPage.assertPlacedOrderDetailsInPurchaseHistoryPage( mobileUser );*/
    }

    public String getRewardsTxt() throws Exception{
        return getRewardsAmt().getText();
    }
    public ProductDetailsPage selectProductThenGoToProductDetailsPage(MobileUser mobileUser, String menuCategories, BreadSize breadSize, CustomizedItem customizedItemDetails) throws Exception {
        try {
            customized = false;
            Logz.step("##### Started placing Default Order #####" + menuCategories);

            String productName = selectMenuGetProductName( customizedItemDetails , breadSize);
            goToProductDetailsPage( productName );
            if (!(customizedItemDetails.getCustomizedProductDetail().getBreadSize().contains( "FOOTLONG™" ) || breadSize.toString().contains( "none" ))) {
                if (MobileApi.getBreadOptionCount( customizedItemDetails, mobileUser ) > 1) {
                    getSixInchOption().click();
                }
            }
        } catch (Exception ex) {
            throw new Exception("Unable to place Default Order: " + menuCategories + "\n" + ex.getMessage());
        }
        return ProductDetailsPage.get((AppiumDriver) driver);

    }
}
