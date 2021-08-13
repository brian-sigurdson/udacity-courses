package model;

import java.time.LocalDate;

public class Reservation {
    private Customer customer;
    private IRoom room;

    /*
    I know you can probably convert a Date object to milliseconds from time zero, but Date objects are basically depricated.
    Use java.time.* classes, which is preferred as of Java 8.
    This page has a good example of some convenience methods associated with java.time.* that will make implementing
    searches easier:  https://howtodoinjava.com/java/date-time/compare-localdates/
    Also, : https://www.google.com/search?q=java+compare+java.time.localdate&oq=java+compare+java.time.localdate&aqs=chrome..69i57j33i22i29i30.46394j0j7&sourceid=chrome&ie=UTF-8
     */
//    private Date checkInDate;
//    private Date checkOutDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @Override
    public String toString() {
        String reservationHeader = "RESERVATION DETAILS:";
        String customerInfo = "Customer: " + customer.getFirstName() + " " + customer.getLastName();
        String customerEmail = "Customer email: " + customer.getEmail();
        String roomInfo = "Room: " + room.getRoomNumber() + " - " + room.getRoomType();
        String roomPrice = "Price: " + room.getRoomPrice();
        String checkIn = "Checkin " + checkInDate;
        String checkOut = "Checkout " + checkOutDate;

        return reservationHeader +
                "\n" +
                customerInfo +
                "\n" +
                customerEmail +
                "\n" +
                roomInfo +
                "\n" +
                roomPrice +
                "\n" +
                checkIn +
                "\n" +
                checkOut;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this){
            return true;
        } else if (!(object instanceof Reservation)) {
            return false;
        } else {
            Reservation reservation = (Reservation) object;
            return reservation.customer.equals(this.customer) && reservation.room.equals(this.room) &&
                    reservation.checkInDate.equals(this.checkInDate) && reservation.checkOutDate.equals(this.checkOutDate);
        }
    }

    @Override
    public int hashCode () {
        // The recipe for a proper hash code, from Effective Java 3rd ed.
        int result = customer.hashCode();
        result += 31 + room.hashCode();
        result += 31 + checkInDate.hashCode();
        result += 31 + checkOutDate.hashCode();
        return result;
    }
}
