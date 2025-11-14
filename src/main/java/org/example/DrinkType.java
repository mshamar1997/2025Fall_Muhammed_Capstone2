package org.example;

public enum DrinkType {
    SODA("Soda", 1.50),
    WATER("Water", 1.00),
    MILKSHAKE("Milk Shake", 2.00),
    ROOT_BEER("Root Beer", 1.50);

    private final String displayName;
    private final double basePrice;

    DrinkType(String displayName, double basePrice){
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
        return displayName + " ($" + String.format("%.2f", basePrice) + ")";
    }
}
