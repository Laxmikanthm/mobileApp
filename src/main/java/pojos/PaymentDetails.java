package pojos;

import utils.Logz;

public class PaymentDetails {
    private String cardType;
    private String cardEndingNumber;
    private String imagePath;


    private String amount;




    public PaymentDetails() {

    }


    public PaymentDetails(String cardType, String cardEndingNumber) {
        this.cardType = cardType;
        this.cardEndingNumber = cardEndingNumber;
    }



    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardEndingNumber() {
        return cardEndingNumber;
    }

    public void setCardEndingNumber(String cardEndingNumber) {
        this.cardEndingNumber = cardEndingNumber;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

//    public String getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        this.total = total;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentDetails)) return false;

        PaymentDetails that = (PaymentDetails) o;

        if (getCardType() != null ? !getCardType().equals(that.getCardType()) : that.getCardType() != null){
            Logz.step("Card type expected: "+getCardType()+"But act: "+that.getCardType());
            return false;
        }

        if (getImagePath() != null ? !getImagePath().equals(that.getImagePath()) : that.getImagePath() != null){
            Logz.step("Image path expected: "+getImagePath()+"But act: "+that.getImagePath());
            return false;
        }


        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null){
            Logz.step("amount expected: "+getAmount()+"But act: "+that.getAmount());
            return false;
        }
        return getCardEndingNumber() != null ? getCardEndingNumber().equals(that.getCardEndingNumber()) : that.getCardEndingNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getCardType() != null ? getCardType().hashCode() : 0;
        result = 31 * result + (getCardEndingNumber() != null ? getCardEndingNumber().hashCode() : 0);
        return result;
    }


}
