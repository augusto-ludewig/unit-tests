package domain;

import br.com.unittests.domain.User;
import br.com.unittests.domain.exception.ValidationException;
import domain.builders.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("Must create an valid User")
    public void mustCreateAnValidUser(){
        User user = UserBuilder.anUserBuilder().now();
        Assertions.assertAll("User",
                () -> Assertions.assertEquals(1L, user.getId()),
                () -> Assertions.assertEquals("Username", user.getName()),
                () -> Assertions.assertEquals("user@email.com", user.getEmail()),
                () -> Assertions.assertEquals("123", user.getPassword())
        );
    }

    @Test
    public void mustRejectUserWithouName(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.anUserBuilder().withName(null).now()
        );
        Assertions.assertEquals("Name need to be valid!", ex.getMessage());
    }
}
