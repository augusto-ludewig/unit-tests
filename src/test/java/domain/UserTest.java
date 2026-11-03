package domain;

import br.com.unittests.domain.User;
import br.com.unittests.domain.exception.ValidationException;
import domain.builders.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @Test
    @DisplayName("Must create an valid User")
    void mustCreateAnValidUser(){
        User user = UserBuilder.anUserBuilder().now();
        Assertions.assertAll("User",
                () -> Assertions.assertEquals(1L, user.getId()),
                () -> Assertions.assertEquals("Username", user.getName()),
                () -> Assertions.assertEquals("user@email.com", user.getEmail()),
                () -> Assertions.assertEquals("123", user.getPassword())
        );
    }

    @Test
    void mustRejectUserWithouName(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.anUserBuilder().withName(null).now()
        );
        Assertions.assertEquals("Name need to be valid!", ex.getMessage());
    }

    @Test
    void mustRejectUserWithouEmail(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.anUserBuilder().withEmail(null).now()
        );
        Assertions.assertEquals("Email need to be valid!", ex.getMessage());
    }

    @Test
    void mustRejectUserWithouPassword(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.anUserBuilder().withPassword(null).now()
        );
        Assertions.assertEquals("Password need to be valid!", ex.getMessage());
    }

    // junior mode to do
    @ParameterizedTest
    @ValueSource(strings = {"Name need to be valid!", "Email need to be valid!", "Password need to be valid!"})
    void mustRejectUserWithouSomeAtribute(String param){
        String method = param.split(" ")[0];
        ValidationException ex = new ValidationException("");

        if(method.equalsIgnoreCase("Name")){
            ex = Assertions.assertThrows(ValidationException.class, () ->
                    UserBuilder.anUserBuilder().withName(null).now());
        }

        if(method.equalsIgnoreCase("Email")){
            ex = Assertions.assertThrows(ValidationException.class, () ->
                    UserBuilder.anUserBuilder().withEmail(null).now());
        }

        if(method.equalsIgnoreCase("Password")){
            ex = Assertions.assertThrows(ValidationException.class, () ->
                    UserBuilder.anUserBuilder().withPassword(null).now());
        }

        Assertions.assertEquals(param, ex.getMessage());
    }

    // senior mode to do
    @ParameterizedTest
    @CsvSource(value = {
                    "1, null, user@email.com, 123, Name need to be valid!",
                    "1, Username, null, 123, Email need to be valid!",
                    "1, Username, user@email.com, null, Password need to be valid!"
    }, nullValues = "null")
    void mustRejectUserWithouSomeAtributeTestWithCsv(Long id, String name, String email, String password, String msg){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                UserBuilder.anUserBuilder()
                .withId(id)
                .withName(name)
                .withEmail(email)
                .withPassword(password)
                .now());
        Assertions.assertEquals(msg, ex.getMessage());
    }
}
