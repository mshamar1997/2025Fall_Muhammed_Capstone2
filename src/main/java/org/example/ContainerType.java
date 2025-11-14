package org.example;

public enum ContainerType {
    REGULAR_CONE("Regular Cone", 0.00),
    WAFFLE_CONE("Waffle Cone", 0.75),
    REGULAR_BOWL("Regular Bowl", 0.00),
    WAFFLE_BOWL("Waffle Bowl", 0.75);

    private final String displayName;
    private final double extraCost;

    ContainerType(String displayName, double extraCost) {
        this.displayName = displayName;
        this.extraCost = extraCost;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getExtraCost() {
        return extraCost;
    }

    @Override
    public String toString() {
        return displayName + " (+$" + String.format("%.2f", extraCost) + ")";
    }
}
