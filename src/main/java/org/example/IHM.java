package org.example;

import org.example.impl.AgenceDAOImpl;
import org.example.impl.ClientDAOImpl;
import org.example.impl.CompteDAOImpl;
import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IHM {

    private static EntityManagerFactory entityManagerFactory;
    private static AgenceDAOImpl agenceDAO;
    private static ClientDAOImpl clientDAO;
    private static CompteDAOImpl compteDAO;
    private static org.example.model.Agence Agence;



    public static void start() {
        entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("banque");
        agenceDAO = new AgenceDAOImpl(entityManagerFactory);
        clientDAO = new ClientDAOImpl(entityManagerFactory);
        compteDAO = new CompteDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1. Ajouter une agence");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Ajouter un compte");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAgence();
                    break;
                case 2:
                    addClient();
                    break;
                case 3:
                    addCompte();
                    break;
                case 4:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        } while (choice != 0);

    }

    private static void addAgence() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Adresse de l'agence: ");
        String adresse = sc.nextLine();

        Agence agence = new Agence(adresse);
        agenceDAO.addAgence(agence);
        System.out.println("Agence ajoutée avec succès!");

    }

    private static void addClient (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom du client: ");
        String nom = sc.nextLine();

        System.out.println("Prénom du client: ");
        String prenom = sc.nextLine();

        System.out.println("Date de naissance du client (dd.MM.yyyy: ");
        String dateNaissanceStr = sc.nextLine();

        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));



        Client client = new Client(nom, prenom, dateNaissance);
        clientDAO.addClient(client);
        System.out.println("Client ajouté avec succès!");

    }

    private static void addCompte (){
        Scanner sc = new Scanner(System.in);
        System.out.println("numéro de compte: ");
        String libelle = sc.nextLine();

        System.out.println("iban: ");
        String iban = sc.nextLine();

        System.out.println("Solde du compte: ");
        double solde = sc.nextDouble();
        sc.nextLine();

        System.out.println("Agence du compte: ");
        Long idAgence = sc.nextLong();
        sc.nextLine();

        System.out.println("Numéro du client: ");
        Long idClient = sc.nextLong();

        Compte compte = new Compte(libelle, iban, solde);
        compteDAO.addCompte(compte, idAgence, idClient);
        System.out.println("Compte ajouté avec succès!");

    }




}

