package domain;

import br.com.unittests.domain.Count;
import domain.builders.CountBuilder;
import domain.builders.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    void mustCreateAValidCount(){
        Count count = CountBuilder.anCountBuilder().now();
        Assertions.assertNotNull(count);
        Assertions.assertAll("Count",
                () -> Assertions.assertEquals(1L, count.getId()),
                () -> Assertions.assertEquals("Username", count.getName()),
                () -> Assertions.assertEquals(UserBuilder.anUserBuilder().now(), count.getUser())
        );
    }
}
