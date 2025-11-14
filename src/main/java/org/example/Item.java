package org.example;

// Base class for all items in the store (IceCream, Drink, Side)
public  class Item {
    // Name of the item
    private String name;
    // Base price for a single Item
    private double basePrice;
    // Number of this item
    private int quantity = 1;
//constructor
    public Item(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;

    }
    //Getters and Setters
    public int getQuantity() {
        return quantity;
    }
    //ensures quantity is at least 1
    public void setQuantity(int quantity) {
        if (quantity < 1) quantity = 1;
        this.quantity = quantity;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getBasePrice() {

        return basePrice;
    }

    public void setBasePrice(double basePrice) {

        this.basePrice = basePrice;
    }
    public double calculatePrice() {
        return basePrice * quantity;

    }
    @Override
    public String toString() {
        return name  + (quantity > 1 ? " x" + quantity : "") + " - $" + String.format("%.2f", calculatePrice());
    }
    public String toReceiptString() {
        return getName() + (getQuantity() > 1 ? " x" + getQuantity() : "")
                + " - $" + String.format("%.2f", calculatePrice());
    }
}

