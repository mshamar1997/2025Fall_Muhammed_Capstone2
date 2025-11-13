package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IceCream iceCream = new IceCream.Builder("Cookie Dream", 3.99)
                .flavor(Flavor.COOKIES_AND_CREAM)
                .size(Size.LARGE)
                .container(ContainerType.REGULAR_CONE)
                .toppings(List.of(
                        new Toppings(ToppingType.SPRINKLES, false),
                        new Toppings(ToppingType.BROWNIE_BITS, true)
                ))
                .specialOptions(true)
                .build();
        System.out.println(iceCream);
    }
        

    }
