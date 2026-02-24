public class TrainTicket<T> {
    private String passengerName;
    private T identityNumber;
    private String bookingCode;
    private TicketClass ticketClass;

    public TrainTicket(String passengerName, T identityNumber, String bookingCode, TicketClass ticketClass){
        this.passengerName = passengerName;
        this.identityNumber = identityNumber;
        this.bookingCode = bookingCode;
        this.ticketClass = ticketClass;
    }

    public T getIdentityNumber() {
        return identityNumber;
    }

    public void displayTicket(){
        System.out.println("\n=== Ticket Information ===");
        System.out.println("Booking Code     : " + bookingCode);
        System.out.println("Passenger Name   : " + passengerName);
        System.out.println("Identity Type    : " + TrainTicket.getIdentityType(this));
        System.out.println("Identity Number  : " + identityNumber);
        System.out.println("Ticket Class     : " + ticketClass);
    }

    public static String getIdentityType(TrainTicket<?> ticket) {
        return ticket.getIdentityNumber().getClass().getSimpleName();
    }
}
