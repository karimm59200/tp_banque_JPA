package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Agence {
    @Id
    @GeneratedValue
    private int id;
    private String address;



    public Agence() {
    }

    public Agence(String address) {
        this.address = address;
    }

    public Agence(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
