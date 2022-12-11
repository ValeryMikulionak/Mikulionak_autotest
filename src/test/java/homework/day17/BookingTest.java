package homework.day17;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BookingTest {

    Booking book = new Booking();

    @Test
    public void bookTest() throws InterruptedException {
        assertTrue("Отелей нет", book.booky());
    }

}
