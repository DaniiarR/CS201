import org.junit.Test;

import static org.junit.Assert.*;

public class TestAuthor {

    Author author = new Author("Daniiar", "daniiar@gmail.com", 'm');

    @Test
    public void getName() {
        assertEquals("Daniiar", author.getName());
    }

    @Test
    public void getEmail() {
        assertEquals("daniiar@gmail.com", author.getEmail());
    }

    @Test
    public void getGender() {
        assertEquals('m', author.getGender());
    }

    @Test
    public void setEmail() {
        author.setEmail("daniiarTest@gmail.com");
        assertEquals("daniiarTest@gmail.com", author.getEmail());
    }

    @Test
    public void testToString() {
        String expected = "Author[name=Daniiar, email=daniiar@gmail.com, gender=m]";
        assertEquals(expected, author.toString());
    }
}