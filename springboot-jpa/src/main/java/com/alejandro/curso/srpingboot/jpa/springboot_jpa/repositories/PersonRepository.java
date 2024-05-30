/**
 * Interface PersonRepository:
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.srpingboot.jpa.springboot_jpa.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    // findBy es una palabra clave si no se usan palabras claves se tiene que
    // usar Query para poner una consulta

    @Query("Select p from Person p where p.programingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgramingLanguage(String programingLanguage, String name);

    List<Person> findByProgramingLanguageAndName(String programingLanguage, String name);

    List<Person> findByProgramingLanguage(String programingLanguage);

    @Query("select p.name, p.programingLanguage from Person p")
    List<Object[]> obtenerPersonData();

}
