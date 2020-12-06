package readinglist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
public class ReadingListRepositoryTest {

    @Autowired
    private ReadingListRepository readingListRepository;

    private Book book;

    @BeforeEach
    public void setup() {
        book = new Book();
        book.setReader("foottube");
        book.setAuthor("Bruce Zhang");
        book.setIsbn("ABC123");
        book.setTitle("A Book About How to Test");
        book.setDescription("Description about this book");
    }

    @Test
    @Transactional
    public void testSaveAndGetOne() {
        Book saved = readingListRepository.save(book);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals(book.getAuthor(), saved.getAuthor());
        assertEquals(book.getDescription(), saved.getDescription());
        assertEquals(book.getIsbn(), saved.getIsbn());
        assertEquals(book.getTitle(), saved.getTitle());
        assertEquals(book.getReader(), saved.getReader());

        Book retrieved = readingListRepository.getOne(saved.getId());
        assertNotNull(retrieved);
        assertEquals(book.getAuthor(), retrieved.getAuthor());
        assertEquals(book.getDescription(), retrieved.getDescription());
        assertEquals(book.getIsbn(), retrieved.getIsbn());
        assertEquals(book.getTitle(), retrieved.getTitle());
        assertEquals(book.getReader(), retrieved.getReader());
        assertEquals(saved.getId(), retrieved.getId());
    }

    @Test
    public void testSaveAndFindById() {
        Book saved = readingListRepository.save(book);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals(book.getAuthor(), saved.getAuthor());
        assertEquals(book.getDescription(), saved.getDescription());
        assertEquals(book.getIsbn(), saved.getIsbn());
        assertEquals(book.getTitle(), saved.getTitle());
        assertEquals(book.getReader(), saved.getReader());

        Optional<Book> retrievedOpt = readingListRepository.findById(saved.getId());
        assertTrue(retrievedOpt.isPresent());
        Book retrieved = retrievedOpt.get();
        assertEquals(book.getAuthor(), retrieved.getAuthor());
        assertEquals(book.getDescription(), retrieved.getDescription());
        assertEquals(book.getIsbn(), retrieved.getIsbn());
        assertEquals(book.getTitle(), retrieved.getTitle());
        assertEquals(book.getReader(), retrieved.getReader());
        assertEquals(saved.getId(), retrieved.getId());
    }

    @Test
    public void testSaveAndFindOne() {
        Book saved = readingListRepository.save(book);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals(book.getAuthor(), saved.getAuthor());
        assertEquals(book.getDescription(), saved.getDescription());
        assertEquals(book.getIsbn(), saved.getIsbn());
        assertEquals(book.getTitle(), saved.getTitle());
        assertEquals(book.getReader(), saved.getReader());

        Book bookExample = new Book();
        bookExample.setId(saved.getId());
        Optional<Book> retrievedOpt = readingListRepository.findOne(Example.of(bookExample));
        assertTrue(retrievedOpt.isPresent());
        Book retrieved = retrievedOpt.get();
        assertEquals(book.getAuthor(), retrieved.getAuthor());
        assertEquals(book.getDescription(), retrieved.getDescription());
        assertEquals(book.getIsbn(), retrieved.getIsbn());
        assertEquals(book.getTitle(), retrieved.getTitle());
        assertEquals(book.getReader(), retrieved.getReader());
        assertEquals(saved.getId(), retrieved.getId());
    }

}
