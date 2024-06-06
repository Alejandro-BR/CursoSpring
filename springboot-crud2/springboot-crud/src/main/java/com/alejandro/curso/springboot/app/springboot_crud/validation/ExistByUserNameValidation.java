package com.alejandro.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alejandro.curso.springboot.app.springboot_crud.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUserNameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByUsername(value);
    }
}