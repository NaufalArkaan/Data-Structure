import java.util.Scanner;

public class MainPassenger {

    public static void main(String[] args) {

        PassengerManager manager = new PassengerManager();
        Scanner input = new Scanner(System.in);

        manager.addPassenger(new Passenger("Naufal", "naufal@mail.com", "081234", 21));
        manager.addPassenger(new Passenger("Raka", "raka@mail.com", "082345", 22));

        int menu = 0;

        do {

            System.out.println("\n==== Passenger Menu ====");
            System.out.println("1. Show Passenger List");
            System.out.println("2. Register New Passenger");
            System.out.println("3. Find Passenger by Name");
            System.out.println("4. Delete Passenger");
            System.out.println("5. Get Passenger by Index");
            System.out.println("6. Update Passenger Name");
            System.out.println("7. Exit");

            try {

                System.out.print("Select menu: ");
                menu = input.nextInt();
                input.nextLine();

            } catch (Exception e) {

                System.out.println("Invalid input! Please enter a number.");
                input.nextLine();
                menu = 0;

            }

            switch(menu){

                case 1: {
                    manager.showPassengers();
                    break;
                }

                case 2: {

                    System.out.print("Input Name: ");
                    String name = input.nextLine();

                    System.out.print("Input Email: ");
                    String email = input.nextLine();

                    System.out.print("Input Phone: ");
                    String phone = input.nextLine();

                    System.out.print("Input Age: ");
                    int age = input.nextInt();
                    input.nextLine();

                    manager.addPassenger(new Passenger(name, email, phone, age));

                    System.out.println("Passenger successfully added.");
                    break;
                }

                case 3: {

                    System.out.print("Search name: ");
                    String search = input.nextLine();

                    Passenger p = manager.findPassenger(search);

                    if (p != null)
                        p.displayInfo();
                    else
                        System.out.println("Passenger not found.");

                    break;
                }

                case 4: {

                    System.out.print("Enter Passenger ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    manager.removePassengerById(id);
                    break;
                }

                case 5: {

                    System.out.print("Enter index: ");
                    int index = input.nextInt();
                    input.nextLine();

                    try {
                        Passenger passenger = manager.getPassenger(index);
                        passenger.displayInfo();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index not found.");
                    }

                    break;
                }

                case 6: {

                    System.out.print("Enter index to update: ");
                    int index = input.nextInt();
                    input.nextLine();

                    try {

                        System.out.print("New Name: ");
                        String name = input.nextLine();

                        System.out.print("New Email: ");
                        String email = input.nextLine();

                        System.out.print("New Phone: ");
                        String phone = input.nextLine();

                        System.out.print("New Age: ");
                        int age = input.nextInt();
                        input.nextLine();

                        manager.updatePassenger(index, name, email, phone, age);

                        System.out.println("Passenger data updated successfully.");

                    } catch (IndexOutOfBoundsException e) {

                        System.out.println("Index not found.");

                    }

                    break;
                }

                case 7: {
                    System.out.println("System closed.");
                    break;
                }

                default:
                    System.out.println("Invalid menu");

            }

        } while(menu != 7);

        input.close();
    }
}