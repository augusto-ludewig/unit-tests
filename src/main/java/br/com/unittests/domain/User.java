package br.com.unittests.domain;

import br.com.unittests.domain.exception.ValidationException;

import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    public User(Long id, String name, String email, String password) {
        // validation to create a valid user
        if(name == null) throw new ValidationException("Name need to be valid!");
        if(email == null) throw new ValidationException("Email need to be valid!");
        if(password == null) throw new ValidationException("Password need to be valid!");

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword());
    }
}
