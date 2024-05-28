package com.alejandro.curso.springboot.error.springboot_error.controllers;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.alejandro.curso.springboot.error.springboot_error.models.domain.User;
import com.alejandro.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    // @GetMapping("/show/{id}")
    // public User show(@PathVariable(name = "id") Long id) {
    // return service.findById(id);
    // }

    // @GetMapping("/show/{id}")
    // public ResponseEntity<?> show(@PathVariable(name = "id") Long id) {
    // UserNotFoundException("Error el usuario no existe!"));
    // Optional<User> optionalUser = service.findById(id);
    // if (optionalUser.isEmpty()) {
    // return ResponseEntity.notFound().build();
    // }
    // return ResponseEntity.ok(optionalUser.get());
    // }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe!"));
        System.out.println(user.getLastname());
        return user;

    }
}
