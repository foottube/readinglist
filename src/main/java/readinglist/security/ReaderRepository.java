package readinglist.security;

import org.springframework.data.jpa.repository.JpaRepository;
import readinglist.security.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {

    Reader findByUsername(String username);

}
