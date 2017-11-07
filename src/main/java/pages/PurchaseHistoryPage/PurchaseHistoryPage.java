package pages.PurchaseHistoryPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileWebElement;
import base.test.BaseTest;
import com.amazonaws.services.opsworks.model.App;
import enums.Country;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonElements.CommonElements;
import pojos.CartItemList;
import pojos.PurchaseHistoryDetails;
import pojos.PaymentDetails;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.OrderData;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import pojos.RemoteOrder;
import pojos.user.RemoteOrderCustomer;
import util.Utils;
import utils.Logz;

import java.util.*;

public abstract class PurchaseHistoryPage<T extends AppiumDriver> extends MobileBasePage {
    public PurchaseHistoryPage(AppiumDriver driver) {
        super(driver);
    }

    CommonElements commonElements = new CommonElements((AppiumDriver)driver);
    String actualTotal;
    String expectedTotal;
    String currencySymbol_US = "$";
    String currencySymbol_CAN = "£";
    String orderNumber;
    String dateTime;

   //payment_method earned_tokens_text
    abstract MobileButton getPaymentMethod() throws Exception;
    abstract MobileButton getEarnedTokensText() throws Exception;
    abstract List<WebElement> getOrderList() throws Exception;
    abstract List<WebElement> getOrderNumberList() throws Exception;
    abstract List<WebElement> getOrderTimeAddressList() throws Exception;
    abstract List<WebElement> getProductTitleList() throws Exception;
    abstract List<WebElement> getProductDescriptionList() throws Exception;
    abstract List<WebElement> getOrderTotalList() throws Exception;
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PurchaseHistoryPage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new PurchaseHistoryPageIOS((IOSDriver) driver);
            case "Android":
                return new PurchaseHistoryPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get PurchaseHistoryPage for platform " + platform);
        }
    }


//    public static MenuPage get(AppiumDriver driver) throws Exception{
//
//        String platform = SubwayAppBaseTest.platformName;
//
//        switch (platform){
//            case "iOS":
//                return new MenuPageIOS((IOSDriver) driver);
//            case "Android":
//                return new MenuPageAndroid((AndroidDriver) driver);
//            default:
//                throw new Exception("Unable to get Find A Store page for platform " + platform);
//        }
//    }

    public void assertPlacedOrderDetailsInPurchaseHistoryPage(RemoteOrderCustomer mobileUser) throws Exception {
        try {

            List<PurchaseHistoryDetails> expectedOrderHistoryList = getExpectedPurchaseHistoryList(mobileUser);
            List<PurchaseHistoryDetails> actualOrderHistoryList = getActualPurchaseHistoryList();
            Logz.step("!!!!! Started asserting placed order details in Purchase History Page !!!!!");
            Assert.assertEquals(actualOrderHistoryList, expectedOrderHistoryList);
            Logz.step("!!!!! Ended asserting placed order details in Purchase History Page !!!!!");

        } catch (Exception ex) {
            throw new Exception(("Failed to assert placed order details in Purchase History Page\n" + ex.getMessage()));
        }

    }

    public List<PurchaseHistoryDetails> getActualPurchaseHistoryList() throws Exception {
        try {
            Logz.step("##### Started getting actual purchase details in Purchase History Page #####");
            List<PurchaseHistoryDetails> orderHistoryList = new ArrayList<>();
         //   int webElementCount = commonElements.getElementListCount(By.id(""), By.id("order_header"), (AppiumDriver) driver);
            int webElementCount = getOrderList().size();
            for (int i = 0; i < webElementCount; i++) {
               // List<WebElement> getOrderHistoryList = commonElements.getElements(By.id(""), By.id("order_time_address"));
                List<WebElement> getOrderHistoryList =getOrderTimeAddressList();
                getOrderHistoryList.get(i).click();
                orderHistoryList.add(getActualPurchaseHistory(i));
            }
            Logz.step("##### Ended getting actual purchase details in Purchase History Page #####");

            return orderHistoryList;

        } catch (Exception ex) {
            throw new Exception(("Failed to get actual purchase details in Purchase History Page\n" + ex.getMessage()));


        }
    }


    private PurchaseHistoryDetails getActualPurchaseHistory(int index) throws Exception {
        try {
            Logz.step("##### Started setting actual purchase details in Purchase History Page #####");
            PurchaseHistoryDetails purchaseHistoryDetails = new PurchaseHistoryDetails();
          //  List<WebElement> getOrderNumbers = commonElements.getElements(By.id(""), By.xpath("//android.widget.TextView[contains(@text,'Order')]"));
            List<WebElement> getOrderNumbers = getOrderNumberList();
            String orderNumber = getOrderNumbers.get(index).getText();
            Logz.step("Order number: "+orderNumber);
          //  List<WebElement> getOrderTimeAddress = commonElements.getElements(By.id(""), By.id("order_time_address"));
            List<WebElement> getOrderTimeAddress = getOrderTimeAddressList();
            String orderTimeAddress = getOrderTimeAddress.get(index).getText();
            String[] split = orderTimeAddress.split("\n");
            purchaseHistoryDetails.setPickupDateTime(split[0]);
            purchaseHistoryDetails.setStoreAddress(split[1]);
            purchaseHistoryDetails.setOrderNumber(orderNumber);
            purchaseHistoryDetails.setCartItemList(getActualCartItemList(index));
            purchaseHistoryDetails.setPaymentDetails(getActualPaymentDetails(index));
            purchaseHistoryDetails.setTotal(actualTotal);
            Logz.step("##### Ended setting actual purchase details in Purchase History Page #####");
            return purchaseHistoryDetails;
        } catch (Exception ex) {
            throw new Exception(("Failed to set actual purchase details in Purchase History Page\n" + ex.getMessage()));
        }
    }

//    private PurchaseHistoryDetails getActualPurchaseHistory(int index) throws Exception {
//        try {
//            Logz.step("##### Started setting actual purchase details in Purchase History Page #####");
//            PurchaseHistoryDetails purchaseHistoryDetails = new PurchaseHistoryDetails();
//            orderNumber = commonElements.getElementTextByClassName("", "android.widget.TextView", (AppiumDriver) driver, 1);
//            List<WebElement> getOrderTimeAddress = commonElements.getElements(By.id(""), By.id("order_time_address"));
//            String orderTimeAddress = getOrderTimeAddress.get(index).getText();
//            String[] split = orderTimeAddress.split("\n");
//            purchaseHistoryDetails.setPickupDateTime(split[0]);
//            purchaseHistoryDetails.setStoreAddress(split[1]);
//            purchaseHistoryDetails.setOrderNumber(orderNumber);
//            purchaseHistoryDetails.setCartItemList(getActualCartItemList());
//            purchaseHistoryDetails.setPaymentDetails(getActualPaymentDetails());
//            purchaseHistoryDetails.setTotal(actualTotal);
//            Logz.step("##### Ended setting actual purchase details in Purchase History Page #####");
//            return purchaseHistoryDetails;
//        } catch (Exception ex) {
//            throw new Exception(("Failed to set actual purchase details in Purchase History Page\n" + ex.getMessage()));
//        }
//    }

//    private List<CartItemList> getActualCartItemList() throws Exception {
//        try {
//            Logz.step("##### Started setting actual cart item list in Purchase History Page #####");
//            List<CartItemList> cartItemList = new ArrayList<>();
//            assertReceiptHeaderText();
//            //assert item receipt icon - item_receipt
//            int webElementCount = commonElements.getElementListCount(By.id(""), By.id("product_title"), (AppiumDriver)driver);
//            for (int i = 0; i < webElementCount; i++) {
//                CartItemList cart = new CartItemList();
//                List<WebElement> getProductTitle = commonElements.getElements(By.id(""), By.id("product_title"));
//                cart.setItemName(getProductTitle.get(i).getText());
//                List<WebElement> getProductDescription = commonElements.getElements(By.id(""), By.id("product_description"));
//                cart.setIngredients(getProductDescription.get(i).getText());
//                cartItemList.add(cart);
//            }
//            ComparatorByIteName comparatorByIteName = new ComparatorByIteName();
//            cartItemList = comparatorByIteName.getSortItemName(cartItemList);
//            Logz.step("##### Ended setting actual cart item list in Purchase History Page #####");
//            return cartItemList;
//        } catch (Exception ex) {
//            throw new Exception(("Failed to get actual cart item list in Purchase History Page\n" + ex.getMessage()));
//        }
//    }


    private List<CartItemList> getActualCartItemList(int index) throws Exception {
        try {
            Logz.step("##### Started setting actual cart item list in Purchase History Page #####");
            List<CartItemList> cartItemList = new ArrayList<>();
            assertReceiptHeaderText();
                CartItemList cart = new CartItemList();
               // List<WebElement> getProductTitle = commonElements.getElements(By.id(""), By.id("product_title"));
                List<WebElement> getProductTitle = getProductTitleList();
                cart.setItemName(getProductTitle.get(index).getText());
                //List<WebElement> getProductDescription = commonElements.getElements(By.id(""), By.id("product_description"));
                List<WebElement> getProductDescription = getProductDescriptionList();
                cart.setIngredients(getProductDescription.get(index).getText());
                cartItemList.add(cart);
            ComparatorByIteName comparatorByIteName = new ComparatorByIteName();
            cartItemList = comparatorByIteName.getSortItemName(cartItemList);
            Logz.step("##### Ended setting actual cart item list in Purchase History Page #####");
            return cartItemList;
        } catch (Exception ex) {
            throw new Exception(("Failed to get actual cart item list in Purchase History Page\n" + ex.getMessage()));
        }
    }

//    private List<PaymentDetails> getActualPaymentDetails() throws Exception {
//        try {
//            Logz.step("##### Started setting actual payment details in Purchase History Page #####");
//            List<PaymentDetails> paymentDetails = new ArrayList<>();
//            //assert dollar symble icon is present --coin_icon
//            assertEarnedTokensText();
//            assesrtPaymentRewardsHeaderText();
//            //break down of order_total
//            int paymentDetailList = commonElements.getElements(By.id(""), By.id("order_total")).size();
//            for (int i = 0; i < paymentDetailList; i++) {
//                PaymentDetails payment = new PaymentDetails();
//                List<WebElement> getCardType = commonElements.getElements(By.id(""), By.id("order_total"));
//                String orderTotal = getCardType.get(i).getText();
//                payment.setCardType(Utils.getConnectionString(orderTotal, "paid with ", " ending "));
//                actualTotal = Utils.getConnectionString(orderTotal, 0, " paid with ");
//                payment.setAmount(actualTotal);
//                payment.setCardEndingNumber(Utils.getConnectionString(orderTotal, "ending in "));
//                paymentDetails.add(payment);
//            }
//            Logz.step("##### Ended setting actual payment details in Purchase History Page #####");
//            return paymentDetails;
//        } catch (Exception ex) {
//            throw new Exception(("Failed to set actual payment details in Purchase History Page\n" + ex.getMessage()));
//        }
//    }


    private List<PaymentDetails> getActualPaymentDetails(int index) throws Exception {
        try {
            Logz.step("##### Started setting actual payment details in Purchase History Page #####");
            List<PaymentDetails> paymentDetails = new ArrayList<>();
            //assert dollar symble icon is present --coin_icon
            assertEarnedTokensText();
            assesrtPaymentRewardsHeaderText();
            //break down of order_total
         //   WebElement getCardType = (WebElement) commonElements.getElements(By.id(""), By.id("order_total")).get(index);
                WebElement getCardType = getOrderTotalList().get(index);
                PaymentDetails payment = new PaymentDetails();
                String orderTotal = getCardType.getText();
                payment.setCardType(Utils.getConnectionString(orderTotal, "paid with ", " ending "));
                actualTotal = Utils.getConnectionString(orderTotal, 0, " paid with ");
                payment.setAmount(actualTotal);
                payment.setCardEndingNumber(Utils.getConnectionString(orderTotal, "ending in "));
                paymentDetails.add(payment);
            Logz.step("##### Ended setting actual payment details in Purchase History Page #####");
            return paymentDetails;
        } catch (Exception ex) {
            throw new Exception(("Failed to set actual payment details in Purchase History Page\n" + ex.getMessage()));
        }
    }

    public List<PurchaseHistoryDetails> getExpectedPurchaseHistoryList(RemoteOrderCustomer remoteOrderCustomer) throws Exception {
        try {
            Logz.step("##### Started getting expected purchase details in Purchase History Page #####");
            List<PurchaseHistoryDetails> historyDetailsList = new ArrayList<>();
            RemoteOrder remoteOrder = new RemoteOrder(remoteOrderCustomer);
            OrderHistoryResponse order = remoteOrder.orderHistory(remoteOrderCustomer);
            OrderHistory[] results = order.getResults();
            for (OrderHistory result : results) {
                historyDetailsList.add(getExpectedPurchaseHistory(remoteOrderCustomer, result));
            }
            Logz.step("##### Ended getting expected purchase details in Purchase History Page #####");
            return historyDetailsList;

        } catch (Exception ex) {
            throw new Exception(("Failed to get expected purchase details from api\n" + ex.getMessage()));


        }
    }

    private PurchaseHistoryDetails getExpectedPurchaseHistory(RemoteOrderCustomer mobileUser, OrderHistory result) throws Exception {
        try {
            Logz.step("##### Started setting expected purchase details from api #####");
            PurchaseHistoryDetails purchaseHistoryDetails = null;
            OrderDetailsResponse orderDetailsResponse = OrderData.orderDetailsAfterPayment(mobileUser, String.valueOf(result.getCartID()));
            CartSummary[] cartSummaryResults = orderDetailsResponse.getResults();
            for (CartSummary cartSummaryResult : cartSummaryResults) {
                expectedTotal = cartSummaryResult.getTotal();
                purchaseHistoryDetails = new PurchaseHistoryDetails();
                dateTime = Utils.formatDateTime(cartSummaryResult.getPickupDate(), "yyyy-MM-dd hh:mm:ss a", "MMMM dd, yyyy | hh:mma");
                if (dateTime.contains("PM")) {
                    dateTime = dateTime.replace("PM", "pm");
                } else {
                    dateTime = dateTime.replace("AM", "am");
                }
                purchaseHistoryDetails.setPickupDateTime(dateTime);//Utils.formatDateTime(cartSummaryResult.getPickupDate(), "yyyy-MM-dd hh:mm:ss a", "MMMM d, yyyy | h:m:a"),
                purchaseHistoryDetails.setOrderNumber("Order " + cartSummaryResult.getOrderNumber());
                purchaseHistoryDetails.setStoreAddress(cartSummaryResult.getStoreAddress());
                purchaseHistoryDetails.setCartItemList(getExpectedCartItemList(cartSummaryResult));
                purchaseHistoryDetails.setPaymentDetails(getExpectedPaymentDetails(cartSummaryResult, mobileUser));
                purchaseHistoryDetails.setTotal(expectedTotal);

            }
            Logz.step("##### Ended setting expected purchase details from api #####");
            return purchaseHistoryDetails;

        } catch (Exception ex) {
            throw new Exception(("Failed to set expected purchase details from api\n" + ex.getMessage()));


        }
    }

    private List<CartItemList> getExpectedCartItemList(CartSummary cartSummaryResult) throws Exception {
        try {
            Logz.step("##### Started setting expected cart item list from API #####");
            List<CartItemList> cartItemList = new ArrayList<>();
            CartSummary.CartItem[] cartItems = cartSummaryResult.getItems();  //cartSummaryResult.getCartItems();
            for (CartSummary.CartItem cartItem : cartItems) {
                CartSummary.Option[] options = cartItem.getOptions();
                CartItemList cart = new CartItemList(Utils.convert12inchToFootLong(cartItem.getName()), getOptions(options), cartItem.getIsFavorite());
                cartItemList.add(cart);
            }
            ComparatorByIteName comparatorByIteName = new ComparatorByIteName();
            cartItemList = comparatorByIteName.getSortItemName(cartItemList);
            Logz.step("##### Ended setting expected cart item list from API #####");
            return cartItemList;

        } catch (Exception ex) {
            throw new Exception(("Failed to get expected cart item list from API\n" + ex.getMessage()));
        }
    }

    private List<PaymentDetails> getExpectedPaymentDetails(CartSummary cartSummaryResult, RemoteOrderCustomer mobileUser) throws Exception {
        try {
            Logz.step("##### Started setting expected payment details from API #####");
            List<PaymentDetails> paymentDetails = new ArrayList<>();
            CartSummary.PaymentMethods[] paymentMethods = cartSummaryResult.getPaymentMethods();
            for (CartSummary.PaymentMethods paymentMethod : paymentMethods) {
                PaymentDetails payment = new PaymentDetails();
                payment.setCardType("paid with " + paymentMethod.getPaymentType());
                payment.setCardEndingNumber("ending in " + paymentMethod.getDescription());
                if (mobileUser.getCountry().contains(Country.UnitedStates.toString())) {
                    expectedTotal = currencySymbol_US + expectedTotal;
                } else {
                    expectedTotal = currencySymbol_CAN + expectedTotal;
                }
                payment.setAmount(expectedTotal);
                paymentDetails.add(payment);
            }
            Logz.step("##### Ended setting expected payment details from API #####");
            return paymentDetails;
        } catch (Exception ex) {
            throw new Exception(("Failed to set expected payment details from API\n" + ex.getMessage()));
        }
    }

    private String getOptions(CartSummary.Option[] options) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            for (CartSummary.Option option : options) {
                sb.append(option.getName() + ", ");

            }
            String ingredients = sb.toString();
            return ingredients.substring(0, ingredients.length() - 2);
        } catch (Exception ex) {
            throw new Exception(("Failed to get options from API\n" + ex.getMessage()));
        }
    }
    private void assesrtPaymentRewardsHeaderText() throws Exception{
        String actualPaymentRewardsHeaderText = getPaymentMethod().getText();//payment_method
        String expectedPaymentRewardsHeaderText = BaseTest.getStringfromBundleFile("PaymentRewardsHeaderText");
        Assert.assertEquals(actualPaymentRewardsHeaderText, expectedPaymentRewardsHeaderText);
    }
    private void assertReceiptHeaderText() throws Exception{
        String actualReceiptHeaderText = commonElements.getElementTextByClassName("", "android.widget.TextView", (AppiumDriver) driver, 5);

        if(actualReceiptHeaderText.contains("Earned MyWay tokens")) {
            actualReceiptHeaderText = commonElements.getElementTextByClassName("", "android.widget.TextView", (AppiumDriver) driver, 6);

        }
        String expectedReceiptHeaderText = BaseTest.getStringfromBundleFile("ReceiptHeaderText");
        Assert.assertEquals(actualReceiptHeaderText, expectedReceiptHeaderText);
    }

    private void assertEarnedTokensText() throws Exception{
        String receiptHeaderText = commonElements.getElementTextByClassName("", "android.widget.TextView", (AppiumDriver) driver, 5);
        if(receiptHeaderText.contains("Earned MyWay tokens")) {
            String  actualEarnedTokensText = getEarnedTokensText().getText();
            String expectedEarnedTokensText = BaseTest.getStringfromBundleFile("EarnedTokensText");
            Assert.assertEquals(actualEarnedTokensText, expectedEarnedTokensText);
        }else {
            Logz.step("##### Not Earned MyWay tokens #####");
        }

    }

  public static class ComparatorByIteName implements Comparator<CartItemList> {
        List<CartItemList> sortItemName = new ArrayList<CartItemList>();

        //@Override
        public int compare(CartItemList o1, CartItemList o2) {
            return o1.getItemName().compareTo(o2.getItemName());
        }

        public void loadListFavoriteName(List<CartItemList> list) {
            Collections.sort(list, new ComparatorByIteName());
            sortItemName.addAll(list);
        }

        public List<CartItemList> getSortItemName(List<CartItemList> list) {
            loadListFavoriteName(list);
            return sortItemName;
        }
    }

}
