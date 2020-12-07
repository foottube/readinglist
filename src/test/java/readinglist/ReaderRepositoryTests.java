package readinglist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;

@SpringBootTest
public class ReaderRepositoryTests {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void testSaveAndFindOne() {
        Reader reader = new Reader();
        reader.setPassword("ABC123");
        reader.setUsername("foottube");
        Reader saved = readerRepository.save(reader);
        assertEquals(saved.getUsername(), reader.getUsername());
        assertEquals(saved.getPassword(), reader.getPassword());

        Reader readerExample = new Reader();
        readerExample.setUsername("foottube");
        Optional<Reader> opt = readerRepository.findOne(Example.of(readerExample));
        assertTrue(opt.isPresent());
        Reader retrieved = opt.get();
        assertEquals(retrieved.getUsername(), reader.getUsername());
        assertEquals(retrieved.getPassword(), reader.getPassword());
    }
}
