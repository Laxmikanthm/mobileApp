package pages.PurchaseHistoryPage;

import Base.SubwayAppBaseTest;
import pojos.CartItemList;
import pojos.OrderHistoryDetails;
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

import java.util.ArrayList;
import java.util.List;

public abstract class PurchaseHistoryPage <T extends AppiumDriver> extends MobileBasePage {
    public PurchaseHistoryPage(AppiumDriver driver) {
        super(driver);
    }

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
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void assertPlacedOrderDetailsInPurchaseHistoryPage(RemoteOrderCustomer mobileUser) throws Exception{
        try{

            List<OrderHistoryDetails> expectedOrderHistoryList =  getExpectedOrderHistoryList(mobileUser);
            List<OrderHistoryDetails> actualOrderHistoryList = new ArrayList<>();//getActualOrderHistoryList();

            for(int i=0;i<actualOrderHistoryList.size();i++) {
                Assert.assertEquals(actualOrderHistoryList.get(i), expectedOrderHistoryList.get(i) );
            }
            Logz.step("!!!!! Successfully complete assertion of order history!!!!!");

        }catch(Exception ex){
            Logz.step("Failed to verify order history\\n" + ex.getMessage());
            throw new Exception(("Failed to verify order history.\n" + ex.getMessage()));
        }

    }
    public List<OrderHistoryDetails> getExpectedOrderHistoryList(RemoteOrderCustomer remoteOrderCustomer) throws Exception {
        try {
            List<OrderHistoryDetails> orderHistoryList = new ArrayList<>();
            RemoteOrder remoteOrder = new RemoteOrder(remoteOrderCustomer);
            OrderHistoryResponse order = remoteOrder.orderHistory(remoteOrderCustomer);
            OrderHistory[] results = order.getResults();
            for (OrderHistory result : results) {

                orderHistoryList.add(getExpectedOrderHistory(remoteOrderCustomer, result));
            }


            return orderHistoryList;

        } catch (Exception ex) {
            Logz.step("Failed to get expected order history list from api.\\n" + ex.getMessage());
            throw new Exception(("Failed to get expected order history list from api.\n" + ex.getMessage()));


        }
    }
    private OrderHistoryDetails getExpectedOrderHistory(RemoteOrderCustomer remoteOrderCustomer, OrderHistory result) throws Exception {
        try {
            OrderHistoryDetails orderHistoryDetails = null;
            OrderDetailsResponse orderDetailsResponse = OrderData.orderDetailsAfterPayment(remoteOrderCustomer, String.valueOf(result.getCartID()));
            CartSummary[] cartSummaryResults = orderDetailsResponse.getResults();
            for (CartSummary cartSummaryResult : cartSummaryResults) {
                orderHistoryDetails = new OrderHistoryDetails
                        (cartSummaryResult.getPickupDate(),//Utils.formatDateTime(cartSummaryResult.getPickupDate(), "yyyy-MM-dd hh:mm:ss a", "MMMM d, yyyy | h:m:a"),
                                cartSummaryResult.getStoreAddress(),
                                "Order "+cartSummaryResult.getOrderNumber(),
                                getCartItemList(cartSummaryResult),
                                "$ "+cartSummaryResult.getTotal()+" Total",
                                getPaymentDetails(cartSummaryResult)
                        );
            }

            return orderHistoryDetails;

        } catch (Exception ex) {
            Logz.step("Failed to get expected order history from api.\\n" + ex.getMessage());
            throw new Exception(("Failed to get expected order history from api.\n" + ex.getMessage()));


        }
    }
    private List<CartItemList> getCartItemList(CartSummary cartSummaryResult) throws Exception {
        try {
            List<CartItemList> cartItemList = new ArrayList<>();
            CartSummary.CartItem[] cartItems = cartSummaryResult.getItems();  //cartSummaryResult.getCartItems();
            for (CartSummary.CartItem cartItem : cartItems) {
                CartSummary.Option[] options = cartItem.getOptions();
                CartItemList cart = new CartItemList(Utils.convert12inchToFootLong(cartItem.getName()), getOptions(options), cartItem.getIsFavorite());
                cartItemList.add(cart);
            }

            return cartItemList;

        } catch (Exception ex) {
            Logz.step("Failed to get cart item list.\\n" + ex.getMessage());
            throw new Exception(("Failed to get cart item list.\n" + ex.getMessage()));
        }
    }

    private List<PaymentDetails> getPaymentDetails(CartSummary cartSummaryResult) throws Exception {
        try {
            List<PaymentDetails> paymentDetails = new ArrayList<>();
            CartSummary.PaymentMethods[] paymentMethods = cartSummaryResult.getPaymentMethods();
            for (CartSummary.PaymentMethods paymentMethod : paymentMethods) {
                PaymentDetails payment = new PaymentDetails(paymentMethod.getPaymentType(), paymentMethod.getDescription());
                paymentDetails.add(payment);

            }

            return paymentDetails;

        } catch (Exception ex) {
            Logz.step("Failed to get payment details from api\\n" + ex.getMessage());
            throw new Exception(("Failed to get payement details from api.\n" + ex.getMessage()));
        }
    }
    private String getOptions(CartSummary.Option[] options) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            for (CartSummary.Option option : options) {
                sb.append(option.getName() + ",");

            }
            String ingredients = sb.toString().replaceAll(" ", "");
            return ingredients.substring(0, ingredients.length() - 1);
        } catch (Exception ex) {
            Logz.step("Failed to get options.\\n" + ex.getMessage());
            throw new Exception(("Failed to get options.\n" + ex.getMessage()));
        }
    }



}
