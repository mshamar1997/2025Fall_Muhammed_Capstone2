package org.example;

public enum Size {
    SMALL(3.00, 1.0),
    MEDIUM(4.00, 1.25),
    LARGE(5.00, 1.5);

    private final double basePrice;
    private final double toppingMultiplier;


    Size(double basePrice, double toppingMultiplier) {
        this.basePrice = basePrice;
        this.toppingMultiplier = toppingMultiplier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getToppingMultiplier() {
        return toppingMultiplier;
    }
}
