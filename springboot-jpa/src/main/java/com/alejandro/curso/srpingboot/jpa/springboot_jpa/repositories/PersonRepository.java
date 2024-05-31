/**
 * Interface PersonRepository:
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.srpingboot.jpa.springboot_jpa.dto.PersonDto;
import com.alejandro.curso.srpingboot.jpa.springboot_jpa.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.id in (1, 2, 5)")
    List<Person> getPersonsByIds();

    @Query("SELECT p.name, LENGTH(p.name) AS nameLength FROM Person p WHERE LENGTH(p.name) = (SELECT MIN(LENGTH(p.name)) FROM Person p)")
    List<Object[]> getShorterName();

    @Query("SELECT p FROM Person p WHERE p.id = (SELECT MAX(p.id) FROM Person p)")
    Optional<Person> getLastRegistration();

    @Query("select max(length(p.name)) from Person p")
    Integer getMaxLengthName();

    @Query("select min(length(p.name)) from Person p")
    Integer getMinLengthName();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLengch();

    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long minId();

    @Query("select max(p.id) from Person p")
    Long maxId();

    @Query("select p from Person p order by p.name asc")
    List<Person> getAll();

    List<Person> findByIdBetweenOrderByNameAsc(Long id1, Long id2);

    List<Person> findByIdBetween(Long id1, Long id2);

    List<Person> findByNameBetween(String name1, String name2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name")
    List<Person> findAllBetweenName(String c1, String c2);

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name desc, p.lastname asc")
    List<Person> findAllBetweenId(Integer c1, Integer c2);

    @Query("select p.name || ' ' || p.lastname || ' ' || upper(p.programingLanguage) from Person p")
    List<String> findAllFullNameConcatAndProgramingLanguage();

    @Query("select lower(concat(p.name, ' ', p.lastname)) from Person p")
    List<String> findAllFullNameConcatLower();

    @Query("select upper(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullNameConcatUpper();

    // @Query("select concat(p.name, ' ', p.lastname) from Person p")
    @Query("select p.name || ' ' || p.lastname from Person p")
    List<String> findAllFullNameConcat();

    @Query("select count(distinct(p.programingLanguage)) from Person p")
    Long findAllprogramingLanguageDistinctCount();

    @Query("select distinct(p.programingLanguage) from Person p")
    List<String> findAllprogramingLanguageDistinct();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select new com.alejandro.curso.srpingboot.jpa.springboot_jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllObjectPersonDto();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p,  p.programingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p")
    List<Object[]> findAllMixPersonDataList();

    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);

    @Query("select p.id from Person p where p.id=?1")
    Long getIdById(Long id);

    @Query("select concat(p.name, ' ', p.lastname) as fullname from Person p where p.id=?1")
    String getFullNameById(Long id);

    @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p where p.id=?1")
    Object[] obtenerPersonDataFullById(Long id);

    @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p where p.id=?1")
    Object obtenerPersonaById(Long id);

    @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p")
    List<Object[]> obtenerPersonDataList();

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
