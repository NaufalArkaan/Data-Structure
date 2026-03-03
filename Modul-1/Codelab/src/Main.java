public class Main {
    public static void main(String[] args) {
        GenericTicket<String> ticket1 = new GenericTicket<>("KA-001", "Andi");
        ticket1.displayTicket();
        System.out.println();
        GenericTicket<Integer> ticket2 = new GenericTicket<>(1002, "Budi");
        ticket2.displayTicket();
    }
}