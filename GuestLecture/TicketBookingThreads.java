package GuestLecture;

class TicketBooking {
    int seatCount = 10;

    public synchronized void BookTicket(int noOfTickets) {
        if (noOfTickets <= seatCount) {
            seatCount -= noOfTickets;
            System.out.println(Thread.currentThread().getName() + " booked " + noOfTickets
                    + " seats. Remaining: " + seatCount);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + ": Not enough seats available.");
        }
    }
}

class BookingTask extends Thread {
    TicketBooking booking;
    int noOfTickets;

    BookingTask(TicketBooking booking, int noOfTickets, String name) {
        super(name);
        this.booking = booking;
        this.noOfTickets = noOfTickets;
    }

    public void run() {
        booking.BookTicket(noOfTickets);
    }
}

public class TicketBookingThreads {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        BookingTask c1 = new BookingTask(booking, 7, "Customer 1");
        BookingTask c2 = new BookingTask(booking, 5, "Customer 2");

        c1.start();
        c2.start();
    }
}
