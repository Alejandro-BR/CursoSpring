/**
 * Clase Person:
 * 
 * Tabla persons en la base de datos.
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    @Column(name = "programing_language")
    private String programingLanguage;

    // Contructores

    public Person(Long id, String name, String lastname, String programingLanguage) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programingLanguage = programingLanguage;
    }

    public Person() {
    }

    // Metodos

    @Override
    public String toString() {
        return "[id = " + id + ", name = " + name + ", lastname = " + lastname + ", programingLanguage = "
                + programingLanguage + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

}
