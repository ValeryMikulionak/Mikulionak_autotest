package homework.day17;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Booking1Test {

    Booking1 book = new Booking1();

    @Test
    public void bookTest() throws InterruptedException {
        assertTrue("Нет отелей с рейтингом выше 9", book.booky());
    }

}