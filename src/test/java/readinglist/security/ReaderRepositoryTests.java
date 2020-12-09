package readinglist.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import readinglist.security.Reader;
import readinglist.security.ReaderRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReaderRepositoryTests {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void testSaveAndFindByUsername() {
        Reader reader = new Reader("foottube", "ABC123", "Bruce Zhang", "18612345678");
        Reader saved = readerRepository.save(reader);
        assertEquals(saved.getUsername(), reader.getUsername());
        assertEquals(saved.getPassword(), reader.getPassword());

        Reader retrieved = readerRepository.findByUsername("foottube");
        assertNotNull(retrieved);
        assertEquals(retrieved.getUsername(), reader.getUsername());
        assertEquals(retrieved.getPassword(), reader.getPassword());

        Reader notExist = readerRepository.findByUsername("aaa");
        assertNull(notExist);
    }
}
