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
        return 0;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor=" + flavor +
                ", size=" + size +
                ", container=" + container +
                ", toppings=" + toppings +
                ", specialOptions=" + specialOptions +
                '}';
    }
}


