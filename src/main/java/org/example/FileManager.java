package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    private static final String FILE_PATH = "Receipt.csv";

    public static void saveOrder(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // append mode

            writer.write("===== ORDER =====\n");
            writer.write("Time: " + timestamp + "\n");

            // 3️⃣ Loop through items and use polymorphic method instead of instanceof
            for (Item item : order.getItems()) {
                writer.write(item.toReceiptString() + "\n"); // 4️⃣ cleaner and extendable
            }

            writer.write("Total: $" + String.format("%.2f", order.calculateTotal()) + "\n\n");

            System.out.println("Order saved to " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}











