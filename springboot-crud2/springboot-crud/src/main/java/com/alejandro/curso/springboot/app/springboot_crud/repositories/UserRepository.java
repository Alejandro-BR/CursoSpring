package com.alejandro.curso.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.app.springboot_crud.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
