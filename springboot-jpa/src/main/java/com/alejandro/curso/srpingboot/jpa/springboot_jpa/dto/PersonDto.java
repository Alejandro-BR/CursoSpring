/**
 * Clase Dto de persona:
 * 
 * Es una clase perzonalizada y simplificada de Person.
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa.dto;

public class PersonDto {

    private String name;
    private String lastname;

    public PersonDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", lastname=" + lastname + "]";
    }

}
