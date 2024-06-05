/**
 * Clase  ProductController:
 * 
 * En esta clase se se controla la clse Product.
 * Direccion: /api/products
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.app.springboot_crud.ProductValidation;
import com.alejandro.curso.springboot.app.springboot_crud.entities.Product;
import com.alejandro.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductValidation validation;

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        return ResponseEntity.badRequest().body(errors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {

        Optional<Product> productOpcional = service.findById(id);

        if (productOpcional.isPresent()) {
            return ResponseEntity.ok(productOpcional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {

        validation.validate(product, result);
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        Product productNew = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product,  BindingResult result,  @PathVariable Long id) {

        validation.validate(product, result);
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        Optional<Product> productOptional = service.update(id, product);
        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Product> productOpcional = service.delete(id);

        if (productOpcional.isPresent()) {
            return ResponseEntity.ok(productOpcional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}
