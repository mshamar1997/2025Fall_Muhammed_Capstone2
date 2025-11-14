package org.example;

public enum Size {
    SMALL("Small", 3.00, 1.0),
    MEDIUM("Medium", 4.00, 1.25),
    LARGE("Large", 5.00, 1.5);

    private final String displayName;
    private final double basePrice;
    private final double toppingMultiplier;


    Size(String displayName, double basePrice, double toppingMultiplier) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.toppingMultiplier = toppingMultiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {

        return basePrice;
    }

    public double getToppingMultiplier() {

        return toppingMultiplier;
    }
    @Override
    public String toString() {
        return displayName;
    }
}