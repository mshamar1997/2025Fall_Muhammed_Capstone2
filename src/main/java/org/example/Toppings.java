package org.example;

public class Toppings {
    private ToppingType type;
    private boolean extraPortion;

    public Toppings(ToppingType type, boolean extraPortion) {
        this.type = type;
        this.extraPortion = extraPortion;
    }
    public String getDisplayName() {
        return type.getDisplayName();
    }
    public boolean isPremium() {
        return type.isPremium();
    }

    public ToppingType getType() {

        return type;
    }

    public void setType(ToppingType type) {

        this.type = type;
    }

    public boolean isExtraPortion() {

        return extraPortion;
    }

    public void setExtraPortion(boolean extra) {

       this.extraPortion = extra;
    }
    public double getPrice() {
        double basePrice = type.getPrice();
        return extraPortion ? basePrice * 1.5 : basePrice;

    }
    @Override
    public String toString() {
        return type.getDisplayName() + (extraPortion ? " (extra)" : "")
                + " - $" + String.format("%.2f", getPrice());
    }
    }
