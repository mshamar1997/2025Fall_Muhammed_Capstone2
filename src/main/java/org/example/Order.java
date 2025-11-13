package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<IceCream> iceCreams;
    private Map<SideType, Integer> sides;
    private Map<DrinkType, Integer> drinks;

    public Order() {
        this.iceCreams = new ArrayList<>();
        this.sides = new HashMap<>();
        this.drinks = new HashMap<>();
    }

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }

    public void setIceCreams(List<IceCream> iceCreams) {
        this.iceCreams = iceCreams;
    }

    public Map<SideType, Integer> getSides() {
        return sides;
    }

    public void setSides(Map<SideType, Integer> sides) {
        this.sides = sides;
    }

    public Map<DrinkType, Integer> getDrinks() {
        return drinks;
    }

    public void setDrinks(Map<DrinkType, Integer> drinks) {
        this.drinks = drinks;
    }

    public void addIceCream(IceCream iceCream) {
        iceCreams.add(iceCream);
    }
    public void addSide(SideType side) {
        addSide(side, 1);
    }

    public void addSide(SideType side, int quantity) {
        sides.put(side, sides.getOrDefault(side, 0) + quantity);
    }

    // Add drinks
    public void addDrink(DrinkType drink) {
        addDrink(drink, 1);
    }

    public void addDrink(DrinkType drink, int quantity) {
        drinks.put(drink, drinks.getOrDefault(drink, 0) + quantity);
    }

        // 💰 Calculate total price of the order
        public double calculateTotal () {
            double total = 0.0;

            // Add up ice creams
            for (IceCream iceCream : iceCreams) {
                total += iceCream.calculatePrice();
            }

            // Add up sides (price * quantity)
            for (Map.Entry<SideType, Integer> entry : sides.entrySet()) {
                total += entry.getKey().getBasePrice() * entry.getValue();
            }

            // Add up drinks (price * quantity)
            for (Map.Entry<DrinkType, Integer> entry : drinks.entrySet()) {
                total += entry.getKey().getBasePrice() * entry.getValue();
            }

            return total;
        }

        // 🧾 Print order summary
        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            sb.append("Order Summary:\n");

            sb.append("\nIce Creams:\n");
            for (IceCream iceCream : iceCreams) {
                sb.append("- ").append(iceCream).append("\n");
            }

            sb.append("\nSides:\n");
            for (Map.Entry<SideType, Integer> entry : sides.entrySet()) {
                sb.append("- ").append(entry.getKey().getDisplayName())
                        .append(" x").append(entry.getValue()).append("\n");
            }

            sb.append("\nDrinks:\n");
            for (Map.Entry<DrinkType, Integer> entry : drinks.entrySet()) {
                sb.append("- ").append(entry.getKey().getDisplayName())
                        .append(" x").append(entry.getValue()).append("\n");
            }

            sb.append("\nTotal: $").append(String.format("%.2f", calculateTotal()));

            return sb.toString();
        }
    }




