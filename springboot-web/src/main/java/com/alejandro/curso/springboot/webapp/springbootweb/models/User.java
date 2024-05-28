package com.alejandro.curso.springboot.webapp.springbootweb.models;

public class User {

    private String name;
    private String lastname;
    private String email;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public User(String name, String lastname, String email) {
        this(name, lastname);
        this.email = email;
    }

    public User() {
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

}
