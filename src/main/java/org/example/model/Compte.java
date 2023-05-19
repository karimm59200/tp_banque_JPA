package org.example.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;

    private String iban;

    private double solde;
    @ManyToOne
    private Agence agence;
    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    public Compte() {
    }

    public Compte(String libelle, String iban, double solde) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
    }

    public Compte(String libelle, String iban, double solde, Agence agence) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
        this.agence = agence;
    }

    public Compte(String libelle, String iban, double solde, Agence agence, List<Client> clients) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
        this.agence = agence;
        this.clients = clients;
    }

    public Compte(String libelle, String iban, double solde, List<Client> clients) {
        this.libelle = libelle;
        this.iban = iban;
        this.solde = solde;
        this.clients = clients;
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
