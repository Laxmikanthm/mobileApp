package pojos;

import kobieApi.pojos.Certificates;
import kobieApi.pojos.Offers;
import kobieApi.pojos.OffersList;

import java.util.List;

public class MyLoyalty {
    private String tokens;
    private List<Certificates> certificates;
    private List<Offers> offers;

    public MyLoyalty() {
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }

    public List<Certificates> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificates> certificates) {
        this.certificates = certificates;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLoyalty myLoyalty = (MyLoyalty) o;

        if (tokens != null ? !tokens.equals(myLoyalty.tokens) : myLoyalty.tokens != null) return false;
        if (certificates != null ? !certificates.equals(myLoyalty.certificates) : myLoyalty.certificates != null)
            return false;
        return offers != null ? offers.equals(myLoyalty.offers) : myLoyalty.offers == null;
    }

    @Override
    public int hashCode() {
        int result = tokens != null ? tokens.hashCode() : 0;
        result = 31 * result + (certificates != null ? certificates.hashCode() : 0);
        result = 31 * result + (offers != null ? offers.hashCode() : 0);
        return result;
    }
}
