package org.example;

public class Toppings {
    private ToppingType type;
    private boolean isExtra;

    public Toppings(ToppingType type, boolean isExtra) {
        this.type = type;
        this.isExtra = isExtra;
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

    public boolean isExtra() {

        return isExtra;
    }

    public void setExtra(boolean extra) {

        isExtra = extra;
    }
    public double getPrice() {
        double basePrice = type.getPrice();
        return isExtra ? basePrice * 1.5 : basePrice;

    }
    @Override
    public String toString() {
        return type.getDisplayName() + (isExtra ? " (extra)" : "")
                + " - $" + String.format("%.2f", getPrice());
    }
    }
