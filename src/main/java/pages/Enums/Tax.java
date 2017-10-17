package pages.Enums;

/**
 * Created by E001599 on 13-10-2017.
 */
public enum  Tax {
    strTaxHotCategoryName("HOT"),
    strTaxColdCategoryName("COLD"),
    strOrderTypeIndividual("INDIVIDUAL");

    private final String stringValue;
    private Tax(String stringValue) {
        this.stringValue = stringValue;
    }
    public String toString(){return this.stringValue;}
    public String Tax(){return this.stringValue;}
}

