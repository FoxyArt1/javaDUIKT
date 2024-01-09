import org.example.Cinema;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CinemaTest {

    private Cinema cinema;
    @Before
    public void setUp() {
        cinema = new Cinema(3, 5, 10);
    }
    @Test
    public void bookSeats_ValidBooking_ReturnsTrue() {
        int hallNumber = 0;
        int row = 2;
        int[] seats = {3, 4, 5};
        assertTrue(cinema.bookSeats(hallNumber, row, seats));
    }
    @Test
    public void bookSeats_SeatAlreadyBooked_ReturnsFalse() {
        int hallNumber = 0;
        int row = 2;
        int[] seats = {3, 4, 5};
        assertTrue(cinema.bookSeats(hallNumber, row, seats));
        assertFalse(cinema.bookSeats(hallNumber, row, seats));
    }
    @Test
    public void cancelBooking_ValidCancellation_ReturnsTrue() {
        int hallNumber = 1;
        int row = 3;
        int[] seats = {1, 2, 3};
        assertTrue(cinema.bookSeats(hallNumber, row, seats));
        assertTrue(cinema.cancelBooking(hallNumber, row, seats));
    }
    @Test
    public void checkAvailability_AvailableSeats_ReturnsTrue() {
        int hallNumber = 2;
        int numSeats = 3;
        assertTrue(cinema.checkAvailability(hallNumber, numSeats));
    }

}