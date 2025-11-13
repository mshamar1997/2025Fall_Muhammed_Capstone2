package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    private static final String FILE_PATH = "Receipt.csv";

    /**
     * Save an order to a CSV file.
     */
    public static void saveOrder(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // append mode

            writer.write("===== ORDER =====\n");
            writer.write("Time: " + timestamp + "\n");

            // Ice creams
            writer.write("Ice Creams:\n");
            for (IceCream iceCream : order.getIceCreams()) {
                writer.write("- " + iceCream.getName() + " | $" + String.format("%.2f", iceCream.calculatePrice()) + "\n");
            }

            // Sides
            writer.write("Sides:\n");
            for (SideType side : order.getSides().keySet()) {
                int qty = order.getSides().get(side);
                writer.write("- " + side.getDisplayName() + " x" + qty + " | $" + String.format("%.2f", side.getBasePrice() * qty) + "\n");
            }

            // Drinks
            writer.write("Drinks:\n");
            for (DrinkType drink : order.getDrinks().keySet()) {
                int qty = order.getDrinks().get(drink);
                writer.write("- " + drink.getDisplayName() + " x" + qty + " | $" + String.format("%.2f", drink.getBasePrice() * qty) + "\n");
            }

            writer.write("Total: $" + String.format("%.2f", order.calculateTotal()) + "\n");
            writer.write("\n"); // blank line between orders

            System.out.println("Order saved to " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}






