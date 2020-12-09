package readinglist.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;

    public Reader toReader(PasswordEncoder passwordEncoder) {
        return new Reader(username, passwordEncoder.encode(password), fullName, phoneNumber);
    }
}
