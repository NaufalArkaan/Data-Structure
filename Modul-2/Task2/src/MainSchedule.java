import java.util.Scanner;

public class MainSchedule {
    public static int safeIntInput(Scanner input) {

        while (true) {
            try {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (Exception e) {
                System.out.print("Invalid input! Please enter a number: ");
                input.nextLine();
            }
        }

    }

    public static double safeDoubleInput(Scanner input) {

        while (true) {
            try {
                double value = input.nextDouble();
                input.nextLine();
                return value;
            } catch (Exception e) {
                System.out.print("Invalid fare! Please enter a valid number: ");
                input.nextLine();
            }
        }

    }

    public static void main(String[] args) {

        ScheduleManager manager = new ScheduleManager();
        Scanner input = new Scanner(System.in);

        manager.addLast(new Schedule("TR001","Argo Bromo","Surabaya","Jakarta","08:00",350000));
        manager.addLast(new Schedule("TR002","Malabar","Malang","Bandung","09:00",300000));

        int menu;

        do{

            System.out.println("\n==== Train Schedule Menu ====");
            System.out.println("1. Show Schedules");
            System.out.println("2. Add Schedule (First)");
            System.out.println("3. Add Schedule (Last)");
            System.out.println("4. Remove First Schedule");
            System.out.println("5. Remove Last Schedule");
            System.out.println("6. Search Route");
            System.out.println("7. Cleanup Destination");
            System.out.println("8. Exit");

            System.out.print("Choose menu: ");
            menu = safeIntInput(input);

            switch(menu){

                case 1:

                    manager.showSchedules();

                    break;

                case 2:

                    System.out.print("Train Code: ");
                    String code = input.nextLine();

                    System.out.print("Train Name: ");
                    String name = input.nextLine();

                    System.out.print("Origin: ");
                    String origin = input.nextLine();

                    System.out.print("Destination: ");
                    String dest = input.nextLine();

                    System.out.print("Departure: ");
                    String time = input.nextLine();

                    System.out.print("Fare: ");
                    double fare = safeDoubleInput(input);

                    manager.addFirst(new Schedule(code,name,origin,dest,time,fare));

                    System.out.println("Schedule added at the beginning.");

                    break;

                case 3:

                    System.out.print("Train Code: ");
                    code = input.nextLine();

                    System.out.print("Train Name: ");
                    name = input.nextLine();

                    System.out.print("Origin: ");
                    origin = input.nextLine();

                    System.out.print("Destination: ");
                    dest = input.nextLine();

                    System.out.print("Departure: ");
                    time = input.nextLine();

                    System.out.print("Fare: ");
                    fare = safeDoubleInput(input);

                    manager.addLast(new Schedule(code,name,origin,dest,time,fare));

                    System.out.println("Schedule added at the end.");

                    break;

                case 4:

                    manager.removeFirst();
                    System.out.println("First schedule removed.");

                    break;

                case 5:

                    manager.removeLast();
                    System.out.println("Last schedule removed.");

                    break;

                case 6:

                    System.out.print("Origin: ");
                    origin = input.nextLine();

                    System.out.print("Destination: ");
                    dest = input.nextLine();

                    if(origin.isEmpty() || dest.isEmpty()){
                        System.out.println("Origin and destination cannot be empty.");
                        break;
                    }

                    manager.searchRoute(origin,dest);

                    break;

                case 7:

                    System.out.print("Destination to delete: ");
                    String remove = input.nextLine();

                    if(remove.isEmpty()){
                        System.out.println("Destination cannot be empty.");
                        break;
                    }

                    manager.cleanupDestination(remove);

                    System.out.println("Cleanup completed.");

                    break;

                case 8:

                    System.out.println("Program finished.");

                    break;

                default:

                    System.out.println("Invalid menu option.");

            }

        }while(menu != 8);

        input.close();
    }
}