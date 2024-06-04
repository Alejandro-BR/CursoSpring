package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.ClientDetails;

public interface ClientDetailRepository extends CrudRepository<ClientDetails, Long> {

}
