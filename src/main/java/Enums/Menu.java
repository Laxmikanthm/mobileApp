package Enums;

public enum  Menu {
    AllSandwiches("All Sandwiches"),
    SUBWAYFreshFit("SUBWAY Fresh Fit"),
    Breakfast("Breakfast"),
    ChoppedSalads("Chopped Salads"),
    KidsMeal("Kids"),
    Sides("Sides"),
    SuboftheDay("Sub of the Day"),
    Drinks("Drinks");
    private final String stringValue;

private Menu(String stringValue) {
    this.stringValue = stringValue;
}
public String toString(){return this.stringValue;}
public String Menu(){return this.stringValue;}
    /*SuboftheDay = Sub of the Day
    AllSandwiches = All Sandwiches
    SUBWAYFreshFit  = SUBWAY Fresh Fit
            Breakfast = Breakfast
    ChoppedSalads = Chopped Salads
    KidsMeal = Kids
            Sides = Sides
    Drinks = Drinks*/
}
