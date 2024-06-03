/**
 * Interfaz InvoiceRepository:
 * 
 * El repositorio de Invoice
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
