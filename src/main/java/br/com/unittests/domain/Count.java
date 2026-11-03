package br.com.unittests.domain;

import java.util.Objects;

public class Count {

    private Long id;
    private String name;
    private User user;

    public Count(Long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Count count)) return false;
        return Objects.equals(getId(), count.getId()) && Objects.equals(getName(), count.getName()) && Objects.equals(getUser(), count.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUser());
    }
}
