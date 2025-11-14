package org.example;

public class Side extends Item {
    private SideType type;

    public Side(SideType type) {
        // Pass name and base price up to Item
        super(type.getDisplayName(), type.getBasePrice());
        this.type = type;
    }

    public SideType getType() {
        return type;
    }

    @Override
    public double calculatePrice() {
        // sides just use their base price (no multipliers)
        return getBasePrice() * getQuantity();
    }

    @Override
    public String toString() {
        return type.getDisplayName() + (getQuantity() > 1 ? " x" + getQuantity() : "")
                + " - $" + String.format("%.2f", calculatePrice());
    }
    @Override
    public String toReceiptString() {
        return "Side: " + getName()
                + (getQuantity() > 1 ? " x" + getQuantity() : "")
                + " | $" + String.format("%.2f", calculatePrice());
    }
}
