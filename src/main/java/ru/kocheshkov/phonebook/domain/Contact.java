package ru.kocheshkov.phonebook.domain;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    private long id;
    private String name;
    private String number;
    @ManyToOne()
    private User user;

    public Contact() {
    }

    public Contact(long id, String name, String number, User user) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
