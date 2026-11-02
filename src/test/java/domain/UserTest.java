package domain;

import br.com.unittests.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("Must create an valid User")
    public void mustCreateAnValidUser(){
        User user = new User(1L, "Username", "user@email.com", "123");
        Assertions.assertAll("User",
                () -> Assertions.assertEquals(1L, user.getId()),
                () -> Assertions.assertEquals("Username", user.getName()),
                () -> Assertions.assertEquals("user@email.com", user.getEmail()),
                () -> Assertions.assertEquals("123", user.getPassword())
        );
    }
}
