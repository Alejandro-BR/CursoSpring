/**
 * Clase Client:
 * 
 * Tabla clients en la base de datos.
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    // , fetch = FetchType.EAGER
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private Set<Invoice> invoices;

    @OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private ClientDetails clientDetails;

    // Contructores

    public Client() {
        this.addresses = new HashSet<>();
    }

    public Client(String name, String lastname) {
        this.addresses = new HashSet<>();
        this.name = name;
        this.lastname = lastname;
    }

    // Metodos

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
        clientDetails.setClient(this);
    }

    public void removeClientDetails(ClientDetails clientDetails) {
        clientDetails.setClient(null);
        this.clientDetails = null;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = " + name +
                ", lastname = " + lastname +
                ", invoices = " + invoices +
                ", addresses = " + addresses +
                ", client details = " + clientDetails +
                "]";
    }

}
