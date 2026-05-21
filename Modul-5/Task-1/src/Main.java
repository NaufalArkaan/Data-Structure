import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static HashMap<String, Item> inventory = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     Railway Inventory System");
            System.out.println("=================================");
            System.out.println("1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Search Item");
            System.out.println("4. Add Stock");
            System.out.println("5. Remove Item");
            System.out.println("6. Update Price");
            System.out.println("7. Exit");
            System.out.print("Choose menu: ");
            try {
                choice = input.nextInt();
                input.nextLine();

            } catch (Exception e) {

                System.out.println("Input harus berupa angka!");

                input.nextLine();
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addItem();
                    break;

                case 2:
                    viewInventory();
                    break;

                case 3:
                    searchItem();
                    break;

                case 4:
                    addStock();
                    break;

                case 5:
                    removeItem();
                    break;

                case 6:
                    updatePrice();
                    break;

                case 7:
                    System.out.println("Program selesai...");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (choice != 7);
    }

    public static void addItem() {
        System.out.println("\n=== Add New Item ===");

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        System.out.print("Enter initial stock: ");
        int stock = input.nextInt();

        System.out.print("Enter price: ");
        double price = input.nextDouble();

        inventory.put(name, new Item(stock, price));

        System.out.println("Item added successfully!");
    }

    public static void viewInventory() {

        System.out.println("\n=== Inventory List ===");

        if (inventory.isEmpty()) {
            System.out.println("Inventory kosong!");
            return;
        }

        int no = 1;

        for (Map.Entry<String, Item> data : inventory.entrySet()) {

            System.out.println(no + ". " + data.getKey()
                    + " | Stock: " + data.getValue().getStock()
                    + " | Price: Rp " + data.getValue().getPrice());

            no++;
        }

        System.out.println("Total items: " + inventory.size());
    }

    public static void searchItem() {

        System.out.println("\n=== Search Item ===");

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            Item item = inventory.get(name);

            System.out.println("\nItem Found!");
            System.out.println("Name  : " + name);
            System.out.println("Stock : " + item.getStock());
            System.out.println("Price : Rp " + item.getPrice());

        } else {
            System.out.println("Item tidak ditemukan!");
        }
    }

    public static void addStock() {

        System.out.println("\n=== Add Stock ===");

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            System.out.print("Enter stock to add: ");
            int add = input.nextInt();

            Item item = inventory.get(name);

            int oldStock = item.getStock();
            item.setStock(oldStock + add);

            System.out.println("Stock updated successfully!");
            System.out.println(name + ": "
                    + oldStock + " -> "
                    + item.getStock());

        } else {
            System.out.println("Item tidak ditemukan!");
        }
    }

    public static void removeItem() {

        System.out.println("\n=== Remove Item ===");

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            inventory.remove(name);

            System.out.println("Item removed successfully!");

        } else {
            System.out.println("Item tidak ditemukan!");
        }
    }

    public static void updatePrice() {

        System.out.println("\n=== Update Price ===");

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            Item item = inventory.get(name);

            System.out.println("Current price: Rp " + item.getPrice());

            System.out.print("Enter new price: ");
            double newPrice = input.nextDouble();

            item.setPrice(newPrice);

            System.out.println("Price updated successfully!");

        } else {
            System.out.println("Item tidak ditemukan!");
        }
    }
}