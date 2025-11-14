package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item != null) items.add(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items); }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.calculatePrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Summary:\n");
        for (Item item : items) {
            sb.append("- ").append(item.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}





