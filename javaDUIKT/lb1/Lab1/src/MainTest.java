import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
    @Test
    public void testBookCreationAndDisplay() {
        String input = "TestBook\nTestAuthor\n123456789\n2024\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[0]);

        assertTrue(outContent.toString().contains("Назва: TestBook"));
        assertTrue(outContent.toString().contains("Автор: TestAuthor"));
        assertTrue(outContent.toString().contains("ISDN номер: 123456789"));
        assertTrue(outContent.toString().contains("Рік видання: 2022"));
    }
    @Test
    public void testBookSearch() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book testBook = new Book("TestBook", "TestAuthor", 123456789, 2024);
        booksList.add(testBook);
        System.setIn(new ByteArrayInputStream("TestBook\n".getBytes()));
        Main.searchBookByTitle(booksList);
        assertTrue(outContent.toString().contains("Знайдена книга: "));
        assertTrue(outContent.toString().contains("Назва: TestBook"));
        assertTrue(outContent.toString().contains("Автор: TestAuthor"));
        assertTrue(outContent.toString().contains("ISDN номер: 123456789"));
        assertTrue(outContent.toString().contains("Рік видання: 2024"));
    }
    @Test
    public void testBookRemoval() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book testBook = new Book("TestBook", "TestAuthor", 123456789, 2022);
        booksList.add(testBook);
        System.setIn(new ByteArrayInputStream("123456789\n".getBytes()));
        Main.removeBookByISBN(booksList);
        assertFalse(booksList.contains(testBook));
        assertTrue(outContent.toString().contains("Книга з ISBN 123456789 видалена "));
    }
    }
}
