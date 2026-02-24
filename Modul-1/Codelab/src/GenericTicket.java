public class GenericTicket <T>{
    private T bookingCode;
    private String passangerName;

    public GenericTicket(T bookingCode, String passangerName){
        this.bookingCode = bookingCode;
        this.passangerName = passangerName;
    }

    public T getBookingCode(){
        return bookingCode; //Answer
    }

    public String getPassangerName(){
        return  passangerName;
    }

    public void displayTicket(){
        System.out.println("=== Railway Ticket Information ===");
        System.out.println("Booking Code        : " + bookingCode);
        System.out.println("Passanger Name      : " + passangerName);
        System.out.println("Booking Code Type   : " + bookingCode.getClass().getSimpleName());
    }
}


