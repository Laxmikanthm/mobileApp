package pojos;

import utils.Logz;

import java.util.List;

public class PurchaseHistoryDetails {
    private String pickupDateTime;
    private String storeAddress;
    private String orderNumber;
    private List<CartItemList> cartItemList;
    private String total;
    private  List<PaymentDetails>  paymentDetails;

public PurchaseHistoryDetails(){}
    public PurchaseHistoryDetails(String pickupDateTime, String storeAddress, String orderNumber, List<CartItemList> cartItemList, String total, List<PaymentDetails> paymentDetails) {
        this.pickupDateTime = pickupDateTime;
        this.storeAddress = storeAddress;
        this.orderNumber = orderNumber;
        this.cartItemList = cartItemList;
        this.total = total;
        this.paymentDetails = paymentDetails;

    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<CartItemList> getCartItemList() { return cartItemList;}

    public void setCartItemList(List<CartItemList> cartItemList) {
        this.cartItemList = cartItemList;
    }


    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseHistoryDetails)) return false;

        PurchaseHistoryDetails that = (PurchaseHistoryDetails) o;

        if (getPickupDateTime() != null ? !getPickupDateTime().equals(that.getPickupDateTime()) : that.getPickupDateTime() != null){
            Logz.step("Pick up date expected: "+getPickupDateTime()+"But act: "+that.getPickupDateTime());
            return false;
        }
        if (getStoreAddress() != null ? !getStoreAddress().equals(that.getStoreAddress()) : that.getStoreAddress() != null){
            Logz.step("Strore address expected: "+getStoreAddress()+" But act: "+that.getStoreAddress());
            return false;
        }
        if (getOrderNumber() != null ? !getOrderNumber().equals(that.getOrderNumber()) : that.getOrderNumber() != null){
            Logz.step("Order number expected: "+getOrderNumber()+" But act: "+that.getOrderNumber());
            return false;
        }
        if (getCartItemList() != null ? !getCartItemList().equals(that.getCartItemList()) : that.getCartItemList() != null){
            Logz.step("Item name and ingredients expected: "+getCartItemList()+" But act: "+that.getCartItemList());
            return false;
        }

        if (getPaymentDetails() != null ? !getPaymentDetails().equals(that.getPaymentDetails()) : that.getPaymentDetails() != null){
            Logz.step("Payment type and card number expected: "+getPaymentDetails()+" But act: "+that.getPaymentDetails());
            return false;
        }
        if (getTotal() != null ? !getTotal().equals(that.getTotal()) : that.getTotal() != null){
            Logz.step("get Total expected: "+getTotal()+" But act: "+that.getTotal());
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getPickupDateTime() != null ? getPickupDateTime().hashCode() : 0;
        result = 31 * result + (getStoreAddress() != null ? getStoreAddress().hashCode() : 0);
        result = 31 * result + (getOrderNumber() != null ? getOrderNumber().hashCode() : 0);
        result = 31 * result + (getCartItemList() != null ? getCartItemList().hashCode() : 0);
        result = 31 * result + (getTotal() != null ? getTotal().hashCode() : 0);
        return result;
    }

}
