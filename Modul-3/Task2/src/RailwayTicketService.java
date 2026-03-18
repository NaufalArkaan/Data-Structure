import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RailwayTicketService {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> history = new Stack<>();

        Scanner input = new Scanner(System.in);
        int choice = -1;

        do{
            System.out.println("\n=== Railway Ticket Service ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Display Queue");
            System.out.println("3. Serve Passenger");
            System.out.println("4. Undo Last Transaction");
            System.out.println("0. Exit");
            System.out.print("Choose menu: ");
            try {
                choice = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Input must be numeric.");
                input.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = input.nextLine();

                    queue.add(name);
                    System.out.println("Passenger added to queue.");
                    break;

                case 2:
                    System.out.println("Current Queue: ");

                    if(queue.isEmpty()){
                        System.out.println("Queue is empty.");
                    } else {
                        int i = 1;
                        for(String p : queue){
                            System.out.println(i++ + ". " + p);
                        }
                    }
                    break;

                case 3:
                    if (queue.isEmpty()){
                        System.out.println("No passengers to serve.");
                    } else {
                        String served = queue.poll();
                        System.out.println("Serving passenger: " + served);

                        history.push(served);
                        System.out.println("Transaction saved.");
                    }
                    break;

                case 4:
                    if(history.isEmpty()){
                        System.out.println("No transaction to undo.");
                    } else {
                        String undo = history.pop();
                        System.out.println("Undo transaction for passenger: " + undo);

                        queue.add(undo);
                    }
                    break;

                case 0:
                    System.out.println("Program Completed.");
                    break;

                default:
                    System.out.println("Invalid Selection.");
            }
        }while(choice != 0);
        input.close();
    }
}
