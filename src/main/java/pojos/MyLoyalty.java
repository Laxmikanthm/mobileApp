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
}
