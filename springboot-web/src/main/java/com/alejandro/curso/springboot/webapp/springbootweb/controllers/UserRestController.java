// http://localhost:8080/api/details
// http://localhost:8080/api/details-map
// http://localhost:8080/api/list

package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alejandro.curso.springboot.webapp.springbootweb.models.User; // Clase User
import com.alejandro.curso.springboot.webapp.springbootweb.models.dto.UserDto; // Clase UserDto

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Alejandro", "Barrionuevo");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    }

    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Alejandro", "Barrionuevo");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Alejandro", "Barriouevo");
        User user2 = new User("David", "Barriouevo");
        User user3 = new User("Antonio", "Barriouevo");

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }
}
