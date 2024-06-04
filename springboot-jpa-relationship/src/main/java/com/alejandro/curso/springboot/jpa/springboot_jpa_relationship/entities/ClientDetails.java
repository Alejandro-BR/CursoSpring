/**
 * Clase ClientDetails
 * 
 * Tabla clients_details en la base de datos.
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients_details")
public class ClientDetails {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean premium;

    private Integer points;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    // Contructores

    public ClientDetails() {
    }

    public ClientDetails(boolean premium, Integer points) {
        this.premium = premium;
        this.points = points;
    }

    // Metodos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Client getClient() {
    return client;
    }

    public void setClient(Client client) {
    this.client = client;
    }

    @Override
    public String toString() {
        return "[id = " + id + ", premium = " + premium + ", points = " + points + "]";
    }

}
