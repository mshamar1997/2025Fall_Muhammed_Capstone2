package org.example;

public enum SideType {
    FRIES("Fries",2.00),
    CHIPS("Chips",1.50),
    COOKIE("Cookie",1.25),
    BROWNIE("Brownie",1.75);

    private final String displayName;
    private final double basePrice;

     SideType(String displayName, double basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return displayName + " ($" + basePrice + ")";
    }
}
