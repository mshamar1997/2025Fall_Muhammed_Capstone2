package org.example;

public enum ToppingType {
    //premium toppings
    COOKIE_DOUGH("Cookie Dough", 1.00, true),
    BROWNIE_BITS("Brownie Bites", 1.00, true),
    OREO_CRUMBLE("Oreo Crumble", 1.00, true),
    WAFFLE_PIECES("Waffle Pieces", 1.00, true),
    CHEESECAKE_BITES("Cheesecake Bites", 1.00, true),

    //regular toppings
    SPRINKLES("Sprinkles", .50, false),
    PEANUTS("Peanuts", .50, false),
    GUMMY_BEARS("Gummy Bears", .50, false ),
    WHIPPED_CREAM("Whipped Cream", .50, false),
    CHOCOLATE_CHIPS("Chocolate Chips", .50, false);

    private final String displayName;
    private final double price;
    private final boolean premium;

    ToppingType(String displayName, double price, boolean premium) {
        this.displayName = displayName;
        this.price = price;
        this.premium = premium;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return displayName + " ($" + String.format("%.2f",price )+ ")";
    }
}
