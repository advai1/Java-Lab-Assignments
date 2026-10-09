package GuestLecture;

class RailwayTicketBooking {
    int seatCount = 15;

    public synchronized void BookTicket(int noOfTickets) {
        if (noOfTickets <= seatCount) {
            seatCount -= noOfTickets;
            System.out.println(Thread.currentThread().getName() + " booked " + noOfTickets + " seats. Remaining: " + seatCount);
        }
        else {
            System.out.println(Thread.currentThread().getName() + ": Not enough seats available.");
        }
    }
}

class RailwayBookingTask extends Thread {
    RailwayTicketBooking booking;
    int noOfTickets;

    RailwayBookingTask(RailwayTicketBooking booking, String name, int noOfTickets) {
        super(name);
        this.booking = booking;
        this.noOfTickets = noOfTickets;
    }

    public void run() {
        booking.BookTicket(noOfTickets);
    }
}

public class RailwayBookingThreads {
    public static void main(String[] args) {
        RailwayTicketBooking booking = new RailwayTicketBooking();

        RailwayBookingTask c1 = new RailwayBookingTask(booking, "Customer 1", 8);
        RailwayBookingTask c2 = new RailwayBookingTask(booking, "Customer 2", 5);
        RailwayBookingTask c3 = new RailwayBookingTask(booking, "Customer 3", 4);

        c1.start();
        c2.start();
        c3.start();
    }
}