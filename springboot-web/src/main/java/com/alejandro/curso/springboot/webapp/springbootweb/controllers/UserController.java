// http://localhost:8080/details
// http://localhost:8080/list

package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

//import java.util.ArrayList;
//import java.util.Map;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alejandro.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Alejandro", "Barrionuevo");
        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    // Tambien se puede usando un Map

    // @GetMapping("/details")
    // public String details(Map<String, Object> model) {
    // model.put("title", "Hola mundo Spring Boot");
    // model.put("name", "Alejandro");
    // model.put("lastname", "Barrionuevo");
    // return "details";
    // }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Alejandro", "Barrionuevo", "alejandro@correo.com"),
                new User("David", "Barrionuevo", "david@correo.com"),
                new User("Antonio", "Barrionuevo", "antonio@correo.com"));
    }
}
