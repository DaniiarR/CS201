import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookTest {

    Book book = new Book("To kill a mockingbird",
            new Author[]{new Author("daniiar", "daniiar@gmail.com", 'm'), new Author("Harper Lee", "harper@gmail.com", 'f')},
            159.9,
            50000);
    @Test
    public void getName() {
        assertEquals("To kill a mockingbird", book.getName());
    }

    @Test
    public void getAuthors() {
        Author[] expected = new Author[] {new Author("daniiar", "daniiar@gmail.com", 'm'),
                new Author("Harper Lee", "harper@gmail.com", 'f')};
        //assertArrayEquals(expected, book.getAuthors());
        Assert.assertArrayEquals(expected, book.getAuthors());
    }

    @Test
    public void getPrice() {
        assertEquals(159.9, book.getPrice(), 0.001);
    }

    @Test
    public void getQty() {
        assertEquals(50000, book.getQty());
    }

    @Test
    public void setPrice() {
        book.setPrice(25.5);
        assertEquals(25.5, book.getPrice(), 0);
    }

    @Test
    public void setQty() {
        book.setQty(50);
        assertEquals(50, book.getQty());
    }

    @Test
    public void testToString() {
        String expected = "Book[name=To kill a mockingbird, authors=={Author[name=daniiar, email=daniiar@gmail.com, gender=m], Author[name=Harper Lee, email=harper@gmail.com, gender=f]}, price=159.9, qty=50000]";
        assertEquals(expected, book.toString());
    }
}