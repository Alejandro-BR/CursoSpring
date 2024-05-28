package com.alejandro.curso.springboot.error.springboot_error.models.domain;

public class User {

    private String name;
    private Long id;
    private String lastname;

    private Role role;

    public User(Long id, String name, String lastname) {
        this.name = name;
        this.id = id;
        this.lastname = lastname;
    }

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // public String getRoleName(){
    //     return role.getName();
    // }

}
