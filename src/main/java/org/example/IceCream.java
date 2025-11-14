package org.example;

import java.util.ArrayList;
import java.util.List;

public class IceCream extends Item {
    private Flavor flavor;                                   //Enums fo flavor size and container type
    private Size size;
    private ContainerType container;
    private List<Toppings> toppings;                         //List of toppings

//constructor
    public IceCream(String name, double basePrice, Flavor flavor, Size size, ContainerType container, List<Toppings> toppings) {
        super(name, basePrice);
        this.flavor = flavor;
        this.size = size;
        this.container = container;
        this.toppings = (toppings != null) ? new ArrayList<>(toppings) : new ArrayList<>();
    //Copies toppings list to prevent external modification.
        //If toppings is null, it initializes as an empty list.
    }

    public IceCream(String name, double basePrice) {

        super(name, basePrice);
        this.toppings = new ArrayList<>();
    }
        //getters and setters
    public Flavor getFlavor() {

        return flavor;
    }

    public void setFlavor(Flavor flavor) {

        this.flavor = flavor;
    }

    public Size getSize() {

        return size;
    }

    public void setSize(Size size) {

        this.size = size;
    }

    public ContainerType getContainer() {

        return container;
    }

    public void setContainer(ContainerType container) {

        this.container = container;
    }

    public List<Toppings> getToppings() {

        return new ArrayList<>(toppings);
    }

    public void setToppings(List<Toppings> toppings) {

        this.toppings = (toppings != null) ? new ArrayList<>(toppings) : new ArrayList<>();
    }

        //Price calculations
    @Override
    public double calculatePrice() {
        double total = 0;

        if (size != null) {
            total += size.getBasePrice();
        }
        if (container != null) {
            total += container.getExtraCost();
        }
            for (Toppings t : toppings) {
                total += t.getPrice();
            }
            total *= getQuantity();

        return total;
    }

    @Override
    public String toString() {
        return "IceCream: " + getName() +
                "\nflavor: " + flavor +
                "\nsize: " + size +
                "\ncontainer: " + container +
                "\ntoppings: " + toppings +
                "\nTotal Price: $" + String.format("%.2f", calculatePrice());
    }

        @Override
        public String toReceiptString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Ice Cream: ").append(getName())
                    .append(" | Flavor: ").append(flavor)
                    .append(" | Size: ").append(size)
                    .append(" | Container: ").append(container);

            if (!toppings.isEmpty()) {
                sb.append(" | Toppings: ");
                for (Toppings t : toppings) sb.append(t.getDisplayName()).append(", ");
                sb.setLength(sb.length() - 2); // remove last comma
            }

            sb.append(" | $").append(String.format("%.2f", calculatePrice()));
            return sb.toString();
        }

        //Nested Builder
        //Lets you create ice cream step by step
    public static class Builder {
        private String name;
        private double basePrice = 3.00;//default price for small cone
        private Flavor flavor;
        private Size size;
        private ContainerType container;
        private final List<Toppings> toppings = new ArrayList<>();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder basePrice(double price) {
            this.basePrice = price;
            return this;
        }

        public Builder flavor(Flavor flavor) {
            this.flavor = flavor;
            return this;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder container(ContainerType container) {
            this.container = container;
            return this;
        }

        public Builder addTopping(Toppings topping) {
            this.toppings.add(topping);
            return this;
        }


        public IceCream build() {
            if (name == null || flavor == null) {
                throw new IllegalStateException("Ice Cream must have a name and flavor.");
            }
            return new IceCream(name, basePrice, flavor, size, container, toppings);
            //returns ice cream instance
        }
    }
}




