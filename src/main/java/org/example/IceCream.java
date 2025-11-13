package org.example;

import java.util.List;

public class IceCream extends Item{
    private Flavor flavor;
    private Size size;
    private ContainerType container;
    private List<Toppings> toppings;
    private boolean specialOptions;

    public IceCream(String name, double basePrice, Flavor flavor, Size size, ContainerType container, List<Toppings> toppings, boolean specialOptions) {
        super(name, basePrice);
        this.flavor = flavor;
        this.size = size;
        this.container = container;
        this.toppings = toppings;
        this.specialOptions = specialOptions;
    }

    public IceCream(String name, double basePrice) {

        super(name, basePrice);
    }

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

        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {

        this.toppings = toppings;
    }

    public boolean isSpecialOptions() {

        return specialOptions;
    }

    public void setSpecialOptions(boolean specialOptions) {

        this.specialOptions = specialOptions;
    }

    @Override
    public double calculatePrice() {
            double total = getBasePrice();

        if (size != null) {
            total += size.getBasePrice();
        }
        if (container != null) {
            total += container.getExtraCost();
        }
        if (toppings != null) {
            for (Toppings t : toppings) {
                total += t.getPrice() * (size != null ? size.getToppingMultiplier() : 1.0);
            }
        }
        if (specialOptions) total += 1.00;
        return total;
    }

    @Override
    public String toString() {
        return "IceCream: " + getName() +
                "\nflavor: " + flavor +
                "\nsize: " + size +
                "\ncontainer: " + container +
                "\ntoppings: " + toppings +
                "\nspecialOptions: " + (specialOptions ? "Yes" : "No") +
                "\nTotal Price" + String.format("%.2f", calculatePrice());
                }

                public static class Builder {
        private String name;
        private double basePrice;
        private Flavor flavor;
        private Size size;
        private ContainerType container;
        private List<Toppings> toppings;
        private boolean specialOptions;

        public Builder(String name, double basePrice) {
            this.name = name;
            this.basePrice = basePrice;
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

        public Builder toppings(List<Toppings> toppings) {
            this.toppings = toppings;
            return this;
        }

        public Builder specialOptions(boolean specialOptions) {
            this.specialOptions = specialOptions;
            return this;
        }

        public IceCream build() {
            return new IceCream(name, basePrice, flavor, size, container, toppings, specialOptions);
        }
    }
    }



