package org.example.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String libelle;

    @Column(unique = true,length = 27, nullable = false)
    private String iban;

    @Column(precision = 10, scale = 2)
    private double solde = 0.00;
    @ManyToOne
    private Agence agence;
    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients = new ArrayList<>();

    public Compte() {
    }

    public Compte(String libelle, String iban, double solde) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", iban='" + iban + '\'' +
                ", solde=" + solde +
                ", agence=" + agence +
                ", clients=" + clients +
                '}';
    }
}
