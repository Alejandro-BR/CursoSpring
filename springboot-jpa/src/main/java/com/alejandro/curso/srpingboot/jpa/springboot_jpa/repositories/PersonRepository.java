/**
 * Interface PersonRepository:
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.srpingboot.jpa.springboot_jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
