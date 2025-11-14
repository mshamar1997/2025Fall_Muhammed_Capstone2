package org.example;

public enum Flavor {
    VANILLA("Vanilla"),
    CHOCOLATE("Chocolate"),
    ROCKY_ROAD("Rocky Road"),
    STRAWBERRY("Strawberry"),
    COOKIES_AND_CREAM("Cookies and Cream"),
    BIRTHDAY_CAKE("Birthday Cake");

    private final String displayName;

    Flavor(String displayName) {

        this.displayName = displayName;
    }

    public String getDisplayName() {

        return displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
