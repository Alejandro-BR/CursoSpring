package com.alejandro.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alejandro.springboot.di.app.springboot_di.models.Product;
import com.alejandro.springboot.di.app.springboot_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    private final ProductService service; 

    public SomeController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}

// package com.alejandro.springboot.di.app.springboot_di.controllers;

// import java.util.List;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import com.alejandro.springboot.di.app.springboot_di.models.Product;
// import com.alejandro.springboot.di.app.springboot_di.services.ProductService;


// @RestController
// @RequestMapping("/api")
// public class SomeController {

//     private ProductService service = new ProductService();

//     @GetMapping
//     public List<Product> list() {
//         return service.findAll();
//     }

//     @GetMapping("/{id}")
//     public Product show(@PathVariable Long id) {
//         return service.findById(id);
//     }
    
// }
