package com.alejandro.curso.springboot.app.springboot_crud.services;

import java.util.List;

import com.alejandro.curso.springboot.app.springboot_crud.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);
}
