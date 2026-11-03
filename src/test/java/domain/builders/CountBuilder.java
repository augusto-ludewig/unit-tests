package domain.builders;

import br.com.unittests.domain.User;
import br.com.unittests.domain.Count;

public class CountBuilder {

    private Long id;
    private String name;
    private User user;
    private CountBuilder(){}

    public static CountBuilder anCountBuilder() {
        CountBuilder builder = new CountBuilder();
        insertData(builder);
        return builder;
    }

    private static void insertData(CountBuilder builder) {
        builder.id = 1L;
        builder.name = "Username";
        builder.user = UserBuilder.anUserBuilder().now();
    }

    public CountBuilder withId(Long newId){
        this.id = newId;
        return this;
    }

    public CountBuilder withName(String newName){
        this.name = newName;
        return this;
    }

    public CountBuilder withUser(User newUser){
        this.user = newUser;
        return this;
    }

    public Count now(){
        return new Count(id, name, user);
    }

}
