/**
 * Interfaz ClientRepository:
 * 
 * El repositorio de Client
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("select c from Client c left join fetch c.addresses where c.id=?1")
    Optional<Client> findOneAddresesses(Long id);
    
    @Query("select c from Client c left join fetch c.invoices where c.id=?1")
    Optional<Client> findOneWirhInvoices(Long id);

    @Query("select c from Client c left join fetch c.invoices left join fetch c.addresses where c.id=?1")
    Optional<Client> findOne(Long id);

}
