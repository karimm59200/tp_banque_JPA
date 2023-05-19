package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agence")
public class Agence {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String address;



    public Agence() {
    }

    public Agence(String address) {
        this.address = address;
    }

    public Agence(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }


    public void setAdresse(String adresse) {
        this.address = address;
    }
}
