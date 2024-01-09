import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testBookConstructor() {
        Book book = new Book("TestBook", "TestAuthor", 123456789, 2024);
        assertEquals("TestBook", book.Name);
        assertEquals("TestAuthor", book.Author);
        assertEquals(123456789, book.isbn);
        assertEquals(2022, book.year);
    }
    @Test
    public void testGetValue() {
        Book book = new Book("TestBook", "TestAuthor", 123456789, 2024);
        assertEquals("NameTestBookAuthorTestAuthorisbn123456789year", getOutput(book));
    }
    private String getOutput(Book book) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        book.getValue();
        return outContent.toString();
    }
}
