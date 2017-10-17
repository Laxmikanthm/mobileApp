package Enums;

public enum MyLoyalty {
    CERTIFICATES("certificates"),
    TOKENS("tokens"),
    OFFERS("offers");
    private final String stringValue;
    private MyLoyalty(String stringValue) {
        this.stringValue = stringValue;
    }
    public String toString(){return this.stringValue;}
    public String Menu(){return this.stringValue;}
}
