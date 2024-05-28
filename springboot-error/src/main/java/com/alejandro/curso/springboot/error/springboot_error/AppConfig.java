package com.alejandro.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alejandro.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alejandro", "Barrionuevo"));
        users.add(new User(2L, "David", "Barrionuevo"));
        users.add(new User(3L, "Antonio", "Barrionuevo"));
        users.add(new User(4L, "Jesus", "Bermejo"));
        users.add(new User(5L, "Cristina", "Fernandez"));
        users.add(new User(6L, "Rafa", "Rosado"));
        users.add(new User(7L, "Javi", "Jimenez"));
        users.add(new User(8L, "Daniel", "Rosado"));

        return users;
    }
}
