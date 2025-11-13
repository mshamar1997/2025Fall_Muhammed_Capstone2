package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printHomeScreen();

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // New Order
                    Order order = new Order();
                    handleOrder(scanner, order);
                    break;
                case "0": // Exit
                    System.out.println("Thanks for visiting Chill Creams! Goodbye 🍦");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
            }
        }

        scanner.close();
    }

    private static void printHomeScreen() {
        System.out.println("\n===============================");
        System.out.println("   🍦  WELCOME TO CHILL CREAMS  🍦");
        System.out.println("===============================\n");
        System.out.println("1) New Order");
        System.out.println("0) Exit\n");
    }

    private static void handleOrder(Scanner scanner, Order order) {
        boolean ordering = true;

        while (ordering) {
            printOrderScreen();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // Add Ice Cream
                    IceCream iceCream = createIceCream(scanner);
                    order.addIceCream(iceCream);
                    break;
                case "2": // Add Drink
                    addDrink(scanner, order);
                    break;
                case "3": // Add Side
                    addSide(scanner, order);
                    break;
                case "4": // Checkout
                    System.out.println("\n===== CHECKOUT =====\n");
                    FileManager.saveOrder(order);
                    ordering = false;
                    break;
                case "0": // Cancel order
                    System.out.println("Order canceled, returning to home screen.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option, try again!");
            }
        }
    }

    private static void printOrderScreen() {
        System.out.println("\n-------------------------------");
        System.out.println("        ORDER MENU 🍨");
        System.out.println("-------------------------------");
        System.out.println("1) Add Ice Cream");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Side");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order\n");
    }

    // ---------------- Ice Cream Creation ----------------
    private static IceCream createIceCream(Scanner scanner) {
        System.out.println("\nSelect flavor:");
        for (Flavor f : Flavor.values()) {
            System.out.println(f.ordinal() + 1 + ") " + f);
        }
        System.out.print("Choice: ");
        int flavorIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Flavor flavor = Flavor.values()[flavorIndex];

        System.out.println("\nSelect size:");
        for (Size s : Size.values()) {
            System.out.println(s.ordinal() + 1 + ") " + s);
        }
        System.out.print("Choice: ");
        int sizeIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Size size = Size.values()[sizeIndex];

        System.out.println("\nSelect container:");
        for (ContainerType c : ContainerType.values()) {
            System.out.println(c.ordinal() + 1 + ") " + c.getDisplayName());
        }
        System.out.print("Choice: ");
        int containerIndex = Integer.parseInt(scanner.nextLine()) - 1;
        ContainerType container = ContainerType.values()[containerIndex];

        // Build ice cream
        IceCream iceCream = new IceCream.Builder()
                .name(flavor + " Ice Cream")
                .flavor(flavor)
                .size(size)
                .container(container)
                .build();

        System.out.println("Added: " + iceCream.getName());
        return iceCream;
    }

    // ---------------- Add Drink ----------------
    private static void addDrink(Scanner scanner, Order order) {
        System.out.println("\nSelect drink:");
        for (DrinkType d : DrinkType.values()) {
            System.out.println(d.ordinal() + 1 + ") " + d.getDisplayName());
        }
        System.out.print("Choice: ");
        int drinkIndex = Integer.parseInt(scanner.nextLine()) - 1;
        DrinkType drink = DrinkType.values()[drinkIndex];

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        order.addDrink(drink, qty);
        System.out.println("Added " + qty + " x " + drink.getDisplayName());
    }

    // ---------------- Add Side ----------------
    private static void addSide(Scanner scanner, Order order) {
        System.out.println("\nSelect side:");
        for (SideType s : SideType.values()) {
            System.out.println(s.ordinal() + 1 + ") " + s.getDisplayName());
        }
        System.out.print("Choice: ");
        int sideIndex = Integer.parseInt(scanner.nextLine()) - 1;
        SideType side = SideType.values()[sideIndex];

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        order.addSide(side, qty);
        System.out.println("Added " + qty + " x " + side.getDisplayName());
    }
}




