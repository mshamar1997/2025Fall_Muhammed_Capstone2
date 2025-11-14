package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Shamz Creamery");

        while (running) {
            switch (showHomeScreen(scanner)) {
                case 1 -> showOrderScreen(scanner); // New Order
                case 0 -> {
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                }
            }
        }

        scanner.close();
    }

    //  Home Screen
    private static int showHomeScreen(Scanner scanner) {
        System.out.println("\n--- HOME SCREEN ---");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
        return getValidInt(scanner, 0, 1);
    }

    // Order Screen
    private static void showOrderScreen(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- ORDER SCREEN ---");
            displayOrder(order); // Show newest entries first

            System.out.println("\n1) Add Ice Cream");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            int choice = getValidInt(scanner, 0, 4);

            switch (choice) {
                case 1 -> addIceCream(scanner, order);
                case 2 -> addDrink(scanner, order);
                case 3 -> addSide(scanner, order);
                case 4 -> {
                    checkout(scanner, order);
                    ordering = false;
                }
                case 0 -> {
                    System.out.println("Order cancelled. Returning to Home Screen.");
                    ordering = false;
                }
            }
        }
    }

    // Display Order
    private static void displayOrder(Order order) {
        System.out.println("\n--- CURRENT ORDER ---");
        List<Item> items = order.getItems();
        if (items.isEmpty()) {
            System.out.println("No items yet.");
        } else {
            // Show newest entries first
            for (int i = items.size() - 1; i >= 0; i--) {
                System.out.println("- " + items.get(i));
            }
        }
        System.out.println("Total: $" + String.format("%.2f", order.calculateTotal()));
    }

    // Checkout
    private static void checkout(Scanner scanner, Order order) {
        System.out.println("\n--- CHECKOUT ---");
        displayOrder(order);

        System.out.println("1) Confirm Order");
        System.out.println("0) Cancel Order");
        int choice = getValidInt(scanner, 0, 1);

        if (choice == 1) {
            FileManager.saveOrder(order);
            System.out.println("Order completed. Returning to Home Screen.");
        } else {
            System.out.println("Order cancelled. Returning to Home Screen.");
        }
    }

    // ------------------- Add Ice Cream -------------------
    private static void addIceCream(Scanner scanner, Order order) {
        System.out.println("\n--- Add Ice Cream ---");

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        // --- Select Flavor ---
        Flavor[] flavors = Flavor.values();
        System.out.println("Select flavor:");
        for (int i = 0; i < flavors.length; i++) System.out.println((i + 1) + ") " + flavors[i]);
        Flavor flavor = flavors[getValidInt(scanner, 1, flavors.length) - 1];

        // --- Select Size ---
        Size[] sizes = Size.values();
        System.out.println("Select size:");
        for (int i = 0; i < sizes.length; i++) System.out.println((i + 1) + ") " + sizes[i]);
        Size size = sizes[getValidInt(scanner, 1, sizes.length) - 1];

        // --- Select Container ---
        ContainerType[] containers = ContainerType.values();
        System.out.println("Select container:");
        for (int i = 0; i < containers.length; i++) System.out.println((i + 1) + ") " + containers[i]);
        ContainerType container = containers[getValidInt(scanner, 1, containers.length) - 1];

        // Toppings
        List<Toppings> toppings = new ArrayList<>();
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Add a topping? (y/n)");
            String add = scanner.nextLine().trim().toLowerCase();
            if (add.equals("y")) {
                ToppingType[] tTypes = ToppingType.values();
                System.out.println("Select topping:");
                for (int i = 0; i < tTypes.length; i++) System.out.println((i + 1) + ") " + tTypes[i]);
                ToppingType selected = tTypes[getValidInt(scanner, 1, tTypes.length) - 1];

                System.out.println("Extra portion? (y/n)");
                boolean extra = scanner.nextLine().trim().equalsIgnoreCase("y");

                toppings.add(new Toppings(selected, extra));
            } else if (add.equals("n")) {
                addingToppings = false;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }


        int quantity = getPositiveInt(scanner, "Quantity: ");

        IceCream ice = new IceCream.Builder()
                .name(name)
                .flavor(flavor)
                .size(size)
                .container(container)
                .build();
        ice.setToppings(toppings);
        ice.setQuantity(quantity);

        order.addItem(ice);
        System.out.println("Ice Cream added!");
    }

    // ------------------- Add Drink -------------------
    private static void addDrink(Scanner scanner, Order order) {
        System.out.println("\n--- Add Drink ---");

        System.out.println("Select drink type:");
        for (DrinkType d : DrinkType.values()) System.out.println(d.ordinal() + 1 + ". " + d);
        DrinkType type = DrinkType.values()[getValidInt(scanner, 1, DrinkType.values().length) - 1];

        System.out.println("Select size:");
        for (DrinkSize s : DrinkSize.values()) System.out.println(s.ordinal() + 1 + ". " + s);
        DrinkSize size = DrinkSize.values()[getValidInt(scanner, 1, DrinkSize.values().length) - 1];

        int quantity = getPositiveInt(scanner, "Quantity: ");

        Drink drink = new Drink(type, size);
        drink.setQuantity(quantity);

        order.addItem(drink);
        System.out.println("Drink added!");
    }

    // ------------------- Add Side -------------------
    private static void addSide(Scanner scanner, Order order) {
        System.out.println("\n--- Add Side ---");

        System.out.println("Select side type:");
        for (SideType s : SideType.values()) System.out.println(s.ordinal() + 1 + ". " + s);
        SideType type = SideType.values()[getValidInt(scanner, 1, SideType.values().length) - 1];

        int quantity = getPositiveInt(scanner, "Quantity: ");

        Side side = new Side(type);
        side.setQuantity(quantity);

        order.addItem(side);
        System.out.println("Side added!");
    }

    // ------------------- Input Utilities -------------------
    private static int getValidInt(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    scanner.nextLine(); // consume newline
                    return choice;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ":");
                }
            } else {
                System.out.println("Invalid input. Enter a number:");
                scanner.next(); // consume invalid input
            }
        }
    }

    private static int getPositiveInt(Scanner scanner, String prompt) {
        int qty;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                qty = scanner.nextInt();
                if (qty > 0) {
                    scanner.nextLine(); // consume newline
                    return qty;
                } else {
                    System.out.println("Quantity must be at least 1.");
                }
            } else {
                System.out.println("Invalid input. Enter a number:");
                scanner.next(); // consume invalid input
            }
        }
    }
}










