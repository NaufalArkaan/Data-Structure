import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static HashMap<String, Item> inventory = new HashMap<>();
    static HashMap<String, String> users = new HashMap<>();
    static HashMap<String, ArrayList<String>> userDetails = new HashMap<>();

    static String loggedInUser = null;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            if (loggedInUser == null) {
                System.out.println("\n=================================");
                System.out.println(" Railway Inventory System");
                System.out.println("=================================");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                choice = inputMenu();

                switch (choice) {

                    case 1:
                        register();
                        break;

                    case 2:
                        login();
                        break;

                    case 3:
                        System.out.println("Program selesai...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Menu tidak valid!");
                }

            } else {
                System.out.println("\n=================================");
                System.out.println(" Welcome, " + loggedInUser);
                System.out.println("=================================");
                System.out.println("1. Add Item");
                System.out.println("2. View Inventory");
                System.out.println("3. Search Item");
                System.out.println("4. Add Stock");
                System.out.println("5. Remove Item");
                System.out.println("6. Update Price");
                System.out.println("7. View Inventory Report");
                System.out.println("8. Logout");

                choice = inputMenu();

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
                        viewInventoryReport();
                        break;

                    case 8:
                        logout();
                        break;

                    default:
                        System.out.println("Menu tidak valid!");
                }
            }

        } while (true);
    }

    public static int inputMenu() {

        int choice;

        while (true) {

            System.out.print("Choose menu: ");

            try {

                choice = input.nextInt();
                input.nextLine();

                return choice;

            } catch (Exception e) {

                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        }
    }

    public static void register() {

        System.out.println("\n=== REGISTER ===");

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        System.out.print("Full Name: ");
        String fullName = input.nextLine();

        System.out.print("Address  : ");
        String address = input.nextLine();

        if (users.containsKey(username)) {

            System.out.println("Username sudah digunakan!");
            System.out.println("Registration Failed!");
            return;
        }

        if (!username.contains("@")) {

            System.out.println("Username harus mengandung '@'");
            System.out.println("Registration Failed!");
            return;
        }

        if (password.length() < 8) {

            System.out.println("Password minimal 8 karakter!");
            System.out.println("Registration Failed!");
            return;
        }

        users.put(username, password);

        ArrayList<String> detail = new ArrayList<>();
        detail.add(fullName);
        detail.add(address);

        userDetails.put(username, detail);

        System.out.println("Registration Successful!");
    }

    public static void login() {

        System.out.println("\n=== LOGIN ===");

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        if (users.containsKey(username)
                && users.get(username).equals(password)) {

            loggedInUser = username;

            ArrayList<String> detail = userDetails.get(username);

            System.out.println("Login Successful!");
            System.out.println("Welcome, " + detail.get(0)
                    + " (" + detail.get(1) + ")");

        } else {

            System.out.println("Login Failed!");
        }
    }

    public static void logout() {

        loggedInUser = null;

        System.out.println("Logout Successful!");
    }

    public static void addItem() {

        System.out.println("\n=== ADD ITEM ===");

        System.out.print("Item name : ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            System.out.println("Item sudah ada!");
            return;
        }

        int stock = inputInteger("Initial stock: ");
        double price = inputDouble("Price: ");

        inventory.put(name, new Item(stock, price));

        System.out.println("Item added successfully!");
    }

    public static void viewInventory() {

        System.out.println("\n=== INVENTORY LIST ===");

        if (inventory.isEmpty()) {

            System.out.println("Inventory kosong!");
            return;
        }

        int no = 1;

        for (Map.Entry<String, Item> data : inventory.entrySet()) {

            System.out.println(no + ". "
                    + data.getKey()
                    + " | Stock: " + data.getValue().getStock()
                    + " | Price: Rp " + data.getValue().getPrice());

            no++;
        }
    }

    public static void searchItem() {

        System.out.println("\n=== SEARCH ITEM ===");

        System.out.print("Item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            Item item = inventory.get(name);

            System.out.println("Item Found!");
            System.out.println("Stock : " + item.getStock());
            System.out.println("Price : Rp " + item.getPrice());

        } else {

            System.out.println("Item tidak ditemukan!");
        }
    }

    public static void addStock() {

        System.out.println("\n=== ADD STOCK ===");

        System.out.print("Item name: ");
        String name = input.nextLine();

        if (!inventory.containsKey(name)) {

            System.out.println("Item tidak ditemukan!");
            return;
        }

        int add = inputInteger("Stock to add: ");

        Item item = inventory.get(name);

        int oldStock = item.getStock();

        item.setStock(oldStock + add);

        System.out.println("Stock updated successfully!");
        System.out.println(oldStock + " -> " + item.getStock());
    }

    public static void removeItem() {

        System.out.println("\n=== REMOVE ITEM ===");

        System.out.print("Item name: ");
        String name = input.nextLine();

        if (inventory.containsKey(name)) {

            inventory.remove(name);

            System.out.println("Item removed successfully!");

        } else {

            System.out.println("Item tidak ditemukan!");
        }
    }

    public static void updatePrice() {

        System.out.println("\n=== UPDATE PRICE ===");

        System.out.print("Item name: ");
        String name = input.nextLine();

        if (!inventory.containsKey(name)) {

            System.out.println("Item tidak ditemukan!");
            return;
        }

        Item item = inventory.get(name);

        System.out.println("Current price: Rp " + item.getPrice());

        double newPrice = inputDouble("New price: ");

        item.setPrice(newPrice);

        System.out.println("Price updated successfully!");
    }

    public static void viewInventoryReport() {

        System.out.println("\n=== INVENTORY REPORT ===");

        if (inventory.isEmpty()) {

            System.out.println("Inventory kosong!");
            return;
        }

        for (Map.Entry<String, Item> data : inventory.entrySet()) {

            System.out.println("- "
                    + data.getKey()
                    + " | Stock: " + data.getValue().getStock()
                    + " | Price: Rp " + data.getValue().getPrice());
        }

        ArrayList<String> detail = userDetails.get(loggedInUser);

        System.out.println("\nLogged-in User: " + detail.get(0));
    }

    public static int inputInteger(String message) {

        while (true) {

            try {

                System.out.print(message);

                int number = input.nextInt();
                input.nextLine();

                return number;

            } catch (Exception e) {

                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        }
    }

    public static double inputDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double number = input.nextDouble();
                input.nextLine();

                return number;

            } catch (Exception e) {

                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        }
    }
}