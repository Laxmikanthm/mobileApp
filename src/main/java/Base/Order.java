package Base;

import pojos.user.MobileUser;

/**
 * Created by E003705 on 27-04-2017.
 */
public class Order {
    public int storeNumber;
    public String storeName;
    public MobileUser mobileUser;

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }



    public String getStoreName1() {
        return storeName1;
    }

    public void setStoreName1(String storeName1) {
        this.storeName1 = storeName1;
    }

    public String storeName1;
    public String paymentType;
    public String zipCode;
    public int endY;
    public int scrollDuration;
    public int swipeDuration;
    public double scrollStartPoint;
    public double scrollEndPoint;
    public String categoryAllSandwiches;
    public String categorySUBWAYFreshFit;

    public String getCategoryAllSandwiches() {
        return categoryAllSandwiches;
    }

    public void setCategoryAllSandwiches(String categoryAllSandwiches) {
        this.categoryAllSandwiches = categoryAllSandwiches;
    }



    public String getCategorySUBWAYFreshFit() {
        return categorySUBWAYFreshFit;
    }

    public void setCategorySUBWAYFreshFit(String categorySUBWAYFreshFit) {
        this.categorySUBWAYFreshFit = categorySUBWAYFreshFit;
    }



    public String getCreditpaymentType() {
        return creditpaymentType;
    }

    public void setCreditpaymentType(String creditpaymentType) {
        this.creditpaymentType = creditpaymentType;
    }

    public String getDebitpaymentType() {
        return debitpaymentType;
    }

    public void setDebitpaymentType(String debitpaymentType) {
        this.debitpaymentType = debitpaymentType;
    }

    public String getPaypalpaymentType() {
        return paypalpaymentType;
    }

    public void setPaypalpaymentType(String paypalpaymentType) {
        this.paypalpaymentType = paypalpaymentType;
    }

    public String creditpaymentType;
    public String debitpaymentType;
    public String paypalpaymentType;


    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String specialInstructions;

    public String getUpdatePassword() {
        return updatePassword;
    }

    public void setUpdatePassword(String updatePassword) {
        this.updatePassword = updatePassword;
    }

    public String updatePassword;

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getScrollDuration() {
        return scrollDuration;
    }

    public void setScrollDuration(int scrollDuration) {
        this.scrollDuration = scrollDuration;
    }

    public int getSwipeDuration() {
        return swipeDuration;
    }

    public void setSwipeDuration(int swipeDuration) {
        this.swipeDuration = swipeDuration;
    }

    public double getScrollStartPoint() {
        return scrollStartPoint;
    }

    public void setScrollStartPoint(double scrollStartPoint) {
        this.scrollStartPoint = scrollStartPoint;
    }

    public double getScrollEndPoint() {
        return scrollEndPoint;
    }

    public void setScrollEndPoint(double scrollEndPoint) {
        this.scrollEndPoint = scrollEndPoint;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


}
