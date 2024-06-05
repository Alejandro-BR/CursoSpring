/**
 * Interface ProductRepository
 * 
 * Repositorio de la clase Product
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.app.springboot_crud.entities.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{

}
