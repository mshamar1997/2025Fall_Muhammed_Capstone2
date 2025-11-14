package org.example;

public class Drink extends Item {
    private DrinkType type;
    private DrinkSize size;

    public Drink(DrinkType type, DrinkSize size) {
        super(type.getDisplayName(), type.getBasePrice());
        this.type = type;
        this.size = size;

    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        // base price * size multiplier
        return (type.getBasePrice() * size.getPriceMultiplier()) * getQuantity();
    }
    @Override
    public String toString() {
        return size.getDisplayName() + " " + type.getDisplayName() +
                (getQuantity() > 1 ? " x" + getQuantity() : "") +
                " - $" + String.format("%.2f", calculatePrice());
    }
    @Override
    public String toReceiptString() {
        return "Drink: " + size.getDisplayName() + " " + getName()
                + (getQuantity() > 1 ? " x" + getQuantity() : "")
                + " | $" + String.format("%.2f", calculatePrice());
    }
}

