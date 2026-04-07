import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Railway Ticket Booking");

            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Identity Number: ");
            Long identity = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter Booking Code: ");
            String bookingCode = scanner.nextLine();

            System.out.println("\nSelect Ticket Class:");
            System.out.println("1. ECONOMY");
            System.out.println("2. BUSINESS");
            System.out.println("3. EXECUTIVE");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            TicketClass selectedClass;

            switch (choice) {
                case 1:
                    selectedClass = TicketClass.ECONOMY;
                    break;
                case 2:
                    selectedClass = TicketClass.BUSINESS;
                    break;
                case 3:
                    selectedClass = TicketClass.EXECUTIVE;
                    break;
                default:
                    throw  new IllegalArgumentException("Invalid ticket class choice!");
            }

            TrainTicket<Long> ticket = new TrainTicket<>(name, identity, bookingCode, selectedClass);
            //TrainTicket.getIdentityType(ticket);
            ticket.displayTicket();
            TrainTicket<Integer> ticket2 = new TrainTicket<>("Dika", 123, "KA-102", TicketClass.ECONOMY);
            ticket2.displayTicket();

        } catch (InputMismatchException e) {
            System.out.println("\nError: Identity number must be numeric!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred!");
        }finally {
            scanner.close();
        }
    }
}
