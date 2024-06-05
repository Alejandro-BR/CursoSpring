/**
 * Clase ProductValidation:
 * 
 * En esta clase se valida de forma personalizada.
 * 
 * Es una de las opciones que se pueden hacer para validar. 
 * 
 * Opciones que hay:
 *  - Utilizando el properties y unas anotaciones en product. (Implementado)
 *  - Esta opcion de una clase personalizada para validar.    (Implementado)
 *  - Anotaciones personalizadas.                             (no implementado)
 *  - Anotaciones check Db.                                   (no implementado)
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.app.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.alejandro.curso.springboot.app.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "es requerido!");

        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotBlank.product.descriptione");
        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null, "es requerido, por favor");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", null, "no puede ser nulo, ok!");
        } else if (product.getPrice() < 500) {
            errors.rejectValue("price", null, "debe ser mayor o igual que 500");
        }
    }

}
