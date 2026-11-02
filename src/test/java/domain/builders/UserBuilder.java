package domain.builders;

import br.com.unittests.domain.User;

public class UserBuilder {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserBuilder(){}

    public static UserBuilder anUserBuilder() {
        UserBuilder builder = new UserBuilder();
        insertData(builder);
        return builder;
    }

    private static void insertData(UserBuilder builder) {
        builder.id = 1L;
        builder.name = "Username";
        builder.email = "user@email.com";
        builder.password  = "123";
    }

    public UserBuilder withId(Long newId){
        this.id = newId;
        return this;
    }

    public UserBuilder withName(String newName){
        this.name = newName;
        return this;
    }

    public UserBuilder withEmail(String newEmail){
        this.email = newEmail;
        return this;
    }

    public UserBuilder withPassword(String newPassword){
        this.password = newPassword;
        return this;
    }

    public User now(){
        return new User(id, name, email, password);
    }

}
