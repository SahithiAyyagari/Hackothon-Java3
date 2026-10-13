
class CinemaBooking {

    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    public CinemaBooking() {
        this.customerName = "UNKNOWN";
        this.movieName = "UNKNOWN";
        this.ticketPrice = 0.0;
        this.numberOfTickets = 0;
    }
    public CinemaBooking(String customerName, String movieName) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();       
        this.ticketPrice = 200.0; 
    }
    public CinemaBooking(String customerName, String movieName, double ticketPrice) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
    }
    public void bookTicket(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }
     public void bookTicket(String confirmName, int numberOfTickets) {
    
        if (this.customerName.equalsIgnoreCase(confirmName)) {
            this.numberOfTickets = numberOfTickets;
            processBooking();
        } else {
            System.out.println("\nVerification Failed: Customer name mismatch!");
        }
    }
    private void processBooking() {
        if (numberOfTickets <= 0) {
            System.out.println("Booking Status : Booking Failed (Invalid number of tickets)");
            return;
        }
           double totalAmount = ticketPrice * numberOfTickets;
        double discount = 0.0;
        if (numberOfTickets >= 5) {
            discount = 0.10 * totalAmount;
        }
        double finalAmount = totalAmount - discount;
        System.out.println("Customer Name    : " + customerName);
        System.out.println("Movie Name       : " + movieName);
        System.out.println(String.format("Ticket Price     : Rs. %.2f", ticketPrice));
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Booking Status   : Booking Successful");
        System.out.println(String.format("Total Amount     : Rs. %.2f", totalAmount));
        System.out.println(String.format("Discount         : Rs. %.2f", discount));
        System.out.println(String.format("Final Amount     : Rs. %.2f", finalAmount));
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========\n");
        CinemaBooking booking1 = new CinemaBooking("Sneha", "Avatar", 200.0);
        booking1.bookTicket(5);
        CinemaBooking booking2 = new CinemaBooking("Arjun", "Avatar");
        booking2.bookTicket("arjun", 2);
    }
}
