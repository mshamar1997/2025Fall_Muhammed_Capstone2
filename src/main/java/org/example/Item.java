package org.example;

public  class Item {
    private String name;
    private double basePrice;

    public Item(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
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
        return basePrice;

    }
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", calculatePrice());
    }
}

